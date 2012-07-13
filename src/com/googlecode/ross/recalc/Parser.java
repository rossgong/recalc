package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;
import com.googlecode.ross.recalc.ops.Number;

public class Parser {
  private static String[] opStrings = {"+","-","/","*"};  


  private Parser() {
  }

  public static Function parse (String s) {
    Function f = new Function();

    s = s.replaceAll("\\s", "");

    int ind = 0;
    String token = "";
    while (ind < s.length()) {
      String curr = "" + s.charAt(ind);
      if (curr.matches("[\\d|\\.]{1}")||(curr.equals("-")&&token.length()==0)){
        if (token.length()==0&&curr.equals(".")) {
          token="0";
        }
        token+=curr;

      } else {
        OperatorNode node = null;
        if (token.matches("-?\\d+(\\.\\d+)?")) {
          node = new Number (Double.parseDouble(token));
        } else {
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
          }
        }
        System.out.println("ADDING:" + node);

        f.add(node);
      }
      ind ++;
    }
    return f;
  }
}
