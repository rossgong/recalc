package com.googlecode.ross.recalc.gui;

import java.util.TreeMap;
import java.util.Map.Entry;

import com.googlecode.ross.recalc.Function;

public class FunctionValueRange {

  private TreeMap<Double, Double> range;
  private Function f;

  private double from;
  private double to;

  private double delta;

  public FunctionValueRange(Function f, double from, double to, int size) {
      range = new TreeMap<Double, Double>();
      this.f = f;

      createRange(from, to, size);
  }

  private void createRange(double from, double to, int size) {
    double curr = from;
    delta = (to-from)/size;

    while (curr < to) {
      curr += delta;
      range.put(curr, f.calc(curr));
    }

    //System.out.println(range);
  }

  public java.util.Set<Entry<Double, Double>> getRange() {
    return range.entrySet();
  }
}