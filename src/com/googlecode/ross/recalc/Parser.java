package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;
import com.googlecode.ross.recalc.ops.Number;

public class Parser {

  private Parser() {
  }

  public static Function parse (String s) {
    Function f = new Function();

    s = s.toLowerCase();

    s = s.replaceAll("\\s", "");

    int ind = 0;
    String token = "";
    while (ind < s.length()) {
      String curr = "" + s.charAt(ind);
      System.out.println("c:" + curr + "t:" + token);
      if (curr.matches("[\\d|\\.]{1}")||(curr.equals("-")&&token.length()==0)){
        if (token.length()==0&&curr.equals(".")) {
          token="0";
        }
        token+=curr;
        if (ind+1 == s.length()) {
          
          f.add(new Number (Double.parseDouble(token)));
          System.out.println("out");
        }

      } else {
        OperatorNode node = null;
        if (token.matches("-?\\d+(\\.\\d+)?")) {
          node = new Number (Double.parseDouble(token));
          f.add(node);
          token = "";
        }
        token += curr;
        switch (token) {
          case "+":
            node = new Add();
            break;
          case "-":
            node = new Subtract();
            break;
          case "*":
            node = new Multiply();
            break;
          case "/":
            node = new Divide();
            break;
          case "^":
            node = new Exponentiation();
            break;
          case "x":
            node = new Variable();
            break;
          case "sin":
            node = new Sine();
            break;
          case "cos":
            node = new Cosine();
            break;
          case "tan":
            node = new Tangent();
            break;
          case "(":
            String inner = "";
            ind ++;
            while (s.charAt(ind) != ')') {
              inner += String.valueOf(s.charAt(ind));
              ind++;
            }
            System.out.println("inner" + inner);
            node = parse(inner);
            ind --;
            break;
        }
        if (node != null) {
          f.add(node);
          token = "";
        }
      }
      ind ++;
    }

    System.out.println("FUNCTION:" + f.getFunctionString());
    return f;
  }
}
