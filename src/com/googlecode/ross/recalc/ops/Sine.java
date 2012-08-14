package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;

public class Sine extends UnaryOperator {

  public <T extends Operator> double calc (java.util.List<T> ops) {
    return Math.sin(ops.get(0).calc());
  }

  public String getStringRepresentation() {
    return "sin";
  }

}