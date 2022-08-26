package com.spring.orm.dao;

import java.awt.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.util.DnsSrv.SrvRecord;
import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	/* Save Student */
	@Transactional
	public int insert(Student student) {
		Integer row = (Integer) hibernateTemplate.save(student);
		return row;
	}

	/* get the single Student data(Object) */
	public Student getStudent(int studentId) {

		// Student student=this.hibernateTemplate.get(Student.class, studentId);
		// return student;

		return this.hibernateTemplate.get(Student.class, studentId);
	}

	/* get All Student (all Rows) */
	public java.util.List<Student> getAllStudent() {
//		java.util.List<Student> students = hibernateTemplate.loadAll(Student.class);
		// return student;
		return hibernateTemplate.loadAll(Student.class);
	}

	/* delete Student */
	@Transactional
	public boolean deleteStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
		return true;
	}

	/* Updating student data */
	@Transactional
	public boolean updateStudent(Student student) {
		this.hibernateTemplate.update(student);
		return true;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
