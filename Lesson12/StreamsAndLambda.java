/**
 * Урок 12: Потоки и лямбда-выражения
 * 
 * В этом уроке мы изучим:
 * - Лямбда-выражения
 * - Функциональные интерфейсы
 * - Stream API
 * - Методы потоков (filter, map, reduce)
 */

import java.util.*;
import java.util.stream.*;

public class StreamsAndLambda {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 12: Потоки и лямбда-выражения ===\n");
        
        // Лямбда-выражения
        System.out.println("--- ЛЯМБДА-ВЫРАЖЕНИЯ ---");
        
        // Старый способ с анонимным классом
        MathOperation oldWay = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        
        // Новый способ с лямбда-выражением
        MathOperation lambdaWay = (a, b) -> a + b;
        
        System.out.println("Старый способ: " + oldWay.operate(5, 3));
        System.out.println("Лямбда-выражение: " + lambdaWay.operate(5, 3));
        
        // Различные лямбда-выражения
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        
        System.out.println("10 + 5 = " + addition.operate(10, 5));
        System.out.println("10 - 5 = " + subtraction.operate(10, 5));
        System.out.println("10 * 5 = " + multiplication.operate(10, 5));
        
        // Функциональные интерфейсы
        System.out.println("\n--- ФУНКЦИОНАЛЬНЫЕ ИНТЕРФЕЙСЫ ---");
        
        // Predicate - проверяет условие
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        
        System.out.println("4 четное: " + isEven.test(4));
        System.out.println("5 четное: " + isEven.test(5));
        System.out.println("10 положительное: " + isPositive.test(10));
        
        // Function - преобразует значение
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, String> numberToString = n -> "Число: " + n;
        
        System.out.println("Длина 'Привет': " + stringLength.apply("Привет"));
        System.out.println("Преобразование 42: " + numberToString.apply(42));
        
        // Consumer - выполняет действие
        Consumer<String> printer = s -> System.out.println("Печать: " + s);
        printer.accept("Тестовое сообщение");
        
        // Stream API
        System.out.println("\n--- STREAM API ---");
        
        // Создание списка
        List<String> names = Arrays.asList("Анна", "Борис", "Вера", "Григорий", "Дарья");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Исходный список имен: " + names);
        System.out.println("Исходный список чисел: " + numbers);
        
        // Фильтрация
        System.out.println("\nФильтрация имен, начинающихся с 'А':");
        List<String> filteredNames = names.stream()
            .filter(name -> name.startsWith("А"))
            .collect(Collectors.toList());
        System.out.println(filteredNames);
        
        // Преобразование
        System.out.println("\nПреобразование имен в верхний регистр:");
        List<String> upperNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(upperNames);
        
        // Фильтрация и преобразование
        System.out.println("\nЧетные числа, умноженные на 2:");
        List<Integer> doubledEvens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println(doubledEvens);
        
        // Методы потоков
        System.out.println("\n--- МЕТОДЫ ПОТОКОВ ---");
        
        // forEach
        System.out.println("Вывод всех имен:");
        names.stream().forEach(name -> System.out.println("  " + name));
        
        // count
        long count = names.stream().filter(name -> name.length() > 4).count();
        System.out.println("Количество имен длиннее 4 символов: " + count);
        
        // anyMatch, allMatch
        boolean anyStartsWithA = names.stream().anyMatch(name -> name.startsWith("А"));
        boolean allHaveLength4 = names.stream().allMatch(name -> name.length() == 4);
        
        System.out.println("Есть ли имя на 'А': " + anyStartsWithA);
        System.out.println("Все ли имена длиной 4: " + allHaveLength4);
        
        // Reduce
        System.out.println("\n--- REDUCE ---");
        
        // Сумма чисел
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Сумма чисел: " + sum);
        
        // Максимальное значение
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Максимальное число: " + max.orElse(0));
        
        // Коллекторы
        System.out.println("\n--- КОЛЛЕКТОРЫ ---");
        
        // toList, toSet
        List<String> nameList = names.stream().collect(Collectors.toList());
        Set<String> nameSet = names.stream().collect(Collectors.toSet());
        
        System.out.println("Список имен: " + nameList);
        System.out.println("Множество имен: " + nameSet);
        
        // joining
        String joinedNames = names.stream().collect(Collectors.joining(", "));
        System.out.println("Объединенные имена: " + joinedNames);
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Работа с сотрудниками
        System.out.println("=== РАБОТА С СОТРУДНИКАМИ ===");
        
        List<Employee> employees = Arrays.asList(
            new Employee("Анна", 25, 50000),
            new Employee("Борис", 30, 60000),
            new Employee("Вера", 28, 55000),
            new Employee("Григорий", 35, 70000),
            new Employee("Дарья", 22, 45000)
        );
        
        // Средняя зарплата
        double avgSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
        System.out.println("Средняя зарплата: " + avgSalary);
        
        // Сотрудники с зарплатой выше средней
        List<Employee> highEarners = employees.stream()
            .filter(emp -> emp.getSalary() > avgSalary)
            .collect(Collectors.toList());
        System.out.println("Сотрудники с высокой зарплатой: " + highEarners);
        
        System.out.println("\n=== Урок 12 завершен! ===");
        System.out.println("Вы изучили потоки и лямбда-выражения!");
    }
}

// Функциональные интерфейсы
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

// Практические примеры
class Employee {
    private String name;
    private int age;
    private double salary;
    
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return name + "(" + age + " лет, " + salary + " руб.)";
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Лямбда-выражения делают код более читаемым и компактным
 * 2. Функциональные интерфейсы имеют только один абстрактный метод
 * 3. Stream API позволяет работать с коллекциями в функциональном стиле
 * 4. Потоки бывают последовательными и параллельными
 * 5. Коллекторы позволяют собирать результаты потоков в различные структуры
 * 6. Лямбда-выражения и потоки появились в Java 8
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте поток для обработки списка строк
 * 2. Реализуйте собственный функциональный интерфейс
 * 3. Используйте параллельные потоки для больших вычислений
 * 4. Создайте сложные цепочки операций с потоками
 */
