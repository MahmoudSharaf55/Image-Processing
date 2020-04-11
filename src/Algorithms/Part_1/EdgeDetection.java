package Algorithms.Part_1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * edge detection using canny method,
 * just right click and choose run main to run the main function
 */
public class EdgeDetection {
    public void edgeDetection(String path){

        // Reading the Image from the file and storing it in to a Matrix object
        Mat src = Imgcodecs.imread(path);

        // Creating an empty matrix to store the result (gray image)
        Mat gray = new Mat();

        // Converting the image from color to Gray
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        //Creating an empty matrix to store the result (edges)
        Mat edges = new Mat();

        // Detecting the edges
        Imgproc.Canny(gray, edges, 60, 60*3);

        // Writing the image
        Imgcodecs.imwrite("result_images\\image_Canny.jpg", edges);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("Original Image", src);
        HighGui.imshow("Gray Scale Image", gray);
        HighGui.imshow("Edges", edges);
        HighGui.waitKey();
    }

}
