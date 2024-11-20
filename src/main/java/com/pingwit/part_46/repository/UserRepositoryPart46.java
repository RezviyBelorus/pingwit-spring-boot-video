package com.pingwit.part_46.repository;

import com.pingwit.part_46.entity.UserPart46;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryPart46 extends JpaRepository<UserPart46, Long> {
    List<UserPart46> findAllByName(String name);
    List<UserPart46> findAllByNameContainingIgnoreCase(String name);
    List<UserPart46> findAllByRatingGreaterThanEqualAndCountryIn(Double rating, List<String> countries);
//    List<UserPart46> findAllByRatingGreaterThanEqualAndLososIn(Double rating, List<String> countries);

    List<UserPart46> findAllByPaymentBetween(Double from, Double to);

    List<UserPart46> findAllByIdInAndRatingGreaterThanEqualAndNameContainingAndPaymentBetweenAndCountryIn(List<Long> ids, Double rating, String name, Double from, Double to, List<String> countries);

}
