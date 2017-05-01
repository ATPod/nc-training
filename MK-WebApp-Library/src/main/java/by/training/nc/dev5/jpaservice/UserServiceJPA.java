package by.training.nc.dev5.jpaservice;

import by.training.nc.dev5.entity.jpa.User;
import by.training.nc.dev5.jpa.UserJPA;

/**
 * Created by ASUS on 01.05.2017.
 */
public class UserServiceJPA  {

    UserJPA userJPA = new UserJPA();

    public User insertUser(User user){
        return userJPA.insertUser(user);
    }

    public void updateUser(User user){
        userJPA.updateUser(user);
    }

    public User findById(int id){
        return userJPA.findById(id);
    }

    public User findByNameAndPassword(String name , String password){
        return userJPA.findByNameAndPassword(name, password);
    }


}
