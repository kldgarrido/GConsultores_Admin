package controller;

import entity.AccountFinances;
import entity.OperacionIngreso;
import entity.TrasactionFinances;
import facade.AccountFinancesFacade;
import facade.OperacionIngresoFacade;
import facade.TrasactionFinancesFacade;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@ManagedBean(name = "operacionIngresoController")
@ViewScoped
@Stateful
public class OperacionIngresoController extends AbstractController<OperacionIngreso> {

    @EJB
    private OperacionIngresoFacade ejbFacade;
    private IngresoController ingresoController;
    
    @EJB
    private TrasactionFinancesFacade ejbFacadeTrasactionFinances;
    
    @EJB
    private AccountFinancesFacade ejbFacadeAccountFinance;
    
    private List<AccountFinances> accountFinancesList;
    private AccountFinances accountFinances;

    /**
     * Initialize the concrete OperacionIngreso controller bean. The
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
        ingresoController = context.getApplication().evaluateExpressionGet(context, "#{ingresoController}", IngresoController.class);
//        trasactionFinancesController = context.getApplication().evaluateExpressionGet(context, "#{trasactionFinancesController}", TrasactionFinancesController.class);
//        accountFinancesController = context.getApplication().evaluateExpressionGet(context, "#{accountFinancesController}", AccountFinancesController.class);
        accountFinancesList = ejbFacadeAccountFinance.findAll();
    }

    public OperacionIngresoController() {
        // Inform the Abstract parent controller of the concrete OperacionIngreso?cap_first Entity
        super(OperacionIngreso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ingresoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ingreso controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIngreso(ActionEvent event) {
        if (this.getSelected() != null && ingresoController.getSelected() == null) {
            ingresoController.setSelected(this.getSelected().getIngreso());
        }
    }

    public void mySaveNew(OperacionIngreso operacionIngreso) {
        operacionIngreso.setId(UUID.randomUUID().toString());
        ejbFacade.create(operacionIngreso);
        
        TrasactionFinances trasactionFinances = new TrasactionFinances(
                UUID.randomUUID().toString());
        trasactionFinances.setAccount(accountFinances);
        trasactionFinances.setBalance(operacionIngreso.getSaldo());
        trasactionFinances.setOperationDate(operacionIngreso.getFecha());
        trasactionFinances.setDescripcion(operacionIngreso.getDescripcion());
        ejbFacadeTrasactionFinances.create(trasactionFinances);
    }


    public List<AccountFinances> getAccountFinancesList() {
        return accountFinancesList;
    }

    public AccountFinances getAccountFinances() {
        return accountFinances;
    }

    public void setAccountFinances(AccountFinances accountFinances) {
        this.accountFinances = accountFinances;
    }

}
