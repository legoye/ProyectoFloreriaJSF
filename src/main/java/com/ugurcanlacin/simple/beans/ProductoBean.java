/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.beans;

import com.ugurcanlacin.simple.model.Categoria;
import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.model.User;
import com.ugurcanlacin.simple.service.CategoriaService;
import com.ugurcanlacin.simple.service.ProductoService;
import com.ugurcanlacin.simple.service.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.primefaces.context.RequestContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.primefaces.*;

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

    @ManagedProperty(value = "#{categoriaService}")
    CategoriaService categoriaService;

    private Integer id;

    private String name;

    private String descripcion;

    private Double precio;

    private String imagen;

    private String tipo;

    private String disponibilidad;

    private String tamaño;

    private Set<Categoria> categorias = new HashSet<Categoria>();

    private Producto newProducto = new Producto();

    private List<String> selectedCategorias;

    private List<Categoria> categoriasSelect;

    public ProductoBean() {

    }

    @PostConstruct
    public void init() {
        listaProductos();
        System.out.println("ejectuando init");

        categoriasSelect = new ArrayList<Categoria>();
        categoriasSelect = categoriaService.findAll();

        System.out.println(categoriasSelect);
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

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
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

    public void listaProductos() {
        list = productoService.findAll();
    }

    public Producto getNewProducto() {
        return newProducto;
    }

    public void setNewProducto(Producto newProducto) {
        this.newProducto = newProducto;
    }

    public List<Categoria> getCategoriasSelect() {
        return categoriasSelect;
    }

    public void setCategoriasSelect(List<Categoria> categoriasSelect) {
        this.categoriasSelect = categoriasSelect;
    }

    public List<String> getSelectedCategorias() {
        return selectedCategorias;
    }

    public void setSelectedCategorias(List<String> selectedCategorias) {
        this.selectedCategorias = selectedCategorias;
    }

    public String detalleProducto() {

        String id = "";
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        System.out.println("id recibido" + id);

        Producto p = new Producto();
        p = productoService.findById(Integer.parseInt(id));
        this.id = p.getId();
        this.name = p.getName();
        this.descripcion = p.getDescripcion();
        this.tamaño = p.getTamaño();
        this.disponibilidad = p.getDisponibilidad();
        this.tipo = p.getTipo();

        return "detalle_producto";

    }

    public String editaProducto(String id) throws IOException {

        System.out.println("entra a editar Producto");

        // id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        System.out.println("id recibido" + id);

        newProducto = productoService.findById(Integer.parseInt(id));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/editarProducto.xhtml");
        return "editarProducto";

    }
    
    public void eliminaProducto(String id) throws IOException {

        System.out.println("entra a editar Producto");

        // id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        System.out.println("id recibido" + id);

        productoService.delete(productoService.findById (Integer.parseInt(id))); 

        addMessage("Eliminado", "Su producto ha sido eliminado correctamente.");
       

    }

    public void agregaProducto() {

        System.out.println("entra a agregar producto");

        for (String selectedCategoria : selectedCategorias) {
            System.out.println(selectedCategoria);
            categorias.add(categoriaService.findUserById(Integer.parseInt(selectedCategoria)));

        }
//        newProducto.setName("test");
//        newProducto.setDescripcion("test");
//        newProducto.setPrecio(20.00);
//        newProducto.setDisponibilidad("inmediata");
//        newProducto.setTamaño("mediano");
//        categorias.add(new Categoria(1));
        newProducto.setCategorias(categorias);
        productoService.persist(newProducto);
        System.out.println("User successfully saved.");
        addMessage("Registro exitoso", "Su producto ha sido agregado correctamente.");
        //  PrimeFaces.current().resetInputs("form:panel");
        newProducto = new Producto();
        categorias = new HashSet<Categoria>();
        listaProductos();

    }
    
    public void editarProducto() {

        System.out.println("entra a agregar producto");

        for (String selectedCategoria : selectedCategorias) {
            System.out.println(selectedCategoria);
            categorias.add(categoriaService.findUserById(Integer.parseInt(selectedCategoria)));

        }
//        newProducto.setName("test");
//        newProducto.setDescripcion("test");
//        newProducto.setPrecio(20.00);
//        newProducto.setDisponibilidad("inmediata");
//        newProducto.setTamaño("mediano");
//        categorias.add(new Categoria(1));
        newProducto.setCategorias(categorias);
        productoService.persist(newProducto);
        System.out.println("User successfully saved.");
        addMessage("Edicion exitoso", "Su producto ha sido editado correctamente.");
        //  PrimeFaces.current().resetInputs("form:panel");
        newProducto = new Producto();
        categorias = new HashSet<Categoria>();
        listaProductos();

    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String test() {

        List<Producto> test = null;
        test = productoService.findAll();
        int i = 0;
        i = i++;
        System.out.println("fadfadf");

        return "segunda";
    }

}
