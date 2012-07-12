import com.googlecode.ross.recalc.*;
import com.googlecode.ross.recalc.ops.*;
import com.googlecode.ross.recalc.ops.Number;

public class CalculationTest {
  public static void main (String[] args) {
    Function f = new Function();
    f.addChild(new Number(2)); 

    f.add(new Number(2));
    f.add(new Add());
    f.add(new Number(3));
    f.add(new Multiply());
    f.add(new Number(7));
    f.add(new Divide());
    f.add(new Variable());

    System.out.println(f + "(2)=" + f.calc());
  }
}
