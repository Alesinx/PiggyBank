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
@Table(name = "transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t")
    , @NamedQuery(name = "Transferencia.findByIBANdestino", query = "SELECT t FROM Transferencia t WHERE t.transferenciaPK.iBANdestino = :iBANdestino")
    , @NamedQuery(name = "Transferencia.findByUsuariodni", query = "SELECT t FROM Transferencia t WHERE t.transferenciaPK.usuariodni = :usuariodni")
    , @NamedQuery(name = "Transferencia.findById", query = "SELECT t FROM Transferencia t WHERE t.transferenciaPK.id = :id")
    , @NamedQuery(name = "Transferencia.findByConcepto", query = "SELECT t FROM Transferencia t WHERE t.concepto = :concepto")
    , @NamedQuery(name = "Transferencia.findByFecha", query = "SELECT t FROM Transferencia t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Transferencia.findByCantidad", query = "SELECT t FROM Transferencia t WHERE t.cantidad = :cantidad")})
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransferenciaPK transferenciaPK;
    @Size(max = 45)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "Usuario_dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Transferencia() {
    }

    public Transferencia(TransferenciaPK transferenciaPK) {
        this.transferenciaPK = transferenciaPK;
    }

    public Transferencia(TransferenciaPK transferenciaPK, String cantidad) {
        this.transferenciaPK = transferenciaPK;
        this.cantidad = cantidad;
    }

    public Transferencia(String iBANdestino, String usuariodni, int id) {
        this.transferenciaPK = new TransferenciaPK(iBANdestino, usuariodni, id);
    }

    public TransferenciaPK getTransferenciaPK() {
        return transferenciaPK;
    }

    public void setTransferenciaPK(TransferenciaPK transferenciaPK) {
        this.transferenciaPK = transferenciaPK;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
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
        hash += (transferenciaPK != null ? transferenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.transferenciaPK == null && other.transferenciaPK != null) || (this.transferenciaPK != null && !this.transferenciaPK.equals(other.transferenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Transferencia[ transferenciaPK=" + transferenciaPK + " ]";
    }
    
}
