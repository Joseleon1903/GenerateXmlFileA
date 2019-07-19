package com.generating.xml.fl.socketserver;

import com.generating.xml.fl.MainApp;
import com.generating.xml.fl.util.IntroLogUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerManager implements Runnable{

    private static Logger log = LogManager.getLogger(MainApp.class);

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter pWriter;
    private BufferedReader bufferReader;

    private boolean isSocketListening= false;
    private int port;

    public void init(int port) {
        log.debug("init socket server on port "+ port);
        log.debug("isSocketListening: "+ port);
        this.port = port;
        this.isSocketListening = true;
    }


    public void stop() throws IOException {
        bufferReader.close();
        pWriter.close();
        clientSocket.close();
        serverSocket.close();
    }

    @Override
    public void run() {
        log.debug("entering in method run for start listening socket");
     try {
         Thread.sleep(5000);
         log.debug(IntroLogUtility.SOCKET_RUN);
            while (isSocketListening) {
                serverSocket = new ServerSocket(port);
                clientSocket = serverSocket.accept();
                pWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = bufferReader.readLine();

                //validate message is not stop
                validateStopMessage(message);




                log.debug("message string " + message);
                pWriter.println("success communication");
                stop();
            }

        }catch (IOException | InterruptedException ex){
          isSocketListening = false;
          log.debug("error in socket communication : "+ ex.getMessage());
          ex.getStackTrace();
        }
        log.debug(IntroLogUtility.SOCKET_STOPPED);
    }

    public void validateStopMessage(String message){
        if (message != null && message.toUpperCase().contains("stop".toUpperCase())){
            this.isSocketListening = false;
        }

    }


}
//            if ("hello server".equals(greeting)) {
//                pWriter.println("hello client");
//            } else {
//                pWriter.println("unrecognised greeting");
//            }
