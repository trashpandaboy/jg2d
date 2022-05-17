package com.trashpandaboy.jg2d.Core;

import java.util.concurrent.TimeUnit;

import com.trashpandaboy.jg2d.Core.Helpers.Environment;
import com.trashpandaboy.jg2d.Objects.GameObject;

/**
 * Base class that is superclass of Component and introduce DelayedUpdate function
 * 
 */
public class CoreComponent {
    public GameObject parent;
    long lastDelayedUpdate = -1;

    public void DelayedUpdate()
    {
        if(IsDelayedPassed())
            lastDelayedUpdate = System.nanoTime();
    }    

    public boolean IsDelayedPassed()
    {
        if(lastDelayedUpdate <= 0 ||
            System.nanoTime() > lastDelayedUpdate + TimeUnit.MILLISECONDS.toNanos(Environment.CURRENT_DELAY))
        {
            return true;
        }
        return false;
    }

    
}
