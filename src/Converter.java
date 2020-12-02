import java.util.HashMap;
import java.util.Map;

public class Converter {

  private static HashMap<Integer, Character> map = new HashMap<>();

  static
  {
    map.put(0, '0');
    map.put(1, '1');
    map.put(2, '2');
    map.put(3, '3');
    map.put(4, '4');
    map.put(5, '5');
    map.put(6, '6');
    map.put(7, '7');
    map.put(8, '8');
    map.put(9, '9');
    map.put(10, 'A');
    map.put(11, 'B');
    map.put(12, 'C');
    map.put(13, 'D');
    map.put(14, 'E');
    map.put(15, 'F');
  }

  public Integer convertBinaryToDec(String number) {
    char[] chars = number.toCharArray();

    int result = 0;
    for (int i = 0; i < chars.length; i++) {
      int integer = Character.getNumericValue(chars[i]);
      double poryadok = Math.pow(2, chars.length - 1 - i);
      int preResult = (int) poryadok * integer;
      result += preResult;
    }
    return result;
  }

  public String convertNumberToAnotherCountSystem(String number, Integer fromRadix, Integer toRadix) {

    Integer result = toDec(fromRadix, number);

    return fromDecToAnotherRadix(result, toRadix, new StringBuilder()).toString();
  }

  private Integer toDec(Integer from, String number) {
    char[] chars = number.toCharArray();

    int result = 0;
    for (int i = 0; i < chars.length; i++) {
      int factor = getNumberFromChar(chars[i]);
      double order = Math.pow(from, chars.length - 1 - i);
      int resultOfOrder = (int) order * factor;
      result += resultOfOrder;
    }
    return result;
  }

  private StringBuilder fromDecToAnotherRadix(Integer number, Integer anotherRadix, StringBuilder builder) {
    if(number == 0){
      return builder.reverse();
    }
    return fromDecToAnotherRadix(number/anotherRadix, anotherRadix, builder.append(map.get(number%anotherRadix)));
  }

  private Integer getNumberFromChar(Character value) {
    Integer result = 0;
    for (Map.Entry<Integer, Character> entry : map.entrySet()) {
      if (entry.getValue().equals(value)) {
        result = entry.getKey();
        break;
      }
    }
    return result;
  }
}
