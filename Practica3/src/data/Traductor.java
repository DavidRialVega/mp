package data;


public class Traductor {
    public int[][] stringToTablero(String cadenaTablero){
        String[] filasTablero = cadenaTablero.split("-");
        int[][] tableroArray = new int[filasTablero.length][];
        String[] columnas;
        for (int i = 0; i < filasTablero.length; i++) {
            columnas = filasTablero[i].split("*");
            for (int j = 0; j < columnas.length; j++) {
                tableroArray[i][j] = Integer.parseInt(columnas[j]);
            }
        }
        return tableroArray;
    }
    
    public String tableroToString(int[][] tablero){
        String cadenaTablero = "";
        for (int i = 0; i < tablero.length; i++) {
            if (i != 0) {
                cadenaTablero += "-";
            }
            for (int j = 0; j < tablero[i].length; j++) {
                if (j != 0) {
                    cadenaTablero += "*";
                }
                cadenaTablero += tablero[i][j];
            }            
        }
        return cadenaTablero;
    }
}
