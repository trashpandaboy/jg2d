package com.trashpandaboy.jg2d;

import java.util.ArrayList;

import com.trashpandaboy.jg2d.Objects.GameObject;
import com.trashpandaboy.jg2d.Objects.GameWindowObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

public class World extends Thread {
    double FPSOldTime = 0;
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
        try {
            while (true) {
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
                
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdateGameobjects() {
        for (GameObject gameObject : _gameObjects) {
            gameObject.Update();
        }
    }

    private void drawFrame()
    {
        gameFrame.fillRect(0,0, GameWindowObject._displayMode.getWidth(), GameWindowObject._displayMode.getHeight());

        for (GameObject gameObject : _gameObjects) {
            gameFrame.drawImage(gameObject.GetSprite().get_spriteImage(), null, gameObject.GetPosition().get_x(), gameObject.GetPosition().get_y());
        }
    }

    private void drawDeubg()
    {
        gameFrame.setColor(Color.GREEN);
        gameFrame.drawString("FPS: " + getFPS(FPSOldTime), 100, 100);
    }

    private double getFPS(double oldTime) {
        double newTime = System.nanoTime();
        double delta = newTime - oldTime;
    
        double FPS = 1 / (delta * 1000);
        FPSOldTime = newTime;
    
        return FPS;
    }
}
