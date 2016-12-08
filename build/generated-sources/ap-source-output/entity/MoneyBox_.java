package entity;

import entity.LogMoneyFluid;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(MoneyBox.class)
public class MoneyBox_ { 

    public static volatile SingularAttribute<MoneyBox, String> name;
    public static volatile SingularAttribute<MoneyBox, String> id;
    public static volatile CollectionAttribute<MoneyBox, LogMoneyFluid> logMoneyFluidCollection;

}