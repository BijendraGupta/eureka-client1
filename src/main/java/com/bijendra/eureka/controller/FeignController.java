package com.bijendra.eureka.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bijendra.eureka.feignclientinterface.FeignClientInterface;
import com.bijendra.eureka.modal.Student;


/**
 * @author pc
 *
 */
@RestController
@RequestMapping(value = "/client2/")
public class FeignController {

	List<Student> studentList=new ArrayList<>();
	{studentList.add(new Student("Bijendra", "B.Tech", "IND"));
		
	}
	
	@Autowired
	private FeignClientInterface feignObj;
	
	@RequestMapping(value = "studList",method = RequestMethod.GET)
	public List<Student> getAllListOfStudent(@RequestParam String type){
	return Stream.concat(studentList.stream(), feignObj.getStudents().stream())
            .collect(Collectors.toList());
	}
}
