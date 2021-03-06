/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.LogMoneyFluid;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kaled
 */
@Stateless
public class LogMoneyFluidFacade extends AbstractFacade<LogMoneyFluid> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogMoneyFluidFacade() {
        super(LogMoneyFluid.class);
    }
    
    public void create(LogMoneyFluid entity){
        entity.setId(UUID.randomUUID().toString());
        em.persist(entity);
    }
    
}
