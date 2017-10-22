package com.shareit.generators;

import com.shareit.helpers.Constants;
import com.shareit.helpers.MessageHelper;

public class CommandGenerator {

    public String generateRegCommand(String userID) {
        MessageHelper messageHelper = new MessageHelper();
        String tempCmd = Constants.REG + Constants.SPACE + messageHelper.getLocalIP() + Constants.MASTER_PORT + userID;
        return String.format("%4d", tempCmd.length() + Constants.LENGTH_CONSTANT) + Constants.SPACE + tempCmd;
    }
}
