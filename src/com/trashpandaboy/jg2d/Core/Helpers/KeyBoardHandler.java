package com.trashpandaboy.jg2d.Core.Helpers;

import java.awt.event.KeyEvent;

import com.trashpandaboy.jg2d.GameLoop;

public class KeyBoardHandler extends Thread {

    public KeyBoardHandler() {
        System.out.println("KeyBoardHandler initialized...");
    }

    @Override
    public void run() {
        System.out.println("KeyBoardHandler started...");
        while (true) {
            try {
                // if (Environment.KEYBOARDHANDLER_PRESSEDKEYS.size() > 0) {
                //     for (int k : Environment.KEYBOARDHANDLER_PRESSEDKEYS) {
                //         switch (k) {
                //         case KeyEvent.VK_LEFT:
                //             World._gameObjects.get(0).moveLeft();
                //             break;
                //         case KeyEvent.VK_RIGHT:
                //             World._gameObjects.get(0).moveRight();
                //             break;
                //         case KeyEvent.VK_DOWN:
                //             World._gameObjects.get(0).moveDown();
                //             break;
                //         case KeyEvent.VK_UP:
                //             World._gameObjects.get(0).moveUp();
                //             break;
                //         case KeyEvent.VK_A:
                //             break;
                //         case KeyEvent.VK_D:
                //             break;
                //         case KeyEvent.VK_S:
                //             break;
                //         case KeyEvent.VK_W:
                //             break;
                //         }
                //     }
                // }
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
