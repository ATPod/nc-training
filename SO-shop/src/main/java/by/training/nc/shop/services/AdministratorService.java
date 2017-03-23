package by.training.nc.shop.services;

import by.training.nc.shop.entities.Administrator;
import by.training.nc.shop.exceptions.NotFoundException;
import by.training.nc.shop.utils.DataKeeper;

public class AdministratorService {

    public static Administrator findAdministratorById(int idAdmin) throws NotFoundException{
        for (int i = 0; i < DataKeeper.administrators.size(); i++){
            if (DataKeeper.administrators.get(i).getId() == idAdmin){
                return DataKeeper.administrators.get(i);
            }
        }
        throw new NotFoundException("No administrator with such ID");
    }

    public static void updateAdministratorName(int idAdmin, String name) throws NotFoundException{
        Administrator administrator = findAdministratorById(idAdmin);
        administrator.setName(name);
    }

    public static void updateAdministratorPassword(int idAdmin, String password) throws NotFoundException {
        Administrator administrator = findAdministratorById(idAdmin);
        administrator.setPassword(password);
    }
}
