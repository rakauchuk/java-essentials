/**
 * Урок 9: Обработка исключений
 * 
 * В этом уроке мы изучим:
 * - Типы исключений (checked и unchecked)
 * - Блоки try-catch
 * - Блок finally
 * - Множественные catch блоки
 * - Создание собственных исключений
 * - Ключевое слово throws
 */

public class ExceptionHandling {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 9: Обработка исключений ===\n");
        
        // ========================================
        // ПРОСТАЯ ОБРАБОТКА ИСКЛЮЧЕНИЙ
        // ========================================
        
        System.out.println("--- ПРОСТАЯ ОБРАБОТКА ИСКЛЮЧЕНИЙ ---");
        
        // Пример с делением на ноль
        try {
            int result = 10 / 0;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль!");
            System.out.println("Сообщение: " + e.getMessage());
        }
        
        // Пример с массивом
        int[] numbers = {1, 2, 3, 4, 5};
        try {
            System.out.println("Элемент с индексом 10: " + numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: индекс выходит за границы массива!");
            System.out.println("Сообщение: " + e.getMessage());
        }
        
        // ========================================
        // МНОЖЕСТВЕННЫЕ CATCH БЛОКИ
        // ========================================
        
        System.out.println("\n--- МНОЖЕСТВЕННЫЕ CATCH БЛОКИ ---");
        
        try {
            // Попробуем разные операции, которые могут вызвать исключения
            String text = "abc";
            int number = Integer.parseInt(text);
            int result = 10 / number;
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования числа: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка арифметики: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Общая ошибка: " + e.getMessage());
        }
        
        // ========================================
        // БЛОК FINALLY
        // ========================================
        
        System.out.println("\n--- БЛОК FINALLY ---");
        
        try {
            System.out.println("Выполняем операцию...");
            int result = 10 / 2;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполняется всегда!");
        }
        
        // Пример с исключением
        try {
            System.out.println("Выполняем операцию с ошибкой...");
            int result = 10 / 0;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполняется даже при ошибке!");
        }
        
        // ========================================
        // СОЗДАНИЕ СОБСТВЕННЫХ ИСКЛЮЧЕНИЙ
        // ========================================
        
        System.out.println("\n--- СОБСТВЕННЫЕ ИСКЛЮЧЕНИЯ ---");
        
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }
        
        try {
            validateAge(25);
            System.out.println("Возраст корректен");
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }
        
        // ========================================
        // КЛЮЧЕВОЕ СЛОВО THROWS
        // ========================================
        
        System.out.println("\n--- КЛЮЧЕВОЕ СЛОВО THROWS ---");
        
        try {
            readFile("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Калькулятор с обработкой ошибок
        System.out.println("=== КАЛЬКУЛЯТОР ===");
        
        Calculator calculator = new Calculator();
        
        try {
            System.out.println("10 + 5 = " + calculator.add(10, 5));
            System.out.println("10 - 5 = " + calculator.subtract(10, 5));
            System.out.println("10 * 5 = " + calculator.multiply(10, 5));
            System.out.println("10 / 5 = " + calculator.divide(10, 5));
            System.out.println("10 / 0 = " + calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка калькулятора: " + e.getMessage());
        }
        
        // Пример 2: Банковский счет с обработкой ошибок
        System.out.println("\n=== БАНКОВСКИЙ СЧЕТ ===");
        
        BankAccount account = new BankAccount("123456789", 1000);
        
        try {
            System.out.println("Баланс: " + account.getBalance());
            account.deposit(500);
            System.out.println("После пополнения: " + account.getBalance());
            account.withdraw(200);
            System.out.println("После снятия: " + account.getBalance());
            account.withdraw(2000); // Попытка снять больше, чем есть
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка банка: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Ошибка банка: " + e.getMessage());
        }
        
        // Пример 3: Работа с массивом
        System.out.println("\n=== РАБОТА С МАССИВОМ ===");
        
        ArrayProcessor processor = new ArrayProcessor();
        int[] data = {1, 2, 3, 4, 5};
        
        try {
            System.out.println("Среднее значение: " + processor.calculateAverage(data));
            System.out.println("Элемент с индексом 2: " + processor.getElement(data, 2));
            System.out.println("Элемент с индексом 10: " + processor.getElement(data, 10));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка массива: " + e.getMessage());
        } catch (EmptyArrayException e) {
            System.out.println("Ошибка массива: " + e.getMessage());
        }
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 9 завершен! ===");
        System.out.println("Вы изучили обработку исключений!");
    }
    
    // Метод с собственным исключением
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Возраст должен быть от 0 до 150 лет");
        }
    }
    
    // Метод с throws
    public static void readFile(String filename) throws FileNotFoundException {
        if (!filename.equals("test.txt")) {
            throw new FileNotFoundException("Файл " + filename + " не найден");
        }
        System.out.println("Читаем файл: " + filename);
    }
}

// ========================================
// СОБСТВЕННЫЕ ИСКЛЮЧЕНИЯ
// ========================================

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class FileNotFoundException extends Exception {
    public FileNotFoundException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class EmptyArrayException extends Exception {
    public EmptyArrayException(String message) {
        super(message);
    }
}

// ========================================
// ПРАКТИЧЕСКИЕ ПРИМЕРЫ
// ========================================

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return (double) a / b;
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма должна быть положительной");
        }
        balance += amount;
        System.out.println("Внесено: " + amount + " руб.");
    }
    
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Сумма должна быть положительной");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств. Баланс: " + balance + " руб.");
        }
        balance -= amount;
        System.out.println("Снято: " + amount + " руб.");
    }
    
    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', balance=" + balance + "}";
    }
}

class ArrayProcessor {
    public double calculateAverage(int[] array) throws EmptyArrayException {
        if (array == null || array.length == 0) {
            throw new EmptyArrayException("Массив пуст или равен null");
        }
        
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
    
    public int getElement(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за границы массива");
        }
        return array[index];
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Checked исключения должны быть обработаны или объявлены в throws
 * 2. Unchecked исключения (RuntimeException) не требуют обработки
 * 3. Блок finally выполняется всегда, даже при исключениях
 * 4. Можно создавать собственные исключения, наследуясь от Exception
 * 5. Множественные catch блоки обрабатывают разные типы исключений
 * 6. Ключевое слово throws передает исключение вызывающему методу
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте метод для валидации email с собственным исключением
 * 2. Реализуйте калькулятор с полной обработкой ошибок
 * 3. Создайте класс для работы с файлами с обработкой исключений
 * 4. Добавьте логирование в блоки catch
 */
