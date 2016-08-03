package org.sampleapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.sampleapp.model.Trainer;

import java.util.List;

/**
 * Created by shelajev on 22/07/16.
 */
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
  List<Trainer> findByName(String name);
}