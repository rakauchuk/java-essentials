/**
 * Урок 5: Методы и функции
 * 
 * В этом уроке мы изучим:
 * - Создание и вызов методов
 * - Параметры и возвращаемые значения
 * - Перегрузка методов
 * - Рекурсия
 * - Статические методы
 * - Методы с переменным количеством аргументов
 * 
 * ИНСТРУКЦИИ ПО ВЫПОЛНЕНИЮ:
 * 1. Откройте терминал в папке проекта
 * 2. Выполните: javac Lesson5/MethodsAndFunctions.java
 * 3. Затем: java Lesson5.MethodsAndFunctions
 * 4. Изучите вывод и комментарии в коде
 */

public class MethodsAndFunctions {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 5: Методы и функции ===\n");
        
        // Создаем экземпляр класса для вызова нестатических методов
        MethodsAndFunctions calculator = new MethodsAndFunctions();
        
        // ========================================
        // ПРОСТЫЕ МЕТОДЫ
        // ========================================
        
        System.out.println("--- ПРОСТЫЕ МЕТОДЫ ---");
        
        // Вызов статического метода
        printHello();
        
        // Вызов метода с параметрами
        greetPerson("Анна");
        greetPerson("Борис");
        
        // Вызов метода с возвращаемым значением
        int sum = addNumbers(5, 3);
        System.out.println("5 + 3 = " + sum);
        
        double result = multiplyNumbers(4.5, 2.0);
        System.out.println("4.5 * 2.0 = " + result);
        
        // ========================================
        // МЕТОДЫ С РАЗНЫМИ ТИПАМИ ДАННЫХ
        // ========================================
        
        System.out.println("\n--- МЕТОДЫ С РАЗНЫМИ ТИПАМИ ДАННЫХ ---");
        
        // Метод с boolean
        boolean isEven = isEvenNumber(8);
        System.out.println("8 - четное число: " + isEven);
        System.out.println("7 - четное число: " + isEvenNumber(7));
        
        // Метод с String
        String reversed = reverseString("Привет");
        System.out.println("'Привет' наоборот: " + reversed);
        
        // Метод с массивом
        int[] numbers = {1, 2, 3, 4, 5};
        int arraySum = sumArray(numbers);
        System.out.println("Сумма массива: " + arraySum);
        
        // ========================================
        // ПЕРЕГРУЗКА МЕТОДОВ
        // ========================================
        
        System.out.println("\n--- ПЕРЕГРУЗКА МЕТОДОВ ---");
        
        // Разные версии метода add
        System.out.println("add(5, 3) = " + add(5, 3));
        System.out.println("add(5.5, 3.2) = " + add(5.5, 3.2));
        System.out.println("add(5, 3, 2) = " + add(5, 3, 2));
        System.out.println("add(\"Привет\", \" мир\") = " + add("Привет", " мир"));
        
        // ========================================
        // РЕКУРСИЯ
        // ========================================
        
        System.out.println("\n--- РЕКУРСИЯ ---");
        
        // Факториал
        int factorial5 = factorial(5);
        System.out.println("5! = " + factorial5);
        
        // Числа Фибоначчи
        System.out.println("Числа Фибоначчи (первые 10):");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        // ========================================
        // СТАТИЧЕСКИЕ МЕТОДЫ
        // ========================================
        
        System.out.println("\n--- СТАТИЧЕСКИЕ МЕТОДЫ ---");
        
        // Статические методы можно вызывать без создания объекта
        System.out.println("Площадь круга с радиусом 5: " + calculateCircleArea(5));
        System.out.println("Площадь прямоугольника 4x6: " + calculateRectangleArea(4, 6));
        
        // ========================================
        // МЕТОДЫ С ПЕРЕМЕННЫМ КОЛИЧЕСТВОМ АРГУМЕНТОВ
        // ========================================
        
        System.out.println("\n--- МЕТОДЫ С ПЕРЕМЕННЫМ КОЛИЧЕСТВОМ АРГУМЕНТОВ ---");
        
        // Метод с varargs
        System.out.println("Сумма чисел: " + sumVarargs(1, 2, 3, 4, 5));
        System.out.println("Сумма чисел: " + sumVarargs(10, 20));
        System.out.println("Сумма чисел: " + sumVarargs(1));
        System.out.println("Сумма чисел: " + sumVarargs()); // 0 аргументов
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Калькулятор
        System.out.println("=== КАЛЬКУЛЯТОР ===");
        System.out.println("10 + 5 = " + calculator.addCalculator(10, 5));
        System.out.println("10 - 5 = " + calculator.subtract(10, 5));
        System.out.println("10 * 5 = " + calculator.multiply(10, 5));
        System.out.println("10 / 5 = " + calculator.divide(10, 5));
        
        // Пример 2: Проверка простого числа
        System.out.println("\n=== ПРОВЕРКА ПРОСТЫХ ЧИСЕЛ ===");
        int[] testNumbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int num : testNumbers) {
            System.out.println(num + " - простое число: " + isPrime(num));
        }
        
        // Пример 3: Поиск максимального числа
        System.out.println("\n=== ПОИСК МАКСИМАЛЬНОГО ===");
        int max1 = findMax(5, 3, 8, 1, 9);
        System.out.println("Максимальное из 5, 3, 8, 1, 9: " + max1);
        
        // Пример 4: Конвертер температур
        System.out.println("\n=== КОНВЕРТЕР ТЕМПЕРАТУР ===");
        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        
        double fahrenheit2 = 77.0;
        double celsius2 = fahrenheitToCelsius(fahrenheit2);
        System.out.println(fahrenheit2 + "°F = " + celsius2 + "°C");
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 5 завершен! ===");
        System.out.println("Вы изучили:");
        System.out.println("- Создание и вызов методов");
        System.out.println("- Параметры и возвращаемые значения");
        System.out.println("- Перегрузку методов");
        System.out.println("- Рекурсию");
        System.out.println("- Статические методы");
        System.out.println("- Методы с переменным количеством аргументов");
        System.out.println("\nПереходите к следующему уроку: ObjectOrientedProgramming");
    }
    
    // ========================================
    // СТАТИЧЕСКИЕ МЕТОДЫ
    // ========================================
    
    // Простой метод без параметров и возвращаемого значения
    public static void printHello() {
        System.out.println("Привет, мир!");
    }
    
    // Метод с параметром
    public static void greetPerson(String name) {
        System.out.println("Привет, " + name + "!");
    }
    
    // Метод с параметрами и возвращаемым значением
    public static int addNumbers(int a, int b) {
        return a + b;
    }
    
    public static double multiplyNumbers(double a, double b) {
        return a * b;
    }
    
    // Метод с boolean возвращаемым значением
    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
    
    // Метод для работы со строками
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    
    // Метод для работы с массивами
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }
    
    // ========================================
    // ПЕРЕГРУЗКА МЕТОДОВ
    // ========================================
    
    // Перегрузка метода add для разных типов
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static String add(String a, String b) {
        return a + b;
    }
    
    // ========================================
    // РЕКУРСИВНЫЕ МЕТОДЫ
    // ========================================
    
    // Факториал (n!)
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // Числа Фибоначчи
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // ========================================
    // ГЕОМЕТРИЧЕСКИЕ МЕТОДЫ
    // ========================================
    
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    public static double calculateRectangleArea(double width, double height) {
        return width * height;
    }
    
    // ========================================
    // МЕТОДЫ С VARARGS
    // ========================================
    
    public static int sumVarargs(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    
    // ========================================
    // НЕСТАТИЧЕСКИЕ МЕТОДЫ (КАЛЬКУЛЯТОР)
    // ========================================
    
    public int addCalculator(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль!");
            return 0;
        }
        return (double) a / b;
    }
    
    // ========================================
    // УТИЛИТАРНЫЕ МЕТОДЫ
    // ========================================
    
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int findMax(int... numbers) {
        if (numbers.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Статические методы принадлежат классу, не объекту
 * 2. Нестатические методы требуют создания объекта
 * 3. Перегрузка методов - разные сигнатуры, одинаковое имя
 * 4. Рекурсия должна иметь условие выхода
 * 5. Varargs позволяют передавать переменное количество аргументов
 * 6. Методы делают код более читаемым и переиспользуемым
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте метод для вычисления НОД двух чисел
 * 2. Напишите метод для сортировки массива
 * 3. Создайте метод для проверки палиндрома
 * 4. Реализуйте метод для конвертации валют
 */
