public class Main {
  public static void main(String[] args) {
    Converter converter = new Converter();

    String change = converter.convertNumberToAnotherCountSystem("1111", 2, 16);

    System.out.println(change);
  }
}
