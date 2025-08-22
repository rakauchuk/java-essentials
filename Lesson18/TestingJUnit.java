/**
 * Урок 18: Тестирование (JUnit)
 * 
 * В этом уроке мы изучим:
 * - Основы тестирования
 * - JUnit 5
 * - Аннотации тестирования
 * - Assertions
 * - Тестовые методы
 * - Моки и стабы
 */

import java.util.*;

public class TestingJUnit {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 18: Тестирование (JUnit) ===\n");
        
        // Основы тестирования
        System.out.println("--- ОСНОВЫ ТЕСТИРОВАНИЯ ---");
        
        System.out.println("Типы тестирования:");
        System.out.println("- Unit тесты - тестирование отдельных компонентов");
        System.out.println("- Integration тесты - тестирование взаимодействия компонентов");
        System.out.println("- System тесты - тестирование всей системы");
        System.out.println("- Acceptance тесты - тестирование с точки зрения пользователя");
        
        // JUnit 5
        System.out.println("\n--- JUNIT 5 ---");
        
        System.out.println("JUnit 5 - современный фреймворк для тестирования:");
        System.out.println("- Поддержка Java 8+");
        System.out.println("- Модульная архитектура");
        System.out.println("- Улучшенные аннотации");
        System.out.println("- Поддержка лямбда-выражений");
        
        // Аннотации тестирования
        System.out.println("\n--- АННОТАЦИИ ТЕСТИРОВАНИЯ ---");
        
        System.out.println("Основные аннотации JUnit 5:");
        System.out.println("- @Test - основной метод тестирования");
        System.out.println("- @BeforeEach - выполняется перед каждым тестом");
        System.out.println("- @AfterEach - выполняется после каждого теста");
        System.out.println("- @BeforeAll - выполняется один раз перед всеми тестами");
        System.out.println("- @AfterAll - выполняется один раз после всех тестов");
        System.out.println("- @DisplayName - описание теста");
        System.out.println("- @Disabled - отключение теста");
        
        // Assertions
        System.out.println("\n--- ASSERTIONS ---");
        
        System.out.println("Assertions - проверки в тестах:");
        System.out.println("- assertEquals - проверка равенства");
        System.out.println("- assertTrue/assertFalse - проверка булевых значений");
        System.out.println("- assertNull/assertNotNull - проверка на null");
        System.out.println("- assertThrows - проверка исключений");
        System.out.println("- assertTimeout - проверка времени выполнения");
        
        // Демонстрация тестирования
        System.out.println("\n--- ДЕМОНСТРАЦИЯ ТЕСТИРОВАНИЯ ---");
        
        // Создание тестируемого класса
        Calculator calculator = new Calculator();
        
        // Простые тесты
        System.out.println("=== ПРОСТЫЕ ТЕСТЫ ===");
        testCalculator(calculator);
        
        // Тесты с исключениями
        System.out.println("\n=== ТЕСТЫ С ИСКЛЮЧЕНИЯМИ ===");
        testCalculatorExceptions(calculator);
        
        // Тесты коллекций
        System.out.println("\n=== ТЕСТЫ КОЛЛЕКЦИЙ ===");
        testCollections();
        
        // Тесты строк
        System.out.println("\n=== ТЕСТЫ СТРОК ===");
        testStrings();
        
        // Моки и стабы
        System.out.println("\n--- МОКИ И СТАБЫ ---");
        
        System.out.println("Моки и стабы - имитация зависимостей:");
        System.out.println("- Mock - имитация объекта с контролируемым поведением");
        System.out.println("- Stub - простая имитация, возвращающая фиксированные значения");
        System.out.println("- Spy - частичная имитация реального объекта");
        
        demonstrateMocks();
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        System.out.println("=== ТЕСТИРОВАНИЕ СЕРВИСА ===");
        testUserService();
        
        System.out.println("=== ТЕСТИРОВАНИЕ РЕПОЗИТОРИЯ ===");
        testUserRepository();
        
        System.out.println("=== ИНТЕГРАЦИОННЫЕ ТЕСТЫ ===");
        testIntegration();
        
        System.out.println("\n=== Урок 18 завершен! ===");
        System.out.println("Вы изучили тестирование с JUnit!");
    }
    
    // ========================================
    // МЕТОДЫ ДЛЯ ДЕМОНСТРАЦИИ ТЕСТИРОВАНИЯ
    // ========================================
    
    private static void testCalculator(Calculator calculator) {
        System.out.println("Тестирование калькулятора:");
        
        // Тест сложения
        int result1 = calculator.add(5, 3);
        assert result1 == 8 : "Ошибка сложения: ожидалось 8, получено " + result1;
        System.out.println("✓ Сложение работает корректно");
        
        // Тест вычитания
        int result2 = calculator.subtract(10, 4);
        assert result2 == 6 : "Ошибка вычитания: ожидалось 6, получено " + result2;
        System.out.println("✓ Вычитание работает корректно");
        
        // Тест умножения
        int result3 = calculator.multiply(7, 6);
        assert result3 == 42 : "Ошибка умножения: ожидалось 42, получено " + result3;
        System.out.println("✓ Умножение работает корректно");
        
        // Тест деления
        double result4 = calculator.divide(15, 3);
        assert result4 == 5.0 : "Ошибка деления: ожидалось 5.0, получено " + result4;
        System.out.println("✓ Деление работает корректно");
    }
    
    private static void testCalculatorExceptions(Calculator calculator) {
        System.out.println("Тестирование исключений калькулятора:");
        
        // Тест деления на ноль
        try {
            calculator.divide(10, 0);
            assert false : "Ожидалось исключение при делении на ноль";
        } catch (ArithmeticException e) {
            System.out.println("✓ Исключение при делении на ноль обработано корректно");
        }
        
        // Тест отрицательного числа
        try {
            calculator.sqrt(-4);
            assert false : "Ожидалось исключение при извлечении корня из отрицательного числа";
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Исключение при извлечении корня из отрицательного числа обработано корректно");
        }
    }
    
    private static void testCollections() {
        System.out.println("Тестирование коллекций:");
        
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        
        // Проверка размера
        assert list.size() == 3 : "Неверный размер списка";
        System.out.println("✓ Размер списка корректен");
        
        // Проверка содержимого
        assert list.contains("banana") : "Список не содержит 'banana'";
        System.out.println("✓ Список содержит ожидаемый элемент");
        
        // Проверка порядка
        assert "apple".equals(list.get(0)) : "Первый элемент неверный";
        System.out.println("✓ Порядок элементов корректен");
        
        // Проверка уникальности
        Set<String> set = new HashSet<>(list);
        assert set.size() == list.size() : "В списке есть дубликаты";
        System.out.println("✓ В списке нет дубликатов");
    }
    
    private static void testStrings() {
        System.out.println("Тестирование строк:");
        
        String text = "Hello, World!";
        
        // Проверка длины
        assert text.length() == 13 : "Неверная длина строки";
        System.out.println("✓ Длина строки корректна");
        
        // Проверка содержимого
        assert text.contains("World") : "Строка не содержит 'World'";
        System.out.println("✓ Строка содержит ожидаемый текст");
        
        // Проверка регистра
        String upper = text.toUpperCase();
        assert upper.equals("HELLO, WORLD!") : "Преобразование в верхний регистр неверно";
        System.out.println("✓ Преобразование регистра работает корректно");
        
        // Проверка подстроки
        String substring = text.substring(0, 5);
        assert substring.equals("Hello") : "Подстрока неверна";
        System.out.println("✓ Извлечение подстроки работает корректно");
    }
    
    private static void demonstrateMocks() {
        System.out.println("Демонстрация моков и стабов:");
        
        // Создание стаба для EmailService
        EmailServiceStub emailStub = new EmailServiceStub();
        
        // Тестирование с использованием стаба
        UserService userService = new UserService();
        userService.setUserRepository(new UserRepository());
        userService.setEmailService(emailStub);
        
        User user = userService.createUser("Test User");
        
        // Проверка, что email был отправлен
        assert emailStub.isEmailSent() : "Email не был отправлен";
        System.out.println("✓ Email отправлен через стаб");
        
        // Проверка содержимого email
        assert emailStub.getLastEmail().contains("Test User") : "Email содержит неверные данные";
        System.out.println("✓ Email содержит корректные данные");
    }
    
    private static void testUserService() {
        System.out.println("Тестирование UserService:");
        
        // Создание мок-репозитория
        UserRepositoryMock mockRepo = new UserRepositoryMock();
        EmailServiceStub emailStub = new EmailServiceStub();
        
        UserService userService = new UserService();
        userService.setUserRepository(mockRepo);
        userService.setEmailService(emailStub);
        
        // Тест создания пользователя
        User user = userService.createUser("John Doe");
        
        assert user != null : "Пользователь не создан";
        assert "John Doe".equals(user.getName()) : "Неверное имя пользователя";
        assert mockRepo.isSaveCalled() : "Метод save не был вызван";
        assert emailStub.isEmailSent() : "Email не был отправлен";
        
        System.out.println("✓ UserService работает корректно");
    }
    
    private static void testUserRepository() {
        System.out.println("Тестирование UserRepository:");
        
        UserRepository repository = new UserRepository();
        
        // Тест сохранения пользователя
        User user1 = new User("Alice");
        User savedUser1 = repository.save(user1);
        
        assert savedUser1.getId() == 1 : "Неверный ID первого пользователя";
        assert "Alice".equals(savedUser1.getName()) : "Неверное имя первого пользователя";
        
        // Тест поиска пользователя
        User foundUser = repository.findById(1);
        assert foundUser != null : "Пользователь не найден";
        assert "Alice".equals(foundUser.getName()) : "Неверное имя найденного пользователя";
        
        // Тест получения всех пользователей
        List<User> allUsers = repository.findAll();
        assert allUsers.size() == 1 : "Неверное количество пользователей";
        
        System.out.println("✓ UserRepository работает корректно");
    }
    
    private static void testIntegration() {
        System.out.println("Тестирование интеграции компонентов:");
        
        // Создание реальных компонентов
        UserRepository repository = new UserRepository();
        EmailServiceStub emailService = new EmailServiceStub();
        UserService userService = new UserService(repository, emailService);
        
        // Интеграционный тест
        User user1 = userService.createUser("Bob");
        User user2 = userService.createUser("Charlie");
        
        List<User> allUsers = userService.getAllUsers();
        
        assert allUsers.size() == 2 : "Неверное количество пользователей";
        assert emailService.getEmailCount() == 2 : "Неверное количество отправленных email";
        
        User foundUser = userService.getUserById(1);
        assert foundUser != null && "Bob".equals(foundUser.getName()) : "Пользователь не найден";
        
        System.out.println("✓ Интеграция компонентов работает корректно");
    }
}

// ========================================
// КЛАССЫ ДЛЯ ТЕСТИРОВАНИЯ
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
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) a / b;
    }
    
    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Нельзя извлечь корень из отрицательного числа");
        }
        return Math.sqrt(a);
    }
}

class User {
    private int id;
    private String name;
    private String email;
    
    public User(String name) {
        this.name = name;
        this.email = name.toLowerCase().replace(" ", ".") + "@example.com";
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

class UserRepository {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;
    
    public User save(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }
    
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
    
    public User findById(int id) {
        return users.stream()
                   .filter(user -> user.getId() == id)
                   .findFirst()
                   .orElse(null);
    }
}

class UserService {
    private UserRepository userRepository;
    private EmailService emailService;
    
    public UserService() {}
    
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }
    
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    public User createUser(String name) {
        User user = new User(name);
        User savedUser = userRepository.save(user);
        
        if (emailService != null) {
            emailService.sendWelcomeEmail(savedUser.getEmail());
        }
        
        return savedUser;
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}

interface EmailService {
    void sendWelcomeEmail(String email);
}

class EmailServiceStub implements EmailService {
    private boolean emailSent = false;
    private String lastEmail = "";
    private int emailCount = 0;
    
    @Override
    public void sendWelcomeEmail(String email) {
        this.emailSent = true;
        this.lastEmail = email;
        this.emailCount++;
    }
    
    public boolean isEmailSent() {
        return emailSent;
    }
    
    public String getLastEmail() {
        return lastEmail;
    }
    
    public int getEmailCount() {
        return emailCount;
    }
}

class UserRepositoryMock extends UserRepository {
    private boolean saveCalled = false;
    
    @Override
    public User save(User user) {
        saveCalled = true;
        return super.save(user);
    }
    
    public boolean isSaveCalled() {
        return saveCalled;
    }
}

// Аннотации JUnit (симуляция)
@interface Test {}
@interface BeforeEach {}
@interface AfterEach {}
@interface BeforeAll {}
@interface AfterAll {}
@interface DisplayName {}
@interface Disabled {}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Тестирование - важная часть разработки программного обеспечения
 * 2. JUnit 5 - современный фреймворк для unit-тестирования
 * 3. Assertions помогают проверять ожидаемое поведение
 * 4. Моки и стабы имитируют зависимости
 * 5. Тесты должны быть независимыми и повторяемыми
 * 6. Хорошие тесты покрывают различные сценарии
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Напишите тесты для ваших классов
 * 2. Добавьте тесты с исключениями
 * 3. Используйте моки для изоляции тестов
 * 4. Настройте автоматическое тестирование
 */
