package com.shareit.controllers;

import com.shareit.generators.CommandGenerator;
import com.shareit.generators.DatagramGenerator;

public class MessageController {
    public void sendRegisterMessage(String IP, String port, String message) {
        CommandGenerator commandGenerator = new CommandGenerator();
        DatagramGenerator datagramGenerator = new DatagramGenerator();
    }
}
