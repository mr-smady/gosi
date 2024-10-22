package com.gosi.company.departments;

import java.util.List;

public interface DepartmentService {

  List<Department> getAllDepartments();
  Department getDepartmentById(long id);
  Department addDepartment(Department department);
  Department updateDepartment(Department department);
  void deleteDepartment(long id);
  Department getDepartmentByName(String name);
}
