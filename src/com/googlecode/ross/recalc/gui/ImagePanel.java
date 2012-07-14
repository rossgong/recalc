package com.googlecode.ross.recalc.gui;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;

import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel{

  private BufferedImage image;

  public ImagePanel(BufferedImage i) {
     image = i;
     setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
  }

  public void paintComponent(Graphics g) {
    g.drawImage(image, 0, 0, null);
  }

  public void setImage(BufferedImage i) {
    image = i;
    setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    repaint();
  }

}
