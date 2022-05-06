package com.knoldus.CRUD.operations.using.Spring.Cloud.GCP;

import com.google.cloud.spanner.Key;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
public class CrudOperationsUsingSpringCloudGcpApplication {




	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsUsingSpringCloudGcpApplication.class, args);
	}

}


@RestController
class HelloController{

	private final EmployeeRepository employeeRepository;

	HelloController(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;

	}

	@GetMapping("/hello")
	String hello(String name){
		Employee e = new Employee(UUID.randomUUID().toString(), name);
		return "hello" + name;

	}

}

@RepositoryRestResource
interface EmployeeRepository extends SpannerRepository<Employee, Key>{

}

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee{
	@Id
	@PrimaryKey
	private String id;
	private String name;

}
