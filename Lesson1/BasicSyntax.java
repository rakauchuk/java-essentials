/**
 * Урок 1: Основы синтаксиса Java
 * 
 * В этом уроке мы изучим:
 * - Структуру Java программы
 * - Основные элементы синтаксиса
 * - Комментарии
 * - Первую программу "Hello World"
 * 
 * ИНСТРУКЦИИ ПО ВЫПОЛНЕНИЮ:
 * 1. Откройте терминал в папке проекта
 * 2. Выполните: javac Lesson1/BasicSyntax.java
 * 3. Затем: java Lesson1.BasicSyntax
 * 4. Изучите вывод и комментарии в коде
 */

// Это однострочный комментарий - начинается с //

/*
 * Это многострочный комментарий
 * Может занимать несколько строк
 * Очень полезен для подробных объяснений
 */

/**
 * Это документационный комментарий (JavaDoc)
 * Используется для автоматической генерации документации
 */

// Каждый Java файл должен содержать класс с именем, совпадающим с именем файла
public class BasicSyntax {
    
    // Главный метод - точка входа в программу
    // public - модификатор доступа (доступен извне)
    // static - метод принадлежит классу, а не объекту
    // void - метод не возвращает значение
    // main - имя метода (должно быть именно "main")
    // String[] args - массив строк с аргументами командной строки
    public static void main(String[] args) {
        
        // Вывод текста в консоль
        // System.out.println() - метод для вывода с переносом строки
        System.out.println("Привет, мир! Hello World!");
        
        // System.out.print() - вывод без переноса строки
        System.out.print("Этот текст ");
        System.out.print("будет в одной строке");
        System.out.println(); // пустая строка
        
        // Вывод с форматированием
        System.out.println("=== Основы синтаксиса Java ===");
        
        // Переменные (изучим подробнее в следующем уроке)
        String name = "Java";
        int version = 17;
        
        // Вывод переменных
        System.out.println("Язык программирования: " + name);
        System.out.println("Версия: " + version);
        
        // Математические операции
        int a = 10;
        int b = 5;
        
        System.out.println("\n=== Математические операции ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Сложение: " + a + " + " + b + " = " + (a + b));
        System.out.println("Вычитание: " + a + " - " + b + " = " + (a - b));
        System.out.println("Умножение: " + a + " * " + b + " = " + (a * b));
        System.out.println("Деление: " + a + " / " + b + " = " + (a / b));
        System.out.println("Остаток от деления: " + a + " % " + b + " = " + (a % b));
        
        // Логические операции
        System.out.println("\n=== Логические операции ===");
        boolean isTrue = true;
        boolean isFalse = false;
        
        System.out.println("true && true = " + (isTrue && isTrue));
        System.out.println("true && false = " + (isTrue && isFalse));
        System.out.println("true || false = " + (isTrue || isFalse));
        System.out.println("!true = " + (!isTrue));
        
        // Сравнения
        System.out.println("\n=== Операции сравнения ===");
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        
        // Завершающее сообщение
        System.out.println("\n=== Урок 1 завершен! ===");
        System.out.println("Поздравляем! Вы изучили основы синтаксиса Java.");
        System.out.println("Переходите к следующему уроку: VariablesAndDataTypes");
    }
}

/*
 * ВАЖНЫЕ ПРАВИЛА СИНТАКСИСА JAVA:
 * 
 * 1. Каждая инструкция заканчивается точкой с запятой (;)
 * 2. Фигурные скобки {} определяют блоки кода
 * 3. Имена классов начинаются с заглавной буквы (PascalCase)
 * 4. Имена методов и переменных начинаются с маленькой буквы (camelCase)
 * 5. Java чувствителен к регистру (a и A - разные переменные)
 * 6. Пробелы и переносы строк игнорируются компилятором
 * 7. Комментарии не выполняются, они только для чтения
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Измените текст в System.out.println()
 * 2. Добавьте новые математические операции
 * 3. Создайте свои переменные
 * 4. Поэкспериментируйте с логическими операциями
 */
