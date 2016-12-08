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
@Table(name = "log_money_fluid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogMoneyFluid.findAll", query = "SELECT l FROM LogMoneyFluid l"),
    @NamedQuery(name = "LogMoneyFluid.findById", query = "SELECT l FROM LogMoneyFluid l WHERE l.id = :id"),
    @NamedQuery(name = "LogMoneyFluid.findByOperationDate", query = "SELECT l FROM LogMoneyFluid l WHERE l.operationDate = :operationDate"),
    @NamedQuery(name = "LogMoneyFluid.findByDescripcion", query = "SELECT l FROM LogMoneyFluid l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "LogMoneyFluid.findByBalance", query = "SELECT l FROM LogMoneyFluid l WHERE l.balance = :balance")})
public class LogMoneyFluid implements Serializable, EntityIdUUID {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private double balance;
    @JoinColumn(name = "money_box", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MoneyBox moneyBox;

    public LogMoneyFluid() {
    }

    public LogMoneyFluid(String id) {
        this.id = id;
    }

    public LogMoneyFluid(String id, Date operationDate, String descripcion, double balance) {
        this.id = id;
        this.operationDate = operationDate;
        this.descripcion = descripcion;
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public MoneyBox getMoneyBox() {
        return moneyBox;
    }

    public void setMoneyBox(MoneyBox moneyBox) {
        this.moneyBox = moneyBox;
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
        if (!(object instanceof LogMoneyFluid)) {
            return false;
        }
        LogMoneyFluid other = (LogMoneyFluid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LogMoneyFluid[ id=" + id + " ]";
    }
    
}
