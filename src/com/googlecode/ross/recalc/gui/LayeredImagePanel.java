package com.googlecode.ross.recalc.gui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class LayeredImagePanel extends JPanel {
  
  private int width, height;
  
  private LinkedList<Layer> layers;
  
  private BufferedImage img;
  
  private Color bg;
  
  private BackgroundLayer bgLayer;
  
  public LayeredImagePanel (int width, int height) {
    this(width, height, null);
  }
  
  public LayeredImagePanel (BackgroundLayer bg) {
    this(bg.getWidth(), bg.getHeight(), bg);
  }
  
  public LayeredImagePanel (int width, int height, BackgroundLayer bg) {
    this.width = width;
    this.height = height;
    
    layers = new LinkedList<Layer>();
    layers.push(bg);
    
    img = null;
    
    bgLayer = bg;
    
    setPreferredSize(new java.awt.Dimension(width, height));
    
    this.bg = Color.WHITE;
  }
  
  public void paintComponent(Graphics graphics) {
    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.getGraphics();
    
    System.out.println("repaintLIP");
    
    g.setColor(bg);
    g.fillRect(0,0,width,height);    
    
    for (Layer l : layers) {
      if (l.isVisible()) {
        System.out.println("\tDrawing.. " + l);
        g.drawImage(l, 0, 0, this);
      }
    }
    
    graphics.drawImage(img, 0, 0, this);
  }
  
  public BufferedImage getImage() {
    return img;
  }
  
  public List<Layer> getLayers() {
    return layers;
  }
  
  public void addToFront (Layer l) {
    layers.add(l);
    repaint();
  }
  
  public void addToBack (Layer l) {
    Layer bg = layers.pop();
    
    layers.push(l);
    layers.push(bg);
    
    repaint();
  }
  
  public BackgroundLayer getBG() {
    return bgLayer;
  }
  
  public String toString() {
    String res = "";
    
    for (Layer l : layers) {
      res += l.toString() + "|";
    }
    
    return res;
  }
}
