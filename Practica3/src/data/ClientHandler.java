//package data;
//
//
//import data.Protocolo;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Clase que recibe y gestiona las peticiones de cada cliente EN EL SERVIDOR Se
// * crea cada vez q un cliente se intenta conectar al server y se mantiene viva
// * hasta q el cliente decide desconectarse
// *
// * por otro lado, si el cliente hace click en un punto de su pantalla,
// * inmediatamente mandará un mensaje, que será recogido por esta clase, la cual
// * actuará en consecuencia.
// */
//public class ClientHandler implements Protocolo {
//
//    private Socket socket;
//
//    private RecibirMensajeHandler recibirMensajeHandler;
//    private EnviarMensajeHandler enviarMensajeHandler;
//
//    public boolean conectado;
//
//    public static ArrayList<ClientHandler> listaClientes = new ArrayList();
//    public static ArrayList<Comida> listaComida = new ArrayList();
//    public static boolean[] imagenSeleccionada = {false, false, false, false, false, false, false, false};//sprite seleccionado
//    public Player player;
//    public static int idPlayer = 0;//id del jugador
//    public static boolean admin = false;//El administrador del juego
//    public static boolean inicioJuego = false;//El inicio del juego
//    public static long tiempo;//El tiempo que va  a tener el juego
//    public static int idFruta, numFrutasPantalla = 6;//id de la fruta y el numero de frutas que quiero que se muestren por pantalla
//    public static Timer t;
//    public static TimerTask upTime;
//
//    /**
//     * ********************************************************************************
//     * clases internas que gestionan mediante hilos la emisión y recepción de
//     * mensajes
//     * *********************************************************************************
//     */
//    public ClientHandler(Socket socket) {
//        try {
//            this.socket = socket;
//
//            DataInputStream in = new DataInputStream(socket.getInputStream());
//            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//
//            recibirMensajeHandler = new RecibirMensajeHandler(in);
//            enviarMensajeHandler = new EnviarMensajeHandler(out);
//
//            conectado = true;
//
//            Random rand = new Random();
//
//            //Agrego el cliente a la lista de jugadores
//            synchronized (listaClientes) {
//                listaClientes.add(this);
//            }
//
//            //Mando un mensaje en el q indico q el jugador  ha iniciado el juego
//            sendMessage(IDC);
//
//            tiempo = 30;
//
//            t = new Timer("Tiempo", true);
//
//            upTime = new TimerTask() {
//
//                @Override
//                public void run() {
//                    if (inicioJuego) {
//
//                        synchronized (listaClientes) {
//
//                            Collections.sort(listaClientes, new CustomComparator());
//
//                            if (listaClientes.size() > 2) {
//                                broadcast(FIN + ";" + ((ClientHandler) listaClientes.get(0)).player.name + "|" + ((ClientHandler) listaClientes.get(0)).player.puntuacion + "|" + ((ClientHandler) listaClientes.get(1)).player.name + "|" + ((ClientHandler) listaClientes.get(1)).player.puntuacion + "|" + ((ClientHandler) listaClientes.get(2)).player.name + "|" + ((ClientHandler) listaClientes.get(2)).player.puntuacion + "|" + ((ClientHandler) listaClientes.get(3)).player.name + "|" + ((ClientHandler) listaClientes.get(3)).player.puntuacion);
//                            } else {
//                                broadcast(FIN + "|" + ((ClientHandler) listaClientes.get(0)).player.name + "|" + ((ClientHandler) listaClientes.get(0)).player.puntuacion + "|" + ((ClientHandler) listaClientes.get(1)).player.name + "|" + ((ClientHandler) listaClientes.get(1)).player.puntuacion + "|" + "NULL" + "|" + "0" + "|" + "NULL" + "|" + "0");
//                            }
//                        }
//
//                        try {
//                            t = null;
//                            this.finalize();
//                        } catch (Throwable ex) {
//                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                    }
//
//                }
//
//            };
//
//        } catch (IOException e) {
//            System.out.println("Esperanjdo para connectar: " + e);
//        }
//    }
//
//    private static class CustomComparator implements Comparator<ClientHandler> {
//
//        public CustomComparator() {
//        }
//
//        @Override
//        public int compare(ClientHandler p, ClientHandler p2) {
//            return p2.player.puntuacion - p.player.puntuacion;
//        }
//    }
//
//    //Clase interna que gestiona, a través de un hilo, la recepción de mensajes
//    public class RecibirMensajeHandler implements Runnable {
//
//        Thread recivir;
//        private DataInputStream dataInputStream;
//
//        public RecibirMensajeHandler(DataInputStream in) {
//            dataInputStream = in;
//            recivir = new Thread(this);
//            recivir.start();
//        }
//
//        public void run() {
//            Thread thisThread = Thread.currentThread();
//            while (recivir == thisThread) {//Mientras sea este hilo Leo y manejo el mensaje recibido
//                try {
//                    String message = dataInputStream.readUTF();
//                    handleMessage(message);//Esta función es la q gestiona el mensaje recibido
//                } catch (IOException e) {//El sprite que ha cogido el cliente lo pone a folse para que se pueda volver a  coger
//                    if (player.spriteId != -1) {
//                        imagenSeleccionada[player.spriteId] = false;
//                    }
//                    disconnect();
//                }
//            }
//        }
//
//        public void destroy() {
//            recivir = null;
//        }
//
//    }
//
//    //Clase interna que gestiona, a través de un hilo, el envío de mensajes hacia los clientes
//    public class EnviarMensajeHandler implements Runnable {
//
//        Thread enviar;
//        LinkedList listaMensajes;//lista con los mensajes a enviar
//        DataOutputStream dataOutputStream;
//
//        public EnviarMensajeHandler(DataOutputStream out) {
//            dataOutputStream = out;
//            listaMensajes = new LinkedList();
//
//            enviar = new Thread(this);
//            enviar.start();
//        }
//
//        public void addMessage(String message) {
//            synchronized (listaMensajes) {
//                listaMensajes.add(message);
//                listaMensajes.notify();
//            }
//        }
//
//        public void run() {
//            String message;
//
//            Thread thisThread = Thread.currentThread();
//            while (enviar == thisThread) {
//                synchronized (listaMensajes) {
//                    //Si no tengo mensajes para enviar, espero
//                    if (listaMensajes.isEmpty() && enviar != null) {
//                        try {
//                            listaMensajes.wait();
//                        } catch (InterruptedException e) {
//                        }
//                    }
//                }
//
//                //Si ya tengo mensajes proceso la lista
//                //La pongo en un while xq procesaré un mensaje por iteración
//                while (listaMensajes.size() > 0) {
//                    synchronized (listaMensajes) {
//                        message = (String) listaMensajes.removeFirst();
//                    }
//
//                    try {
//                        //Envío el mensaje
//                        dataOutputStream.writeUTF(message);
//                    } catch (IOException e) {
//                        disconnect();
//                    }
//                }
//            }
//        }
//
//        public void destroy() {
//            enviar = null;
//
//            synchronized (listaMensajes) {
//                listaMensajes.notify(); // despierta al hilo por si se encuentra parado en el wait(por si se para de mandar mensajes porque se desconecta un cliente)
//            }
//        }
//
//    }
//
//    //Si se desconecta un cliente
//    public synchronized void disconnect() {
//        if (conectado) {
//            synchronized (listaClientes) {
//                listaClientes.remove(this);
//            }
//
//            //Mando un mensje a todos los clientes informando de la desconexón
//            broadcast(FIN + "|" + player.playerId);
//
//            conectado = false;
//
//            recibirMensajeHandler.destroy();
//            enviarMensajeHandler.destroy();
//
//            try {
//                socket.close();
//            } catch (Exception e) {
//            }
//            socket = null;
//        }
//        if (listaClientes.isEmpty()) {
//            admin = false;
//            inicioJuego = false;
//        }
//        System.out.println("Cliente desconectado");
//    }
//
//    /**
//     * Función importantísima que se encarga de difundir un mensaje a TODOS los
//     * jugadores esta función la usa el servidor para comunicar algo que ha
//     * generado él
//     *
//     * @param message mensaje a difundir
//     */
//    public static void broadcast(String message) {
//        synchronized (listaClientes) {
//            ClientHandler client;
//            for (int i = 0; i < listaClientes.size(); i++) {
//                client = (ClientHandler) listaClientes.get(i);
//                client.sendMessage(message);
//            }
//        }
//    }
//
//    /**
//     * Igual que la anterior pero no le manda la info al jugador q la genera
//     * Esta función la usa el servidor para comunicar algo que ha generado un
//     * cliente concreto
//     *
//     * @param message mensaje a difundir
//     */
//    public void broadcastFromClient(String message) {
//        synchronized (listaClientes) {
//            ClientHandler client;
//            for (int i = 0; i < listaClientes.size(); i++) {
//                client = (ClientHandler) listaClientes.get(i);
//                if (client != this) {
//                    client.sendMessage(message);
//                }
//            }
//        }
//    }
//
//    /*Siempre q mando un mensaje pasaré por aquí, 
//     añadiendo el mensaje a la lista de mensajes a enviar
//     a través del método de la clase q los gestiona
//     */
//    public void sendMessage(String message) {
//        enviarMensajeHandler.addMessage(message);
//    }
//
//    /**
//     * Funcion que se encarga de gestionar la recepción de un mensaje por parte
//     * del cliente
//     */
//    public void handleMessage(String message) {
//        StringTokenizer st = new StringTokenizer(message, ";");
//        int tipo_mensaje = Integer.parseInt(st.nextToken());
//
//        switch (tipo_mensaje) {
//            case IDC://Si recibo un msj de nombre...
//            {
//                player.id = st.nextToken();
//
//                sendMessage(IDC + ";" + player.id);
//
//                break;
//            }
//
//            case MOV://si me muevo
//            {
//                player.x = Integer.parseInt(st.nextToken());
//                player.y = Integer.parseInt(st.nextToken());
//
//                broadcast(MSG_MOVER_POSICION + "|" + player.playerId + "|"
//                        + player.x + "|" + player.y);
//                break;
//            }
//
//            case MSG_SELECCION_AVATAR: {
//
//                player.spriteId = Integer.parseInt(st.nextToken());
//                imagenSeleccionada[player.spriteId] = true;
//
//                broadcast(MSG_SELECCION_AVATAR + "|" + player.spriteId);
//                break;
//            }
//
//            case MSG_INICIO_PLAYER: {
//                sendMessage(MSG_ADD_PLAYER + "|");
//
//                Player p;
//                synchronized (listaClientes) {
//                    for (int i = 0; i < listaClientes.size(); i++) {
//                        p = ((ClientHandler) listaClientes.get(i)).player;
//                        if (player != p) {
//                            sendMessage(MSG_AGREGAR_NEW_PLAYER + "|" + p.x + "|" + p.y + "|" + p.spriteId + "|" + p.playerId + "|" + p.name);
//                        }
//                    }
//                }
//                break;
//            }
//
//            case MSG_COMER_FRUTA: {
//                if (player.spriteId == Integer.parseInt(st.nextToken())) {
//                    int idFruta = Integer.parseInt(st.nextToken());
//                    synchronized (listaComida) {//Me recorro toda la lista de comida
//                        for (Comida f : listaComida) {
//                            if (f.id == idFruta) {
//                                this.player.puntuacion += f.puntuacion;
//                                broadcast(MSG_COMER_FRUTA + "|" + f.id);
//                                listaComida.remove(f);
//                                break;
//                            }
//                        }
//                    }
//                }
//                break;
//            }
//
//            case MSG_INICIO_JUEGO: {
//
//                synchronized (listaClientes) {
//                    Player p;
//                    int avaataresCogidos = 0;
//                    if (listaClientes.size() > 1) {
//                        for (int i = 0; i < listaClientes.size(); i++) {
//                            p = ((ClientHandler) listaClientes.get(i)).player;
//                            if (p.spriteId != -1) {
//                                avaataresCogidos++;
//                            }
//                        }
//                        if (avaataresCogidos == listaClientes.size()) {
//                            broadcast(MSG_INICIO_JUEGO + "|" + listaClientes.size());
//                            inicioJuego = true;
//                            t.scheduleAtFixedRate(upTime, 0, 1000);
//
//                        } else {
//                            sendMessage(MSG_NECESITAR_AVATAR + "|");
//                        }
//                    } else {
//                        sendMessage(MSG_ESPERAR_CONEXION + "|");
//                    }
//                }
//
//                break;
//            }
//
//        }
//    }
//
//}
