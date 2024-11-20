package com.pingwit.part_50.service;

import com.pingwit.part_50.entity.Phone;
import com.pingwit.part_50.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PhonesTransactionalClassService {

    private final PhoneRepository phoneRepository;

    public Phone save(Phone phone) throws Exception {
        Phone save = phoneRepository.save(phone);

        throw new RuntimeException("Transaction rollback");
    }

    public Phone saveCheckedException(Phone phone) throws Exception {
        Phone save = phoneRepository.save(phone);

        throw new Exception("Transaction will NOT rollback");
    }

    @Transactional(rollbackFor = Exception.class)
    public Phone saveRollbackFor(Phone phone) throws Exception {
        Phone save = phoneRepository.save(phone);

        throw new Exception("Transaction will rollback");
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public Phone saveNoRollbackFor(Phone phone) {
        Phone save = phoneRepository.save(phone);

        throw new RuntimeException("Transaction will NOT rollback");
    }

    @Transactional(readOnly = true)
    public Phone saveReadOnlyTrue(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional
    public Phone savePropagationRequiresNew(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Transactional(propagation = Propagation.NEVER)
    public Phone savePropagationNever(Phone phone) {
        return phoneRepository.save(phone);
    }

}
