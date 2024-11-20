package com.pingwit.part_50.service;

import com.pingwit.part_50.entity.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PhonesTransactionalPropagationService {

    private final PhonesTransactionalClassService transactionalClassService;

    @Transactional
    public Phone savePropagationRequiresNew(Phone phone) {
        transactionalClassService.savePropagationRequiresNew(phone);

        throw new RuntimeException();
    }

    @Transactional
    public Phone savePropagationNever(Phone phone) {
        transactionalClassService.savePropagationNever(phone);

        throw new RuntimeException();
    }
}
