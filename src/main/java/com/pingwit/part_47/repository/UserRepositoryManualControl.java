package com.pingwit.part_47.repository;

import com.pingwit.part_46.dto.UserDto;
import com.pingwit.part_47.entity.UserPart47;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryManualControl {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    @PostConstruct
    private void init() {
//        find(1L);
//        findWithSpring(1L);
    }

    public UserDto find(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();
        transaction.begin();

        UserPart47 user = session.find(UserPart47.class, id);
        user.setName("Egorka2");
        boolean sessionContainsUser = session.contains(user);
        System.out.println("sessionContainsUser = " + sessionContainsUser);

        UserPart47 user_2 = session.find(UserPart47.class, id);

        session.persist(user);

        session.flush();
        transaction.commit();
        session.close();
//        UserPart47 user_3 = session.find(UserPart47.class, id);


        return null;
    }

    @Transactional
    public UserDto findWithSpring(Long id) {
        Session session = this.entityManager.unwrap(Session.class);

//        Transaction transaction = session.getTransaction();
//        transaction.begin();
        UserPart47 user = session.find(UserPart47.class, id);

        boolean sessionContainsUser = session.contains(user);
        System.out.println("sessionContainsUser = " + sessionContainsUser);

        UserPart47 user_2 = session.find(UserPart47.class, id);

        session.persist(user);

        session.flush();
//        transaction.commit();
        session.close();

        return null;
    }

}
