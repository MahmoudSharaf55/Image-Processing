package Algorithms.Part_2;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * adaptive threshold to convert image from gray to binary,
 * just right click and choose run main to run the main function
 */

public class Threshold {

    public void adaptativeThresholding(String path){

        // Reading the Image from the file and storing it as gray scale image in to a Matrix object source
        Mat img = Imgcodecs.imread(path,
                Imgcodecs.IMREAD_GRAYSCALE);

        Mat im = new Mat();
        Imgproc.medianBlur(img,im,5);
        Imgproc.adaptiveThreshold(im,img,255,Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C,Imgproc.THRESH_BINARY,21,2);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("After threshold", img);
        HighGui.imshow("blur image", im);
        HighGui.waitKey();
    }
}
