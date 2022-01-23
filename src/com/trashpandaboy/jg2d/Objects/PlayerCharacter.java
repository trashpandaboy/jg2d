package com.trashpandaboy.jg2d.Objects;

import java.awt.event.KeyEvent;

import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Core.Helpers.Environment;

public class PlayerCharacter extends GameObject {
    
    public int moveOffset = 5;

    public PlayerCharacter(Component[] componentOfObject){
        super(componentOfObject);
    }

    @Override
    public void Update()
    {
        if(CanUpdate())
        {
            HandleKeys();
            super.Update();
        }
    }

    public void moveRight() {
        GetPosition().set_x(GetPosition().get_x() + moveOffset);
    }

    public void moveLeft() {
        GetPosition().set_x(GetPosition().get_x() - moveOffset);
    }

    public void moveUp() {
        GetPosition().set_y(GetPosition().get_y() - moveOffset);
    }

    public void moveDown() {
        GetPosition().set_y(GetPosition().get_y() + moveOffset);
    }

    public void HandleKeys()
    {
        try {
            if (Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.size() > 0) {
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_LEFT))
                {
                    moveLeft();
                }
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_RIGHT))
                {
                    moveRight();
                }
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_UP))
                {
                    moveUp();
                }
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_DOWN))
                {
                    moveDown();
                }
            }
        } catch (Exception e) {

        }
    }
}
