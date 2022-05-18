package com.trashpandaboy.jg2d;

import com.trashpandaboy.jg2d.Components.Position;
import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Objects.GameObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class GameLoop extends Thread {
    Runtime runtimeApp;
    boolean showDebug = false;

    double minFPSUpdate = 1;
    double lastFPSUpdate = 0;

    int FPS_CAP = 0;

    public void SetFPS_CAP(int cap) {
        FPS_CAP = cap;
    }

    long minDrawDelayInNanoseconds() {
        if (FPS_CAP != 0)
            return TimeUnit.MILLISECONDS.toNanos(Math.round(1000 / FPS_CAP));
        else
            return TimeUnit.MILLISECONDS.toNanos(Math.round(1000 / Environment.FPS_CAP));
    }

    long lastDrawMoment = -1;
    long waitTimeNanoseconds = 0;

    public long deltaTime() {
        return System.nanoTime() - lastDrawMoment;
    }

    BufferStrategy _strategy;
    Graphics2D gameFrame = null;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    public static ArrayList<GameObject> _gameObjects;

    public GameLoop(BufferStrategy strategy) {
        _strategy = strategy;
        _gameObjects = new ArrayList<GameObject>();
    }

    public GameLoop() {
        _gameObjects = new ArrayList<GameObject>();
    }

    public void AddGameObject(GameObject go) {
        _gameObjects.add(go);
        // gameobject need to be sorted by Z
        Collections.sort(_gameObjects, new Comparator<GameObject>() {
            @Override
            public int compare(GameObject go1, GameObject go2) {
                return go1.GetPosition().get_z() - go2.GetPosition().get_z();
            }
        });
    }

    public ArrayList<GameObject> get_gameObjects() {
        return _gameObjects;
    }

    @Override
    public void run() {
        runtimeApp = Runtime.getRuntime();
        try {
            while (true) {
                if (Environment.SYSTEM_READY) {
                    CheckForKeyboard();
                    DelayedUpdateGameobjects();
                    if (canDrawNewFrame()) {
                        drawNewFrame();
                    }
                    Thread.sleep(1);
                } else // wait for system to be ready to draw
                {
                    Thread.sleep(100);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawNewFrame() {
        FrameUpdateGameobjects();
        do {
            do {
                gameFrame = (Graphics2D) _strategy.getDrawGraphics();
                gameFrame.setRenderingHints(rh);

                drawFrame();
                drawDeubg();
                gameFrame.dispose();

                long nowNanoTime = System.nanoTime();
                waitTimeNanoseconds = nowNanoTime - lastDrawMoment;
                lastDrawMoment = nowNanoTime;
                if (waitTimeNanoseconds < minDrawDelayInNanoseconds()) {
                    waitTimeNanoseconds = minDrawDelayInNanoseconds() - lastDrawMoment;
                } else {
                    waitTimeNanoseconds = minDrawDelayInNanoseconds();
                }

            } while (_strategy.contentsRestored());
            _strategy.show();

        } while (_strategy.contentsLost());
    }

    private boolean canDrawNewFrame() {
        if (lastDrawMoment <= 0) {
            return true;
        } else if (System.nanoTime() > (lastDrawMoment + waitTimeNanoseconds)) {
            return true;
        } else {
            return false;
        }
    }

    private void CheckForKeyboard() {
        if (Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_D)) {
            // TODO change to press not continuous
            showDebug = !showDebug;
        }

    }

    private void FrameUpdateGameobjects() {
        for (int i = 0; i < _gameObjects.size(); i++) {
            _gameObjects.get(i).FrameUpdate();
        }
    }

    private void DelayedUpdateGameobjects() {
        for (int i = 0; i < _gameObjects.size(); i++) {
            _gameObjects.get(i).DelayedUpdate();
        }
    }

    private void drawFrame() {
        gameFrame.fillRect(0, 0, Environment.CURRENT_DISPLAYMODE.getWidth(),
                Environment.CURRENT_DISPLAYMODE.getHeight());

        for (int i = 0; i < _gameObjects.size(); i++) {
            BufferedImage imageGO = _gameObjects.get(i).GetSprite().get_spriteImage();
            Position positionGO = _gameObjects.get(i).GetPosition();
            gameFrame.drawImage(imageGO, null, positionGO.get_x(), positionGO.get_y());
        }
    }

    private void drawDeubg() {
        if (showDebug) {
            int baseY = 50;
            // All the debug informations
            ArrayList<String> debugStrings = new ArrayList<String>();
            debugStrings.add("FPS: " + getFPS());
            debugStrings.add("RAM: " + (((runtimeApp.totalMemory() - runtimeApp.freeMemory()) / 1024) / 1024) + " Mb");
            debugStrings.add("Display: " + Environment.CURRENT_DISPLAY.toString());
            debugStrings.add("Resolution: " + Environment.CURRENT_DISPLAYMODE.toString());
            debugStrings.add("Last frame lenght: " + getLastFrameLenght() + "ms");

            gameFrame.setColor(Color.GREEN);
            for (int i = 0; i < debugStrings.size(); i++) {
                gameFrame.drawString(debugStrings.get(i), 5, baseY + (20 * i));
            }
        }
    }

    private long getLastFrameLenght() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - lastDrawMoment);
    }

    private int getFPS() {
        double FPS = 0;

        FPS = (1000000 * 1000) / waitTimeNanoseconds;

        return (int) FPS;
    }
}
