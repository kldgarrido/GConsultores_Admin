package entity;

import entity.AccountFinances;
import entity.Ingreso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(OperacionIngreso.class)
public class OperacionIngreso_ { 

    public static volatile SingularAttribute<OperacionIngreso, String> descripcion;
    public static volatile SingularAttribute<OperacionIngreso, Date> fecha;
    public static volatile SingularAttribute<OperacionIngreso, Ingreso> ingreso;
    public static volatile SingularAttribute<OperacionIngreso, String> id;
    public static volatile SingularAttribute<OperacionIngreso, Double> saldo;
    public static volatile SingularAttribute<OperacionIngreso, AccountFinances> account;

}