package com.googlecode.ross.recalc.gui;

import java.awt.image.BufferedImage;

public class Layer extends BufferedImage {
  
  private String name;
  
  private boolean visible;
  
  public Layer (int width, int height, String name) {
    super(width, height, TYPE_INT_ARGB);
    
    this.name = name;
    visible = true;
  }
  
  public void setVisible(boolean visible) {
    this.visible = visible;
  }
  
  public boolean isVisible() {
    return visible;  
  }
  
  public String getName() {
    return name;
  }
  
  public String toString() {
    return name;
  }
}
