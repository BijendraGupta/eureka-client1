package com.bijendra.eureka.feignclientinterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bijendra.eureka.modal.Student;


@FeignClient(name="eureka-client-service")
public interface FeignClientInterface {
	@RequestMapping(value = "/getStudents",method = RequestMethod.GET)
    public List<Student> getStudents();
}