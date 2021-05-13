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
public class Controlador {
    
    private Cine initCine(){
        Sala[]salas = new Sala[4];
        for (int i = 0; i < salas.length; i++) {
            salas[i]=Vista.pedirDatosSala(i+1);
        }
        Cine cine = new Cine(Vista.leerNombreCine(),
                Vista.leerDireccionCine(), 
                salas);
        return cine;
    }

    public void run() {
        Cine cine = initCine();
        int opc=0;
        do {
            Vista.showMenu();
            opc = Vista.leerOpcion();
            switch (opc) {
                case 1:
                    ArrayList<Butaca> butacas = cine.listarButacasSala(Vista.leerSala());
                    for (Butaca butaca : butacas) {
                        Vista.showButaca(butaca);
                    }
                    break;
                case 2:
                    Vista.showTituloPelicula(cine.buscarPeliculaSala(Vista.leerSala()));
                    break;
                case 3:
                    Sala[]salas = cine.getSalas();
                    for (Sala sala : salas) {
                        Vista.showSala(sala);
                    }
                    break;
                case 4:
                    Butaca butaca = cine.venderEntrada(Vista.leerSala());
                    Vista.showButaca(butaca);
                    break;
                case 5:
                    Vista.showResult(cine.liberarButacasSala(Vista.leerSala()));
                    break;
                default:
                    if (opc!=0){
                        Vista.showResult(false);
                    }
                    break;
            }
        } while (opc!=0);
    }
}
