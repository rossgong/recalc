package com.googlecode.ross.recalc;


public interface Operator {
  
  public <T extends Operator> double calc(java.util.List<T> ops);
  
  public double calc();

  public int numOperands ();
}

