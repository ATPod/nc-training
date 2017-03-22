package by.training.nc.shop.services;

import by.training.nc.shop.entities.Ordering;
import by.training.nc.shop.entities.Product;
import by.training.nc.shop.exceptions.NotFoundException;
import by.training.nc.shop.utils.DataKeeper;

import java.util.ArrayList;
import java.util.List;

public class OrderingService {

    public static void addOrdering(int idOrdering, int idClient, int [] idProduct) throws NotFoundException{
        Ordering ordering = new Ordering(idOrdering, idClient);
        List <Product> products = new ArrayList<Product>();
        for (int i = 0; i < idProduct.length; i++){
            products.add(ProductService.findProductById(idProduct[i]));
        }
        ordering.setProducts(products);
        DataKeeper.orderings.add(ordering);
    }

    public static Ordering findOrderingById(int idOrdering) throws NotFoundException{
        for (int i = 0; i < DataKeeper.orderings.size(); i++){
            if (DataKeeper.orderings.get(i).getId() == idOrdering){
                return DataKeeper.orderings.get(i);
            }
        }
        throw new NotFoundException("No ordering with such ID");
    }

    public static void updateOrderingPayment(int idOrdering) throws NotFoundException{
        for (int i = 0; i < DataKeeper.orderings.size(); i++){
            if (DataKeeper.orderings.get(i).getId() == idOrdering){
                DataKeeper.orderings.get(i).setPaid(true);
                break;
            }
        }
        throw new NotFoundException("No ordering with such ID");
    }

    public static List<Ordering> getAllOrderings(int idClient){
        return DataKeeper.orderings;
    }

    public static List<Ordering> getOrderingsByClientId(int idClient){
        List <Ordering> orderings = new ArrayList<Ordering>();
        for (int i = 0; i < DataKeeper.orderings.size(); i++){
            if (DataKeeper.orderings.get(i).getIdClient() == idClient){
                orderings.add(DataKeeper.orderings.get(i));
            }
        }
        return orderings;
    }
}
