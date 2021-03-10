package com.trashpandainteractive.jg2d;

import java.util.ArrayList;

public abstract class GameObject {
    public ArrayList<Component> _components;

    public GameObject()
    {
        _components = new ArrayList<Component>();
    }

    public void AddComponent(Component c)
    {
        boolean canAdd = true;
        for (Component tComponent : _components) {
            if(tComponent.getClass().equals(c.getClass()))
            {
                System.out.println( tComponent.getClass() + " equals to " + c.getClass() );
                canAdd = false;
            }
        }
        
        if(canAdd)
        {
            System.out.println( "Added" );
            _components.add(c);
        }
        else
        {
            System.out.println( "Can't add component" );
        }
    }
}
