public class Seminar1 {
    public static void main(String[] args) {
        System.out.println("start");
    }
    //Реализуйте 3 метода, чтобы в каждом из них получить разные стандартные для Java исключения;
    public void methodWithNullPointerException() {
        String str = null;
        int length = str.length(); // Вызовет NullPointerException, так как str равно null
    }
    public void methodWithArrayIndexOutOfBoundsException() {
        int[] arr = {1, 2, 3};
        int element = arr[3]; // Вызовет ArrayIndexOutOfBoundsException, так как индекс 3 выходит за пределы массива
    }
    public void methodWithArithmeticException() {
        int result = 10 / 0; // Вызовет ArithmeticException, так как деление на ноль запрещено
    }
    //    public static int sum2d(String[][] arr) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < 5; j++) {
//                int val = Integer.parseInt(arr[i][j]);
//                sum += val;
//            }
//        }
//        return sum;
//    }
    // В представленном коде может возникнуть несколько различных типов исключений:
    //NumberFormatException: Если значение в массиве arr не может быть преобразовано в целое число, возникнет исключение NumberFormatException при вызове Integer.parseInt(arr[i][j]).
    //ArrayIndexOutOfBoundsException: Если значение переменной i выходит за пределы допустимого диапазона индексов массива arr или если значение переменной j выходит за пределы допустимого диапазона индексов внутреннего массива, то возникнет исключение ArrayIndexOutOfBoundsException.
    //NullPointerException: Если в массиве arr или в одном из его внутренних массивов находится null, то возникнет исключение NullPointerException при попытке доступа к элементу массива или вызове метода Integer.parseInt().
    public static int sum2d(String[][] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 5; j++) {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                }
            }
        } catch (NumberFormatException e) {
            // Обработка исключения NumberFormatException, если не удалось преобразовать значение в целое число
            System.err.println("Ошибка преобразования строки в число: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // Обработка исключения ArrayIndexOutOfBoundsException, если индексы выходят за пределы массива
            System.err.println("Выход за пределы массива: " + e.getMessage());
        } catch (NullPointerException e) {
            // Обработка исключения NullPointerException, если массив или внутренний массив содержат null
            System.err.println("Обнаружен null в массиве: " + e.getMessage());
        }
        return sum;
    }

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращает новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя
    public static int[] calculateDifferences(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Длины массивов не равны");
            return null;
        }

        int[] differences = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            differences[i] = arr1[i] - arr2[i];
        }

        return differences;
    }
    // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращает новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException
    public static int[] calculateQuotients(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }

        int[] quotients = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            quotients[i] = arr1[i] / arr2[i];
        }

        return quotients;
    }

}