package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;

public class Function extends UnaryOperator {
  private OperatorNode root;
  private Variable var;


  public Function () {
    root = null;
    var = new Variable();
  }

  public void add (OperatorNode node) {
    if (root == null) root = node;
  }

  public <T extends Operator> double calc (java.util.List<T> ops) {
    var.setVal(ops.get(0).calc());
    return root.calc();
  }

  public String toString() {
    return root.toString();
  }

}
