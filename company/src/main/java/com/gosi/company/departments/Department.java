package com.gosi.company.departments;

public class Department {

  private Long id;
  private String name;
  private String location;

  public Department(){

  }

  public Department(Long id, String name, String location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }

  public Department(DepartmentEntity entity){
    this.id = entity.getId();
    this.name = entity.getName();
    this.location = entity.getLocation();
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
    return "Department {id=" + id + ", name=" + name + ", location=" + location + "}";
  }
}
