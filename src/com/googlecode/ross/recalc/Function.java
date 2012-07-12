package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;

public class Function extends UnaryOperator {
  private OperatorNode root;
  private Variable var;
  private OperatorNode curr;

  public Function () {
    root = null;
    var = new Variable();
  }

  public void add (OperatorNode node) {
    if (root == null) {
      root = node;
      curr = root;
    } else if (curr == null) {
      node.addChild(root);
      root = node;
      curr = root;
    } else {
      curr.addChild(node);
      
      curr = node;
   }

    while (curr != null && curr.getChildren().size() == curr.numOperands()) {
      curr = curr.getParent();
    }
  }

  public <T extends Operator> double calc (java.util.List<T> ops) {
    if (curr != null) return -1;
    
    var.setVal(ops.get(0).calc());
    return root.calc();
  }

  public String toString() {
    return root.toString();
  }

}
