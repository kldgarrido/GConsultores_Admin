package entity;

import entity.OperacionGasto;
import entity.OperacionIngreso;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(AccountFinances.class)
public class AccountFinances_ { 

    public static volatile CollectionAttribute<AccountFinances, OperacionGasto> operacionGastoCollection;
    public static volatile SingularAttribute<AccountFinances, String> id;
    public static volatile CollectionAttribute<AccountFinances, OperacionIngreso> operacionIngresoCollection;
    public static volatile SingularAttribute<AccountFinances, String> nameAccount;

}