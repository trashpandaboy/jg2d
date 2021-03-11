package com.trashpandainteractive.jg2d;

import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import com.trashpandainteractive.jg2d.Objects.GameObject;

public class World {

    BufferStrategy _strategy;
    Graphics2D gameFrame = null;
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    ArrayList<GameObject> _gameObjects;

    public World(BufferStrategy strategy) {
        _strategy = strategy;
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

    public void Update() {
        try {
            while (true) {
                UpdateGameobjects();
                do {
                    do {

                        gameFrame = (Graphics2D) _strategy.getDrawGraphics();
                        gameFrame.setRenderingHints(rh);
                        
                        drawFrame();

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
        for (GameObject gameObject : _gameObjects) {
            gameFrame.drawImage(gameObject.GetSprite().get_spriteImage(), null, gameObject.GetPosition().get_x(), gameObject.GetPosition().get_y());
        }
    }
}
