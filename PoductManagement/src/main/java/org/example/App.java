package org.example;
import java.sql.SQLException;
import java.util.*;
public class App 
{
    public static void main( String[] args )  {
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("-----CRUD Operations------");
            System.out.println("1. Insert Product");
            System.out.println("2.  View Products");
            System.out.println("3.  Update Product");
            System.out.println("4.  Delete Product");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice=Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1://Integer product_id,String product_name,String category,Double price,int quantity,Float rating,String manufacturer
                    System.out.println("enter product_id");
                    int product_id=sc.nextInt();
                    sc.nextLine();

                    System.out.println("enter product_name");
                    String product_name=sc.nextLine();

                    System.out.println("enter category");
                    String category=sc.nextLine();

                    System.out.println("Enter Price:");
                    Double price=sc.nextDouble();

                    System.out.println("Enter Quantity");
                    int quantity= sc.nextInt();

                    System.out.println("Enter Rating");
                    Float rating= sc.nextFloat();
                    sc.nextLine();

                    System.out.println("enter manufacturer");
                    String manufacturer=sc.nextLine();


                    Operations.addProduct(product_id, product_name,category,price,quantity,rating,manufacturer);
                    break;


                case 2:
                    System.out.println("22222");
                    Operations.display();
                    break;

                case 3:{
                    System.out.println("Enter Product ID to update:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Which field do you want to update?");
                    System.out.println("1. Name");
                    System.out.println("2. Category");
                    System.out.println("3. Price");
                    System.out.println("4. Quantity");
                    System.out.println("5. Rating");
                    System.out.println("6. Manufacturer");

                    int option = sc.nextInt();
                    sc.nextLine();

                    String field = "";

                    switch (option) {
                        case 1: field = "product_name"; break;
                        case 2: field = "category"; break;
                        case 3: field = "price"; break;
                        case 4: field = "quantity"; break;
                        case 5: field = "rating"; break;
                        case 6: field = "manufacturer"; break;
                        default:
                            System.out.println("Invalid choice");
                            return;
                    }

                    System.out.println("Enter new value:");
                    String newValue = sc.nextLine();

                    Operations.updateProduct(id, field, newValue);
                    break;
                }


                case 4: {
                    System.out.println("Enter Product ID to delete:");
                    int id = Integer.parseInt(sc.nextLine());

                    Operations.deleteProduct(id);
                    break;
                }

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }

        }
    }
}
