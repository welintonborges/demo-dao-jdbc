package com.example.demo.dao;

import com.example.demo.dao.impl.SellerDaoJDBC;

public class DaoFactory {

  public static SellerDao createSellerDao(){
    return  new SellerDaoJDBC();
  }
}
