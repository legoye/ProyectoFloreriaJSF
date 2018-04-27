/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto", catalog = "floreria")
public class Producto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String name;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;
    
    @Column(name = "precio", nullable = false, length = 20)
    private Double precio;
    
    @Column(name = "imagen", nullable = false, length = 200)
    private String imagen;
    
    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;
    
    @Column(name = "disponibilidad", nullable = false, length = 30)
    private String disponibilidad;
    
    @Column(name = "tamaño", nullable = false, length = 30)
    private String tamaño;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "producto_has_categoria_flores", 
        joinColumns = { @JoinColumn(name = "Producto_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "Categoria_Flores_id") }
    )
    private Set<Categoria> categorias = new HashSet<Categoria>(0);
//    Set<Categoria> categorias = new HashSet<>();
    
    

    public Producto() {
    }
    
    

    public Producto(Integer id, String name, String lastName, Double precio, String imagen, String tipo, String disponibilidad, String tamaño) {
        this.id = id;
        this.name = name;
        this.descripcion = lastName;
        this.precio = precio;
        this.imagen = imagen;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.tamaño = tamaño;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return descripcion;
    }

    public void setLastName(String lastName) {
        this.descripcion = lastName;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
    
}
