import com.googlecode.ross.recalc.*;

public class ParserTest {
  
  public static void main(String[] args) {
    Function f = Parser.parse("2+3");
    f.addChild(Parser.parse("2"));
    
    System.out.println(7);
    System.out.println(f + ":" + f.calc());
  }
}
