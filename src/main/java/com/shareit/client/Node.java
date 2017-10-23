package com.shareit.client;

import com.shareit.controllers.MessageController;
import com.shareit.helpers.Constants;

import java.util.Scanner;

public class Node {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MessageController messageController = new MessageController();

        System.out.println(Constants.NODE_ID);
        String userID = scanner.nextLine();
        System.out.println(Constants.BS_IP);
        String serverIP = scanner.nextLine();
        System.out.println(Constants.BS_PORT);
        int serverPort = scanner.nextInt();

        messageController.initConnection(serverIP, serverPort, userID);
    }
}
