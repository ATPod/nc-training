package by.training.nc.dev5.entity.metamodel;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.TimeSheet;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Created by Nikita on 07.05.2017.
 */
@StaticMetamodel(TimeSheet.class)
public class TimeSheet_ {
    public static volatile SingularAttribute<TimeSheet, Integer> id;
    public static volatile SingularAttribute<TimeSheet, Developer> developer;
    public static volatile SingularAttribute<TimeSheet, Project> project;
    public static volatile SingularAttribute<TimeSheet, Date> date;
    public static volatile SingularAttribute<TimeSheet, Integer> time;
}
