package ProjectInventoryApp.app;
import  ProjectInventoryApp.dao.ProductDAO;
import  ProjectInventoryApp.model.Product;

import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true){

            System.out.println("\n===== PRODUCT INVENTORY MENU =====");
            System.out.println("1 Add Product");
            System.out.println("2 View All Products");
            System.out.println("3 View Product By ID");
            System.out.println("4 Update Product Price");
            System.out.println("5 Update Product Quantity");
            System.out.println("6 Delete Product");
            System.out.println("7 Search Product By Name");
            System.out.println("8 Show Low Stock Products");
            System.out.println("9 Exit");

            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("Enter ID:");
                    int id=sc.nextInt();

                    System.out.println("Enter Name:");
                    String name=sc.next();

                    System.out.println("Category:");
                    String cat=sc.next();

                    System.out.println("Price:");
                    double price=sc.nextDouble();

                    System.out.println("Quantity:");
                    int qty=sc.nextInt();

                    System.out.println("Rating:");
                    double rating=sc.nextDouble();

                    Product p=new Product(id,name,cat,price,qty,rating);

                    dao.addProduct(p);

                    break;

                case 2:
                    dao.viewAllProducts();
                    break;

                case 3:
                    System.out.println("Enter id:");
                    dao.viewProductById(sc.nextInt());
                    break;

                case 4:
                    System.out.println("Enter id:");
                    int pid=sc.nextInt();
                    System.out.println("New price:");
                    double np=sc.nextDouble();
                    dao.updatePrice(pid,np);
                    break;

                case 5:
                    System.out.println("Enter id:");
                    int pid2=sc.nextInt();
                    System.out.println("New qty:");
                    int nq=sc.nextInt();
                    dao.updateQuantity(pid2,nq);
                    break;

                case 6:
                    System.out.println("Enter id:");
                    dao.deleteProduct(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Enter keyword:");
                    dao.searchProduct(sc.next());
                    break;

                case 8:
                    dao.lowStockProducts();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}
