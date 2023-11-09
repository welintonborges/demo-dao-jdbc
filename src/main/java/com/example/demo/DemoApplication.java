package com.example.demo;

import com.example.demo.entities.Department;
import com.example.demo.entities.Seller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);

    System.out.println("---Testando Objeto departamento---");

    Department obj = new Department(1, "Books");
    System.out.println(obj);

    System.out.println("---Testando Objeto Seller---");

    Seller seller = new Seller(21, "Bob","bob@gmail.com", new Date(), 4000.0, obj);
    System.out.println(seller);
  }

}
