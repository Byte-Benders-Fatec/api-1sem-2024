package pom.xml.app;

import pom.xml.gui.GUI;

public class Main {
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI startWindow = new GUI();
                startWindow.setVisible(true);
            }
        });
    }
}
