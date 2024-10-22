package com.gosi.company.departments;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
  Optional<DepartmentEntity> findByName(String name);
}
