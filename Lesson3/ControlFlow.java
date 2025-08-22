/**
 * Урок 3: Управляющие конструкции
 * 
 * В этом уроке мы изучим:
 * - Условные операторы (if, else, else if)
 * - Оператор switch
 * - Циклы (for, while, do-while)
 * - Операторы break и continue
 * - Тернарный оператор
 * 
 * ИНСТРУКЦИИ ПО ВЫПОЛНЕНИЮ:
 * 1. Откройте терминал в папке проекта
 * 2. Выполните: javac Lesson3/ControlFlow.java
 * 3. Затем: java Lesson3.ControlFlow
 * 4. Изучите вывод и комментарии в коде
 */

import java.util.Scanner;

public class ControlFlow {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 3: Управляющие конструкции ===\n");
        
        // ========================================
        // УСЛОВНЫЕ ОПЕРАТОРЫ
        // ========================================
        
        System.out.println("--- УСЛОВНЫЕ ОПЕРАТОРЫ ---");
        
        // Простой if
        int age = 18;
        if (age >= 18) {
            System.out.println("Вы совершеннолетний");
        }
        
        // if-else
        int temperature = 25;
        if (temperature > 30) {
            System.out.println("Жарко!");
        } else {
            System.out.println("Температура комфортная");
        }
        
        // if-else if-else (множественные условия)
        int score = 85;
        if (score >= 90) {
            System.out.println("Отлично! Оценка: A");
        } else if (score >= 80) {
            System.out.println("Хорошо! Оценка: B");
        } else if (score >= 70) {
            System.out.println("Удовлетворительно! Оценка: C");
        } else if (score >= 60) {
            System.out.println("Оценка: D");
        } else {
            System.out.println("Неудовлетворительно! Оценка: F");
        }
        
        // Вложенные if
        boolean isStudent = true;
        boolean hasDiscount = false;
        
        if (isStudent) {
            if (hasDiscount) {
                System.out.println("Студент со скидкой");
            } else {
                System.out.println("Обычный студент");
            }
        } else {
            System.out.println("Не студент");
        }
        
        // ========================================
        // ТЕРНАРНЫЙ ОПЕРАТОР
        // ========================================
        
        System.out.println("\n--- ТЕРНАРНЫЙ ОПЕРАТОР ---");
        
        // Синтаксис: условие ? значение_если_истина : значение_если_ложь
        int number = 7;
        String result = (number % 2 == 0) ? "четное" : "нечетное";
        System.out.println("Число " + number + " - " + result);
        
        // Тернарный оператор для присваивания
        int max = (age > 16) ? age : 16;
        System.out.println("Максимальное значение: " + max);
        
        // ========================================
        // ОПЕРАТОР SWITCH
        // ========================================
        
        System.out.println("\n--- ОПЕРАТОР SWITCH ---");
        
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
            case 7:
                System.out.println("Выходной");
                break;
            default:
                System.out.println("Неверный день недели");
        }
        
        // Switch с выражениями (Java 14+)
        String season = "лето";
        switch (season) {
            case "зима" -> System.out.println("Холодно");
            case "весна" -> System.out.println("Цветут цветы");
            case "лето" -> System.out.println("Жарко");
            case "осень" -> System.out.println("Листья опадают");
            default -> System.out.println("Неизвестное время года");
        }
        
        // ========================================
        // ЦИКЛЫ
        // ========================================
        
        System.out.println("\n--- ЦИКЛЫ ---");
        
        // Цикл for
        System.out.println("Цикл for (1-5):");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Цикл for с шагом
        System.out.println("Цикл for с шагом 2 (0-10):");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Обратный цикл for
        System.out.println("Обратный цикл for (5-1):");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Цикл while
        System.out.println("Цикл while:");
        int count = 0;
        while (count < 3) {
            System.out.println("Счетчик: " + count);
            count++;
        }
        
        // Цикл do-while (выполняется минимум один раз)
        System.out.println("Цикл do-while:");
        int num = 1;
        do {
            System.out.println("Число: " + num);
            num++;
        } while (num <= 3);
        
        // Цикл for-each (для массивов и коллекций)
        System.out.println("Цикл for-each:");
        String[] fruits = {"яблоко", "банан", "апельсин"};
        for (String fruit : fruits) {
            System.out.println("Фрукт: " + fruit);
        }
        
        // ========================================
        // ОПЕРАТОРЫ BREAK И CONTINUE
        // ========================================
        
        System.out.println("\n--- BREAK И CONTINUE ---");
        
        // Оператор break - выход из цикла
        System.out.println("Пример break:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break; // выходим из цикла при i = 6
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Оператор continue - пропуск текущей итерации
        System.out.println("Пример continue (пропускаем четные числа):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // пропускаем четные числа
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Проверка пароля
        String password = "secret123";
        if (password.length() >= 8) {
            if (password.contains("123")) {
                System.out.println("Пароль содержит '123' - небезопасно!");
            } else {
                System.out.println("Пароль достаточно длинный");
            }
        } else {
            System.out.println("Пароль слишком короткий");
        }
        
        // Пример 2: Поиск максимального числа
        int[] numbers = {23, 45, 12, 67, 34, 89, 56};
        int maxNumber = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        System.out.println("Максимальное число в массиве: " + maxNumber);
        
        // Пример 3: Подсчет четных чисел
        int evenCount = 0;
        for (int currentNumber : numbers) {
            if (currentNumber % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println("Количество четных чисел: " + evenCount);
        
        // Пример 4: Простой калькулятор
        System.out.println("\n--- ПРОСТОЙ КАЛЬКУЛЯТОР ---");
        int a = 10, b = 5;
        char operation = '+';
        
        switch (operation) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println(a + " / " + b + " = " + (a / b));
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                }
                break;
            default:
                System.out.println("Неизвестная операция");
        }
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 3 завершен! ===");
        System.out.println("Вы изучили:");
        System.out.println("- Условные операторы (if, else, else if)");
        System.out.println("- Оператор switch");
        System.out.println("- Тернарный оператор");
        System.out.println("- Циклы (for, while, do-while, for-each)");
        System.out.println("- Операторы break и continue");
        System.out.println("\nПереходите к следующему уроку: ArraysAndCollections");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. В switch-case не забывайте break после каждого case
 * 2. Цикл do-while выполняется минимум один раз
 * 3. Оператор break выходит из самого внутреннего цикла
 * 4. Оператор continue пропускает только текущую итерацию
 * 5. Тернарный оператор удобен для простых условий
 * 6. Вложенные условия могут усложнить код
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Напишите программу для определения високосного года
 * 2. Создайте таблицу умножения с помощью вложенных циклов
 * 3. Напишите программу для поиска простых чисел
 * 4. Создайте простую игру "Угадай число"
 */
