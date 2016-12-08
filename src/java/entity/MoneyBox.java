/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "money_box")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MoneyBox.findAll", query = "SELECT m FROM MoneyBox m"),
    @NamedQuery(name = "MoneyBox.findById", query = "SELECT m FROM MoneyBox m WHERE m.id = :id"),
    @NamedQuery(name = "MoneyBox.findByName", query = "SELECT m FROM MoneyBox m WHERE m.name = :name")})
public class MoneyBox implements Serializable, EntityIdUUID {
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
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moneyBox")
    private Collection<LogMoneyFluid> logMoneyFluidCollection;

    public MoneyBox() {
    }

    public MoneyBox(String id) {
        this.id = id;
    }

    public MoneyBox(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<LogMoneyFluid> getLogMoneyFluidCollection() {
        return logMoneyFluidCollection;
    }

    public void setLogMoneyFluidCollection(Collection<LogMoneyFluid> logMoneyFluidCollection) {
        this.logMoneyFluidCollection = logMoneyFluidCollection;
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
        if (!(object instanceof MoneyBox)) {
            return false;
        }
        MoneyBox other = (MoneyBox) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MoneyBox[ id=" + id + " ]";
    }
    
}
