package com.example.demo.dao.impl;

import com.example.demo.dao.SellerDao;
import com.example.demo.db.DB;
import com.example.demo.db.DbException;
import com.example.demo.entities.Department;
import com.example.demo.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

  private Connection conn;

  public SellerDaoJDBC(Connection conn){
    this.conn = conn;
  }

  @Override
  public void insert(Seller obj) {

  }

  @Override
  public void update(Seller obj) {

  }

  @Override
  public void deleteById(Integer id) {

  }

  @Override
  public Seller findById(Integer id) throws SQLException {
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st = conn.prepareStatement("SELECT seller.*, department.Name as DepName" +
        "FROM seller INNER JOIN department ON " +
        "seller.DepartmentId = department.Id WHERE seller.id = ?");

      st.setInt(1, id);
      rs = st.executeQuery();

      if(rs.next()){
        Department department = instantiateDepartament(rs);
        return instantiateSeller(rs, department);
      }
      return null;
    }catch (SQLException e){
      throw new DbException(e.getMessage());
    }finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  private Seller instantiateSeller(ResultSet rs, Department departmentm) throws SQLException {
    Seller  obj = new Seller();
    obj.setId(rs.getInt("id"));
    obj.setName(rs.getString("Name"));
    obj.setEmail(rs.getString("Email"));
    obj.setBaseSalary(rs.getDouble("BaseSalary"));
    obj.setBirthDate(rs.getDate("BrithDate"));
    obj.setDepartment(departmentm);
    return obj;
  }

  private Department instantiateDepartament(ResultSet  rs) throws SQLException {
    Department department  = new Department();
    department.setId(rs.getInt("DepartmentId"));
    department.setName(rs.getString("DepName"));
    return  department;
  }


  @Override
  public List<Seller> finAll() {
    return null;
  }
}
