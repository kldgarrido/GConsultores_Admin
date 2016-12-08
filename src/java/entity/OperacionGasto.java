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
@Table(name = "operacion_gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionGasto.findAll", query = "SELECT o FROM OperacionGasto o ORDER BY o.fecha DESC"),
    @NamedQuery(name = "OperacionGasto.findById", query = "SELECT o FROM OperacionGasto o WHERE o.id = :id"),
    @NamedQuery(name = "OperacionGasto.findByDescripcion", query = "SELECT o FROM OperacionGasto o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "OperacionGasto.findBySaldo", query = "SELECT o FROM OperacionGasto o WHERE o.saldo = :saldo"),
    @NamedQuery(name = "OperacionGasto.findByFecha", query = "SELECT o FROM OperacionGasto o WHERE o.fecha = :fecha")})
public class OperacionGasto implements Serializable, EntityIdUUID  {
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
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "account", referencedColumnName = "id")
    @ManyToOne
    private AccountFinances account;
    @JoinColumn(name = "gasto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gasto gasto;

    public OperacionGasto() {
    }

    public OperacionGasto(String id) {
        this.id = id;
    }

    public OperacionGasto(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AccountFinances getAccount() {
        return account;
    }

    public void setAccount(AccountFinances account) {
        this.account = account;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
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
        if (!(object instanceof OperacionGasto)) {
            return false;
        }
        OperacionGasto other = (OperacionGasto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OperacionGasto[ id=" + id + " ]";
    }
    
}
