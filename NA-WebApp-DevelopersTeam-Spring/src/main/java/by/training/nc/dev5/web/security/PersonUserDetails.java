package by.training.nc.dev5.web.security;

import by.training.nc.dev5.dto.PersonDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Nikita on 05.06.2017.
 */
public class PersonUserDetails implements UserDetails {
    private UserDetails userDetails;
    private PersonDto personDto;

    public PersonUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    @Override
    public String getPassword() {
        return userDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userDetails.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userDetails.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userDetails.isEnabled();
    }

    /**
     * Gets the value of personDto
     *
     * @return the value of personDto.
     */
    public PersonDto getPersonDto() {
        return personDto;
    }

    /**
     * Sets the value of personDto
     *
     * @param personDto the new value of personDto.
     */
    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
}
