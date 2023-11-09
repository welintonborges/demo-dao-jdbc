package com.example.demo;

import com.example.demo.entities.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);

    System.out.println("---Testando Objeto departamento---");

    Department obj = new Department(1, "Books");
    System.out.println(obj);
  }

}
