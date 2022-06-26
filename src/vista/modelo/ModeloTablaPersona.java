/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import controlador.tda.lista.ListaEnlazada;

import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author jy
 */
public class ModeloTablaPersona extends AbstractTableModel{

    private ListaEnlazada<Persona> lista = new ListaEnlazada();

    public ListaEnlazada<Persona> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Persona> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona per = lista.obtenerDato(i);
        switch(i1){
            case 0: return (i + 1);
            case 1: return per.getNombre();
            case 2: return per.getCedula();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nro";
            case 1: return "Nombre";
             case 2: return "Cedula";
//            case 3: return "Placa";
            default: return null;
        }
    }
    
}
