package entity;

import entity.OperacionGasto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(Gasto.class)
public class Gasto_ { 

    public static volatile SingularAttribute<Gasto, String> name;
    public static volatile CollectionAttribute<Gasto, OperacionGasto> operacionGastoCollection;
    public static volatile SingularAttribute<Gasto, String> id;

}