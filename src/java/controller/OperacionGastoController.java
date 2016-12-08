package controller;

import entity.AccountFinances;
import entity.OperacionGasto;
import entity.TrasactionFinances;
import facade.OperacionGastoFacade;
import facade.TrasactionFinancesFacade;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "operacionGastoController")
@ViewScoped
public class OperacionGastoController extends AbstractController<OperacionGasto> {

    @EJB
    private OperacionGastoFacade ejbFacade;
    private GastoController gastoController;
    
    @EJB
    private TrasactionFinancesFacade ejbFacadeTrasactionFinances;
    
    private List<AccountFinances> accountFinancesList;
    private AccountFinances accountFinances;

    /**
     * Initialize the concrete OperacionGasto controller bean. The
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
        gastoController = context.getApplication().evaluateExpressionGet(context, "#{gastoController}", GastoController.class);
    }

    public OperacionGastoController() {
        // Inform the Abstract parent controller of the concrete OperacionGasto?cap_first Entity
        super(OperacionGasto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        gastoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Gasto controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGasto(ActionEvent event) {
        if (this.getSelected() != null && gastoController.getSelected() == null) {
            gastoController.setSelected(this.getSelected().getGasto());
        }
    }
    
    public void mySaveNew(OperacionGasto operacionGasto) {
        operacionGasto.setId(UUID.randomUUID().toString());
        ejbFacade.create(operacionGasto);
        
        TrasactionFinances trasactionFinances = new TrasactionFinances(
                UUID.randomUUID().toString());
        trasactionFinances.setAccount(accountFinances);
        trasactionFinances.setBalance(operacionGasto.getSaldo());
        trasactionFinances.setOperationDate(operacionGasto.getFecha());
        trasactionFinances.setDescripcion(operacionGasto.getDescripcion());
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
