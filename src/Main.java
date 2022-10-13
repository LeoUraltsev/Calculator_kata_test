import java.util.Scanner;

/**
 *
 * Создай консольное приложение “Калькулятор”.
 * Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции проводимые между
 * ними и выводить в консоль результат их выполнения.
 * Реализуй класс Main с методом public static String calc(String input). Метод должен принимать строку с арифметическим
 * выражением между двумя числами и возвращать строку с результатом их выполнения. Ты можешь добавлять свои импорты,
 * классы и методы. Добавленные классы не должны иметь модификаторы доступа (public или другие)
 *
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String input = scanner.nextLine().replaceAll("\\s+", "");

        System.out.println("Вывод: " + input);

    }



    public static String calc(String input){
        return "";
    }

}

