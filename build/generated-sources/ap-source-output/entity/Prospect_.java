package entity;

import entity.Course;
import entity.ProspectType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(Prospect.class)
public class Prospect_ { 

    public static volatile SingularAttribute<Prospect, Boolean> sendNotification;
    public static volatile SingularAttribute<Prospect, Boolean> deleteLogical;
    public static volatile SingularAttribute<Prospect, String> lastname;
    public static volatile SingularAttribute<Prospect, Boolean> prosecuted;
    public static volatile SingularAttribute<Prospect, String> phone;
    public static volatile SingularAttribute<Prospect, String> name;
    public static volatile SingularAttribute<Prospect, Course> course;
    public static volatile SingularAttribute<Prospect, String> comment;
    public static volatile SingularAttribute<Prospect, String> id;
    public static volatile SingularAttribute<Prospect, String> calendarContact;
    public static volatile SingularAttribute<Prospect, String> applyDate;
    public static volatile SingularAttribute<Prospect, String> email;
    public static volatile SingularAttribute<Prospect, ProspectType> prospectType;

}