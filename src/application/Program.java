package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: Seller findById ====");
		Seller seller = sellerDao.findyById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: Seller findByDepartment ===");
		Department department = new Department(2, null);

		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);

		}

		System.out.println("\n=== TEST 3: Seller findAll ===");

		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: Seller Insert ===");

		Seller newSeller = new Seller(null, "Greg", "greg@hotmail.com", new Date(), (double) 4000, department);
		// sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: Seller Update ===");
		seller = sellerDao.findyById(1);
		seller.setName("Marta Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed");
		System.out.println(seller);

		System.out.println("\n=== TEST 6: Seller Delete from Id ===");
		System.out.println("Enter id for delete seller: ");
		int id = sc.nextInt();
		sellerDao.deletById(id);
		System.out.println("Delete Complete");
		sc.close();
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
	}
}
