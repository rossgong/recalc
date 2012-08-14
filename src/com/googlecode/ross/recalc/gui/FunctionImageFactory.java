package com.googlecode.ross.recalc.gui;

import java.util.Map.Entry;
import java.util.Set;

import java.awt.image.BufferedImage;

import java.awt.Image;
import java.awt.Graphics;

public class FunctionImageFactory {

  public static Image createImage(FunctionValueRange range,
                                  double minY,
                                  double maxY,
                                  int width,
                                  int height,
                                  java.awt.Color c) {
    BufferedImage image = new BufferedImage(width, height, 
      BufferedImage.TYPE_INT_ARGB);

    Graphics g = image.getGraphics();
    g.setColor(c);

    Set<Entry<Double,Double>> coords = range.getRange();
    int currentXPixel = 0;

    int lastCoord = -2;

    for (Entry<Double, Double> coord : coords) {
      double y = coord.getValue();

      int imageYCoord = convertY(y, minY, maxY, height);

      //System.out.println(imageYCoord);

      if (!(lastCoord == -2 || 
            ((lastCoord == -1 || lastCoord == height+1)  &&
            imageYCoord != lastCoord))) {
        g.drawLine(currentXPixel-1, lastCoord, currentXPixel, imageYCoord);
      }

      lastCoord = imageYCoord;
      currentXPixel++;
    }

    return image;
  }

  public static int convertY (double yCoord, 
                              double minY,
                              double maxY, 
                              int height) {
    if (yCoord < minY) return height+1;
    else if (yCoord > maxY) return -1;
    else return height - (int)((yCoord-minY)/((maxY-minY)/height));
  }
}