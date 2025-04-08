package com.aps.dancingQApp.Service;

import com.aps.dancingQApp.Exceptions.InstructorException;
import com.aps.dancingQApp.Model.DClass;
import com.aps.dancingQApp.Model.Instructor;
import com.aps.dancingQApp.Model.InstructorDTO;
import com.aps.dancingQApp.Repos.DClassRepo;
import com.aps.dancingQApp.Repos.InstructorRepo;
import com.aps.dancingQApp.Util.DQConstants;
import com.aps.dancingQApp.Util.InstructorMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InstructorService {
    private final InstructorRepo instructorRepo;
    private final DClassRepo dClassRepo;

    public InstructorService(InstructorRepo instructorRepo, DClassRepo dClassRepo) {
        this.instructorRepo = instructorRepo;
        this.dClassRepo = dClassRepo;
    }

    public InstructorDTO newInstructor(InstructorDTO input) throws InstructorException {

        Optional<Instructor> instructorOpt = instructorRepo.findByName(input.getName());
        if(instructorOpt.isPresent()) {
            log.info("Instructor name exist");
            return InstructorMapper.toDTO(instructorOpt.get());
        }

        log.info("Creating new Instructor data for: {}",input);

        Instructor instructor = instructorRepo.save(InstructorMapper.toEntity(input));

        if(!ObjectUtils.isEmpty(instructor)) {
            log.info("New instructor successfully added: {}", instructor);
        } else {
            throw new InstructorException(DQConstants.INSTRUCTOR_SAVE_ERROR);
        }
        return InstructorMapper.toDTO(instructor);
    }

    public List<InstructorDTO> getAllInstructors() {
        log.info("Returning all Instructors");
        return InstructorMapper.toDTOList(instructorRepo.findAll());
    }

    @Transactional
    public synchronized Instructor addClassToInstructor(String instructorName, String className) throws InstantiationException {
        Instructor instructor = instructorRepo.findByName(instructorName).orElse(new Instructor());
        DClass dClass = dClassRepo.findByClassName(className).orElse(new DClass());

        log.info("Adding class {} to instructor {}.", dClass.getClassName(), instructor.getName());
        if(instructor != null && dClass != null) {
            instructor.addClass(dClass);
            return instructorRepo.save(instructor);
        }
        throw new InstantiationException(DQConstants.INSTRUCTOR_NEW_CLASS_ERROR);
    }
}