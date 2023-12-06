package com.example.demo.dao;

import com.example.demo.dao.impl.DepartmentDaoJDBC;
import com.example.demo.dao.impl.SellerDaoJDBC;
import com.example.demo.db.DB;

public class DaoFactory {

  public static SellerDao createSellerDao(){
    return  new SellerDaoJDBC(DB.getConnection());
  }

  public  static  DepartmentDao createDepartmentDao(){
    return new DepartmentDaoJDBC(DB.getConnection());
  }
}
