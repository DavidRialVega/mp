package data;


public class Traductor {
    public int[][] stringToTablero(String cadenaTablero){
        String[] filasTablero = cadenaTablero.split("p");
        int[][] tableroArray = new int[filasTablero.length][];
        String[] columnas;
        for (int i = 0; i < filasTablero.length; i++) {
            columnas = filasTablero[i].split("_");
            tableroArray[i] = new int[columnas.length];
            for (int j = 0; j < columnas.length - 1; j++) {
                tableroArray[i][j] = Integer.parseInt(columnas[j]);
            }
        }
        return tableroArray;
    }
    
    public String tableroToString(int[][] tablero){
        String cadenaTablero = "";
        for (int i = 0; i < tablero.length; i++) {
            if (i != 0) {
                cadenaTablero += "p";
            }
            for (int j = 0; j < tablero[i].length; j++) {
                if (j != 0) {
                    cadenaTablero += "_";
                }
                cadenaTablero += tablero[i][j];
            }            
        }
        return cadenaTablero;
    }
}
