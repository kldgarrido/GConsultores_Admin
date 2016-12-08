package controller;

import controller.util.JsfUtil;
import entity.AccountFinances;
import entity.TypeAccountFinances;
import facade.TypeAccountFinancesFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "typeAccountFinancesController")
@ViewScoped
public class TypeAccountFinancesController extends AbstractController<TypeAccountFinances> {

    @EJB
    private TypeAccountFinancesFacade ejbFacade;

    /**
     * Initialize the concrete TypeAccountFinances controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
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

    public TypeAccountFinancesController() {
        // Inform the Abstract parent controller of the concrete TypeAccountFinances?cap_first Entity
        super(TypeAccountFinances.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of AccountFinances entities
     * that are retrieved from TypeAccountFinances?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AccountFinances page
     */
    
    public void create(TypeAccountFinances entity){
        ejbFacade.create(entity);
        JsfUtil.addSuccessMessage("Se creo el nuevo registro");
    }

}
