package Algorithms.Part_1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


/**
 * load and display an image, just right click and choose run main to run the main function
 */

public class LoadDisplayImage {
   public void readAndDisplayImage(String path) {
        //Mat Matrix object used to host the image
        Mat imageArray;
        // Reading the Image from the file and storing it in to a Matrix object(can you change the image just you need to change the path)
        imageArray = Imgcodecs.imread(path);
        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("Image", imageArray);
        //this method to close the window after click to close button
        HighGui.waitKey();
    }
}
