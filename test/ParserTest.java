import com.googlecode.ross.recalc.*;

public class ParserTest {
  
  public static void main(String[] args) {
    Function f = Parser.parse("2+3*6-8/15");
    
    System.out.println(7);
    System.out.println(f + ":" + f.calc());
  }
}
