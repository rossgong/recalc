package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.*;

public class Variable extends OperatorNode {
  
  private double val;

  public Variable () {
    this (0, null);
  }

  public Variable (double init) {
    this(init, null);
  }

  public Variable (double init, OperatorNode parent) {
    this.val = init;
    setParent(parent);
  }

  public void setValue(double val) {
    this.val = val;
  }

  public int numOperands () {
    return 0;
  }

  public String getStringRepresentation() {
    return "X";
  }

  public String toString() {
    return getStringRepresentation();
  }

  public <T extends Operator> double calc (java.util.List<T> ops) {
    return val;
  }
}
