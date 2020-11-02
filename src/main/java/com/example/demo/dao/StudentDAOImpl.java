package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository//(value = "sdao")
@Transactional
public class StudentDAOImpl implements StudentDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<Student> getAllStudents() {
		
		List<Student> data = new ArrayList<Student>();
		Session sess = sessionfactory.getCurrentSession();
		data = sess.createQuery("from Student").list();
		return data;
	}

	@Override
	public void create(Student ob) {
		Session sess = sessionfactory.getCurrentSession();
		sess.beginTransaction();
		sess.save(ob);
		sess.getTransaction().commit();
	}

	@Override
	public void Update(Student ob) {
		try {
		Session sess=sessionfactory.getCurrentSession();
		sess.beginTransaction();
		sess.update(ob);	
		sess.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

	@Override
	public Student getStudentById(int id) {
		Session sess=sessionfactory.getCurrentSession();
		Student ob= sess.get(Student.class, id);
		return ob;
	}

	@Override
	public void delete(int id) 
	{
		try {

		Session sess=sessionfactory.getCurrentSession();
		Student ob= sess.get(Student.class, id);
		sess.beginTransaction();
		sess.delete(ob);
		sess.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
