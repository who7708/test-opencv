package org.example.opencv;

import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.util.Objects;

public class FaceDetectionImage {

    private static String loadFile(String file) {
        return Objects.requireNonNull(FaceDetectionImage.class.getResource(file))
                .getPath();
    }

    public static void main(String[] args) {
        // Loading the OpenCV core library
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        OpenCV.loadShared();

        // Reading the Image from the file and storing it in to a Matrix object
        String inputImage = loadFile("/images/facedetection_input.jpg");
        Mat src = Imgcodecs.imread(inputImage);
        System.out.println(src);

        // Instantiating the CascadeClassifier
        // String xmlFile = "/lbpcascades/lbpcascade_frontalface.xml";
        String xmlFile = loadFile("/lbpcascades/lbpcascade_frontalface.xml");
        CascadeClassifier classifier = new CascadeClassifier(xmlFile);

        // Detecting the face in the snap
        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(src, faceDetections);
        System.out.println(String.format("Detected %s faces",
                faceDetections.toArray().length));

        // Drawing boxes
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(
                    src,                                               // where to draw the box
                    new Point(rect.x, rect.y),                            // bottom left
                    new Point(rect.x + rect.width, rect.y + rect.height), // top right
                    new Scalar(0, 0, 255),
                    3                                                     // RGB colour
            );
        }

        // Writing the image
        Imgcodecs.imwrite("facedetect_output1.jpg", src);

        System.out.println("Image Processed");
    }
}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/opencv/opencv_face_detection_in_picture.html#article-start

