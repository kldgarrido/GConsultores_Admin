/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TrasactionFinances;
import entity.TypeAccountFinances;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kaled
 */
@Stateless
public class TrasactionFinancesFacade extends AbstractFacade<TrasactionFinances> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrasactionFinancesFacade() {
        super(TrasactionFinances.class);
    }
    
    public void create(TrasactionFinances entity){
        entity.setId(UUID.randomUUID().toString());
        em.persist(entity);
    }
    
}
