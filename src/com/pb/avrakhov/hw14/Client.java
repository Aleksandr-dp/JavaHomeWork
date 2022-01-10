package com.pb.avrakhov.hw14;

import java.io.*;
import java.net.Socket;

public class Client {
        public static void main(String[] args) throws Exception {
        System.out.println("Client in.");

        String serverIP = "127.0.0.1";
        int serverPort = 5321;

        System.out.println("Connect to server " + serverIP + ":" + serverPort);

        Socket server = new Socket(serverIP, serverPort);
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser, dataFromServer;

        // Основной цикл отправки сообщений серверу
        while ((dataFromUser = inConsole.readLine()) != null) {
            outServer.println(dataFromUser);
            dataFromServer = inServer.readLine();
            System.out.println(dataFromServer);
            if ("exit".equalsIgnoreCase(dataFromUser)) {
                break;
            }
        }

        outServer.close();
        inServer.close();
        outServer.close();
        server.close();
    }
}