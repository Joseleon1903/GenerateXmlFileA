package com.generating.xml.fl;

import com.generating.xml.fl.socketserver.SocketClient;
import java.io.IOException;

public class ClientSocketImpl {

    public static void main(String args[]){
        SocketClient client = new SocketClient();
        int intentNumber = 10;
        try {
            while(intentNumber >=0){
                Thread.sleep(10000);
                client.startConnection("localhost", 9090);
                String response = client.sendMessage("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><MESSAGE TYPE=\"860\" BANKID=\"102\" CORRELATIONID=\"20190703669732\"><CLIENT ID=\"12345\" TYPE=\"PASAPORTE\" TELEPHONE=\"8094447844\" TELCOID=\"200\" BPSEQUENCE=\"000032\"/><TRANSACTION DATE=\"03072019\" TIME=\"103246\"/></MESSAGE>");
                System.out.println("response: "+response);
                client.stopConnection();
                intentNumber--;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
