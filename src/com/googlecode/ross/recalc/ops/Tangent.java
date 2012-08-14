package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;

public class Tangent extends UnaryOperator {

  public <T extends Operator> double calc (java.util.List<T> ops) {
    return Math.tan(ops.get(0).calc());
  }

  public String getStringRepresentation() {
    return "tan";
  }

}