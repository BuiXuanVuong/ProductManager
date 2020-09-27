import model.Product;
import service.ProductService;

import java.util.*;

public class Main {

    public static void display(List<Product> arr) {
        Iterator<Product> iterator = arr.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        int choose;
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();


        System.out.println("1. Add new product");
        System.out.println("2. Update product");
        System.out.println("3. Delete product");
        System.out.println("4. Find product by id");
        System.out.println("5. Find product by name");
        System.out.println("6. Sort price product");
        System.out.println("8. Display list product");
        System.out.println("0. Exit");
        System.out.println("Your choice ");
        do {
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("----------------Add product--------------");
                    System.out.println("Input id new product");
                    int id = 0;
                    String name = "";
                    long price = 0;
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Input name new product ");
                    name = sc.nextLine();
                    System.out.println("Input price new product");
                    price = sc.nextLong();
                    Product product = new Product(id,name,price);
                    productService.addProduct(product);
                    System.out.println("Add new product success!");
                    break;

                case 2:
                    System.out.println("---------------Update product---------------");
                    System.out.println("Input id for update");
                    id = sc.nextInt();
                    sc.nextLine();
                    if(productService.checkId(id)) {
                        System.out.println("Input name update");
                        name = sc.nextLine();
                        System.out.println("Input price update");
                        price = sc.nextLong();
                        productService.updateProduct(id, name, price);
                        System.out.println("Update success!");
                    } else {
                        System.out.println("No found id!");
                    }
                    break;

                case 3:
                    System.out.println("---------------Delete product---------------");
                    System.out.println("Input id for delete");
                    id = sc.nextInt();
                    if(productService.checkId(id)) {
                        System.out.println(productService.deleteProduct(id));
                        System.out.println("Delete success!");
                    } else {
                        System.out.println("No found id");
                    }
                    break;
                case 4:
                    System.out.println("---------------Find by Id---------------");
                    System.out.println("Input id find");
                    id = sc.nextInt();
                    if(productService.findProductById(id) != null) {
                        System.out.println("Information product has id " + id);
                        System.out.println(productService.findProductById(id));
                    } else {
                        System.out.println("No found id");
                    };
                    break;
                case 5:
                    System.out.println("---------------Find by Name---------------");
                    System.out.println("Input name find");
                    name = sc.next();
                    System.out.println("Information products have name: " + name);
                    display(productService.findProductByName(name));
                    break;
                case 6:
                    System.out.println("---------------Sort by price---------------");
                    productService.sortProduct(ProductService.productList);
                    display(ProductService.productList);
                    break;
                case 8:
                    System.out.println("---------------Display list product---------------");
                    display(ProductService.productList);
                    break;
                case 0:
                    System.out.println("---------------Exit program---------------");
                    System.exit(0);
                default:
                    System.out.println("------------------------------");
                    break;
            }
                System.out.println("Your choice");
        } while (true);
    }
}
