package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		//MySQLConnector = Projeto que utiliza o MySQL para acesso de dados em um banco de dados relacional
		
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

	}

}
