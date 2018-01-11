package ImageDivide;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.*;

public class DivideTest {

    public ArrayList<String> filesPath = new ArrayList<String>();
    public String DivideImage(){
	BufferedImage bimg = null;
	try {
	    bimg = ImageIO.read(new File(filesPath.get(0)));
	    System.out.println("Orign:" + bimg.getWidth() + "*" + bimg.getHeight());
	    ImageIO.write(bimg.getSubimage(700, 610, 900, 160), "jpg", new File("E:\\npwf\\mvnweb\\barcode\\2.jpg"));
	    return "E:\\npwf\\mvnweb\\barcode\\2.jpg";
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return "";
    }

}
