package com.trashpandaboy.jg2d.Components;

import java.util.ArrayList;

import com.trashpandaboy.jg2d.Core.Component;
import com.trashpandaboy.jg2d.Core.Sprite;

public class SpriteRenderer extends Component {

    ArrayList<Sprite> _spriteList;
    boolean _loopTroughList = false;
    int actualSpriteToRender = 0;

    public SpriteRenderer(Sprite spriteImage) {
        _spriteList = new ArrayList<Sprite>();
        _spriteList.add(spriteImage);
    }

    public SpriteRenderer(Sprite[] sprites) {
        for (Sprite sprite : sprites) {

            _spriteList.add(sprite);
        }
        _loopTroughList = true;
    }

    public Sprite GetSpriteToRender()
    {
        return _spriteList.get(actualSpriteToRender);
    }

    @Override
    public void Update() {
        if (_loopTroughList) { //cycle through sprite list
            if (actualSpriteToRender < (_spriteList.size() - 1)) {
                actualSpriteToRender++;
            } else {
                actualSpriteToRender = 0;
            }
        }
    }

}
