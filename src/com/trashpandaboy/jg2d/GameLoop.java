package com.trashpandaboy.jg2d;

import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Objects.GameObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class GameLoop extends Thread {
    Runtime runtimeApp;
    boolean showDebug = false;
    
    double minFPSUpdate = 1;
    double lastFPSUpdate = 0;

    int _maxFPS = 120;

    int minDrawDelay() {
        return Math.round(1000 / _maxFPS);
    } 

    long lastDrawMoment = -1;
    public long deltaTime()
    {
        return System.currentTimeMillis() - lastDrawMoment;
    }

    BufferStrategy _strategy;
    Graphics2D gameFrame = null;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    public static ArrayList<GameObject> _gameObjects;

    public GameLoop(BufferStrategy strategy, int maxFps) {
        _strategy = strategy;
        _maxFPS = maxFps;
        _gameObjects = new ArrayList<GameObject>();
    }

    public GameLoop(int maxFps) {
        _maxFPS = maxFps;
        _gameObjects = new ArrayList<GameObject>();
    }

    public void AddGameObject(GameObject go) {
        _gameObjects.add(go);
    }

    public ArrayList<GameObject> get_gameObjects() {
        return _gameObjects;
    }

    @Override
    public void run() {
        runtimeApp = Runtime.getRuntime();
        try {
            lastDrawMoment = System.currentTimeMillis();
            while (true) {
                if(Environment.SYSTEM_READY)
                {

                    CheckForKeyboard();
                    UpdateGameobjects();
                    do {
                        do {
                            gameFrame = (Graphics2D) _strategy.getDrawGraphics();
                            gameFrame.setRenderingHints(rh);
                            
                            drawFrame();
                            drawDeubg();
                            gameFrame.dispose();
                            
                            long waitTime = System.currentTimeMillis() - lastDrawMoment;
                            if(waitTime < minDrawDelay())
                            {
                                waitTime = minDrawDelay() - waitTime;
                            }
                            else
                            {
                                waitTime = minDrawDelay();
                            }
                            lastDrawMoment = System.currentTimeMillis();
                            Thread.sleep(waitTime);
                            
                        } while (_strategy.contentsRestored());
                        _strategy.show();
                        
                    } while (_strategy.contentsLost());    
                }
                else //wait for system to be ready to draw
                {
                    Thread.sleep(100);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CheckForKeyboard() {
        if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_D))
        {
            //TODO change to press not continuous
            showDebug = !showDebug;
        }
        
    }

    private void UpdateGameobjects() {
        for (GameObject gameObject : _gameObjects) {
            if(gameObject.CanUpdate())
            {
                gameObject.Update();
            }
        }
    }

    private void drawFrame()
    {
        gameFrame.fillRect(0,0, Environment.CURRENT_DISPLAYMODE.getWidth(), Environment.CURRENT_DISPLAYMODE.getHeight());

        for (GameObject gameObject : _gameObjects) {
            gameFrame.drawImage(gameObject.GetSprite().get_spriteImage(), null, gameObject.GetPosition().get_x(), gameObject.GetPosition().get_y());
        }
    }

    private void drawDeubg()
    {
        if(showDebug)
        {
            int baseY = 50;
            //All the debug informations
            ArrayList<String> debugStrings = new ArrayList<String>();
            debugStrings.add("FPS: " + getFPS());
            debugStrings.add("RAM: " + (((runtimeApp.totalMemory() - runtimeApp.freeMemory())/1024)/1024) + " Mb");
            debugStrings.add("Display: " + Environment.CURRENT_DISPLAY.toString());
            debugStrings.add("Resolution: " + Environment.CURRENT_DISPLAYMODE.toString());
            debugStrings.add("Last frame lenght: " + getLastFrameLenght() + "ms");
            
            gameFrame.setColor(Color.GREEN);
            for(int i = 0; i < debugStrings.size(); i++)
            {
                gameFrame.drawString(debugStrings.get(i), 5, baseY + (20*i));
            }
        }
    }

    private long getLastFrameLenght()
    {
        return System.currentTimeMillis() - lastDrawMoment;
    }

    private int getFPS() {
        double FPS = 0;
    
        FPS = 1000 / getLastFrameLenght();
            
        return (int)FPS;
    }
}
