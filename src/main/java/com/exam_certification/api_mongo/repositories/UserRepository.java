package com.exam_certification.api_mongo.repositories;

import com.exam_certification.api_mongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'id': '66719852003ad2ea03f6d017', 'repliedQuestions.isCorrect': false}")
    User findRepliedQuestions();

    Optional<User> findByEmailAndPassword(String email, String password);
}