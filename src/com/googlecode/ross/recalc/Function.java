package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;

import java.util.LinkedList;

public class Function extends UnaryOperator {
  private OperatorNode root;
  private Variable var;
  private OperatorNode curr;

  private LinkedList<Function> inners;

  public Function () {
    root = null;
    var = new Variable();
    inners = new LinkedList<Function>();
    addChild(var);
  }

  public void add (OperatorNode node) {
    if (node instanceof Variable) {
      node = var;
    } else if (node instanceof Function) {
      inners.add((Function)node);
    }
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
    
    setVariable(ops.get(0).calc());
    return root.calc();
  }

  public void setVariable(double value) {
    var.setValue(value);

    for (Function f : inners) {
      f.setVariable(value);
    }
  }

  public double calc(double x) {
    setVariable(x);
    return root.calc();
  }

  public String getStringRepresentation() {
    return "f";
  }

  public String getFunctionString() {
    return root.toString();
  }

}
