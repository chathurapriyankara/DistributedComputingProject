/**
 * This class contains message control related codes
 * */
package com.shareit.controllers;

import com.shareit.helpers.Constants;
import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

public class MessageController {

    public void initConnection(String serverIP, int serverPort, String nodeID) {
        try {
            byte[] data = generateRegCommand(nodeID).getBytes();
            byte[] response = new byte[65536];
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(new DatagramPacket(data, data.length, InetAddress.getByName(serverIP), serverPort));

            DatagramPacket packet = new DatagramPacket(response, response.length);
            datagramSocket.receive(packet);
            String serverResponse = new String(packet.getData(), 0, packet.getLength());

            List<String> result = Arrays.asList(serverResponse.split("\\s+"));
            processResponse(result);
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateRegCommand(@NotNull String nodeID) {
        String tempCmd = Constants.REG + Constants.SPACE + "192.168.8.100" + Constants.SPACE + Constants.MASTER_PORT + Constants.SPACE + nodeID;
        return String.format("%4d", tempCmd.length() + Constants.LENGTH_CONSTANT) + Constants.SPACE + tempCmd;
    }

    private void processResponse(List<String> response) {
        System.out.println("Please wait...");
        switch (Integer.parseInt(response.get(2))){
            case 9999:
                System.out.println("Failed, there is some error in the command");
                break;
            case 9998:
                System.out.println("Failed, already registered to you, unregister first");
                break;
            case 9997:
                System.out.println("Failed, registered to another user, try a different IP and port");
                break;
            case 9996:
                System.out.println("Failed, can’t register. BS full");
                break;
            case 0:
                System.out.println("Request is successful, no nodes in the system");
        }
    }

}
