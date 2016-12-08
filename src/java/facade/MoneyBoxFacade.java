/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.MoneyBox;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kaled
 */
@Stateless
public class MoneyBoxFacade extends AbstractFacade<MoneyBox> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MoneyBoxFacade() {
        super(MoneyBox.class);
    }
    
    public void create(MoneyBox entity){
        entity.setId(UUID.randomUUID().toString());
        em.persist(entity);
    }
    
}
