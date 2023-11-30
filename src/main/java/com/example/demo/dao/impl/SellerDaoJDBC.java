package com.example.demo.dao.impl;

import com.example.demo.dao.SellerDao;
import com.example.demo.db.DB;
import com.example.demo.db.DbException;
import com.example.demo.entities.Department;
import com.example.demo.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st = conn.prepareStatement("SSELECT seller.*,department.Name as DepName " +
        "FROM seller INNER JOIN department " +
        "ON seller.DepartmentId = department.Id " +
        "ORDER BY Name ");

      rs = st.executeQuery();

      List<Seller> list =  new ArrayList<>();
      Map<Integer, Department> map = new HashMap<>();

      while (rs.next()){
        Department dep = map.get(rs.getInt("DepartmentId"));

        if (dep == null){
          dep = instantiateDepartament(rs);
          map.put(rs.getInt("DepartmentId"), dep);
        }

        Seller obj =instantiateSeller(rs, dep);
        list.add(obj);
      }
      return list;

    }catch (SQLException e){
      throw new DbException(e.getMessage());
    }finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  @Override
  public List<Seller> findByDepartment(Department department) {
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st = conn.prepareStatement("SSELECT seller.*,department.Name as DepName " +
        "FROM seller INNER JOIN department " +
        "ON seller.DepartmentId = department.Id " +
        "WHERE DepartmentId =  ? " +
        "ORDER BY Name ");

      st.setInt(1, department.getId());
      rs = st.executeQuery();

      List<Seller> list =  new ArrayList<>();
      Map<Integer, Department> map = new HashMap<>();

      while (rs.next()){
        Department dep = map.get(rs.getInt("DepartmentId"));

        if (dep == null){
            dep = instantiateDepartament(rs);
            map.put(rs.getInt("DepartmentId"), dep);
        }

        Seller obj =instantiateSeller(rs, dep);
        list.add(obj);
      }
      return list;

    }catch (SQLException e){
      throw new DbException(e.getMessage());
    }finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }
}
