package com.paul.PaulSeahBot;

import discord4j.core.spec.EmbedCreateSpec;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLibrary {

    public BufferedImage yellowForm() throws IOException {

        BufferedImage img = null;
        img = getYellowForm(img);

        return img;
    }

    private BufferedImage getYellowForm(BufferedImage image){
        try {
            File yellowForm = new File("C:\\Users\\James\\Desktop\\PaulSeahBot\\yellowForm.png");
            image = new BufferedImage(222, 308, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(yellowForm);
            System.out.println("DO!");
        }catch(Exception e){
            System.out.println("FAIL!!!11!1!");
        }
        return image;
    }
    public static void writeToFile(BufferedImage image, String user) throws IOException {
        Graphics2D img = image.createGraphics();
        img.setColor(Color.black);
        img.setFont(new Font( "SansSerif", Font.BOLD, 20 ));
        img.drawString(user, 20, 55);
        img.dispose();
        File output = new File("C:\\Users\\James\\Desktop\\PaulSeahBot\\editedYellowForm.png");
        ImageIO.write(image, "png", output);
    }
}
