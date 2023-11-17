package com.example.demo.dao;

import com.example.demo.entities.Seller;

import java.util.List;

public interface SellerDao {

  void insert(Seller obj);
  void update(Seller obj);
  void deleteById(Integer id);
  Seller findById(Integer id);
  List<Seller> finAll();
}