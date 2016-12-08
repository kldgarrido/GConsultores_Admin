package controller;

import entity.Gasto;
import facade.GastoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "gastoController")
@ViewScoped
public class GastoController extends AbstractController<Gasto> {

    @EJB
    private GastoFacade ejbFacade;

    /**
     * Initialize the concrete Gasto controller bean. The AbstractController
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

    public GastoController() {
        // Inform the Abstract parent controller of the concrete Gasto?cap_first Entity
        super(Gasto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of OperacionGasto entities
     * that are retrieved from Gasto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OperacionGasto page
     */
    public String navigateOperacionGastoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OperacionGasto_items", this.getSelected().getOperacionGastoCollection());
        }
        return "/operacionGasto/index";
    }

}
