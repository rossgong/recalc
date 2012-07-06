package com.googlecode.ross.recalc;

import java.util.List;

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
    children.add(child);
    child.setParent(this);
  }

  private void setParent (OperatorNode parent) {
    this.parent = parent;
  }

  public double calc() {
    if (checkOps(children)) {
      return calc(children);
    } else {
      //throw some exception
      return 0.0;
    }
  }
}
