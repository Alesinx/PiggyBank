/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author RetailAdmin
 */
@Entity
@Table(name = "movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m")
    , @NamedQuery(name = "Movimientos.findById", query = "SELECT m FROM Movimientos m WHERE m.movimientosPK.id = :id")
    , @NamedQuery(name = "Movimientos.findByConcepto", query = "SELECT m FROM Movimientos m WHERE m.concepto = :concepto")
    , @NamedQuery(name = "Movimientos.findByFecha", query = "SELECT m FROM Movimientos m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Movimientos.findByCantidad", query = "SELECT m FROM Movimientos m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "Movimientos.findByUsuariodni", query = "SELECT m FROM Movimientos m WHERE m.movimientosPK.usuariodni = :usuariodni")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovimientosPK movimientosPK;
    @Size(max = 45)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @JoinColumn(name = "Usuario_dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Movimientos() {
    }

    public Movimientos(MovimientosPK movimientosPK) {
        this.movimientosPK = movimientosPK;
    }

    public Movimientos(MovimientosPK movimientosPK, double cantidad) {
        this.movimientosPK = movimientosPK;
        this.cantidad = cantidad;
    }

    public Movimientos(int id, String usuariodni) {
        this.movimientosPK = new MovimientosPK(id, usuariodni);
    }

    public MovimientosPK getMovimientosPK() {
        return movimientosPK;
    }

    public void setMovimientosPK(MovimientosPK movimientosPK) {
        this.movimientosPK = movimientosPK;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimientosPK != null ? movimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.movimientosPK == null && other.movimientosPK != null) || (this.movimientosPK != null && !this.movimientosPK.equals(other.movimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Movimientos[ movimientosPK=" + movimientosPK + " ]";
    }
    
}
