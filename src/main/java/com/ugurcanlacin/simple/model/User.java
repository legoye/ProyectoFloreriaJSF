package com.ugurcanlacin.simple.model;

// default package
// Generated 14.Þub.2015 03:57:06 by Hibernate Tools 4.3.1
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "floreria")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String name;

    @Column(name = "ap", nullable = false, length = 20)
    private String lastName;

    @Column(name = "am", nullable = false, length = 20)
    private String secondLastName;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telphoneNumber;

    @Column(name = "direccion", nullable = false, length = 20)
    private String address;

    @Column(name = "correo", nullable = false, length = 20)
    private String email;

    @Column(name = "usuario", nullable = false, length = 20, unique = true)
    private String username;

    @Column(name = "contraseña", nullable = false, length = 20)
    private String password;

    public User() {
    }

    public User(Integer id, String name, String lastName, String secondLastName, String telphoneNumber, String address, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.telphoneNumber = telphoneNumber;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getTelphoneNumber() {
        return telphoneNumber;
    }

    public void setTelphoneNumber(String telphoneNumber) {
        this.telphoneNumber = telphoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
