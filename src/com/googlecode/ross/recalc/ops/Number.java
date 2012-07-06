package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.*;

public class Number extends OperatorNode {
  
  private double val;

  public Number (double val) {
    this(val, null);
  }

  public Number (double val, OperatorNode parent) {
    this.val = val;
    setParent(parent);
  }

  public int numOperands () {
    return 0;
  }

  public <T extends Operator> double calc (java.util.List<T> ops) {
    return val;
  }
}
