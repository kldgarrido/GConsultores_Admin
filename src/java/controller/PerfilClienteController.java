package controller;

import entity.PerfilCliente;
import facade.PerfilClienteFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name="perfilClienteController")
@ViewScoped
public class PerfilClienteController extends AbstractController<PerfilCliente> {

    @EJB
    private PerfilClienteFacade ejbFacade;
    
    private List<PerfilCliente> perfilClientes;

    /**
     * Initialize the concrete PerfilCliente controller bean.
     * The AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        perfilClientes = ejbFacade.getPerfilClientes();
    }

    public PerfilClienteController() {
        // Inform the Abstract parent controller of the concrete PerfilCliente?cap_first Entity
        super(PerfilCliente.class);
    }

    public PerfilClienteFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(PerfilClienteFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<PerfilCliente> getPerfilClientes() {
        return perfilClientes;
    }
    
}
