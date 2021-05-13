/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

/**
 *
 * @author CES
 */
public class Vista {

    public static void showMenu() {
        System.out.println("1. Consultar butacas sala");
        System.out.println("2. Consultar pelicula sala");
        System.out.println("3. Consultar cartelera");
        System.out.println("4. Vender entradas");
        System.out.println("5. Liberar butacas");
        System.out.println("0. Salir");
    }

    public static int leerOpcion() {
        return Utils.readUnsignedInt();
    }

    public static int leerSala() {
        int sala = 0;
        do {
            System.out.println("Introduce nº de sala:");
            sala = Utils.readUnsignedInt();
        } while (sala < 1 || sala > 4);
        return sala;
    }
    
    public static void showButaca (Butaca butaca){
        System.out.println("Fila: "+butaca.getFila());
        System.out.println("Número: "+butaca.getNumero());
        System.out.println("Estado: "+(butaca.isLibre() ? "Libre" : "Ocupada"));
        //Estado: true Estado: false
    }
    
    public static void showTituloPelicula(String pelicula){
        
        //System.out.println(pelicula!=null ? pelicula : "No hay película");
        if(pelicula!=null && !pelicula.isEmpty()){
            System.out.println(pelicula);
        }else{
            System.out.println("No hay película");
        }
        
    }
    
    public static Pelicula leerPelicula(){
        System.out.println("Introduce el título de la película: ");
        String titulo = Utils.readString();
        System.out.println("Introduce la clasificación");
        String clasificacion = Utils.readString();
        System.out.println("Introduce la duración en minutos: ");
        int duracion = Utils.readUnsignedInt();
        Pelicula pelicula = new Pelicula(titulo, clasificacion, duracion);
        return pelicula;
    }
    
    public static Sala pedirDatosSala(int nSala){
        System.out.println("Sala "+nSala);
        int nButacas = 0;
        int nFilas = 0;
        //validar butacas
        do{
            System.out.println("Introduce número de butacas");
            nButacas = Utils.readUnsignedInt();
        }while(nButacas<10 || nButacas>40);
        //validar filas
        do{
            System.out.println("Introduce número de filas");
            nFilas = Utils.readUnsignedInt();
        }while(nFilas<=0 || nFilas>nButacas);
        
        System.out.println("Información de la pelicula: ");
        Pelicula pelicula = leerPelicula();
        
        Sala sala = new Sala(nSala, nButacas, nFilas);
        sala.setPelicula(pelicula);
        return sala;
    }
    
    public static String leerNombreCine(){
        System.out.println("Introduce el nombre del cine");
        return Utils.readString();
    }
    
    public static String leerDireccionCine(){
        System.out.println("Introduce la dirección del cine");
        return Utils.readString();
    }
    
    public static void showSala(Sala sala){
        System.out.println("Sala: "+sala.getNumero());
        showTituloPelicula(sala.getPelicula().getTitulo());
    }
    
    public static void showResult(boolean result){
        if (result){
            System.out.println("Operación realizada correctamente");
        }else{
            System.out.println("Algo no ha ido bien");
        }
    }
}
