package by.training.nc.dev5.testing.services;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Main {
    @Autowired
    static IStudentDAO userService;
    public static void main(String[] args)
    {
        try {
            userService.getAll();
        }
        catch(DaoException e)
        {
            e.printStackTrace();
        }
        if(userService!=null) {
           // System.out.println(userService.getAuthorizedUser("1"));
            //User user=userService.getAuthorizedUser("1","1");
        }
        else
        {
            System.out.println("Userserv is null!");
        }
    }
}
