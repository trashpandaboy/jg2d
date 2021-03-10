package com.trashpandainteractive.jg2d.Core;

import java.awt.image.BufferedImage;

import com.trashpandainteractive.jg2d.Core.Helpers.GraphicsUtils;

public class Sprite {

    private BufferedImage _spriteImage;

    public Sprite(BufferedImage sprite, int pixelToScaleSize)
    {
        double scaleFactor = 1.0d;
        //check dimension before scaling
        if(sprite.getWidth() != sprite.getHeight())
        {
            
            //need to fit to width or height
            if(sprite.getWidth() > sprite.getHeight())
            {
                scaleFactor = (double)pixelToScaleSize / (double)sprite.getWidth();
            }
            else
            {
                scaleFactor = (double)pixelToScaleSize / (double)sprite.getHeight();
            }
        }

        _spriteImage = GraphicsUtils.ScaleImage(sprite, scaleFactor);
    }

    public BufferedImage get_spriteImage() {
        return _spriteImage;
    }
}
