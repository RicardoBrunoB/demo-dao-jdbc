package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: findById =====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert =====");
		Department newDepartment = new Department(9, "Logística");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());

		System.out.println("\n=== TEST 4: update =====");
		Department dep2 = departmentDao.findById(4);
		dep2.setName("Fashion Week");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();
	}
}
