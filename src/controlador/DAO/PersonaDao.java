/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.tda.lista.ListaEnlazada;
import modelo.Persona;

/**
 *
 * @author jy
 */
public class PersonaDao extends AdaptadorDao<Persona> {
    private Persona persona;
    private ListaEnlazada<Persona> lista = new ListaEnlazada();

    public ListaEnlazada<Persona> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Persona> lista) {
        this.lista = lista;
    }


    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if(persona==null)
            persona = new Persona();
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public boolean guardar(){
        return this.guardar(persona);
    }
}
