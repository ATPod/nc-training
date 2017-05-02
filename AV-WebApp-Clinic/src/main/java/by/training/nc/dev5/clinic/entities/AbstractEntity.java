package by.training.nc.dev5.clinic.entities;

/**
 * Created by user on 02.05.2017.
 */
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class AbstractEntity {

    protected Integer id;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
