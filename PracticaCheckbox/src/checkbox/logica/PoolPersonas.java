/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox.logica;

import checkbox.basedatos.ConexionMySQL;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dual
 */
public class PoolPersonas {
    /**
     * Lista de personas.
     */
    private final ArrayList<Persona> personas = new ArrayList();
    public ConexionMySQL conexionMySQL = new ConexionMySQL();
    private final String error_buscarPersona = "No se encuentra la persona con este dni. Guarde primero la persona con 'aceptar'.";

    public PoolPersonas() {
    }
    
    public Persona getPersona(String dni) {
        for (Persona p: personas) {
            if (p.getNie().equals(dni)) return p;
        }
        return null;
    }

    /**
     * Get the value of personas
     *
     * @return the value of personas
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }
    
    /**
     * Añade una persona
     * @param p
     */
    public void addPersona(Persona p){
        personas.add(p);
    }
    
    /**
     * Elimina una persona.
     * @param p
     */
    public void removePersona(Persona p){
        personas.remove(p);
    }
    
    /**
     * Guardar en un txt.
     */
    public void guardarDatos() {
        try (FileWriter fw = new FileWriter("src/checkbox/salida/Estat Solicitants.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (int i = 0; i < personas.size(); i++) {
                out.println(personas.get(i).getNie()+" "+personas.get(i).getNom()+ " " + personas.get(i).getApellido()+ " "
                        + personas.get(i).getEstado()+ " "
                        + personas.get(i).getSexe());
            }
        } catch (IOException error) {
            System.out.println(error);
        }
    }

    public String alta(String dni) { //insert into tabla values ('','');
        Persona persona = getPersona(dni);
        if (persona==null) return error_buscarPersona;
        conexionMySQL.actualizar("INSERT INTO usuaris values ('"+persona.getNie()+"','"+persona.getNom()+"','"+persona.getApellido()+"');");
        
        return "Alta OK.";
    }
    
    public String eliminar(String dni) {//delete from tabla where ...;
        conexionMySQL.actualizar("DELETE FROM usuaris WHERE NIF='"+dni+"';");
        
        return "Persona eliminada. RIP :(";
    }
    
    public String modificacion(String dni) {//update tabla set col=val where ...;
        Persona persona = getPersona(dni);
        if (persona==null) return error_buscarPersona;
        conexionMySQL.actualizar("UPDATE usuaris SET Nom='"+persona.getNom()+"', Llinatge='"+persona.getApellido()+"' WHERE NIF='"+persona.getNie()+"';");
        return "Persona 5modificada.";
    }
    
    public Persona consulta(String dni) { //select * from tabla where ...;
        ResultSet consultar = conexionMySQL.consultar("SELECT * FROM usuaris WHERE NIF='"+dni+"';");
        try {
            if (!consultar.next()) return null;
            String nif = consultar.getString("NIF");
            String nom = consultar.getString("Nom");
            String llinatge = consultar.getString("Llinatge");
            Persona p = new Persona(dni);
            p.setNom(nom);
            p.setApellido(llinatge);
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PoolPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
