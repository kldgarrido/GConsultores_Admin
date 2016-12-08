/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.PerfilCliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kaled
 */
@Stateless
public class PerfilClienteFacade extends AbstractFacade<PerfilCliente> {
    @PersistenceContext(unitName = "GConsultoresAdminPU")
    private EntityManager em;
    
    private List<PerfilCliente> perfilClientes;
    
    @PostConstruct
    public void init() {
        perfilClientes = loadAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilClienteFacade() {
        super(PerfilCliente.class);
    }

    
    private List<PerfilCliente> loadAll() {
        Query query = em.createNamedQuery("PerfilCliente.findAllOrderByFechaInscripcion");
        List<PerfilCliente> result = (List<PerfilCliente>) query.getResultList();
        return result;
    }

    public List<PerfilCliente> getPerfilClientes() {
        return perfilClientes;
    }
   
}
