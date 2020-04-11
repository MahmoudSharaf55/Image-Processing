package Algorithms.Part_1;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * point processing such as addition, subtraction, multiplication,
 * and division,just right click and choose run main to run the main function
 */

public class PointProcessing {
    public void pointProcessing(String path1,String path2){

        // Reading the Image from the file and storing it in to a Matrix object
        Mat img1 = Imgcodecs.imread(path1);
        Mat img2 = Imgcodecs.imread(path2);

        //resize image two to match the same number of row and columns of image one
        Imgproc.resize(img2, img2, new Size(img1.cols(), img1.rows()));

        //Copy the original image to four different objects to store the result
        Mat image1 = img1.clone();
        Mat image2 = img1.clone();
        Mat image3 = img1.clone();
        Mat image4 = img1.clone();

        int rows = img1.rows(); //Calculates number of rows
        int cols = img1.cols(); //Calculates number of columns
        int ch = img1.channels(); //Calculates number of channels (GrayScale: 1, RGB: 3, etc.)
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                double[] data1_1 = img1.get(i, j); //Stores element(pixel value) in an array
                double[] data1_2 = img1.get(i, j); //Stores element(pixel value) in an array
                double[] data1_3 = img1.get(i, j); //Stores element(pixel value) in an array
                double[] data1_4 = img1.get(i, j); //Stores element(pixel value) in an array

                double[] data2_1 = img2.get(i, j); //Stores element(pixel value) in an array
                double[] data2_2 = img2.get(i, j); //Stores element(pixel value) in an array
                double[] data2_3 = img2.get(i, j); //Stores element(pixel value) in an array
                double[] data2_4 = img2.get(i, j); //Stores element(pixel value) in an array

                for (int k = 0; k < ch; k++) //Runs for the available number of channels
                {
                    data1_1[k] = data1_1[k] + data2_1[k]; //Pixel modification done here add pixel value of image one and pixel value of image two
                    data1_2[k] = data1_2[k] - data2_2[k]; //Pixel modification done here subtraction pixel value of image two from pixel value of image one
                    data1_3[k] = data1_3[k] * data2_3[k]; //Pixel modification done here multiplication pixel value of image one and pixel value of image two
                    data1_4[k] = data1_4[k] / data2_4[k]; //Pixel modification done here division pixel value of image one and pixel value of image two
                }
                image1.put(i, j, data1_1); //Puts element back into matrix(after modified)
                image2.put(i, j, data1_2); //Puts element back into matrix(after modified)
                image3.put(i, j, data1_3); //Puts element back into matrix(after modified)
                image4.put(i, j, data1_3); //Puts element back into matrix(after modified)
            }
        }


        // saving the results, can you delete this as you like
        Imgcodecs.imwrite("result_images\\image_addition.jpg", image1);
        Imgcodecs.imwrite("result_images\\image_subtraction.jpg", image2);
        Imgcodecs.imwrite("result_images\\image_multiplication.jpg", image3);
        Imgcodecs.imwrite("result_images\\image_division.jpg", image4);


        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("Original Image", img1);
        HighGui.imshow("Addition Result", image1);
        HighGui.imshow("Subtraction Result", image2);
        HighGui.imshow("Multiplication Result", image3);
        HighGui.imshow("Division Result", image4);
        //this method to close the window after click to close button
        HighGui.waitKey();
    }
}
