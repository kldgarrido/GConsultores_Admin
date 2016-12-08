package entity;

import entity.AccountFinances;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(TrasactionFinances.class)
public class TrasactionFinances_ { 

    public static volatile SingularAttribute<TrasactionFinances, String> descripcion;
    public static volatile SingularAttribute<TrasactionFinances, Date> operationDate;
    public static volatile SingularAttribute<TrasactionFinances, Double> balance;
    public static volatile SingularAttribute<TrasactionFinances, String> id;
    public static volatile SingularAttribute<TrasactionFinances, AccountFinances> account;

}