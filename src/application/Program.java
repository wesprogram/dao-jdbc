package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.print("Enter the ID: ");
		
		Seller seller = sellerDao.findById(sc.nextInt());
		
		System.out.println(seller);
		
		sc.close();

	}

}
