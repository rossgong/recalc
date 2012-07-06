package com.googlecode.ross.recalc;

import java.util.List;
import com.googlecode.ross.recalc.ops.OperandAmountException;

public abstract class OperatorNode implements Operator {

  private OperatorNode parent;
  private List<OperatorNode> children;

  public OperatorNode (OperatorNode parent, List<OperatorNode> children) {
    this.children = children;
    this.parent = parent;
  }

  public OperatorNode (OperatorNode parent) {
    this(parent, new java.util.LinkedList<OperatorNode>());
  }

  public OperatorNode (List<OperatorNode> children) {
    this(null, children);
  }

  public OperatorNode () {
    this(null, new java.util.LinkedList<OperatorNode>());
  }

  public OperatorNode getParent () {
    return parent;
  }

  public List<OperatorNode> getChildren () {
    return children;
  }

  public void addChild (OperatorNode child) {
    if (children.size() < numOperands()) {
      children.add(child);
      child.setParent(this);
    }
  }

  protected void setParent (OperatorNode parent) {
    this.parent = parent;
  }

  public double calc() {
    if (numOperands() == children.size()) {
      return calc(children);
    } else {
      throw new OperandAmountException("There are supposed to be " +
                                      numOperands() + "operands for a " + this);
    }
  }
}
