package com.aps.dancingQApp.Service;

import com.aps.dancingQApp.Exceptions.DClassException;
import com.aps.dancingQApp.Model.DClass;
import com.aps.dancingQApp.Model.DClassDTO;
import com.aps.dancingQApp.Repos.DClassRepo;
import com.aps.dancingQApp.Util.DClassMapper;
import com.aps.dancingQApp.Util.DQConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DClassService {
    private final DClassRepo dClassRepo;

    public DClassService(DClassRepo dClassRepo) {
        this.dClassRepo = dClassRepo;
    }

    public DClassDTO newDClass(DClassDTO input) throws DClassException {

        Optional<DClass> dClassOpt = dClassRepo.findByClassName(input.getClassName());

        if(dClassOpt.isPresent()) {
            log.info("Class already exist");
            return DClassMapper.toDTO(dClassOpt.get());
        }

        log.info("Creating new Dance Class for {}", input);

        DClass dClass = dClassRepo.save(DClassMapper.toEntity(input));

        if(!ObjectUtils.isEmpty(dClass)) {
            log.info("New Dance Class successfully added: {}", dClass);
        } else {
            throw new DClassException(DQConstants.DCLASS_SAVE_ERROR);
        }
        return DClassMapper.toDTO(dClass);
    }

    public List<DClassDTO> getAllClasses() {
        log.info("Retrieving all classes");
        return DClassMapper.toDTOList(dClassRepo.findAll());
    }
}