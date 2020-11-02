package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@CrossOrigin(origins = "http://localhost:4200",
methods = {RequestMethod.GET ,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
@RestController
public class StudentController {

	@Autowired 
	StudentDao sdao;
	
	@GetMapping("/allstudents")
	public ResponseEntity<List<Student>> allStudents()
	{
		List<Student> allstu;
		allstu = sdao.getAllStudents();
		if(allstu==null)
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		else 
		return new ResponseEntity<List<Student>>(allstu, HttpStatus.OK );//200
		
	}
	
	//@PostMapping("/addStudent")
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public ResponseEntity<Student> saveStudent (@RequestBody Student ob)
	{
		if(ob!= null)
		{
		sdao.create(ob);
		return new ResponseEntity<Student>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.PUT)
	public ResponseEntity<Student> Update(@RequestBody Student ob)
	{
		if(ob!= null)
		{
			sdao.Update(ob);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id)
	{
		Student ob=sdao.getStudentById(id);
		if(ob!= null)
		{
		return new ResponseEntity<Student>(ob,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable int id)
	{
		sdao.delete(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
}
