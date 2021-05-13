/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

import cine.exceptions.SalaNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author CES
 */
public class Cine {

    private String nombre, direccion;
    private Sala[] salas = new Sala[4];

    public Cine(String nombre, String direccion, Sala[]salas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.salas = salas;
    }

    public ArrayList<Butaca> listarButacasSala(int nSala) {
        if (nSala > 0 && nSala < 5) {
            return salas[nSala - 1].getButacas();
        }
        return null;

    }

    public String buscarPeliculaSala(int nSala) throws SalaNotFoundException{
        try{
            return salas[nSala - 1].getPelicula().getTitulo();
        }catch(IndexOutOfBoundsException ex){
            throw new SalaNotFoundException(nSala);
        }
  
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public Butaca venderEntrada(int nSala) {
        if (nSala > 0 && nSala < 5) {
            Butaca butaca = salas[nSala - 1].buscarButacaLibre();
            if (butaca != null) {
                butaca.setLibre(false);
            }
            return butaca;
        }
        return null;
    }
    
    public boolean liberarButacasSala(int nSala){
        if (nSala > 0 && nSala < 5) {
            salas[nSala - 1].liberarButacas();
            return true;
        }
        return false;
    }
}
