package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: Department findById ====");
		Department department = departmentDao.findyById(3);
		System.out.println(department);

		System.out.println("\n=== TEST 3: Seller findAll ===");
		
		//continuar daqui
		List<Seller> list = departmentDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: Department Insert ===");

		Department newDepartment = new Department(null, "Music");
		// departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 5: Department Update ===");
		department = departmentDao.findyById(15);
		department.setName("Developers");
		departmentDao.update(department);
		System.out.println("Update completed");
		System.out.println(department);

		System.out.println("\n=== TEST 6: Department Delete from Id ===");
		System.out.println("Enter id for delete department: ");
		int id = sc.nextInt();
		departmentDao.deletById(id);
		System.out.println("Delete Complete");
		sc.close();

	}

}
