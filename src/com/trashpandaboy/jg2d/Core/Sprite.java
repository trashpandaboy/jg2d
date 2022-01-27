package com.trashpandaboy.jg2d.Core;

import java.awt.image.BufferedImage;

import com.trashpandaboy.jg2d.Core.Helpers.GraphicsUtils;

/**
 * Sprite class that let you 
 */
public class Sprite {

    /**
     * BufferedImage of the Sprite
     */
    private BufferedImage _spriteImage;

    /**
     * Create a Sprite object that will fit a specified size with both dimension
     * 
     * @param sprite BufferedImage of Sprite
     * @param fitSize Max size to fit
     */
    public Sprite(BufferedImage sprite, int fitSize)
    {
        double scaleFactor = 1.0d;
        
        if(sprite.getWidth() != sprite.getHeight())
        {
            if(sprite.getWidth() > sprite.getHeight())
            {
                scaleFactor = (double)fitSize / (double)sprite.getWidth();
            }
            else
            {
                scaleFactor = (double)fitSize / (double)sprite.getHeight();
            }
        }

        _spriteImage = GraphicsUtils.ScaleBufferedImage(sprite, scaleFactor);
    }

    /**
     * Create a Sprite object with provieded Image
     * 
     * @param sprite
     */
    public Sprite(BufferedImage sprite)
    {
        _spriteImage = sprite;
    }

    /**
     * Return the BufferedImage representing the Sprite
     * 
     * @return A BufferedImage
     */
    public BufferedImage get_spriteImage() {
        return _spriteImage;
    }
}
