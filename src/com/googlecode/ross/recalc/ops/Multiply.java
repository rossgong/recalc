package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.Operator;

public class Multiply extends BinaryOperator {
  
  public <T extends Operator> double calc (java.util.List<T> ops) {
    return ops.get(0).calc() * ops.get(1).calc();
  }

  public String getStringRepresentation() {
    return "*";
  }

}
