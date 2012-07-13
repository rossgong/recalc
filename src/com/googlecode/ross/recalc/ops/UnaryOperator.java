package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.*;

public abstract class UnaryOperator extends OperatorNode {
  
  public int numOperands () {
    return 1;
  }
  
  public String toString() {
    return getStringRepresentation() + "(" + getChildren().get(0) + ")";
  }
}
