package com.briz.springbootpatchexample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "This is Patch Test";
}
//insert into employee (age,name) values (?,?) if only name and age are sent into postman other are with null 
@RequestMapping("/save")
public Employee save(@RequestBody Employee employee)
{
	return erepo.save(employee);
}
/*   THIS IS FOR UPDATING ALL THE FIELDS 
@PutMapping("/{id}")
public Employee upd(@RequestBody Employee employee,@pathVariable int id)
{
Employee e=erepo.findById(id).get();
e.setAge(employee.getAge());
e.setName(employee.getName());
e.setCity(employee.getCity());
erepo.save(e);
return employee;
}
*/

@PatchMapping("/partial/{id}")// ONLY NAME AND AGE UPDATE NOTE THIS BOTH MUST BE PASSED 
public Employee part(@RequestBody Employee employee,@PathVariable int id)
{
	// update employee set age=?,city=?,name=? where id=? without dynamic insert and update
	// update employee set age=?,name=? where id=?    with dynamic insert and update
Employee e=erepo.findById(id).get();
e.setAge(employee.getAge());
e.setName(employee.getName());
erepo.save(e);
return e;
}

@RequestMapping("/all")
public List<Employee> alldata()
{
	return erepo.findAll();
}
@RequestMapping("/{id}")
public Optional<Employee> byid(@PathVariable int id)
{
	return erepo.findById(id);
}
@RequestMapping("/name/{name}")
public List<Employee> byname(@PathVariable String name)
{
	return erepo.findByName(name);
}
@RequestMapping("/city/{city}")
public List<Employee> bycity(@PathVariable String city)
{
	return erepo.findByCity(city);
}
/*
@RequestMapping("/both/{name}/{city}")
List<Employee> both(@PathVariable String name,@PathVariable String city)
{
	
}
*/
}




