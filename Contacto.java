/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.javierlr.agenda2024;
import java.time.LocalDate;
/**
 *
 * @author alu14d
 */
public class Contacto implements Comparable <Contacto>{
    //atributos
    private String nombre;
    private String telefono;
    private String email;
    private LocalDate fechaNac;
           

    public Contacto(String nombre, String telefono, String email, LocalDate fechaNac ) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac= fechaNac;
    }
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = null;
        this.fechaNac=null;
       
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", fechaNac=" + fechaNac + '}';
    }

   
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Contacto c) {
        return this.getNombre().compareTo(c.getNombre());
    }
   
}



