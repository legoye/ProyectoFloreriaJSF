/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurcanlacin.simple.beans;

import com.ugurcanlacin.simple.model.Producto;
import com.ugurcanlacin.simple.service.ProductoService;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author admin
 */
@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean extends SpringBeanAutowiringSupport implements Serializable {

    private List<Producto> list;
    private Double total = 0.00;
    @ManagedProperty(value = "#{productoService}")
    ProductoService productoService;

    private String calle;
    private String numero;
    private String cp;
    private String nombreTitular;
    private String numeroTarjeta;
    private Date fechaVencimiento;

    public CarritoBean() {
        list = new ArrayList<Producto>();
    }

    public List<Producto> getList() {
        return list;
    }

    public void setList(List<Producto> list) {
        this.list = list;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String agregarCarrito() {

        String id = "";
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        Producto p = new Producto();
        Integer idI = Integer.parseInt(id);

        try {
            p = productoService.findById(idI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.add(p);

        this.total = this.total + p.getPrecio();

        return "carrito";

    }

    public String borrarCarrito() {

        String id = "";
        id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        int idI = Integer.parseInt(id);
        int itera = 0;

//        for (Producto producto : this.getList()) {
//            if (producto.getId() == idI) {
//                list.remove(itera);
//            }
//            itera++;
//        }
        for (int i = 0; i < this.getList().size(); i++) {
            Producto producto = list.get(i);
            if (producto.getId() == idI) {
                list.remove(i);
                this.total = this.total - producto.getPrecio();
            }
        }

        return "index";
    }

    public void pagar() {

        this.calle = "";
        this.cp = "";
        this.nombreTitular = "";
        this.numero = "";
        this.numeroTarjeta = "";
        this.total = 0.00;
        this.fechaVencimiento = null;
        this.list  = new ArrayList<Producto>();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gracias por su compra", "Su pago se ha procesado exitosamente."));

    }

}
