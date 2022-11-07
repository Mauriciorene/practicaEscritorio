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
    //Método para seleccionar todos los registros de la tabla
    public List ObtenerDatos() {
        String transaccion = "SELECT * FROM Autor";
        //Llama a método Listar de DataBase.java
        List<Map> registros = new DataBase().Listar(transaccion);
        List<Autor> autores = new ArrayList(); //Arreglo de Autores
        //Ciclo que recorre cada registro y los agrega al arreglo autores
        for (Map registro : registros) {
            Autor aut = new Autor((int) registro.get("id_autor"),
                    (String) registro.get("nombres"),
                    (String) registro.get("apellidos"),
                    (String) registro.get("email"),
                    (String) registro.get("cedula"),
                    (java.sql.Date) registro.get("fechaNac"));
            autores.add(aut);
        }
        return autores; //Retorna todos los autores ubicados en la tabla de BD
    }
    //Método para eliminar un registro de la tabla en la BD
    public int Eliminar(int id) {
        String transaccion = "DELETE FROM Autor WHERE id_autor=´'"+ id +"'";
        
        return new DataBase().Actualizar(transaccion);
    }
    
}
