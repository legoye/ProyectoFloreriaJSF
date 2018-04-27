package com.ugurcanlacin.simple.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Bean administrado para el ejemplo de navegación
 * Captura un número y, en función de éste,
 * elige la página siguiente
 * @author BAOZ
 */
@ManagedBean(name = "nav")
@SessionScoped
public class NavegacionJB extends SpringBeanAutowiringSupport implements Serializable {
private String seleccion;
    
    public String elegir(){
    String sRet = "estacion";
        if (seleccion.equals("numero"))
            sRet = "numero";
        return sRet;
    }
    
    public String getSeleccion(){
        return seleccion;
    }
    public void setSeleccion(String val){
        this.seleccion = val;
    }
}
