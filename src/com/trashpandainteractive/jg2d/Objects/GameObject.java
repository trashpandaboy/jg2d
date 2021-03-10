package com.trashpandainteractive.jg2d.Objects;

import com.trashpandainteractive.jg2d.Core.*;
import java.util.ArrayList;

public abstract class GameObject {
    ArrayList<Component> _components;

    public ArrayList<Component> get_components() {
        return _components;
    }

    public GameObject() {
        _components = new ArrayList<Component>();
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

    @Override
    public String toString() {
        return "Components: " + _components.size();
    }

    public void Update() {
        for (Component component : _components) {
            component.Update();
        }
    }
}
