package controller;

import entity.AccountFinances;
import facade.AccountFinancesFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "accountFinancesController")
@ViewScoped
public class AccountFinancesController extends AbstractController<AccountFinances> {

    @EJB
    private AccountFinancesFacade ejbFacade;
    private TypeAccountFinancesController typeAccountController;

    /**
     * Initialize the concrete AccountFinances controller bean. The
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
        typeAccountController = context.getApplication().evaluateExpressionGet(context, "#{typeAccountFinancesController}", TypeAccountFinancesController.class);
    }

    public AccountFinancesController() {
        // Inform the Abstract parent controller of the concrete AccountFinances?cap_first Entity
        super(AccountFinances.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        typeAccountController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TypeAccountFinances controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */

    /**
     * Sets the "items" attribute with a collection of OperacionGasto entities
     * that are retrieved from AccountFinances?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for OperacionGasto page
     */
    public String navigateOperacionGastoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OperacionGasto_items", this.getSelected().getOperacionGastoCollection());
        }
        return "/operacionGasto/index";
    }

    /**
     * Sets the "items" attribute with a collection of OperacionIngreso entities
     * that are retrieved from AccountFinances?cap_first and returns the
     * navigation outcome.
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
