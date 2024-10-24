package com.gosi.company.departments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
class DepartmentServiceImp implements DepartmentService {

  private final DepartmentRepository departmentRepo;

  public DepartmentServiceImp(DepartmentRepository departmentRepo) {
    this.departmentRepo = departmentRepo;
  }


  @Override
  public List<Department> getAllDepartments() {
    List<Department> departments = new ArrayList<>();
    Iterable<DepartmentEntity> departmentEntities = departmentRepo.findAll();
    for (DepartmentEntity departmentEntity : departmentEntities) {
      departments.add(new Department(departmentEntity));
    }
    return departments;
  }

  @Override
  public Department getDepartmentById(long id) {
    Optional<DepartmentEntity> departmentEntity = departmentRepo.findById(id);
    if (departmentEntity != null && departmentEntity.isPresent()) {
      return new Department(departmentEntity.get());
    }
    return null;
  }

  @Override
  public Department addDepartment(Department department) {
    DepartmentEntity entity = new DepartmentEntity(department);
    entity.setId(null);
    DepartmentEntity newEntity = departmentRepo.save(entity);
    return new Department(newEntity);
  }

  @Override
  public Department updateDepartment(Department department) throws DepartmentNotFoundException{
    if (departmentRepo.existsById(department.getId())) {
      DepartmentEntity entity = new DepartmentEntity(department);
      DepartmentEntity updatedEntity = departmentRepo.save(entity);
      return new Department(updatedEntity);
    }
    throw new DepartmentNotFoundException("Department with id = "+ department.getId() + " not found");
  }

  @Override
  public void deleteDepartment(long id) throws DepartmentNotFoundException {
    if (departmentRepo.existsById(id)) {
      departmentRepo.deleteById(id);
    }
    throw new DepartmentNotFoundException("Department with id = "+id + " not found");
  }

  @Override
  public Department getDepartmentByName(String name) {
    Optional<DepartmentEntity> departmentEntity = departmentRepo.findByName(name);
    if (departmentEntity.isPresent()) {
      return new Department(departmentEntity.get());
    }
    return null;
  }
}
