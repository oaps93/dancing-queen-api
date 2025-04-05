package com.aps.dancingQApp.Repos;

import com.aps.dancingQApp.Model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InstructorRepo extends CrudRepository<Instructor, Long> {

    Optional<Instructor> findById(Long id);
    Instructor save(Instructor instructor);
}
