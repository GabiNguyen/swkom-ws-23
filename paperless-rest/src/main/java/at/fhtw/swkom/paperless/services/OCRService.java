package at.fhtw.swkom.paperless.services;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCRService {
    public static void main(String[] args)
    {
        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("E:/FH/WS23/swkom/Tess4J-3.4.8-src/Tess4J/tessdata");

            // the path of your tess data folder
            // inside the extracted file
            String text
                    = tesseract.doOCR(new File("E:\\FH\\WS23\\swkom\\Tess4J-3.4.8-src\\Tess4J\\image.png"));

            // path of your image file
            System.out.print(text);
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
