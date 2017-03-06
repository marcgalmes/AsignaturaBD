
package org.dual.escola.persones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * 
 */
public class Professor extends Persona{
    
    private String especialidad, mensaje; //ATRIBUTOS DE PROFESOR Y PARA MOSTRAR POR PANTALLA
    
    
    public Professor (String nom, String llinatge, String fecha){   //CONSTRUCTOR DE LA CALSE PROFESOR CON VAORES POR PARAMETRO
        super(nom, llinatge, fecha);    //INICIALIZAMOS LAS VARIABLES HACÍA LA CLASE PADRE (PERSONA) LOS ATRIBUTOS TIENEN QUE SER DEL TIPO PROTECTED
        
        mensaje = "Intoruduzca la especialidad del profesor:";
        imprimir(mensaje);
        especialidad = entradaTexto();  //NOS INTRODUCE LA ESPECIALIDAD
        
    }

    //FUNCIÓN QUE DEVUELVE UN STRING CON TODOS LOS ATRIBUTOS Y SUS RESPECTIVOS VALORES
    public String toString() {
        return "Professor{" + "especialidad=" + especialidad +  ", nom=" + nom + ", llinatge=" + llinatges + ", fecha=" + dataDeNaixement + '}';
    }
    //METODO PARA ENTRADA DE TEXTO
    public String entradaTexto(){
        String entrada = "";
        try{
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            entrada = br.readLine();
            if (entrada.isEmpty()){
                throw new StringVacio();
            }entrada.toUpperCase();
            
        }catch (StringVacio sv){
            System.err.println("No has introducido un nada, por favor, introduzca especialidad");
            entrada = entradaTexto();
        }catch (IOException ioe){
            System.err.println("Error: " + ioe.getMessage());
        }
        return entrada;
    }
    //METODO PARA IMPRIMIR
    public void imprimir(String sms){
        System.out.println(sms);
    }
    //CLASE PARA TRATAMIENTO DE ERRORES
    public static class StringVacio extends Exception{
        public StringVacio(){
            
        }
    }
    
}
