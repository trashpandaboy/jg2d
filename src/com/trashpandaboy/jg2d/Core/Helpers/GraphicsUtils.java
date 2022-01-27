package com.trashpandaboy.jg2d.Core.Helpers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class GraphicsUtils {
    
        
    /**
     * Scales a BufferedImage to a provided scale factor
     * 
     * @param imageToScale BufferedImage to scale
     * @param scaleFactor  A double value that scales the image original sizes
     * @return Scaled BufferedImage
     */
    public static BufferedImage ScaleBufferedImage(BufferedImage imageToScale, double scaleFactor) {
        return toBufferedImage(imageToScale, scaleFactor);
    }

    /**
     * Create a BufferedImage from the Image provided as parameter
     * 
     * @param img Originale Image
     * @return A BufferedImage with the Image content
     */
    public static BufferedImage ToBufferedImage(Image img) {
        BufferedImage retBuffImage = new BufferedImage((int) img.getWidth(null), (int) img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = retBuffImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return retBuffImage;
    }

    /**
     * Create a BufferedImage from the Image provided as parameter with the scaleFactor specified
     * 
     * @param img Original Image
     * @param scaleFactor The scaleFactor to use
     * @return A BufferedImage with the Image content
     */
    public static BufferedImage toBufferedImage(Image img, double scaleFactor)
    {
        img = img.getScaledInstance((int) (img.getWidth(null) * scaleFactor),
                                    (int) (img.getHeight(null) * scaleFactor),
                                    Image.SCALE_SMOOTH);
        return ToBufferedImage(img);
    } 
    
}
