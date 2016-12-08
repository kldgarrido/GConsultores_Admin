/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

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
public class TypeAccountFinancesFacade extends AbstractFacade<TypeAccountFinances> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeAccountFinancesFacade() {
        super(TypeAccountFinances.class);
    }
    
    public void create(TypeAccountFinances entity){
        entity.setId(UUID.randomUUID().toString());
        em.persist(entity);
    }
    
}
