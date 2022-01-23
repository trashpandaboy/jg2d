package com.trashpandaboy.jg2d;

import java.util.ArrayList;

import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Objects.GameObject;
import com.trashpandaboy.jg2d.Objects.GameWindowObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class World extends Thread {
    Runtime runtimeApp;
    boolean showDebug = false;
    
    double minFPSUpdate = 1;
    double lastFPSUpdate = 0;

    BufferStrategy _strategy;
    Graphics2D gameFrame = null;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    public static ArrayList<GameObject> _gameObjects;

    public World(BufferStrategy strategy) {
        _strategy = strategy;
        _gameObjects = new ArrayList<GameObject>();
    }

    public World() {
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
            while (true) {
                CheckForKeyboard();
                UpdateGameobjects();
                do {
                    do {
                        gameFrame = (Graphics2D) _strategy.getDrawGraphics();
                        gameFrame.setRenderingHints(rh);
                        
                        drawFrame();
                        drawDeubg();
                        gameFrame.dispose();

                    } while (_strategy.contentsRestored());
                    _strategy.show();
                } while (_strategy.contentsLost());
                
                // Thread.sleep(10);
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
            gameFrame.setColor(Color.GREEN);
            gameFrame.drawString("FPS: " + getFPS(), 5, baseY);
            gameFrame.drawString("RAM(MB): " + (((runtimeApp.totalMemory() - runtimeApp.freeMemory())/1024)/1024), 5, baseY + 20);
        }
    }

    private double getFPS() {
        double FPS = 0;
        double newTime = System.currentTimeMillis();
        if(lastFPSUpdate + minFPSUpdate < newTime)
        {            
            FPS = 1000 / (newTime - lastFPSUpdate);
            lastFPSUpdate = newTime;
        }
            
        return FPS;
    }
}
