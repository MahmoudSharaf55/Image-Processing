package Algorithms.Part_3;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * to select a Region Of Interest many techniques can be used but in this class using template matching technique to select ROC,
 * just right click and choose run main to run the main function
 */

public class TemplateMatching {
    public void templateMatching(String pathOfImage,String pathOfTemplate){
        //Read image file
        Mat source=Imgcodecs.imread(pathOfImage);
        // saving original before modify to display
        Mat image = source.clone();
        //Read template file
        Mat template=Imgcodecs.imread(pathOfTemplate);
        //create an empty object to store result
        Mat outputImage=new Mat();
        //define match method
        int machMethod= Imgproc.TM_CCOEFF;
        //Template matching method
        Imgproc.matchTemplate(source, template, outputImage, machMethod);

        Core.MinMaxLocResult mmr = Core.minMaxLoc(outputImage);
        Point matchLoc=mmr.maxLoc;
        //Draw rectangle on result image
        Imgproc.rectangle(source, matchLoc, new Point(matchLoc.x + template.cols(),
                matchLoc.y + template.rows()), new Scalar(255, 255, 0));

        Imgcodecs.imwrite("result_images\\template_matching_result.jpg", source);

        // this method to display the image take label and image to display note can you change the label if you need it
        HighGui.imshow("original image", image);
        HighGui.imshow("Template image", template);
        HighGui.imshow("matching result", source);
        HighGui.waitKey();
    }
}
