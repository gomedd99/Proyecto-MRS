import View.GUIMain.GUIMain;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        clearScreen();
        GUIMain guiMain = new GUIMain();
        GUIMain.inicio();

    }


    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
