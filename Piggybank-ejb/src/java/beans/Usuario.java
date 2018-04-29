/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RetailAdmin
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByDni", query = "SELECT u FROM Usuario u WHERE u.dni = :dni")
    , @NamedQuery(name = "Usuario.findByNumeroCuenta", query = "SELECT u FROM Usuario u WHERE u.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido1", query = "SELECT u FROM Usuario u WHERE u.apellido1 = :apellido1")
    , @NamedQuery(name = "Usuario.findByApellido2", query = "SELECT u FROM Usuario u WHERE u.apellido2 = :apellido2")
    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Usuario.findByEfectivo", query = "SELECT u FROM Usuario u WHERE u.efectivo = :efectivo")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_cuenta")
    private int numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 30)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 10)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "efectivo")
    private Double efectivo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tipoUsuario")
    private Short tipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Transferencia> transferenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariodni")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "Usuario_dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuario usuariodni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Movimientos> movimientosCollection;

    public Usuario() {
    }

    public Usuario(String dni) {
        this.dni = dni;
    }

    public Usuario(String dni, int numeroCuenta, String nombre) {
        this.dni = dni;
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Double efectivo) {
        this.efectivo = efectivo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Short getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Short tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @XmlTransient
    public Collection<Transferencia> getTransferenciaCollection() {
        return transferenciaCollection;
    }

    public void setTransferenciaCollection(Collection<Transferencia> transferenciaCollection) {
        this.transferenciaCollection = transferenciaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Usuario getUsuariodni() {
        return usuariodni;
    }

    public void setUsuariodni(Usuario usuariodni) {
        this.usuariodni = usuariodni;
    }

    @XmlTransient
    public Collection<Movimientos> getMovimientosCollection() {
        return movimientosCollection;
    }

    public void setMovimientosCollection(Collection<Movimientos> movimientosCollection) {
        this.movimientosCollection = movimientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Usuario[ dni=" + dni + " ]";
    }
    
}
