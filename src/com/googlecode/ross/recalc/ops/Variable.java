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

  public void setVal(double val) {
    this.val = val;
  }

  public int numOperands () {
    return 0;
  }

  public <T extends Operator> double calc (java.util.List<T> ops) {
    return val;
  }
}
