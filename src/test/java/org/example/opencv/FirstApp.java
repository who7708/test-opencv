package org.example.opencv;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstApp {
    public static void main(String[] args) throws IOException {
        //Input File
        File input = new File("/Users/chmy/git/java/test-opencv/src/main/resources/qingshuiwan.png");

        //Reading the image
        BufferedImage image = ImageIO.read(input);

        //Saving the image with a different name
        File ouptut = new File("/Users/chmy/git/java/test-opencv/src/main/resources/qswan.jpg");
        ImageIO.write(image, "jpg", ouptut);

        System.out.println("图片已保存成功~");
    }
}

