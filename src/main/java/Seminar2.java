import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Seminar2 {

    public static void main(String[] args) {
        System.out.println("start");
    }

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
// значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно
// запросить у пользователя ввод данных.
    public class UserInput {
        public static float readFloatInput() {
            Scanner scanner = new Scanner(System.in);
            float number = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Введите дробное число: ");

                try {
                    number = scanner.nextFloat();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    scanner.nextLine(); // Очистка буфера ввода
                }
            }

            return number;
        }

        public static void main(String[] args) {
            float userInput = readFloatInput();
            System.out.println("Вы ввели: " + userInput);
        }
    }

    // исправьте данный код (задание 2)

//    try {
//            int d = 0;
//            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Пример массива
//            double catchedRes1 = intArray[8] / (double) d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }


// исправьте данный код (задание 3)
    public class Main {
        public static void main(String[] args) {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = {1, 2};
                abc[3] = 9;
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            }
        }

        public static void printSum(Integer a, Integer b) throws FileNotFoundException {
            System.out.println(a + b);
        }
    }

    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно
    // показаться сообщение, что пустые строки вводить нельзя.
    public class EmptyStringExceptionExample {
        public static void main(String[] args) {
            try {
                String input = getInputFromUser();
                if (input.isEmpty()) {
                    throw new Exception("Пустые строки вводить нельзя!");
                }
                System.out.println("Введенная строка: " + input);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        public static String getInputFromUser() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку: ");
            return scanner.nextLine();
        }
    }



}
