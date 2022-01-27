package com.trashpandaboy.jg2d.Components;

import java.util.ArrayList;

import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Core.Sprite;

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
    public SpriteRenderer(Sprite spriteImage) {
        _spriteList = new ArrayList<Sprite>();
        _spriteList.add(spriteImage);
    }

    /**
     * Create a Sprite Rendere with a list of Sprite
     * 
     * @param sprites the list of sprites
     */
    public SpriteRenderer(Sprite[] sprites) {
        for (Sprite sprite : sprites) {

            _spriteList.add(sprite);
        }
        if(_spriteList.size() > 1)  //cycle through sprite list only if there are more than 1 sprite
            _loopTroughList = true;
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
    public void Update() {
        if (_loopTroughList) { 
            if (actualSpriteToRender < (_spriteList.size() - 1)) {
                actualSpriteToRender++;
            } else {
                actualSpriteToRender = 0;
            }
        }
    }

}
