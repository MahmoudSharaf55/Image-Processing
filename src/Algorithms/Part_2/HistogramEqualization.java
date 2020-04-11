package Algorithms.Part_2;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * histogram equalization task,
 * just right click and choose run main to run the main function
 */
public class HistogramEqualization {

    public void enhanceImageContrast(String path) {

        // Reading the Image from the file and storing it as gray scale image in to a Matrix object source
        Mat source = Imgcodecs.imread(path,
                Imgcodecs.IMREAD_GRAYSCALE);

        //Creating an empty matrix to store the result
        Mat destination = new Mat(source.rows(), source.cols(), source.type());

        // apply histogram equalization
        Imgproc.equalizeHist(source, destination);
        // saving result
        Imgcodecs.imwrite("result_images\\test6_after_equalization.bmp", destination);
        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("gray scale image", source);
        HighGui.imshow("equalized histogram", destination);
        HighGui.waitKey();
    }
}
