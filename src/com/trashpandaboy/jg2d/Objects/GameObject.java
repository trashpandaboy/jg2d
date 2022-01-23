package com.trashpandaboy.jg2d.Objects;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.trashpandaboy.jg2d.Components.*;
import com.trashpandaboy.jg2d.Core.*;

public abstract class GameObject {
    ArrayList<Component> _components;

    public ArrayList<Component> get_components() {
        return _components;
    }

    public GameObject() {
        _components = new ArrayList<Component>();
    }

    public GameObject(Component[] componentOfObject) {
        _components = new ArrayList<Component>();

        for (Component component : componentOfObject) {
            _components.add(component);
        }
    }

    public void AddComponent(Component c) {
        boolean canAdd = true;
        for (Component tComponent : _components) {
            if (tComponent.getClass().equals(c.getClass())) {
                System.out.println("This gameObject already have a componet of class: " + c.getClass().getSimpleName());
                canAdd = false;
            }
        }

        if (canAdd) {
            System.out.println("Component added: " + c.getClass().getSimpleName());
            _components.add(c);
        } else {
            System.out.println("Can't add component: " + c.getClass().getSimpleName());
        }
    }

    public Sprite GetSprite() {
        Sprite spriteReturn = null;

        // try to get SpriteRenderer component
        SpriteRenderer spriteRenderedTemp = (SpriteRenderer) _components.stream()
                .filter(c -> c.getClass().equals(SpriteRenderer.class)).collect(Collectors.toList()).get(0);

        if (spriteRenderedTemp != null) {
            spriteReturn = spriteRenderedTemp.GetSpriteToRender();
        }

        return spriteReturn;
    }

    public Position GetPosition() {
        Position positionReturn = null;

        // try to get Position component
        positionReturn = (Position) _components.stream().filter(c -> c.getClass().equals(Position.class))
                .collect(Collectors.toList()).get(0);

        return positionReturn;
    }

    @Override
    public String toString() {
        return "Components: " + _components.size();
    }

    public void Update() {
        if(CanUpdate())
        {
            for (Component component : _components) {
                component.Update();
            }
        }
    }

    public Boolean CanUpdate()
    {
        //TODO is it needed?
        return true;    
    }
}
