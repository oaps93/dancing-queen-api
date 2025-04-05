package com.aps.dancingQApp.Service;

import com.aps.dancingQApp.Exceptions.InstructorException;
import com.aps.dancingQApp.Model.Instructor;
import com.aps.dancingQApp.Repos.InstructorRepo;
import com.aps.dancingQApp.Util.DQConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class InstructorService {
    private final InstructorRepo instructorRepo;

    public InstructorService(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }
    public Instructor newInstructor(Instructor input) throws InstructorException {

        log.info("Creating new Instructor data for: {}",input);

        Instructor newInstructor = instructorRepo.save(input);

        if(ObjectUtils.isEmpty(newInstructor)) {
            log.info("New instructor successfully added: {}", newInstructor);
        } else {
            throw new InstructorException(DQConstants.INSTRUCTOR_SAVE_ERROR);
        }

        return newInstructor;
    }
}