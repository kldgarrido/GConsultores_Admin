/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaled
 */
@Entity
@Table(name = "trasaction_finances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrasactionFinances.findAll", query = "SELECT t FROM TrasactionFinances t"),
    @NamedQuery(name = "TrasactionFinances.findById", query = "SELECT t FROM TrasactionFinances t WHERE t.id = :id"),
    @NamedQuery(name = "TrasactionFinances.findByOperationDate", query = "SELECT t FROM TrasactionFinances t WHERE t.operationDate = :operationDate"),
    @NamedQuery(name = "TrasactionFinances.findByDescripcion", query = "SELECT t FROM TrasactionFinances t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TrasactionFinances.findByBalance", query = "SELECT t FROM TrasactionFinances t WHERE t.balance = :balance")})
public class TrasactionFinances implements Serializable, EntityIdUUID {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Column(name = "operation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDate;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @JoinColumn(name = "account", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountFinances account;

    public TrasactionFinances() {
    }

    public TrasactionFinances(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountFinances getAccount() {
        return account;
    }

    public void setAccount(AccountFinances account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasactionFinances)) {
            return false;
        }
        TrasactionFinances other = (TrasactionFinances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TrasactionFinances[ id=" + id + " ]";
    }
    
}
