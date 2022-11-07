package Modelo;
import java.sql.Date;
//import java.util.List;
import java.util.*;


 // @author Mauricio Rubio
public class DAOAutor {
    //Método para insertar datos en la BD
    public Autor Insertar(String cedula, String nombres, String apellidos,
            String email, java.sql.Date fechaNac) {
        String transaccion = "INSERT INTO Autor VALUES('"
                + nombres + "', '"
                + apellidos + "', '"
                + email + "', '"
                + cedula + "', '"
                + fechaNac + "')";
        //Llama al método Actualizar ubicado en DateBase.java
        if (new DataBase().Actualizar(transaccion) > 0) {
            return new Autor(cedula, nombres, apellidos, email, fechaNac);
        }
        return null;
    }
    //métod para actualizar un registro en la BD
    public int Actualizar(int id, String nombres, String apellidos,
            String email, String cedula, java.sql.Date fechaNac) {
        
        String transaccion = "UPDATE Autor SET nombres=´'"
                + nombres + "', apellidos='"
                + apellidos + "', email= '"
                + email + "', fechaNac= '"
                + fechaNac + "',cedula='"
                + cedula +"', WHERE id_autor="
                + id ;
        
        return new DataBase().Actualizar(transaccion);
    }
    
}
