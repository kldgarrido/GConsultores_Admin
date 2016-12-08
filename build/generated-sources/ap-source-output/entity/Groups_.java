package entity;

import entity.Credentials;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile SingularAttribute<Groups, String> groupname;
    public static volatile SingularAttribute<Groups, Credentials> username;

}