package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		//MySQLConnector = Projeto que utiliza o MySQL para acesso de dados em um banco de dados relacional
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();//criação de um sellerDao usando uma fabrica.
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);//Buscando o vendedor pelo Id 3
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findById ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll() ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(0), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update complete");
		
		System.out.println("\n=== Test 6: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
