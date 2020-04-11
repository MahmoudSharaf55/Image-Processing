package Algorithms.Part_1;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *   this class to scaling and shifting original image,
 *   just right click and choose run main to run the main function
 */

public class RescalingShifting {
    public void rescaling(String path){
        // Reading the Image from the file and storing it in to a Matrix object
        Mat src = Imgcodecs.imread(path);

        // Creating an empty matrix to store the result
        Mat dst = new Mat();

        //scaling an original image to half width and half height of original and store result to des object
        Imgproc.resize(src, dst, new Size(src.rows()/2, src.cols()/2), 0, 0,
                Imgproc.INTER_CUBIC);

        // saving a result image to a specific path
        Imgcodecs.imwrite("result_images\\BaboonScaled.bmp", dst);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("original Image",src);
        HighGui.imshow("scaled Image",dst);

        //this method to close the window after click to close button
        HighGui.waitKey();
    }


    public void shifting(String path){
        // Loading the OpenCV core library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //Mat Matrix object used to host the image
        Mat imageArray;
        // Reading the Image from the file and storing it in to a Matrix object(can you change the image just you need to change the path)
        imageArray = Imgcodecs.imread(path);
        //Creating destination matrix
        Mat dst = new Mat(imageArray.rows(), imageArray.cols(), imageArray.type());
        Point p1 = new Point( 0,0 );
        Point p2 = new Point( imageArray.cols() - 1, 0 );
        Point p3 = new Point( 0, imageArray.rows() - 1 );
        Point p4 = new Point( imageArray.cols()*0.0, imageArray.rows()*0.33 );
        Point p5 = new Point( imageArray.cols()*0.85, imageArray.rows()*0.25 );
        Point p6 = new Point( imageArray.cols()*0.15, imageArray.rows()*0.7 );
        MatOfPoint2f ma1 = new MatOfPoint2f(p1,p2,p3);
        MatOfPoint2f ma2 = new MatOfPoint2f(p4,p5,p6);
        //Creating the transformation matrix
        Mat transformationMatrix = Imgproc.getAffineTransform(ma1,ma2);
        //Creating object of the class Size
        Size size = new Size(imageArray.cols(), imageArray.cols());
        //Applying Wrap Affine to translate image based on transformation matrix
        Imgproc.warpAffine(imageArray, dst, transformationMatrix, size);

        // saving a result image to a specific path
        Imgcodecs.imwrite("images\\BaboonTranslated.jpg", dst);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("original image", imageArray);
        HighGui.imshow("translated image", dst);
        HighGui.waitKey();
    }

}
