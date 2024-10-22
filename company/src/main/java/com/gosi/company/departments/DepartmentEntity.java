package com.gosi.company.departments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 255)
  private String name;

  @Column(nullable = false, length = 255)
  private String location;

  public DepartmentEntity() {

  }

  public DepartmentEntity(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public DepartmentEntity(Department department){
    this.id = department.getId();
    this.name = department.getName();
    this.location = department.getLocation();
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public String toString() {
    return "DepartmentEntity {id=" + id + ", name=" + name + ", location=" + location + "}";
  }
}
