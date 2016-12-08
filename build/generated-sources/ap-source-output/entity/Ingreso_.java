package entity;

import entity.OperacionIngreso;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(Ingreso.class)
public class Ingreso_ { 

    public static volatile SingularAttribute<Ingreso, String> name;
    public static volatile SingularAttribute<Ingreso, String> id;
    public static volatile CollectionAttribute<Ingreso, OperacionIngreso> operacionIngresoCollection;

}