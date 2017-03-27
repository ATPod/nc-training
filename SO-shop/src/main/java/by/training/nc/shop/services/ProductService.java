package by.training.nc.shop.services;

import by.training.nc.shop.entities.Client;
import by.training.nc.shop.entities.Product;
import by.training.nc.shop.exceptions.IdRepeatException;
import by.training.nc.shop.exceptions.NotFoundException;
import by.training.nc.shop.utils.DataKeeper;

import java.util.List;

public class ProductService {

    public static List <Product> getAllProducts(){
        return DataKeeper.products;
    }

    public static void addProduct(int id, String title, int price) throws IdRepeatException{
        for (int i = 0; i < DataKeeper.products.size(); i++){
            if (DataKeeper.products.get(i).getId() == id){
                throw new IdRepeatException("Repetition of ID!");
            }
        }
        DataKeeper.products.add(new Product(id, title, price));
    }

    public static void removeProduct(int idProduct) throws NotFoundException{
        Product product = findProductById(idProduct);
        DataKeeper.products.remove(product);
    }

    public static Product findProductById(int idProduct) throws NotFoundException{
        for (int i = 0; i < DataKeeper.products.size(); i++){
            if (DataKeeper.products.get(i).getId() == idProduct){
                return DataKeeper.products.get(i);
            }
        }
        throw new NotFoundException("No client with such ID");
    }

    public static void updateProductTitle(int idProduct, String title) throws NotFoundException{
        Product product = findProductById(idProduct);
        product.setTitle(title);
    }

    public static void updateProductPrice(int idProduct, int price) throws NotFoundException{
        Product product = findProductById(idProduct);
        product.setPrice(price);
    }
}
