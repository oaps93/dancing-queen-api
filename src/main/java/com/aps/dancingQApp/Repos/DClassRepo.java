package com.aps.dancingQApp.Repos;

import com.aps.dancingQApp.Model.DClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DClassRepo extends CrudRepository<DClass, Long> {
    DClass save(DClass dClass);
    List<DClass> findAll();
    Optional<DClass> findByClassName(String name);
}