/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox.logica;

/**
 *
 * @author dual
 */
public class Persona {

    private String nom;
    private String apellido;
    private final String nie;
    private Sexe sexe;
    private Estado estado;

    
    /**
     * Crear persona con el nie
     * @param nie
     */
    public Persona(String nie) {
        this.nie = nie;
    }

    /**
     * Get sexe.
     * @return 
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * Set sexe
     * @param sexe
     */
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    /**
     * Get estado 
     * @return 
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Set estado 
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Get Nom
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set Nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get Apellido
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set apellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Get Nie
     * @return 
     */
    public String getNie() {
        return nie;
    }
    
    public enum Estado {Estudiante,Paro,Trabajador;
        public Estado getRandom() {
            return Estudiante;
        } 
};
    public enum Sexe {Home,Dona};
    
}
