package com.googlecode.ross.recalc.tree;

import java.util.List;

/**
 * 
 * Gives an object a representation within a tree. Implementation stores parent 
 * and children, so it can be considered a tree itself.
 */

public class Node<T> {
  
  private T content;
  private Node<T> parent;
  private List<Node<T>> children;
  
  public Node (T content, Node<T> parent, List<Node<T>> children) {
    this.parent = parent;
    this.children = children;  
    this.content = content;
  }
  
  public Node (T content, Node<T> parent) {
    this(content, parent, new java.util.LinkedList<Node<T>>());
  }
  
  public Node (T content, List<Node<T>> children) {
    this(content, null, children);
  }
  
  public Node (T content) {
    this(content, null, new java.util.LinkedList<Node<T>>());
  }
  
  public Node<T> getParent () {
    return parent;
  }
  
  public List<Node<T>> getChildren () {
    return children;
  }
  
  public void addChild (Node<T> child) {
    children.add(child);
    child.setParent(this);
  }
  
  private void setParent (Node<T> parent) {
    this.parent = parent;
  }
}
