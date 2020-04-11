package Algorithms.Part_1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * static filtering such as median filter,
 * just right click and choose run main to run the main function
 */

public class StaticFilter {
    public void medianFilter(String path){

        // Reading the Image from the file and storing it in to a Matrix object
        Mat src = Imgcodecs.imread(path);

        // Creating an empty matrix to store the result
        Mat gray = new Mat();

        // Converting the image from color to Gray
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        Mat medianFilter = new Mat();

        // apply median filter on image
        Imgproc.medianBlur(gray, medianFilter, 3);
        //Saving result
        Imgcodecs.imwrite("result_images\\image_median.jpg", medianFilter);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("original image", src);
        HighGui.imshow("gray image", gray);
        HighGui.imshow("Median Filter", medianFilter);
        HighGui.waitKey();
    }

}
