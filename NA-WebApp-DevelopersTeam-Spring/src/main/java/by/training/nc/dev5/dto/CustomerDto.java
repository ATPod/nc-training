package by.training.nc.dev5.dto;

import by.training.nc.dev5.accounts.UserRole;

/**
 * Created by Nikita on 08.05.2017.
 */
public class CustomerDto extends PersonDto {
    public CustomerDto() {
        super(UserRole.CUSTOMER);
    }
}
