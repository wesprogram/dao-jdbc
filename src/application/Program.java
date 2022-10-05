package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("\n=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeler = new Seller(null, "Greg", "greg@mail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeler);
		System.out.println("Inserted! New id: " + newSeler.getId());

		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 6: seller delete ===");
		int id = 15;
		sellerDao.deleteBtId(id);
		System.out.println("Delete completed!");

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		// System.out.println("\n=== TEST 7: department insert ===");
		// Department newDep = new Department(5, "Shoes");
		// departmentDao.insert(newDep);
		// System.out.println("Inserted! New id: " + newDep.getId());

		System.out.println("\n=== TEST 8: department findById ===");
		Department department2 = departmentDao.findById(2);
		System.out.println(department2);

		System.out.println("\n=== TEST 9: department update ===");
		department2 = departmentDao.findById(1);
		department2.setName("Food");
		departmentDao.update(department2);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 10: department delete ===");
		id = 5;
		departmentDao.deleteBtId(id);
		System.out.println("Delete completed!");

		System.out.println("\n=== TEST 10: department findAll ===");
		List<Department> list2 = new ArrayList<>();
		list2 = departmentDao.findAll();

		for (Department obj : list2) {
			System.out.println(obj);
		}

	}

}
