package com.example.demo;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String massageFromClient;

        while (socket.isConnected()) {
            try {
                massageFromClient = bufferedReader.readLine();
                broadcastMessage(massageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message) {

        for (ClientManager client : clients) {
            try {
                if (message.startsWith("@")) {
                    String[] parts = message.split("\\s+", 2);
                    String recipient = null;
                    String privateMessage = null;
                    if (parts.length == 2 && parts[0].startsWith("@")) {
                        recipient = parts[0].substring(1);
                        privateMessage = parts[1];
                    }
                    if (client.name.equals(recipient)) {
                        client.bufferedWriter.write(privateMessage);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                } else {
                    if (!client.name.equals(name)) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

}