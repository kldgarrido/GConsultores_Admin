/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.BalanceGeneral;

/**
 *
 * @author Kaled
 */
public class BalanceGeneralDAO {
    
    private static final String PERSISTENCE_UNIT_NAME = "GConsultoresAdminPU";
    private static EntityManagerFactory factory;
    private EntityManager em;
    
    private final String queryBalanceGeneral = "SELECT SUM(operacion_ingreso.SALDO) as ingreso_total, SUM(operacion_gasto.SALDO) as gasto_total FROM operacion_ingreso, operacion_gasto WHERE operacion_gasto.fecha BETWEEN '2016/01/01' AND '2017/01/02' AND operacion_gasto.fecha BETWEEN '2016/01/01' AND '2017/01/02';";
    private final String queryBalanceIngreso = "SELECT (SELECT ingreso.name FROM ingreso WHERE ingreso.id=operacion_ingreso.ingreso), SUM(operacion_ingreso.SALDO) FROM operacion_ingreso, ingreso WHERE operacion_ingreso.ingreso = ingreso.id AND fecha BETWEEN '2016/01/01' AND '2017/01/02' GROUP BY operacion_ingreso.ingreso;";
    private final String queryBalanceGastos = "SELECT (SELECT gasto.name FROM gasto WHERE gasto.id=operacion_gasto.gasto), SUM(operacion_gasto.SALDO) FROM operacion_gasto, gasto WHERE operacion_gasto.gasto = gasto.id AND fecha BETWEEN '2016/01/01' AND '2017/01/02' GROUP BY operacion_gasto.gasto;";

    public BalanceGeneralDAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

//    public BalanceGeneral getBalanceGeneral(Date fechaInicial, Date fechaFinal){
//        EntityManager em = factory.createEntityManager();
//		Query q = em.createNativeQuery(queryBalanceGeneral);
//		List<BalanceGeneral> persons = q.getResultList();
//		for (Person person : persons) {
//			System.out.println(person);
//		}
//     }
    
}
