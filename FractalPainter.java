import java.awt.*;
import java.applet.*;

public class FractalPainter extends Applet {

   public void paint(Graphics g) {
      drawSquare1(g, 1024, 768);
   }

   public void drawSquare1(Graphics g, int maxX, int maxY) {
      int midX = maxX / 2;
      int midY = maxY / 2;
      int startWidth = maxX / 4;
      int startHeight = maxY / 4;
      int tlX = midX - (startWidth / 2);
      int tlY = midY - (startHeight / 2);
      g.fillRect(tlX, tlY, startWidth, startHeight);
      drawFractal(g, tlX - startWidth / 2, tlY - startHeight / 2, startWidth / 2, startHeight / 2, Color.red,
            "topLeft");
      drawFractal(g, tlX + startWidth, tlY - startHeight / 2, startWidth / 2, startHeight / 2, Color.blue, "topRight");
      drawFractal(g, tlX - startWidth / 2, tlY + startHeight, startWidth / 2, startHeight / 2, Color.green,
            "bottomLeft");
      drawFractal(g, tlX + startWidth, tlY + startHeight, startWidth / 2, startHeight / 2, Color.yellow, "bottomRight");
   }

   public void drawFractal(Graphics g, int x, int y, int w, int h, Color c, String whichCorner) {
      if (h >= 1) {
         g.setColor(c);
         g.fillRect(x, y, w, h);

         if (whichCorner.equals("topLeft")) {
            drawFractal(g, x - w / 2, y - h / 2, w / 2, h / 2, Color.red, "topLeft");
            drawFractal(g, x + w, y - h / 2, w / 2, h / 2, Color.blue, "topRight");
            drawFractal(g, x - w / 2, y + h, w / 2, h / 2, Color.green, "bottomLeft");
         } else if (whichCorner.equals("topRight")) {
            drawFractal(g, x - w / 2, y - h / 2, w / 2, h / 2, Color.red, "topLeft");
            drawFractal(g, x + w, y - h / 2, w / 2, h / 2, Color.blue, "topRight");
            drawFractal(g, x + w, y + h, w / 2, h / 2, Color.yellow, "bottomRight");
         } else if (whichCorner.equals("bottomLeft")) {
            drawFractal(g, x - w / 2, y - h / 2, w / 2, h / 2, Color.red, "topLeft");
            drawFractal(g, x - w / 2, y + h, w / 2, h / 2, Color.green, "bottomLeft");
            drawFractal(g, x + w, y + h, w / 2, h / 2, Color.yellow, "bottomRight");
         } else {
            drawFractal(g, x + w, y - h / 2, w / 2, h / 2, Color.blue, "topRight");
            drawFractal(g, x - w / 2, y + h, w / 2, h / 2, Color.green, "bottomLeft");
            drawFractal(g, x + w, y + h, w / 2, h / 2, Color.yellow, "bottomRight");
         }
      }
   }

   public void delay(long n) {
      n *= 1000;
      long startDelay = System.nanoTime();
      long endDelay = 0;
      while (endDelay - startDelay < n)
         endDelay = System.nanoTime();
   }

}
