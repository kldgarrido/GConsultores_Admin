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
 * @author kaled
 */
@Entity
@Table(name = "perfil_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilCliente.findAll", query = "SELECT p FROM PerfilCliente p"),
    @NamedQuery(name = "PerfilCliente.findAllOrderByFechaInscripcion", query = "SELECT p FROM PerfilCliente p ORDER BY P.fechaInscripcion DESC"),
    @NamedQuery(name = "PerfilCliente.findByApellidos", query = "SELECT p FROM PerfilCliente p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "PerfilCliente.findByCargoActual", query = "SELECT p FROM PerfilCliente p WHERE p.cargoActual = :cargoActual"),
    @NamedQuery(name = "PerfilCliente.findByCiudadNacimiento", query = "SELECT p FROM PerfilCliente p WHERE p.ciudadNacimiento = :ciudadNacimiento"),
    @NamedQuery(name = "PerfilCliente.findByCodigo", query = "SELECT p FROM PerfilCliente p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "PerfilCliente.findByCorreo", query = "SELECT p FROM PerfilCliente p WHERE p.correo = :correo"),
    @NamedQuery(name = "PerfilCliente.findByEdad", query = "SELECT p FROM PerfilCliente p WHERE p.edad = :edad"),
    @NamedQuery(name = "PerfilCliente.findByEmpresa", query = "SELECT p FROM PerfilCliente p WHERE p.empresa = :empresa"),
    @NamedQuery(name = "PerfilCliente.findByEstadoCivil", query = "SELECT p FROM PerfilCliente p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "PerfilCliente.findByFechaInscripcion", query = "SELECT p FROM PerfilCliente p WHERE p.fechaInscripcion = :fechaInscripcion"),
    @NamedQuery(name = "PerfilCliente.findByFechaNacimiento", query = "SELECT p FROM PerfilCliente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "PerfilCliente.findByGenero", query = "SELECT p FROM PerfilCliente p WHERE p.genero = :genero"),
    @NamedQuery(name = "PerfilCliente.findByIdentificacion", query = "SELECT p FROM PerfilCliente p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "PerfilCliente.findByNombres", query = "SELECT p FROM PerfilCliente p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "PerfilCliente.findByOcupacion", query = "SELECT p FROM PerfilCliente p WHERE p.ocupacion = :ocupacion"),
    @NamedQuery(name = "PerfilCliente.findByPaisNacimiento", query = "SELECT p FROM PerfilCliente p WHERE p.paisNacimiento = :paisNacimiento"),
    @NamedQuery(name = "PerfilCliente.findByProfesion", query = "SELECT p FROM PerfilCliente p WHERE p.profesion = :profesion"),
    @NamedQuery(name = "PerfilCliente.findByTelefonoCelular", query = "SELECT p FROM PerfilCliente p WHERE p.telefonoCelular = :telefonoCelular"),
    @NamedQuery(name = "PerfilCliente.findByTelefonoFijo", query = "SELECT p FROM PerfilCliente p WHERE p.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "PerfilCliente.findByTipoIdentificacion", query = "SELECT p FROM PerfilCliente p WHERE p.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "PerfilCliente.findById", query = "SELECT p FROM PerfilCliente p WHERE p.id = :id")})
public class PerfilCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 255)
    @Column(name = "cargo_actual")
    private String cargoActual;
    @Size(max = 255)
    @Column(name = "ciudad_nacimiento")
    private String ciudadNacimiento;
    @Size(max = 255)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 255)
    @Column(name = "correo")
    private String correo;
    @Column(name = "edad")
    private Integer edad;
    @Size(max = 255)
    @Column(name = "empresa")
    private String empresa;
    @Size(max = 255)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 255)
    @Column(name = "genero")
    private String genero;
    @Size(max = 255)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 255)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 255)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Size(max = 255)
    @Column(name = "pais_nacimiento")
    private String paisNacimiento;
    @Size(max = 255)
    @Column(name = "profesion")
    private String profesion;
    @Size(max = 255)
    @Column(name = "telefono_celular")
    private String telefonoCelular;
    @Size(max = 255)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Size(max = 255)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "id")
    private String id;

    public PerfilCliente() {
    }

    public PerfilCliente(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargoActual() {
        return cargoActual;
    }

    public void setCargoActual(String cargoActual) {
        this.cargoActual = cargoActual;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(object instanceof PerfilCliente)) {
            return false;
        }
        PerfilCliente other = (PerfilCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PerfilCliente[ id=" + id + " ]";
    }
    
}
