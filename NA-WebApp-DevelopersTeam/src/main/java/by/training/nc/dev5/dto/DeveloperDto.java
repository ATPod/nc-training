package by.training.nc.dev5.dto;

import by.training.nc.dev5.accounts.UserRole;

/**
 * Created by Nikita on 08.05.2017.
 */
public class DeveloperDto extends PersonDto {
    private QualificationDto qualification;

    public DeveloperDto() {
        super(UserRole.DEVELOPER);
    }

    /**
     * Gets the value of qualification
     *
     * @return the value of qualification.
     */
    public QualificationDto getQualification() {
        return qualification;
    }

    /**
     * Sets the value of qualification
     *
     * @param qualification the new value of qualification.
     */
    public void setQualification(QualificationDto qualification) {
        this.qualification = qualification;
    }
}
