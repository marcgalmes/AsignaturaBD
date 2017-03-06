
package org.dual.escola.persones;
/**
 *
 * 
 */
public class Persona {
    
    protected String nom, llinatges,dataDeNaixement;    //ATRIBUTOS DE LA CLASE PERSONA QUE SON GENERICOS CON LAS DEMÁS CLASES TIPO PROTECTED
    

    public Persona(String Nom, String Llinatges, String dataDeNaixement) {  //CONSTRUCTOR CLASE PERSONA CON SUS RESPECTIVOS PARAMETROS
        //INICIALIZAMOS LAS VARIABLES CON LOS VALORES RECIBIDOS DE LAS CLASES HIJAS
        this.nom = Nom;
        this.llinatges = Llinatges;
        this.dataDeNaixement = dataDeNaixement;
    }
    //DEVOLVEMOS UN STRING PARA PODER IMPRIMIR
    public String toString() {
        return "Persona{" + "Nom=" + nom + ", Llinatges=" + llinatges + ", dataDeNaixement=" + dataDeNaixement + '}';
    }
    //DEVOLVEMOS EL NOMBRE
    public String getNom() {
        return nom;
    }
    //DEVOLVEMOS EL APELLIDO
    public String getLlinatges() {
        return llinatges;
    }
    //DEVOLVEMOS LA FECHA DE NACIMIENTO
    public String getDataDeNaixement() {
        return dataDeNaixement;
    }
    //METODO PARA MODIFICAR EL VALOR DEL NOMBRE
    public void setNom(String Nom) {
        this.nom = Nom;
    }
    //METODO PARA MODIFICAR EL APELLIDO
    public void setLlinatges(String Llinatges) {
        this.llinatges = Llinatges;
    }
    
    
}
