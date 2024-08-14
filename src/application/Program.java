package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SellerDao sellerDao = DaoFactory.createSellerDao();


        System.out.println("===Test 1: Seller findById===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 2: Seller findByDepartment===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj: list) {
            System.out.println(obj);
        }
        System.out.println("\n=== Test 3: Seller findAll===");
       List<Seller> list1 = sellerDao.findAll();
        for (Seller obj: list1) {
            System.out.println(obj);
        }
        System.out.println("\n=== Test 4: Seller Insert===");
        Seller obj = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, new Department(2, null));
        sellerDao.insert(obj);
        System.out.println("Inserted! New id = " + obj.getId());
    }
}
