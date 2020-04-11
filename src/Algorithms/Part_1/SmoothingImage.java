package Algorithms.Part_1;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Smoothing the image, just right click and choose run main to run the main function
 */
public class SmoothingImage {
    public void smoothingImage(String path, int numberOfTimes) {
        //Reading the Image
        Mat input = Imgcodecs.imread(path, Imgcodecs.IMREAD_GRAYSCALE);
        // define a matrix object to store the result for each iteration
        Mat sourceImage = new Mat();
        // define a matrix object to store the final result
        Mat destImage = input.clone();
        for (int i = 0; i < numberOfTimes; i++) {
            sourceImage = destImage.clone();//for each iteration store result to the source image
            // method blur to smoothing image take the source, destination image, and kernel size if you need to increase smoothing degree just increase kernel size(3 , 5 , 7 and so on)
            Imgproc.blur(sourceImage, destImage, new Size(5.0, 5.0));
        }

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("original image", input);
        HighGui.imshow("smoothed image", destImage);
        HighGui.waitKey();
    }
}
