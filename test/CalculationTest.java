import com.googlecode.ross.recalc.*;
import com.googlecode.ross.recalc.ops.*;

public class CalculationTest {
  public static void main (String[] args) {
    OperatorNode top = new Add();

    top.addChild(new Number(3));
    top.addChild(new Number(4));

    System.out.println(top.calc());
  }
}
