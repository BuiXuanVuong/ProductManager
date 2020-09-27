package service;

import java.util.List;

public interface IService<T> {
   boolean checkId( int id);
   void addProduct(T t);
   void updateProduct(int i, String s, long l);
   T deleteProduct(int i);
   T findProductById(int i);
   List<T> findProductByName(String s);
}
