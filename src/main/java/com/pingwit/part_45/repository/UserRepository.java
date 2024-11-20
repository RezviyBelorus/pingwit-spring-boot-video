package com.pingwit.part_45.repository;

import com.pingwit.part_45.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
    List<User> findAllByNameContainingIgnoreCase(String name);
    List<User> findAllByRatingGreaterThanEqualAndCountryIn(Double rating, List<String> countries);
//    List<User> findAllByRatingGreaterThanEqualAndLososIn(Double rating, List<String> countries);

    List<User> findAllByPaymentBetween(Double from, Double to);

    List<User> findAllByIdInAndRatingGreaterThanEqualAndNameContainingAndPaymentBetweenAndCountryIn(List<Long> ids, Double rating, String name, Double from, Double to, List<String> countries);

}
