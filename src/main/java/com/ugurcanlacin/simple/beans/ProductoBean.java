/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.beans;

import com.ugurcanlacin.simple.model.Categoria;
import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.model.User;
import com.ugurcanlacin.simple.service.ProductoService;
import com.ugurcanlacin.simple.service.UserService;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author admin
 */
@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductoBean extends SpringBeanAutowiringSupport implements Serializable {


    private List<Producto> list;

    @ManagedProperty(value = "#{productoService}")
    ProductoService productoService;

    private Integer id;

    private String name;

    private String descripcion;

    private Double precio;

    private String imagen;

    private String tipo;

    private String disponibilidad;

    private String tamaño;

    private Set<Categoria> categorias = new HashSet<Categoria>(0);

    public ProductoBean() {

    }

    @PostConstruct
    public void init() {
        listaProductos();
        System.out.println("ejectuando init");
    }
    public List<Producto> getList() {
        return list;
    }

    public void setList(List<Producto> list) {
        this.list = list;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void listaProductos(){
        list = productoService.findAll();
    }

    public String test() {

        List<Producto> test = null;
        test = productoService.findAll();
        int i  =0 ;
        i = i++;
        System.out.println("fadfadf");
        
        return "segunda";
    }

}
