package com.example.dockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dockerexample.json.Employee;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

@SpringBootApplication
public class DockerexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerexampleApplication.class, args);
		System.out.println("Hello Loannt");
		
		String json ="{"
                + "\"Emp_Name\":\"Robert\""
                + ",\"Emp_Gen\":\"No1332\""
                + ",\"Emp_dept\":\"Developement\""
                + ",\"Emp_age\":\"25\""
                + ",\"Emp_Pos\":\"Staff\""
                + ",\"Emp_colleague\":[\"Lina\",\"Tom\",\"Thomas\"]"
                + "}";
         // Cách 1 chuyển đổi json thành object
         Gson gson = new Gson(); // khởi tạo Gson  
         Employee employee = gson.fromJson(json, Employee.class); // parse Gson về object
         System.out.println("Emp_Name:"+ employee.emp_Name);
         System.out.println("Emp_Gen:"+ employee.emp_Gen);
         System.out.println("Emp_age:"+ employee.emp_age);
         System.out.println("Emp_Pos:"+ employee.emp_Pos);
         System.out.println("Emp_dept:"+ employee.emp_dept);
         System.out.println("Emp_colleague:"+ employee.emp_colleague.toString());
         

	}

}
