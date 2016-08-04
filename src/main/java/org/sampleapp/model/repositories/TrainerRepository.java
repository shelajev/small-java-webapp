package org.sampleapp.model.repositories;

import org.sampleapp.model.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by shelajev on 22/07/16.
 */
public interface TrainerRepository extends CrudRepository<Trainer, Long> {

  List<Trainer> findByName(String name);
  Page<Trainer> findAll(Pageable pageable);

}