package com.nch.atmmachine;
import java.io.IOException;

public class ATM extends com.nch.atmmachine.OptionMenu {
    public static void main(String[] args) throws IOException{
        com.nch.atmmachine.OptionMenu optionMenu = new com.nch.atmmachine.OptionMenu();

        optionMenu.getLogin();
    }
}
