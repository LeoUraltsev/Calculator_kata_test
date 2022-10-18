import java.util.List;
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

/**
 *
 * Задачи:
 * 1. Получить строку введенную в консоль. +
 * 2. Получить оператор. +
 * 3. Получить операнды разделив строку по оператору. +
 * 4. Написать конвертер для римских цифр. (Из римских в арабские и наоборот).
 * 4. Проверить числа римские или арабские. Если оба числа римские или арабские -> ОК. Иначе, Исключение.
 * 4.1 Проверить чтобы числа были в диапазоне от (1 .. 10). Иначе, Исключение. Если числа не целые, исключение.
 * 5. Реализуем калькулятор
 * 5.1 Если числа арабские, считаем и выводим результат. (Округляем до целого)
 * 5.2. Если числа римские, переводим в арабские, выполняем вычесление. Если результат < 1 выбрасыываем Исключение.
 *      Переводим результат в число Римскими цифрами.
 * 6. Показываем результат.
 */

public class Main {

    private static final String NO_OPERATOR = "OPERATOR IS NULL";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String input = scanner.nextLine().replaceAll("\\s+", "");

        System.out.println("Вывод введенной строки: " + input);
        System.out.println("Вывод: " + calc(input));

    }

    public static String calc(String input){
        String operator = getOperator(input);
        if(operator.equals(NO_OPERATOR)){
            //TODO: Выбросить исключение ("Введено неккоректное выражение")
            return "Введено неккоректное выражение";
        }

        String[] operands = input.split("[-+/*]");
        if(operands.length > 2){
            //TODO: Выбросить исключение ("Введено неккоректное выражение")
            return "Введено неккоректное выражение";
        }
        System.out.println(operands[0] + operands[1]);

        if(checkByRoman(operands[0]) && checkByRoman(operands[1])){
            System.out.println("Is roman");
        }else if (!checkByRoman(operands[0]) && !checkByRoman(operands[1])){
            System.out.println("Is arabic");
            int firstOperand = 0;
            int secondOperand = 0;
            try {
                firstOperand = Integer.parseInt(operands[0]);
                secondOperand = Integer.parseInt(operands[1]);
            }catch (NumberFormatException e){
                return "Введено неккоректное выражение " + e;
            }
            System.out.println(firstOperand + secondOperand);
        }else {
            //TODO: Выбросить исключение ("Введено неккоректное выражение")
            return "Введено неккоректное выражение";
        }
        return "";
    }

    public static boolean checkByRoman(String value){
        RomanNumberConverter converter = new RomanNumberConverter();
        return converter.isRomanNumber(value);
    }
    private static String getOperator(String input){
        String operator = NO_OPERATOR;
        String[] operatorsList = {"+","-","*","/"};

        for (String s : operatorsList) {
            if (input.contains(s)) {
                operator = s;
                break;
            }
        }
        return operator;
    }


}

