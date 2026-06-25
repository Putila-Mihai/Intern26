package betr.intern;

public class Exercise9 {

  @FunctionalInterface
  public interface PasswordValidator {
    boolean isValid(String password);
  }

  public static void run() {
    final PasswordValidator lengthValidator =
        password -> password != null && password.length() >= 10;

    System.out.println(lengthValidator.isValid("1234"));
    System.out.println(lengthValidator.isValid("1parola6181"));
  }
}
