package com.example.demo.dao;

import com.example.demo.entities.Department;

import java.util.List;

public interface DepartementDao {

  void insert(Department obj);
  void update(Department obj);
  void deleteById(Integer id);
  Department findById(Integer id);
  List<Department> finAll();
}
