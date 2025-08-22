/**
 * Урок 2: Переменные и типы данных
 * 
 * В этом уроке мы изучим:
 * - Примитивные типы данных
 * - Ссылочные типы данных
 * - Объявление и инициализацию переменных
 * - Преобразование типов
 * - Константы
 * 
 * ИНСТРУКЦИИ ПО ВЫПОЛНЕНИЮ:
 * 1. Откройте терминал в папке проекта
 * 2. Выполните: javac Lesson2/VariablesAndDataTypes.java
 * 3. Затем: java Lesson2.VariablesAndDataTypes
 * 4. Изучите вывод и комментарии в коде
 */

public class VariablesAndDataTypes {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 2: Переменные и типы данных ===\n");
        
        // ========================================
        // ПРИМИТИВНЫЕ ТИПЫ ДАННЫХ
        // ========================================
        
        System.out.println("--- ПРИМИТИВНЫЕ ТИПЫ ДАННЫХ ---");
        
        // 1. ЦЕЛЫЕ ЧИСЛА
        
        // byte - 8 бит, диапазон от -128 до 127
        byte smallNumber = 127;
        System.out.println("byte: " + smallNumber + " (размер: 8 бит)");
        
        // short - 16 бит, диапазон от -32,768 до 32,767
        short mediumNumber = 32000;
        System.out.println("short: " + mediumNumber + " (размер: 16 бит)");
        
        // int - 32 бита, диапазон от -2^31 до 2^31-1 (наиболее используемый)
        int normalNumber = 2147483647;
        System.out.println("int: " + normalNumber + " (размер: 32 бита)");
        
        // long - 64 бита, для больших чисел
        long bigNumber = 9223372036854775807L; // L в конце обязательно!
        System.out.println("long: " + bigNumber + " (размер: 64 бита)");
        
        // 2. ЧИСЛА С ПЛАВАЮЩЕЙ ТОЧКОЙ
        
        // float - 32 бита, точность ~7 знаков
        float decimalNumber = 3.14159f; // f в конце обязательно!
        System.out.println("float: " + decimalNumber + " (размер: 32 бита)");
        
        // double - 64 бита, точность ~15 знаков (по умолчанию)
        double preciseNumber = 3.141592653589793;
        System.out.println("double: " + preciseNumber + " (размер: 64 бита)");
        
        // 3. СИМВОЛЫ
        
        // char - 16 бит, один символ Unicode
        char letter = 'A';
        char unicodeChar = '\u0041'; // Unicode для 'A'
        System.out.println("char: " + letter + " (Unicode: " + unicodeChar + ")");
        
        // 4. ЛОГИЧЕСКИЙ ТИП
        
        // boolean - true или false
        boolean isJavaFun = true;
        boolean isLearning = true;
        System.out.println("boolean: " + isJavaFun + " (размер: зависит от JVM)");
        
        // ========================================
        // ССЫЛОЧНЫЕ ТИПЫ ДАННЫХ
        // ========================================
        
        System.out.println("\n--- ССЫЛОЧНЫЕ ТИПЫ ДАННЫХ ---");
        
        // String - строка (самый популярный ссылочный тип)
        String message = "Привет, Java!";
        String emptyString = ""; // пустая строка
        String nullString = null; // null - отсутствие значения
        
        System.out.println("String: \"" + message + "\"");
        System.out.println("Пустая строка: \"" + emptyString + "\"");
        System.out.println("null строка: " + nullString);
        
        // Массивы (изучим подробнее в уроке 4)
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        
        // ========================================
        // ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ
        // ========================================
        
        System.out.println("\n--- ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ ---");
        
        // Способ 1: Объявление и инициализация в одной строке
        int age = 25;
        String name = "Анна";
        
        // Способ 2: Объявление, затем инициализация
        int height;
        height = 170; // инициализация позже
        
        // Способ 3: Объявление нескольких переменных одного типа
        int x = 10, y = 20, z = 30;
        
        System.out.println("Возраст: " + age);
        System.out.println("Имя: " + name);
        System.out.println("Рост: " + height);
        System.out.println("x=" + x + ", y=" + y + ", z=" + z);
        
        // ========================================
        // ПРЕОБРАЗОВАНИЕ ТИПОВ
        // ========================================
        
        System.out.println("\n--- ПРЕОБРАЗОВАНИЕ ТИПОВ ---");
        
        // Автоматическое преобразование (расширение)
        int intValue = 100;
        long longValue = intValue; // int -> long (автоматически)
        float floatValue = longValue; // long -> float (автоматически)
        
        System.out.println("int -> long: " + intValue + " -> " + longValue);
        System.out.println("long -> float: " + longValue + " -> " + floatValue);
        
        // Явное преобразование (сужение)
        double doubleValue = 9.99;
        int intFromDouble = (int) doubleValue; // double -> int (явно)
        byte byteFromInt = (byte) intValue; // int -> byte (явно)
        
        System.out.println("double -> int: " + doubleValue + " -> " + intFromDouble);
        System.out.println("int -> byte: " + intValue + " -> " + byteFromInt);
        
        // Преобразование строк
        String numberString = "42";
        int numberFromString = Integer.parseInt(numberString);
        double doubleFromString = Double.parseDouble("3.14");
        
        System.out.println("String -> int: \"" + numberString + "\" -> " + numberFromString);
        System.out.println("String -> double: \"3.14\" -> " + doubleFromString);
        
        // ========================================
        // КОНСТАНТЫ
        // ========================================
        
        System.out.println("\n--- КОНСТАНТЫ ---");
        
        // final - ключевое слово для создания констант
        final double PI = 3.14159;
        final String GREETING = "Добро пожаловать!";
        final int MAX_SIZE = 100;
        
        System.out.println("Константа PI: " + PI);
        System.out.println("Константа GREETING: " + GREETING);
        System.out.println("Константа MAX_SIZE: " + MAX_SIZE);
        
        // Попытка изменить константу вызовет ошибку компиляции:
        // PI = 3.14; // ОШИБКА! Константу нельзя изменить
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример: Калькулятор площади круга
        final double PI_CALC = 3.14159;
        double radius = 5.0;
        double area = PI_CALC * radius * radius;
        
        System.out.println("Радиус круга: " + radius);
        System.out.println("Площадь круга: " + area);
        
        // Пример: Работа с персонами
        String firstName = "Иван";
        String lastName = "Петров";
        int personAge = 30;
        double personHeight = 1.75;
        boolean isStudent = false;
        
        System.out.println("\nИнформация о человеке:");
        System.out.println("Имя: " + firstName + " " + lastName);
        System.out.println("Возраст: " + personAge + " лет");
        System.out.println("Рост: " + personHeight + " м");
        System.out.println("Студент: " + (isStudent ? "Да" : "Нет"));
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 2 завершен! ===");
        System.out.println("Вы изучили:");
        System.out.println("- Примитивные типы данных (8 типов)");
        System.out.println("- Ссылочные типы данных");
        System.out.println("- Объявление и инициализацию переменных");
        System.out.println("- Преобразование типов");
        System.out.println("- Константы");
        System.out.println("\nПереходите к следующему уроку: ControlFlow");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Примитивные типы хранят значения напрямую
 * 2. Ссылочные типы хранят ссылки на объекты
 * 3. По умолчанию дробные числа имеют тип double
 * 4. Для float нужно добавлять 'f' в конце
 * 5. Для long нужно добавлять 'L' в конце
 * 6. Переменные должны быть инициализированы перед использованием
 * 7. Имена переменных должны начинаться с буквы или '_'
 * 8. Java чувствителен к регистру
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте переменные всех примитивных типов
 * 2. Попробуйте различные преобразования типов
 * 3. Создайте константы для часто используемых значений
 * 4. Напишите программу для расчета площади прямоугольника
 */
