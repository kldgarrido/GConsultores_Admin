package entity;

import entity.Prospect;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(ProspectFollowing.class)
public class ProspectFollowing_ { 

    public static volatile SingularAttribute<ProspectFollowing, String> descripcion;
    public static volatile SingularAttribute<ProspectFollowing, Prospect> prospect;
    public static volatile SingularAttribute<ProspectFollowing, Date> fecha;
    public static volatile SingularAttribute<ProspectFollowing, String> id;

}