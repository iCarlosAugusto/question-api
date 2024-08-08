package com.exam_certification.api_mongo.services;

import com.exam_certification.api_mongo.controllers.request.CourseRequest;
import com.exam_certification.api_mongo.controllers.request.QuestionRequest;
import com.exam_certification.api_mongo.controllers.request.ReplyQuestionRequest;
import com.exam_certification.api_mongo.controllers.response.CourseResponse;
import com.exam_certification.api_mongo.controllers.response.QuestionResponse;
import com.exam_certification.api_mongo.entities.*;
import com.exam_certification.api_mongo.entities.enums.QuestionType;
import com.exam_certification.api_mongo.repositories.CourseRepository;
import com.exam_certification.api_mongo.repositories.QuestionRepository;
import com.exam_certification.api_mongo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseService courseService;

    private final ModelMapper mapper;

    public boolean validateQuestion(QuestionRequest question) {

        if(question.getQuestionType() == QuestionType.multipleChoices && question.getAlternatives().stream().filter(Alternative::isCorrect).count() == 2){
            return true;
        };

        if(question.getQuestionType() == QuestionType.singleChoice && question.getAlternatives().stream().filter(Alternative::isCorrect).count() == 1){
            return true;
        };

        return false;
    }

    public QuestionResponse createQuestion(QuestionRequest questionRequest, String courseId) throws Exception {
        Course course = courseService.getCourseById(courseId).orElseThrow(() -> new Exception("Id do curso não existe"));
        boolean isQuestionValid = validateQuestion(questionRequest);
        if(!isQuestionValid){
            throw new Exception("Questão inválida, verifique o questionType");
        }
        Question question = questionRequest.toEntity();
        question.setCourse(course);
        Question questionCreated = questionRepository.save(question);
        return mapper.map(questionCreated, QuestionResponse.class);
    }

    public List<QuestionResponse> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(el -> mapper.map(el, QuestionResponse.class))
                .toList();
    }

    public Page<Question> getQuestionsByCourse(String courseId) throws Exception {
        courseService.getCourseById(courseId).orElseThrow(() -> new Exception("Id do curso não existe"));
        Pageable paging = PageRequest.of(0, 1);
        return questionRepository.findByCourseId(courseId, paging);
    }


    public User getRepliedQuestions() {
        return userRepository.findRepliedQuestions();
    }


    public Set<RepliedQuestion> replyQuestion(String questionId, ReplyQuestionRequest replyQuestionRequest) throws Exception {

        Question question = questionRepository.findById(questionId).orElseThrow(() -> new Exception("Id da questão não existe"));
        User user = userRepository.findById(replyQuestionRequest.getUserId()).orElseThrow(() -> new Exception("Id de usuário não existe"));

        Set<String> correctAlternatives = new HashSet<>();

        for(Alternative alternative : question.getAlternatives()){
            if(alternative.isCorrect()){
                correctAlternatives.add(alternative.getId());
            }
        }

        boolean isQuestionCorrect = replyQuestionRequest.getAlternativesId().containsAll(correctAlternatives);
        RepliedQuestion repliedQuestion = new RepliedQuestion();
        repliedQuestion.setQuestion(question);
        repliedQuestion.setCorrect(isQuestionCorrect);

        user.getRepliedQuestions().add(repliedQuestion);
        System.out.println(user);
        userRepository.save(user);

        return user.getRepliedQuestions();
    }
}
