package com.trashpandainteractive.jg2d.Core.Helpers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class GraphicsUtils {
    
    /**
     * Scales the original image by the provided scaleFactor
     * 
     * @param imageToScale The original image
     * @param scaleFactor  A double value that scales the image original sizes
     * @return The new image object scaled by the scaleFactor
     */
    public static BufferedImage ScaleImage(BufferedImage imageToScale, double scaleFactor) {
        Image tmp = imageToScale.getScaledInstance((int) (imageToScale.getWidth() * scaleFactor),
                (int) (imageToScale.getHeight() * scaleFactor), Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage((int) (imageToScale.getWidth() * scaleFactor),
                (int) (imageToScale.getHeight() * scaleFactor), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    /**
     * Create a BufferedImage from the image provided as parameter
     * 
     * @param img The original Image
     * @return The BufferedImage generated from the Image provided
     */
    public static BufferedImage GetBufferedImageFrom(Image img) {
        BufferedImage retBuffImage = new BufferedImage((int) img.getWidth(null), (int) img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = retBuffImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return retBuffImage;
    }
}
