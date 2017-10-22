package com.shareit.client;

import com.shareit.controllers.MessageController;
import com.shareit.generators.CommandGenerator;
import com.shareit.helpers.Constants;

import java.util.Scanner;

public class Node {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MessageController messageController = new MessageController();
        CommandGenerator commandGenerator = new CommandGenerator();

        System.out.println(Constants.BS_IP);
        String serverIP = scanner.nextLine();
        System.out.println(Constants.BS_PORT);
        String serverPort = scanner.nextLine();
        System.out.println(Constants.USER_ID);
        String userID = scanner.nextLine();

        System.out.println(serverIP);
        System.out.println(serverPort);
        System.out.println(userID);

        messageController.sendRegisterMessage(serverIP, serverPort, commandGenerator.generateRegCommand(userID));
    }
}
