package BarCode;

import java.awt.image.BufferedImage;  
import java.io.File;  
import java.util.*;
  
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;  
import com.google.zxing.MultiFormatReader;  
import com.google.zxing.Result;  
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;  
import com.google.zxing.common.HybridBinarizer;

import ImageDivide.DivideTest;  

public class BarCodeTest {
    /** 
     * @param imgPath 
     * @return String 
     */  
    public String decode(String imgPath) {  
        BufferedImage image = null;  
        Result result = null;  
        try {  
            image = ImageIO.read(new File(imgPath));  
            if (image == null) {  
                System.out.println("the decode image may be not exit.");  
            }  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source)); 
            //指定条形码解码版本
            Map<DecodeHintType, ArrayList<BarcodeFormat>> hint =
        	    new HashMap<DecodeHintType, ArrayList<BarcodeFormat>>();
            ArrayList<BarcodeFormat> possibleFormat =
        	    new ArrayList<BarcodeFormat>();
            possibleFormat.add(BarcodeFormat.CODE_128);
            possibleFormat.add(BarcodeFormat.CODE_39);
            possibleFormat.add(BarcodeFormat.CODE_93);
            hint.put(DecodeHintType.POSSIBLE_FORMATS, possibleFormat);
  
            result = new MultiFormatReader().decode(bitmap, hint);  
            return result.getText();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  

    public static void main(String[] args) {
        //String imgPath = "E:\\npwf\\mvnweb\\barcode\\1.jpg";
        DivideTest imgTest = new DivideTest();
        imgTest.filesPath.add("E:\\npwf\\mvnweb\\barcode\\201FC23DB4E34313A18BD47AEAFC5FAC_0_0_0.jpg");
        BarCodeTest handler = new BarCodeTest();  
        String decodeContent = handler.decode(imgTest.DivideImage());  
        System.out.println("解码结果：");  
        System.out.println(decodeContent);   

    }

}
