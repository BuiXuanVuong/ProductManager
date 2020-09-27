package service;

import model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductService implements IService<Product> {
    public static List<Product> productList = new ArrayList<>();
    int indexId = 0;
    static {
        for (int i = 0; i < 1; i+=6) {
            productList.add(new Product(i+0,"Apple",1500));
            productList.add(new Product(i+1,"Samsung",1300));
            productList.add(new Product(i+2,"Sony",1000));
            productList.add(new Product(i+3,"Asus",1600));
            productList.add(new Product(i+4,"Asus",1200));
            productList.add(new Product(i+5,"Lenovo",2500));
        }

    }


    @Override
    public void addProduct(Product product) {
        if(!checkId(product.getId())) {
            productList.add(product);
        }
    }

    @Override
    public void updateProduct(int id, String name, long price) {
        productList.get(indexId).setName(name);
        productList.get(indexId).setPrice(price);
    }

    @Override
    public Product deleteProduct(int id){
        Product temp;
        temp = productList.get(indexId);
        productList.remove(indexId);
        return temp;
    }

    @Override
    public Product findProductById(int id) {
        if(checkId(id)) {
            return productList.get(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> productsFind = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(name.equalsIgnoreCase(productList.get(i).getName())) {
                productsFind.add(productList.get(i));
            }
        }
        return productsFind;
    }


    public void sortProduct(List<Product> list){
        Collections.sort(list, new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getPrice() > p2.getPrice() ? 1 : -1;
        }
        });
    }




    @Override
    public boolean checkId(int id) {
        int[] arrId  = new int[productList.size()];
        for (int i = 0; i < arrId.length; i++) {
            arrId[i] = productList.get(i).getId();
        }
        int low, high;
        low = 0;
        high = arrId.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if(id < arrId[mid]) {
                high = mid -1;
            } else if (id == arrId[mid]) {
                indexId = mid;
                return true;
            } else
                low = mid + 1;
        }
        return false;
    }
}
