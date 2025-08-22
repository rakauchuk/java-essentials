/**
 * Урок 11: Обобщения (Generics)
 * 
 * В этом уроке мы изучим:
 * - Обобщенные классы
 * - Обобщенные методы
 * - Ограничения типов (bounds)
 * - Wildcards (подстановочные знаки)
 * - Обобщенные коллекции
 * - Type erasure
 */

import java.util.*;

public class Generics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 11: Обобщения (Generics) ===\n");
        
        // ========================================
        // ОБОБЩЕННЫЕ КЛАССЫ
        // ========================================
        
        System.out.println("--- ОБОБЩЕННЫЕ КЛАССЫ ---");
        
        // Создание обобщенных объектов
        Box<String> stringBox = new Box<>("Привет, мир!");
        Box<Integer> intBox = new Box<>(42);
        Box<Double> doubleBox = new Box<>(3.14);
        
        System.out.println("stringBox: " + stringBox);
        System.out.println("intBox: " + intBox);
        System.out.println("doubleBox: " + doubleBox);
        
        // Получение значений
        String str = stringBox.getContent();
        Integer num = intBox.getContent();
        Double dbl = doubleBox.getContent();
        
        System.out.println("Строка: " + str);
        System.out.println("Число: " + num);
        System.out.println("Дробное: " + dbl);
        
        // ========================================
        // ОБОБЩЕННЫЕ МЕТОДЫ
        // ========================================
        
        System.out.println("\n--- ОБОБЩЕННЫЕ МЕТОДЫ ---");
        
        // Использование обобщенных методов
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"яблоко", "банан", "апельсин"};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        
        System.out.println("Максимум в intArray: " + findMax(intArray));
        System.out.println("Максимум в stringArray: " + findMax(stringArray));
        System.out.println("Максимум в doubleArray: " + findMax(doubleArray));
        
        // Обмен элементов
        System.out.println("До обмена: " + Arrays.toString(intArray));
        swap(intArray, 0, 4);
        System.out.println("После обмена: " + Arrays.toString(intArray));
        
        // ========================================
        // ОГРАНИЧЕНИЯ ТИПОВ
        // ========================================
        
        System.out.println("\n--- ОГРАНИЧЕНИЯ ТИПОВ ---");
        
        // Создание объектов с ограничениями
        NumberBox<Integer> intNumberBox = new NumberBox<>(100);
        NumberBox<Double> doubleNumberBox = new NumberBox<>(99.9);
        // NumberBox<String> stringNumberBox = new NumberBox<>("текст"); // Ошибка!
        
        System.out.println("intNumberBox: " + intNumberBox);
        System.out.println("doubleNumberBox: " + doubleNumberBox);
        
        System.out.println("Сумма intNumberBox: " + intNumberBox.getSum());
        System.out.println("Сумма doubleNumberBox: " + doubleNumberBox.getSum());
        
        // ========================================
        // WILDCARDS
        // ========================================
        
        System.out.println("\n--- WILDCARDS ---");
        
        // Создание списков
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<String> stringList = Arrays.asList("один", "два", "три");
        
        // Использование wildcards
        System.out.println("Сумма intList: " + sumOfList(intList));
        System.out.println("Сумма doubleList: " + sumOfList(doubleList));
        // System.out.println("Сумма stringList: " + sumOfList(stringList)); // Ошибка!
        
        // Вывод списков
        printList(intList);
        printList(doubleList);
        printList(stringList);
        
        // ========================================
        // ОБОБЩЕННЫЕ КОЛЛЕКЦИИ
        // ========================================
        
        System.out.println("\n--- ОБОБЩЕННЫЕ КОЛЛЕКЦИИ ---");
        
        // ArrayList с обобщениями
        ArrayList<String> names = new ArrayList<>();
        names.add("Анна");
        names.add("Борис");
        names.add("Вера");
        
        System.out.println("Имена: " + names);
        
        // HashMap с обобщениями
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Анна", 25);
        ages.put("Борис", 30);
        ages.put("Вера", 28);
        
        System.out.println("Возрасты: " + ages);
        
        // HashSet с обобщениями
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1); // Дубликат не добавится
        
        System.out.println("Числа: " + numbers);
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Стек
        System.out.println("=== СТЕК ===");
        
        Stack<String> stringStack = new Stack<>();
        stringStack.push("первый");
        stringStack.push("второй");
        stringStack.push("третий");
        
        System.out.println("Стек: " + stringStack);
        System.out.println("Верхний элемент: " + stringStack.peek());
        System.out.println("Извлечен: " + stringStack.pop());
        System.out.println("Стек после извлечения: " + stringStack);
        
        // Пример 2: Пара
        System.out.println("\n=== ПАРА ===");
        
        Pair<String, Integer> nameAge = new Pair<>("Иван", 25);
        Pair<Double, Double> coordinates = new Pair<>(10.5, 20.3);
        
        System.out.println("nameAge: " + nameAge);
        System.out.println("coordinates: " + coordinates);
        
        // Пример 3: Кэш
        System.out.println("\n=== КЭШ ===");
        
        Cache<String, String> cache = new Cache<>();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        
        System.out.println("Кэш: " + cache);
        System.out.println("Значение для key2: " + cache.get("key2"));
        System.out.println("Значение для key4: " + cache.get("key4"));
        
        // ========================================
        // TYPE ERASURE
        // ========================================
        
        System.out.println("\n--- TYPE ERASURE ---");
        
        // Демонстрация type erasure
        Box<String> stringBox2 = new Box<>("тест");
        Box<Integer> intBox2 = new Box<>(123);
        
        System.out.println("Тип stringBox2: " + stringBox2.getClass().getName());
        System.out.println("Тип intBox2: " + intBox2.getClass().getName());
        System.out.println("Типы одинаковые: " + (stringBox2.getClass() == intBox2.getClass()));
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 11 завершен! ===");
        System.out.println("Вы изучили обобщения (Generics)!");
    }
    
    // ========================================
    // ОБОБЩЕННЫЕ МЕТОДЫ
    // ========================================
    
    // Обобщенный метод для поиска максимума
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
    
    // Обобщенный метод для обмена элементов
    public static <T> void swap(T[] array, int i, int j) {
        if (array == null || i < 0 || j < 0 || i >= array.length || j >= array.length) {
            return;
        }
        
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // Метод с wildcard для суммирования чисел
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    // Метод с wildcard для вывода любого списка
    public static void printList(List<?> list) {
        System.out.println("Список: " + list);
    }
}

// ========================================
// ОБОБЩЕННЫЕ КЛАССЫ
// ========================================

// Простой обобщенный класс
class Box<T> {
    private T content;
    
    public Box(T content) {
        this.content = content;
    }
    
    public T getContent() {
        return content;
    }
    
    public void setContent(T content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "Box{content=" + content + "}";
    }
}

// Обобщенный класс с ограничением
class NumberBox<T extends Number> {
    private List<T> numbers;
    
    public NumberBox(T... numbers) {
        this.numbers = new ArrayList<>(Arrays.asList(numbers));
    }
    
    public void add(T number) {
        numbers.add(number);
    }
    
    public double getSum() {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    @Override
    public String toString() {
        return "NumberBox{numbers=" + numbers + "}";
    }
}

// ========================================
// ПРАКТИЧЕСКИЕ ПРИМЕРЫ
// ========================================

// Обобщенный стек
class Stack<T> {
    private List<T> elements;
    
    public Stack() {
        this.elements = new ArrayList<>();
    }
    
    public void push(T element) {
        elements.add(element);
    }
    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return elements.get(elements.size() - 1);
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    public int size() {
        return elements.size();
    }
    
    @Override
    public String toString() {
        return "Stack{elements=" + elements + "}";
    }
}

// Обобщенная пара
class Pair<T, U> {
    private T first;
    private U second;
    
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    
    public T getFirst() {
        return first;
    }
    
    public U getSecond() {
        return second;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
    public void setSecond(U second) {
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "Pair{first=" + first + ", second=" + second + "}";
    }
}

// Обобщенный кэш
class Cache<K, V> {
    private Map<K, V> cache;
    
    public Cache() {
        this.cache = new HashMap<>();
    }
    
    public void put(K key, V value) {
        cache.put(key, value);
    }
    
    public V get(K key) {
        return cache.get(key);
    }
    
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
    
    public void remove(K key) {
        cache.remove(key);
    }
    
    public int size() {
        return cache.size();
    }
    
    public void clear() {
        cache.clear();
    }
    
    @Override
    public String toString() {
        return "Cache{cache=" + cache + "}";
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Обобщения обеспечивают типобезопасность на этапе компиляции
 * 2. Type erasure означает, что информация о типах стирается во время выполнения
 * 3. Wildcards (?) позволяют работать с неизвестными типами
 * 4. Ограничения типов (extends) ограничивают возможные типы
 * 5. Обобщения нельзя использовать с примитивными типами
 * 6. Обобщения делают код более переиспользуемым и безопасным
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте обобщенный класс для работы с деревом
 * 2. Реализуйте обобщенный метод для сортировки массивов
 * 3. Создайте обобщенный класс для работы с матрицами
 * 4. Добавьте ограничения для числовых типов
 */
