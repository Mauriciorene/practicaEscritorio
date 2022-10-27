/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
/**
 *
 * @author Mauricio Rubio
 */
public class Autor {
    
    private int id_autor;
    private String cedula;
    private String nombres;
    private String Apellidos;
    private String email;
    private Date fechaNac;
    
    public Autor(int id_autor, String cedula, String nombres, String Apellidos,
            String email, Date fechanac) {
        this.id_autor = id_autor;
        this.cedula = cedula;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        this.email = email;
        this.fechaNac = fechaNac;
    }
    
    public Autor(String cedula, String nombres, String Apellidos, String email,
            Date fechaNac) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        this.email = email;
        this.fechaNac = fechaNac;     
    }
}
