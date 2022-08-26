package com.spring.orm;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);

//		Student student = new Student(1, "Manish", "Indore");
//		int row=studentDao.insert(student);
//	System.out.println("Done = "+row);

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		String studentName, studentCity;
		int studentId;
		while (flag) {
			try {

				System.out.println("\nPress 1 for Add Student");
				System.out.println("Press 2 for get Student details");
				System.out.println("Press 3 for show All Students details");
				System.out.println("Press 4 for Delete Student");
				System.out.println("Press 5 for Update Student");
				System.out.println("Press 6 or any other key for Exit\n");

				int input = scanner.nextInt();
				switch (input) {
				case 1: {
					// add Student
					System.out.println("Enter Student Id");
					studentId = scanner.nextInt();

					System.out.println("Enter Student City");
					studentCity = scanner.next();

					System.out.println("Enter Student Name");
					studentName = scanner.next();

					int row = studentDao.insert(new Student(studentId, studentCity, studentName));
					System.out.println(row + " =Student Added");
					break;
				}
				case 2: {
					// get Student details
					System.out.println("Enter Student Id");
					studentId = scanner.nextInt();
					Student student = studentDao.getStudent(studentId);
					System.out.print(student);
					break;
				}
				case 3: {
					// show All Students details
					System.out.print(studentDao.getAllStudent());
					break;
				}
				case 4: {
					// Delete Student
					System.out.println("Enter Student Id");
					studentId = scanner.nextInt();

					if (studentDao.deleteStudent(studentId))
						System.out.println("Student Success Fully Deleted");
					else
						System.out.println("Student Success Fully Deleted");
					break;
				}
				case 5: {
					// Update Student
					System.out.println("Enter Student Id");
					studentId = scanner.nextInt();

					System.out.println("Enter Student City");
					studentCity = scanner.next();

					System.out.println("Enter Student Name");
					studentName = scanner.next();

					boolean updateStudent = studentDao.updateStudent(new Student(studentId, studentCity, studentName));
					if (updateStudent) {
						System.out.println("Update Successfully");
					} else
						System.out.println("Update Not Successfully");
					break;
				}
				case 6: {
					// Exit
					flag = false;
					System.out.print("Good By");
					break;
				}
				default: {
					flag = false;
					System.out.print("Good By");
					break;
				}
				}
				//flag = false;
			} catch (Exception e) {
				System.out.println("Invalid input ");
				e.printStackTrace();
			}
		}
	}
}
