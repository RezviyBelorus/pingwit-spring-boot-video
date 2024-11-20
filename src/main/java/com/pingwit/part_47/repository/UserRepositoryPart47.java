package com.pingwit.part_47.repository;

import com.pingwit.part_47.entity.UserPart47;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryPart47 extends JpaRepository<UserPart47, Long> {
    List<UserPart47> findAllByName(String name);

    List<UserPart47> findAllByNameContainingIgnoreCase(String name);

    List<UserPart47> findAllByRatingGreaterThanEqualAndCountryIn(Double rating, List<String> countries);
//    List<UserPart47> findAllByRatingGreaterThanEqualAndLososIn(Double rating, List<String> countries);

    List<UserPart47> findAllByPaymentBetween(Double from, Double to);

    List<UserPart47> findAllByIdInAndRatingGreaterThanEqualAndNameContainingAndPaymentBetweenAndCountryIn(List<Long> ids, Double rating, String name, Double from, Double to, List<String> countries);

}
