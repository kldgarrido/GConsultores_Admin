package entity;

import entity.Prospect;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile CollectionAttribute<Course, Prospect> prospectCollection;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, String> id;

}