package com.gosi.company.departments;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

  private final DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @GetMapping("{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
    Department department = departmentService.getDepartmentById(id);
    if (department == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(department, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
    Department newDepartment = departmentService.addDepartment(department);
    return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
  }

  @PutMapping
  public Department updateDepartment(@RequestBody Department department)
      throws DepartmentNotFoundException {
    return departmentService.updateDepartment(department);
  }

}
