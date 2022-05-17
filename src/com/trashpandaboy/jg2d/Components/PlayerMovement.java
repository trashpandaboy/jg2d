package com.trashpandaboy.jg2d.Components;

import java.awt.event.KeyEvent;
import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Objects.GameObject;

public class PlayerMovement extends Component{

    int verticalMovement = 1;
    int horizontalMovement = 1;

    public PlayerMovement(int verticalOffset, int horizontalOffset, GameObject parent)
    {
        verticalMovement = verticalOffset;
        horizontalMovement = horizontalOffset;
        super.parent = parent;
    }

    public PlayerMovement(GameObject parent)
    {
        super.parent = parent;
    }

    @Override
    public void FrameUpdate() {
        // TODO Auto-generated method stub
        
    }
    
    @Override 
    public void DelayedUpdate()
    {
        if(super.IsDelayedPassed())
        {
            if (Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.size() > 0) {
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_LEFT))
                {
                    parent.GetPosition()._x -= horizontalMovement;
                }
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_RIGHT))
                {
                    parent.GetPosition()._x += horizontalMovement;
                }
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_UP))
                {
                    parent.GetPosition()._y -= verticalMovement;
                }
                if(Environment.KEYBOARDHANDLER_CONTINUOUSKEYS.contains(KeyEvent.VK_DOWN))
                {
                    parent.GetPosition()._y += verticalMovement;
                }
            }
        }
        super.DelayedUpdate();
    }
}
