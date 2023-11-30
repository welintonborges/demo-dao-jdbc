package com.example.demo.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String name;
  public Department() {
  }
  public Department(Integer id, String name) {
    this.id = id;
    this.name = name;
  }
  public int getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Department that = (Department) o;
    return Objects.equals(id, that.id);
  }
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Department{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
