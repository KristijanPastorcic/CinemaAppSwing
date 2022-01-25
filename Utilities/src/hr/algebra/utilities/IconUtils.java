/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author islan
 */
public class IconUtils {
    private IconUtils(){}
    
    public static Icon getIcon(File file, int width, int heigth) throws IOException{
        BufferedImage bufferedImage = ImageIO.read(file); // byte array
            Image image = bufferedImage.getScaledInstance(width, heigth,Image.SCALE_SMOOTH);
            return new ImageIcon(image);
    }
}
