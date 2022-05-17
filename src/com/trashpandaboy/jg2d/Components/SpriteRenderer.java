package com.trashpandaboy.jg2d.Components;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Core.Sprite;
import com.trashpandaboy.jg2d.Objects.GameObject;

/**
 * A SpriteRenderer Componenet that provide the Sprite to render
 * Can loop through a Sprite List
 */
public class SpriteRenderer extends Component {

    /**
     * Sprite List to loop
     */
    ArrayList<Sprite> _spriteList;
    /**
     * Flag that enable the loop
     */
    boolean _loopTroughList = false;
    /**
     * Index of Sprite to render
     */
    int actualSpriteToRender = 0;

    /**
     * Number of Sprite to render in a second of gamepaly
     */
    int spritePerSecond = 4;

    /**
     * Delay in nanoseconds for setting new sprite
     */
    long delayInNanoSeconds = 1;

    /**
     * Last moment in nanoSecond of sprite update
     */
    long lastMomentSpriteSet = 1;
    /**
     * Create a Sprite Renderer with a Single sprite
     * 
     * @param spriteImage 
     */
    public SpriteRenderer(Sprite spriteImage, GameObject parent) {
        _spriteList = new ArrayList<Sprite>();
        _spriteList.add(spriteImage);
        super.parent = parent;
    }

    /**
     * Create a Sprite Rendere with a list of Sprite
     * 
     * @param sprites the list of sprites
     */
    public SpriteRenderer(Sprite[] sprites, GameObject parent) {
        _spriteList = new ArrayList<Sprite>(){};
        for (Sprite sprite : sprites) {

            _spriteList.add(sprite);
        }
        if(_spriteList.size() > 1)  //cycle through sprite list only if there are more than 1 sprite
        {
            _loopTroughList = true;

            lastMomentSpriteSet = System.nanoTime();
            SetSpritePerSecond(spritePerSecond);
        }

        super.parent = parent;
    }

    /**
     * Get the selected Sprite that must be rendered
     * 
     * @return
     */
    public Sprite GetSpriteToRender()
    {
        return _spriteList.get(actualSpriteToRender);
    }

    @Override
    public void DelayedUpdate() {
        if (_loopTroughList) { 
            if(System.nanoTime() > (lastMomentSpriteSet + delayInNanoSeconds))
            {
                if (actualSpriteToRender < (_spriteList.size() - 1)) {
                    actualSpriteToRender++;
                } else {
                    actualSpriteToRender = 0;
                }
                lastMomentSpriteSet = System.nanoTime();
            }
        }
        super.DelayedUpdate();
    }

    @Override
    public void FrameUpdate() {
        // TODO Auto-generated method stub
        
    }

    public void SetSpritePerSecond(int spritePerSecond)
    {
        this.spritePerSecond = spritePerSecond;
        this.delayInNanoSeconds = TimeUnit.MILLISECONDS.toNanos(1000 / spritePerSecond);
    }

}
