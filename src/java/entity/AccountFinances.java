/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaled
 */
@Entity
@Table(name = "account_finances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountFinances.findAll", query = "SELECT a FROM AccountFinances a"),
    @NamedQuery(name = "AccountFinances.findById", query = "SELECT a FROM AccountFinances a WHERE a.id = :id"),
    @NamedQuery(name = "AccountFinances.findByNameAccount", query = "SELECT a FROM AccountFinances a WHERE a.nameAccount = :nameAccount")})
public class AccountFinances implements Serializable, EntityIdUUID  {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name_account")
    private String nameAccount;
    @OneToMany(mappedBy = "account")
    private Collection<OperacionGasto> operacionGastoCollection;
    @OneToMany(mappedBy = "account")
    private Collection<OperacionIngreso> operacionIngresoCollection;

    public AccountFinances() {
    }

    public AccountFinances(String id) {
        this.id = id;
    }

    public AccountFinances(String id, String nameAccount) {
        this.id = id;
        this.nameAccount = nameAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    @XmlTransient
    public Collection<OperacionGasto> getOperacionGastoCollection() {
        return operacionGastoCollection;
    }

    public void setOperacionGastoCollection(Collection<OperacionGasto> operacionGastoCollection) {
        this.operacionGastoCollection = operacionGastoCollection;
    }

    @XmlTransient
    public Collection<OperacionIngreso> getOperacionIngresoCollection() {
        return operacionIngresoCollection;
    }

    public void setOperacionIngresoCollection(Collection<OperacionIngreso> operacionIngresoCollection) {
        this.operacionIngresoCollection = operacionIngresoCollection;
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
        if (!(object instanceof AccountFinances)) {
            return false;
        }
        AccountFinances other = (AccountFinances) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AccountFinances[ id=" + id + " ]";
    }
    
}
