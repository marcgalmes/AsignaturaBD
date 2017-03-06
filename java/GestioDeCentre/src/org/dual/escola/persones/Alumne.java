package org.dual.escola.persones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 
 */
public class Alumne extends Persona{
    
    private String curso, mensaje, fecha;   //ATRIBUTOS DE LA CLASE ALUMNO
    
    
    public Alumne (String nom, String llinatges, String fecha){ //CONSTRUCTOR DE LA CLASE ALUMNO CON SUS RESPECTIVOS PARAMETROS
        super(nom, llinatges, fecha);   //INICIALIZAMOS LAS VARIABLES DE LA CLASE PADRE (PERSONA)
        mensaje = "Introduzca el curso del alumno: ";
        imprimir(mensaje);
        curso = entradaTexto(); //NOS INTRODUCE EL CURSO DEL ALUMNO
    }
    //FUNCIÓN QUE NOS DEVUELVE EL CURSO PARA PODER ACCEDER DESDE OTRA CLASE Y PODER IMPRIMIRLO
    public String getCurso() {
        return curso;
    }
    //FUNCIÓN QUE DEVUELVE UN STRING PARA ENTRA DE TEXTO POR PARTE DEL USUARIO
    public String entradaTexto(){
        String entrada = "";
        try{
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            entrada = br.readLine();
            if (entrada.isEmpty()){
                throw new Professor.StringVacio();
            }entrada.toUpperCase();
            
        }catch (Professor.StringVacio sv){
            System.err.println("No has introducido un nada, por favor, introduzca curso");
            entrada = entradaTexto();
        }catch (IOException ioe){
            System.err.println("Error: " + ioe.getMessage());
        }
        return entrada;
    }
    //METODO PARA IMPRIMIR POR PANTALLA
    public void imprimir(String sms){
        System.out.println(sms);
    }
}
