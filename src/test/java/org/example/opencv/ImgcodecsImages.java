package org.example.opencv;

import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImgcodecsImages {
    public static void main(String args[]) {
        //Loading the OpenCV core library
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        OpenCV.loadShared();

        //Reading the Image from the file
        String file = "/Users/chmy/git/java/test-opencv/src/main/resources/qingshuiwan.png";
        Mat matrix = Imgcodecs.imread(file);
        System.out.println(matrix);
        System.out.println("Image Loaded");

        String file2 = "/Users/chmy/git/java/test-opencv/src/main/resources/qswang_Imgcodecs.png";

        //Writing the image
        Imgcodecs.imwrite(file2, matrix);
        System.out.println("Image Saved ~ ");

    }
}

