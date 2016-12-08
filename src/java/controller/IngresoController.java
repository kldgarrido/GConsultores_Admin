package controller;

import entity.Ingreso;
import facade.IngresoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "ingresoController")
@ViewScoped
public class IngresoController extends AbstractController<Ingreso> {

    @EJB
    private IngresoFacade ejbFacade;

    /**
     * Initialize the concrete Ingreso controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     * <p>
     * In addition, this controller also requires references to controllers for
     * parent entities in order to display their information from a context
     * menu.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        FacesContext context = FacesContext.getCurrentInstance();
    }

    public IngresoController() {
        // Inform the Abstract parent controller of the concrete Ingreso?cap_first Entity
        super(Ingreso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of OperacionIngreso entities
     * that are retrieved from Ingreso?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OperacionIngreso page
     */
    public String navigateOperacionIngresoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OperacionIngreso_items", this.getSelected().getOperacionIngresoCollection());
        }
        return "/operacionIngreso/index";
    }

}
