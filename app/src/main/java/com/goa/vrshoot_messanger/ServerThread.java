package com.goa.vrshoot_messanger;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Akshay on 2/1/2016.
 */
public class ServerThread extends Thread {

    ServerSocket server;
    Socket socket;
    DataOutputStream dataOutputStream;

    public ServerThread() {

    server = null;socket = null;
    }

    @Override
    public void run() {
        super.run();
        try {
            server = new ServerSocket(2489);

            //while (true) {
                socket = server.accept();
            Log.d("server","accpeted");
                Log.d("server", "accepted");
                String	message = "hello";

                //DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
                //dataOutputStream.writeBytes(message);

            //}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendMessage(int ch){
        if (socket != null && server!= null) {

            try {
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                switch (ch){
                    case 0://reload
                        dataOutputStream.writeBytes("0");
                        break;
                    case 1://fire
                        dataOutputStream.writeBytes("1");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            return;
    }

    public Socket getSocket(){
        return this.socket;
    }
}
