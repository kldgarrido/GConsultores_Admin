package entity;

import entity.AccountFinances;
import entity.Gasto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(OperacionGasto.class)
public class OperacionGasto_ { 

    public static volatile SingularAttribute<OperacionGasto, String> descripcion;
    public static volatile SingularAttribute<OperacionGasto, Date> fecha;
    public static volatile SingularAttribute<OperacionGasto, String> id;
    public static volatile SingularAttribute<OperacionGasto, Double> saldo;
    public static volatile SingularAttribute<OperacionGasto, Gasto> gasto;
    public static volatile SingularAttribute<OperacionGasto, AccountFinances> account;

}