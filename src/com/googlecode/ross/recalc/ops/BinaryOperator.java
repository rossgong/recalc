package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.*;

public abstract class BinaryOperator extends OperatorNode {
  
  public int numOperands () {
    return 2;
  }

  public String toString() {
    return getChildren().get(0) + getStringRepresentation()
            + getChildren().get(1);
  }
}
