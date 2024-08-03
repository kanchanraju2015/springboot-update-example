package com.briz.springbootpatchexample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>
{
List<Employee> findByName(String name);
List<Employee> findByCity(String city);
List<Employee> findByNameAndCity(String name,String city);
List<Employee> findByNameOrCity(String name,String city);

List<Employee> findByNameContains(String name);


}
