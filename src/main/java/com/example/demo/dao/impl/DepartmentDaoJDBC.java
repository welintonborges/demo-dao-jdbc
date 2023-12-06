package com.example.demo.dao.impl;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.db.DbException;
import com.example.demo.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

  private Connection conn;


  public DepartmentDaoJDBC(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void insert(Department obj) {
    PreparedStatement st = null;

    try {
      st = conn.prepareStatement("INSERT INTO  department " +
        "(Name) " +
        "VALUES " +
        "(?)");

      st.setString(1, obj.getName());

      int rowsAffected = st.executeUpdate();

      if(rowsAffected > 0){
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
          int id = rs.getInt(1);
          obj.setId(id);
        }
      }else{
        throw new DbException("Unexpected error! No rows affected!");
      }
    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    }
  }

  @Override
  public void update(Department obj) {

  }

  @Override
  public void deleteById(Integer id) {

  }

  @Override
  public Department findById(Integer id) {
    return null;
  }

  @Override
  public List<Department> finAll() {
    return null;
  }
}
