package com.trashpandaboy.jg2d.Core.Helpers;

public class KeyBoardHandler extends Thread {

    public KeyBoardHandler() {
        System.out.println("KeyBoardHandler initialized...");
    }

    @Override
    public void run() {
        System.out.println("KeyBoardHandler started...");
        while (true) {
            try {
                
            } catch (Exception e) {

            }

            try {
                // Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
