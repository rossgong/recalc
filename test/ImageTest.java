import com.googlecode.ross.recalc.*;
import com.googlecode.ross.recalc.gui.*;

import java.awt.image.BufferedImage;

public class ImageTest {

  private static String f = "sin(2^x)";
  private static double from = -5;
  private static double to = 10;
  private static int size = 500;
  
  public static void main(String[] args) throws Exception {
    FunctionValueRange range = new FunctionValueRange(Parser.parse(f),
                                                        from,
                                                        to,
                                                        size);
    BufferedImage img = (BufferedImage)FunctionImageFactory.createImage(range, from, to, size, size, java.awt.Color.black);

    javax.imageio.ImageIO.write(img, "png", new java.io.File("love.png"));
  }
}
