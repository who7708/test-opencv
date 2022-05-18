package org.example.opencv;

import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DisplayingImagesUsingSwings {
    public static void main(String args[]) throws Exception {
        //Loading the OpenCV core library
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        OpenCV.loadShared();

        //Reading the Image from the file and storing it in to a Matrix object
        String file = "/Users/chmy/Pictures/shanghai_3.jpg";
        // Mat image = Imgcodecs.imread(file);
        // Mat image = Imgcodecs.imread(file, Imgcodecs.IMREAD_GRAYSCALE);
        Mat image = Imgcodecs.imread(file, Imgcodecs.IMREAD_REDUCED_GRAYSCALE_2);

        //Encoding the image
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", image, matOfByte);

        //Storing the encoded Mat in a byte array
        byte[] byteArray = matOfByte.toArray();

        //Preparing the Buffered Image
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);

        //Instantiate JFrame
        JFrame frame = new JFrame();

        //Set Content to the JFrame
        frame.getContentPane().add(new JLabel(new ImageIcon(bufImage)));
        frame.pack();
        frame.setVisible(true);

        System.out.println("Image Loaded");
    }
}

