package com.trashpandaboy.jg2d.Components;

import java.util.ArrayList;

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
        for (Sprite sprite : sprites) {

            _spriteList.add(sprite);
        }
        if(_spriteList.size() > 1)  //cycle through sprite list only if there are more than 1 sprite
            _loopTroughList = true;

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
    public void FrameUpdate() {
        if (_loopTroughList) { 
            if (actualSpriteToRender < (_spriteList.size() - 1)) {
                actualSpriteToRender++;
            } else {
                actualSpriteToRender = 0;
            }
        }
    }

}
