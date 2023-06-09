import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Seminar3 {


    public class UserDataApplication {
        private static final int REQUIRED_FIELDS_COUNT = 6;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол");
                String input = scanner.nextLine();
                String[] data = input.split(" ");

                if (data.length != REQUIRED_FIELDS_COUNT) {
                    throw new DataFormatException("Неверное количество данных");
                }

                String lastName = data[0];
                String firstName = data[1];
                String patronymic = data[2];
                LocalDate birthDate = parseDate(data[3]);
                int phoneNumber = parsePhoneNumber(data[4]);
                char gender = parseGender(data[5]);

                String fileName = lastName + ".txt";
                String fileContent = lastName + firstName + patronymic + birthDate + " " + phoneNumber + gender;

                try (FileWriter fileWriter = new FileWriter(fileName)) {
                    fileWriter.write(fileContent);
                } catch (IOException e) {
                    System.out.println("Ошибка записи файла: " + e.getMessage());
                }

            } catch (DataFormatException e) {
                System.out.println("Ошибка в данных: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private static LocalDate parseDate(String date) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                return LocalDate.parse(date, formatter);
            } catch (Exception e) {
                throw new DataFormatException("Неверный формат даты");
            }
        }

        private static int parsePhoneNumber(String phoneNumber) {
            try {
                return Integer.parseInt(phoneNumber);
            } catch (NumberFormatException e) {
                throw new DataFormatException("Неверный формат номера телефона");
            }
        }

        private static char parseGender(String gender) {
            if (gender.length() != 1 || !gender.matches("[mf]")) {
                throw new DataFormatException("Неверное значение пола");
            }
            return gender.charAt(0);
        }

        private static class DataFormatException extends RuntimeException {
            public DataFormatException(String message) {
                super(message);
            }
        }
    }

}
