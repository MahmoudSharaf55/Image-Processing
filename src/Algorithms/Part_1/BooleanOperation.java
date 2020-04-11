package Algorithms.Part_1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


/**
 * boolean operation between two images,just right click
 * and choose run main to run the main function
 */


public class BooleanOperation {

    public void booleanOperation(String path1 ,String path2){
        // Reading the Image from the file and storing it in to a Matrix object
        Mat src1 = Imgcodecs.imread(path1);
        Mat src2 = Imgcodecs.imread(path2);

        //resize image two to match the same number of row and columns of image one
        Imgproc.resize(src2, src2, new Size(src1.cols(), src1.rows()));

        //Creating an empty matrix to store the results
        Mat dst_OrOperation = new Mat(src1.rows(), src1.cols(), src1.type());
        Mat dst_AndOperation = new Mat(src1.rows(), src1.cols(), src1.type());
        Mat dst_XorOperation = new Mat(src1.rows(), src1.cols(), src1.type());
        Mat dst_NotOperation = new Mat(src1.rows(), src1.cols(), src1.type());


        //Applying bitwise "OR" operation between two images and store the result
        Core.bitwise_or(src1, src2, dst_OrOperation);
        //Applying bitwise "AND" operation between two images and store the result
        Core.bitwise_and(src1, src2, dst_AndOperation);
        //Applying bitwise "XOR" operation between two images and store the result
        Core.bitwise_xor(src1, src2, dst_XorOperation);
        //Applying bitwise "Not" on one image and store the result
        Core.bitwise_not(src1,dst_NotOperation);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("Original Image1", src1);
        HighGui.imshow("Original Image2", src2);
        HighGui.imshow("Bitwise OR operation", dst_OrOperation);
        HighGui.imshow("Bitwise xOR operation", dst_XorOperation);
        HighGui.imshow("Bitwise and operation", dst_AndOperation);
        HighGui.imshow("Bitwise not operation", dst_NotOperation);
        //this method to close the window after click to close button
        HighGui.waitKey();
    }
}
