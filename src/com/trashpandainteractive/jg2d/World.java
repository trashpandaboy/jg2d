package com.trashpandainteractive.jg2d;

import java.util.ArrayList;

import com.trashpandainteractive.jg2d.Objects.GameObject;

public class World {

    ArrayList<GameObject> _gameObjects;

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
        while (true) {
            for (GameObject gameObject : _gameObjects) {
                gameObject.Update();
            }
        }
    }
}
