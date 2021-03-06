/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name = "depositoplazofijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depositoplazofijo.findAll", query = "SELECT d FROM Depositoplazofijo d")
    , @NamedQuery(name = "Depositoplazofijo.findByIdDeposito", query = "SELECT d FROM Depositoplazofijo d WHERE d.idDeposito = :idDeposito")
    , @NamedQuery(name = "Depositoplazofijo.findByTasaInteres", query = "SELECT d FROM Depositoplazofijo d WHERE d.tasaInteres = :tasaInteres")
    , @NamedQuery(name = "Depositoplazofijo.findByValorFinal", query = "SELECT d FROM Depositoplazofijo d WHERE d.valorFinal = :valorFinal")
    , @NamedQuery(name = "Depositoplazofijo.findByEstado", query = "SELECT d FROM Depositoplazofijo d WHERE d.estado = :estado")
    , @NamedQuery(name = "Depositoplazofijo.findByDeposito", query = "SELECT d FROM Depositoplazofijo d WHERE d.deposito = :deposito")
    , @NamedQuery(name = "Depositoplazofijo.findByTiempo", query = "SELECT d FROM Depositoplazofijo d WHERE d.tiempo = :tiempo")
    , @NamedQuery(name = "Depositoplazofijo.findByFecha", query = "SELECT d FROM Depositoplazofijo d WHERE d.fecha = :fecha")})
public class Depositoplazofijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_deposito")
    private Integer idDeposito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasaInteres")
    private Float tasaInteres;
    @Column(name = "valorFinal")
    private Float valorFinal;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Column(name = "deposito")
    private Float deposito;
    @Column(name = "tiempo")
    private Integer tiempo;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeposito")
    private List<Transacciondpf> transacciondpfList;

    public Depositoplazofijo() {
    }

    public Depositoplazofijo(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Float getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(Float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Float valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getDeposito() {
        return deposito;
    }

    public void setDeposito(Float deposito) {
        this.deposito = deposito;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Transacciondpf> getTransacciondpfList() {
        return transacciondpfList;
    }

    public void setTransacciondpfList(List<Transacciondpf> transacciondpfList) {
        this.transacciondpfList = transacciondpfList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeposito != null ? idDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depositoplazofijo)) {
            return false;
        }
        Depositoplazofijo other = (Depositoplazofijo) object;
        if ((this.idDeposito == null && other.idDeposito != null) || (this.idDeposito != null && !this.idDeposito.equals(other.idDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sys.model.Depositoplazofijo[ idDeposito=" + idDeposito + " ]";
    }
    
}
