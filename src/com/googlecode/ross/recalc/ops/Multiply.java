package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.*;

public class Multiply extends OperatorNode {

  public <T extends Operator> boolean checkOps (java.util.List<T> ops) {
    return ops.size() == 2;
  }

  public <T extends Operator> double calc (java.util.List<T> ops) {
    return ops.get(0).calc() * ops.get(1).calc();
  }
}
