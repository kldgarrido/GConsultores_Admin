/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Prospect;
import entity.ProspectFollowing;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kaled
 */
@Stateless
public class ProspectFollowingFacade extends AbstractFacade<ProspectFollowing> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProspectFollowingFacade() {
        super(ProspectFollowing.class);
    }

    public List<ProspectFollowing> findAllForProspect(String idProspect) {
        Query query = em.createNamedQuery("ProspectFollowing.findByProspect");
        query.setParameter("id", idProspect);
        return query.getResultList();
    }

    public List<ProspectFollowing> findForProspect(Prospect detail) {
        Query query = em.createNamedQuery("ProspectFollowing.findByProspect");
        query.setParameter("id", detail.getId());
        
        List<ProspectFollowing> list = query.getResultList();
        
        if(list.isEmpty()){
            list = new ArrayList<>();
        }
        
        return list;
    }

    public void create(Date newDate, String newComent, Prospect prospect) {
        ProspectFollowing entity = new ProspectFollowing(
                UUID.randomUUID().toString(), newDate, newComent, prospect);
        em.persist(entity);
    }
    
}
