package entity;

import entity.MoneyBox;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:48:07")
@StaticMetamodel(LogMoneyFluid.class)
public class LogMoneyFluid_ { 

    public static volatile SingularAttribute<LogMoneyFluid, String> descripcion;
    public static volatile SingularAttribute<LogMoneyFluid, Date> operationDate;
    public static volatile SingularAttribute<LogMoneyFluid, Double> balance;
    public static volatile SingularAttribute<LogMoneyFluid, String> id;
    public static volatile SingularAttribute<LogMoneyFluid, MoneyBox> moneyBox;

}