package org.example;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RootRepository extends CrudRepository<RootEntity, Long> {
  List<RootEntity> findByName(String name);

  @Query("SELECT DISTINCT root FROM RootEntity root " +
          "LEFT JOIN FETCH root.subList l " +
          "LEFT JOIN FETCH l.one")
  List<RootEntity> findRelationAll();

}
