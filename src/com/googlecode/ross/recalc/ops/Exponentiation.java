package com.googlecode.ross.recalc.ops;

import com.googlecode.ross.recalc.Operator;

public class Exponentiation extends BinaryOperator {
  
  public <T extends Operator> double calc (java.util.List<T> ops) {
    //System.out.println(ops.get(0) +"+"+ ops.get(1));
    return Math.pow(ops.get(0).calc(), ops.get(1).calc());
  }

  public String getStringRepresentation() {
    return "^";
  }
}
