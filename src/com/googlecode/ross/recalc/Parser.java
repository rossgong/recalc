package com.googlecode.ross.recalc;

import com.googlecode.ross.recalc.ops.*;


public class Parser {
  private static String[] opStrings = {"+","-","/","*"};  


  private Parser() {
  }

  public static OperatorNode parse (String s) {
    if (!isValid(s)) {
      return null;
    }

    s = s.replaceAll("\\s", "");

    int ind = 0;
    String token = "";
    while (curr < s.length()) {
      String curr = "" + s.charAt(ind);
      if (curr.matches("[0-9|\\.]{1}") || (curr.equals("-")&&token.equals(""))){
        token+=curr;
      } else {
        Number dig = 



        while (s.charAt(ind+1)!='-' && s.charAt(ind+1!='.' &&
                 !Character.isDigit(s.charAt(ind+1))) {
          curr
        }
      }

    }
  }
}
