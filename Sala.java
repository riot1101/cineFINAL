/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

import java.util.ArrayList;

/**
 *
 * @author CES
 */
public class Sala {
    private int numero;
    private ArrayList<Butaca> butacas;
    private Pelicula pelicula;

    public Sala(int numero, int nButacas, int filas) {
        this.numero = numero;
        this.butacas = new ArrayList();
        //filas
        for (int i = 0; i < filas; i++) {
            //butacas
            for (int j = 0; j < nButacas/filas; j++) {
                Butaca butaca = new Butaca(i+1,j+1, true);
                this.butacas.add(butaca);
            } 
        }
        //butacas restantes
        for (int i = 0; i < nButacas%filas; i++) {
            Butaca butaca = new Butaca(filas+1,i+1, true);
            this.butacas.add(butaca);
        }
    }
    
    public Butaca buscarButacaLibre (){
        for (Butaca butaca : butacas) {
            if(butaca.isLibre()){
                return butaca;
            }
        }
        return null;
    }
    
    public void liberarButacas(){
        for (Butaca butaca : butacas) {
            butaca.setLibre(true);
        }
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    

    public ArrayList<Butaca> getButacas() {
        return butacas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
