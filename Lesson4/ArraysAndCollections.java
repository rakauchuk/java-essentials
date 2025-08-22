/**
 * Урок 4: Массивы и коллекции
 * 
 * В этом уроке мы изучим:
 * - Одномерные и многомерные массивы
 * - Создание и инициализацию массивов
 * - Работа с массивами
 * - Основные коллекции (ArrayList, LinkedList, HashSet, HashMap)
 * - Методы работы с коллекциями
 * 
 * ИНСТРУКЦИИ ПО ВЫПОЛНЕНИЮ:
 * 1. Откройте терминал в папке проекта
 * 2. Выполните: javac Lesson4/ArraysAndCollections.java
 * 3. Затем: java Lesson4.ArraysAndCollections
 * 4. Изучите вывод и комментарии в коде
 */

import java.util.*;

public class ArraysAndCollections {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 4: Массивы и коллекции ===\n");
        
        // ========================================
        // ОДНОМЕРНЫЕ МАССИВЫ
        // ========================================
        
        System.out.println("--- ОДНОМЕРНЫЕ МАССИВЫ ---");
        
        // Способ 1: Объявление и инициализация
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Массив numbers: " + Arrays.toString(numbers));
        
        // Способ 2: Объявление с указанием размера
        String[] names = new String[3];
        names[0] = "Анна";
        names[1] = "Борис";
        names[2] = "Вера";
        System.out.println("Массив names: " + Arrays.toString(names));
        
        // Способ 3: Объявление и создание
        double[] prices = new double[]{10.5, 20.3, 15.7, 8.9};
        System.out.println("Массив prices: " + Arrays.toString(prices));
        
        // Доступ к элементам массива
        System.out.println("Первый элемент numbers: " + numbers[0]);
        System.out.println("Последний элемент names: " + names[names.length - 1]);
        
        // Длина массива
        System.out.println("Длина массива numbers: " + numbers.length);
        
        // Перебор массива
        System.out.println("Перебор массива numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Элемент " + i + ": " + numbers[i]);
        }
        
        // Перебор с помощью for-each
        System.out.println("Перебор с for-each:");
        for (String name : names) {
            System.out.println("Имя: " + name);
        }
        
        // ========================================
        // МНОГОМЕРНЫЕ МАССИВЫ
        // ========================================
        
        System.out.println("\n--- МНОГОМЕРНЫЕ МАССИВЫ ---");
        
        // Двумерный массив (матрица)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Двумерный массив:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Создание двумерного массива с указанием размеров
        int[][] table = new int[2][3];
        table[0][0] = 10;
        table[0][1] = 20;
        table[0][2] = 30;
        table[1][0] = 40;
        table[1][1] = 50;
        table[1][2] = 60;
        
        System.out.println("Таблица:");
        for (int[] row : table) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        // ========================================
        // ARRAYLIST (ДИНАМИЧЕСКИЙ МАССИВ)
        // ========================================
        
        System.out.println("\n--- ARRAYLIST ---");
        
        // Создание ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        
        // Добавление элементов
        fruits.add("яблоко");
        fruits.add("банан");
        fruits.add("апельсин");
        fruits.add("груша");
        
        System.out.println("ArrayList fruits: " + fruits);
        System.out.println("Размер: " + fruits.size());
        
        // Доступ к элементам
        System.out.println("Первый фрукт: " + fruits.get(0));
        System.out.println("Последний фрукт: " + fruits.get(fruits.size() - 1));
        
        // Изменение элемента
        fruits.set(1, "киви");
        System.out.println("После изменения: " + fruits);
        
        // Удаление элемента
        fruits.remove(2);
        System.out.println("После удаления: " + fruits);
        
        // Проверка наличия элемента
        System.out.println("Содержит 'яблоко': " + fruits.contains("яблоко"));
        System.out.println("Содержит 'виноград': " + fruits.contains("виноград"));
        
        // Перебор ArrayList
        System.out.println("Перебор ArrayList:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        // Создание ArrayList с начальными элементами
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("ArrayList с числами: " + numbersList);
        
        // ========================================
        // LINKEDLIST (СВЯЗАННЫЙ СПИСОК)
        // ========================================
        
        System.out.println("\n--- LINKEDLIST ---");
        
        LinkedList<String> colors = new LinkedList<>();
        colors.add("красный");
        colors.add("зеленый");
        colors.add("синий");
        
        System.out.println("LinkedList colors: " + colors);
        
        // Добавление в начало и конец
        colors.addFirst("желтый");
        colors.addLast("фиолетовый");
        System.out.println("После добавления: " + colors);
        
        // Удаление первого и последнего элемента
        String firstColor = colors.removeFirst();
        String lastColor = colors.removeLast();
        System.out.println("Удалены: " + firstColor + ", " + lastColor);
        System.out.println("Результат: " + colors);
        
        // ========================================
        // HASHSET (МНОЖЕСТВО)
        // ========================================
        
        System.out.println("\n--- HASHSET ---");
        
        HashSet<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Анна");
        uniqueNames.add("Борис");
        uniqueNames.add("Анна"); // дубликат не добавится
        uniqueNames.add("Вера");
        uniqueNames.add("Борис"); // дубликат не добавится
        
        System.out.println("HashSet uniqueNames: " + uniqueNames);
        System.out.println("Размер: " + uniqueNames.size());
        
        // Проверка наличия элемента
        System.out.println("Содержит 'Анна': " + uniqueNames.contains("Анна"));
        
        // Удаление элемента
        uniqueNames.remove("Борис");
        System.out.println("После удаления: " + uniqueNames);
        
        // ========================================
        // HASHMAP (СЛОВАРЬ)
        // ========================================
        
        System.out.println("\n--- HASHMAP ---");
        
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Анна", 25);
        ages.put("Борис", 30);
        ages.put("Вера", 28);
        ages.put("Григорий", 35);
        
        System.out.println("HashMap ages: " + ages);
        
        // Доступ к значению по ключу
        System.out.println("Возраст Анны: " + ages.get("Анна"));
        System.out.println("Возраст Петра: " + ages.get("Петр")); // null
        
        // Проверка наличия ключа
        System.out.println("Содержит ключ 'Анна': " + ages.containsKey("Анна"));
        System.out.println("Содержит значение 30: " + ages.containsValue(30));
        
        // Изменение значения
        ages.put("Анна", 26); // обновление существующего ключа
        System.out.println("После изменения: " + ages);
        
        // Удаление пары ключ-значение
        ages.remove("Борис");
        System.out.println("После удаления: " + ages);
        
        // Перебор HashMap
        System.out.println("Перебор HashMap:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " лет");
        }
        
        // Перебор только ключей
        System.out.println("Ключи: " + ages.keySet());
        
        // Перебор только значений
        System.out.println("Значения: " + ages.values());
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Поиск максимального и минимального значения
        int[] scores = {85, 92, 78, 96, 88, 91};
        int maxScore = scores[0];
        int minScore = scores[0];
        
        for (int score : scores) {
            if (score > maxScore) maxScore = score;
            if (score < minScore) minScore = score;
        }
        
        System.out.println("Оценки: " + Arrays.toString(scores));
        System.out.println("Максимальная оценка: " + maxScore);
        System.out.println("Минимальная оценка: " + minScore);
        
        // Пример 2: Подсчет частоты элементов
        String[] words = {"яблоко", "банан", "яблоко", "апельсин", "банан", "яблоко"};
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Слова: " + Arrays.toString(words));
        System.out.println("Частота слов: " + wordCount);
        
        // Пример 3: Фильтрация четных чисел
        ArrayList<Integer> allNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        
        for (int number : allNumbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        
        System.out.println("Все числа: " + allNumbers);
        System.out.println("Четные числа: " + evenNumbers);
        
        // Пример 4: Создание телефонной книги
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Анна", "+7-123-456-7890");
        phoneBook.put("Борис", "+7-234-567-8901");
        phoneBook.put("Вера", "+7-345-678-9012");
        
        System.out.println("\nТелефонная книга:");
        for (Map.Entry<String, String> contact : phoneBook.entrySet()) {
            System.out.println(contact.getKey() + ": " + contact.getValue());
        }
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 4 завершен! ===");
        System.out.println("Вы изучили:");
        System.out.println("- Одномерные и многомерные массивы");
        System.out.println("- ArrayList (динамический массив)");
        System.out.println("- LinkedList (связанный список)");
        System.out.println("- HashSet (множество)");
        System.out.println("- HashMap (словарь)");
        System.out.println("- Методы работы с коллекциями");
        System.out.println("\nПереходите к следующему уроку: MethodsAndFunctions");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Массивы имеют фиксированный размер
 * 2. ArrayList автоматически расширяется
 * 3. HashSet хранит только уникальные элементы
 * 4. HashMap хранит пары ключ-значение
 * 5. Индексы массивов начинаются с 0
 * 6. Коллекции более гибкие, чем массивы
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте массив и найдите среднее значение
 * 2. Напишите программу для сортировки массива
 * 3. Создайте простую базу данных студентов
 * 4. Реализуйте поиск по телефонной книге
 */
