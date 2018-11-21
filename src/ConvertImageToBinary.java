import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class ConvertImageToBinary {

    /*
     *  Purpose                 : Demonstrate basic digital image processing using java.
     *                            Demonstrate how to convert jpg image to binary image using java.
     *                            Demonstrate how to control noise using threshold.
     *  Reference               : Digital Image Processing: A Practical Introduction Using Java - Nick Efford
     *
     *  Image type              : jpg only.
     *  Color support           : black/white, grey and color.
     *  Default threshold value : 12500000
     *                            Lower threshold = less noise but image will be less detail. Higher threshold = more detail image but more noise.
                                   Experiment@adjust threshold value to get the best output.
                                   threshold value = 0 -> 99999999 (**currently not sure about the highest value...). **tips: adjust for every million first((+-)10000000)
     *  To run program          : Put inputfile(jpg image) into program folder. Set inputfile name in the program below and run normally.
     *  To view output          : Output will be save as .txt file in program folder.
     *                            Use notepad. Disable wordwrap in notepad. Set font size to 4 or 5 and font type arial or timesnewroman to get best view.
     */

    public static void main(String[] argv) {
        processImage("BarChart.jpg"); // put your file name here(inputfile).
        System.exit(0);
    }

    public static void processImage(String infile) {
        infile = infile.toLowerCase();
        Image image = Toolkit.getDefaultToolkit().getImage(infile);

        try {
            String outfile = infile.replace(".jpg", ".txt");
            PrintWriter out = new PrintWriter(outfile);
            PixelGrabber grabber = new PixelGrabber(image, 0, 0, -1, -1, false);

            if (grabber.grabPixels()) {
                int width = grabber.getWidth();
                int height = grabber.getHeight();

                int[] data = (int[]) grabber.getPixels();
                int loopstatus = 1;
                int output;

                // default = 12500000.threshold value = 0 -> 99999999 (**currently not sure about the highest value...). **tips: adjust for every million first((+-)10000000)
                int threshold = 12500000;

                for (int i = 0; i < width * height; i++) {
                    // white
                    if (data[i] == 16777215) {
                        output = 0;
                    }
                    // black
                    else if (data[i] == 0) {
                        output = 1;
                    }
                    // value that are not white/black.
                    else if (data[i] < threshold) {
                        output = 1;
                    } else {
                        output = 0;
                    }

                    out.print(output);

                    if (width == (i + 1) / loopstatus) {
                        out.println();
                        loopstatus++;
                    }
                }
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

