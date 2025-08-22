/**
 * Урок 17: Spring Framework
 * 
 * В этом уроке мы изучим:
 * - Dependency Injection (DI)
 * - Inversion of Control (IoC)
 * - Spring Beans
 * - Аннотации Spring
 * - Spring Boot
 * - REST контроллеры
 */

import java.util.*;

public class SpringFramework {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 17: Spring Framework ===\n");
        
        // Dependency Injection
        System.out.println("--- DEPENDENCY INJECTION ---");
        
        System.out.println("Dependency Injection (DI) - внедрение зависимостей:");
        System.out.println("- Уменьшает связанность между компонентами");
        System.out.println("- Упрощает тестирование");
        System.out.println("- Делает код более модульным");
        
        // Демонстрация DI
        demonstrateDependencyInjection();
        
        // Inversion of Control
        System.out.println("\n--- INVERSION OF CONTROL ---");
        
        System.out.println("Inversion of Control (IoC) - инверсия управления:");
        System.out.println("- Контроль создания объектов передается фреймворку");
        System.out.println("- Управление жизненным циклом объектов");
        System.out.println("- Автоматическое разрешение зависимостей");
        
        // Spring Beans
        System.out.println("\n--- SPRING BEANS ---");
        
        System.out.println("Spring Beans - объекты, управляемые Spring контейнером:");
        System.out.println("- Создаются Spring IoC контейнером");
        System.out.println("- Имеют жизненный цикл");
        System.out.println("- Могут быть синглтонами или прототипами");
        
        demonstrateSpringBeans();
        
        // Аннотации Spring
        System.out.println("\n--- АННОТАЦИИ SPRING ---");
        
        System.out.println("Основные аннотации Spring:");
        System.out.println("- @Component - базовый компонент");
        System.out.println("- @Service - сервисный слой");
        System.out.println("- @Repository - слой доступа к данным");
        System.out.println("- @Controller - веб-контроллер");
        System.out.println("- @Autowired - внедрение зависимостей");
        System.out.println("- @Value - внедрение значений");
        
        demonstrateSpringAnnotations();
        
        // Spring Boot
        System.out.println("\n--- SPRING BOOT ---");
        
        System.out.println("Spring Boot - упрощенная разработка Spring приложений:");
        System.out.println("- Автоконфигурация");
        System.out.println("- Встроенный сервер");
        System.out.println("- Starter зависимости");
        System.out.println("- Actuator для мониторинга");
        
        demonstrateSpringBoot();
        
        // REST контроллеры
        System.out.println("\n--- REST КОНТРОЛЛЕРЫ ---");
        
        System.out.println("REST контроллеры в Spring:");
        System.out.println("- @RestController - REST API контроллер");
        System.out.println("- @RequestMapping - маппинг URL");
        System.out.println("- @GetMapping, @PostMapping - HTTP методы");
        System.out.println("- @PathVariable - параметры пути");
        System.out.println("- @RequestParam - параметры запроса");
        
        demonstrateRESTControllers();
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        System.out.println("=== ПРОСТОЕ ПРИЛОЖЕНИЕ ===");
        SimpleSpringApp app = new SimpleSpringApp();
        app.run();
        
        System.out.println("\n=== Урок 17 завершен! ===");
        System.out.println("Вы изучили Spring Framework!");
    }
    
    private static void demonstrateDependencyInjection() {
        System.out.println("Демонстрация Dependency Injection:");
        
        // Без DI (плохой подход)
        System.out.println("Без DI:");
        UserService userService1 = new UserService();
        userService1.setUserRepository(new UserRepository());
        userService1.createUser("John Doe");
        
        // С DI (хороший подход)
        System.out.println("С DI:");
        UserRepository repository = new UserRepository();
        UserService userService2 = new UserService(repository);
        userService2.createUser("Jane Smith");
    }
    
    private static void demonstrateSpringBeans() {
        System.out.println("Демонстрация Spring Beans:");
        
        // Создание Spring контейнера (симуляция)
        SpringContainer container = new SpringContainer();
        
        // Регистрация бинов
        container.registerBean("userService", new UserService());
        container.registerBean("userRepository", new UserRepository());
        container.registerBean("emailService", new EmailService());
        
        // Получение бинов
        UserService userService = (UserService) container.getBean("userService");
        userService.setUserRepository((UserRepository) container.getBean("userRepository"));
        userService.createUser("Bob Johnson");
        
        System.out.println("Бины созданы и управляются контейнером");
    }
    
    private static void demonstrateSpringAnnotations() {
        System.out.println("Демонстрация Spring аннотаций:");
        
        // @Component
        System.out.println("@Component - базовый компонент");
        UserComponent userComponent = new UserComponent();
        userComponent.setName("Component User");
        
        // @Service
        System.out.println("@Service - сервисный слой");
        UserService userService = new UserService();
        userService.setUserRepository(new UserRepository());
        
        // @Repository
        System.out.println("@Repository - слой доступа к данным");
        UserRepository userRepository = new UserRepository();
        
        // @Autowired (симуляция)
        System.out.println("@Autowired - внедрение зависимостей");
        userService.setUserRepository(userRepository);
        
        System.out.println("Аннотации помогают Spring понять структуру приложения");
    }
    
    private static void demonstrateSpringBoot() {
        System.out.println("Демонстрация Spring Boot:");
        
        // Автоконфигурация
        System.out.println("Автоконфигурация:");
        System.out.println("- Автоматическое создание DataSource");
        System.out.println("- Автоматическое создание EntityManager");
        System.out.println("- Автоматическое создание WebMvc");
        
        // Встроенный сервер
        System.out.println("Встроенный сервер:");
        System.out.println("- Tomcat (по умолчанию)");
        System.out.println("- Jetty");
        System.out.println("- Undertow");
        
        // Starter зависимости
        System.out.println("Starter зависимости:");
        System.out.println("- spring-boot-starter-web");
        System.out.println("- spring-boot-starter-data-jpa");
        System.out.println("- spring-boot-starter-security");
        
        System.out.println("Spring Boot упрощает разработку");
    }
    
    private static void demonstrateRESTControllers() {
        System.out.println("Демонстрация REST контроллеров:");
        
        // Создание REST контроллера
        UserRestController controller = new UserRestController();
        UserService userService = new UserService();
        userService.setUserRepository(new UserRepository());
        controller.setUserService(userService);
        
        // Симуляция HTTP запросов
        System.out.println("GET /api/users");
        List<User> users = controller.getAllUsers();
        System.out.println("Получено пользователей: " + users.size());
        
        System.out.println("POST /api/users");
        User newUser = controller.createUser("Alice Brown");
        System.out.println("Создан пользователь: " + newUser.getName());
        
        System.out.println("GET /api/users/1");
        User user = controller.getUserById(1);
        if (user != null) {
            System.out.println("Найден пользователь: " + user.getName());
        }
        
        System.out.println("REST API готов к использованию");
    }
}

// ========================================
// КЛАССЫ ДЛЯ ДЕМОНСТРАЦИИ
// ========================================

class User {
    private int id;
    private String name;
    private String email;
    
    public User() {}
    
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
    
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

class UserRepository {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;
    
    public User save(User user) {
        user.setId(nextId++);
        users.add(user);
        System.out.println("Пользователь сохранен в базе данных: " + user);
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
    
    // Конструктор для DI
    public UserService() {}
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
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
        
        System.out.println("Пользователь создан: " + savedUser);
        return savedUser;
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        System.out.println("Отправлено приветственное письмо на: " + email);
    }
    
    public void sendNotificationEmail(String email, String message) {
        System.out.println("Отправлено уведомление на " + email + ": " + message);
    }
}

class SpringContainer {
    private Map<String, Object> beans = new HashMap<>();
    
    public void registerBean(String name, Object bean) {
        beans.put(name, bean);
        System.out.println("Зарегистрирован бин: " + name);
    }
    
    public Object getBean(String name) {
        Object bean = beans.get(name);
        if (bean != null) {
            System.out.println("Получен бин: " + name);
        }
        return bean;
    }
}

// Аннотации Spring (симуляция)
@interface Component {}
@interface Service {}
@interface Repository {}
@interface Controller {}
@interface RestController {}
@interface Autowired {}
@interface Value {}

@Component
class UserComponent {
    @Value
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

@Service
class UserServiceAnnotated {
    @Autowired
    private UserRepository userRepository;
    
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

@Repository
class UserRepositoryAnnotated {
    public List<User> findAll() {
        return Arrays.asList(new User("John"), new User("Jane"));
    }
}

@RestController
class UserRestController {
    private UserService userService;
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    public User createUser(String name) {
        return userService.createUser(name);
    }
    
    public User getUserById(int id) {
        return userService.getUserById(id);
    }
}

class SimpleSpringApp {
    public void run() {
        System.out.println("Запуск простого Spring приложения:");
        
        // Создание компонентов
        UserRepository repository = new UserRepository();
        EmailService emailService = new EmailService();
        UserService userService = new UserService(repository, emailService);
        
        // Создание пользователей
        userService.createUser("John Doe");
        userService.createUser("Jane Smith");
        userService.createUser("Bob Johnson");
        
        // Получение всех пользователей
        List<User> users = userService.getAllUsers();
        System.out.println("Всего пользователей: " + users.size());
        
        System.out.println("Приложение работает!");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Spring Framework - популярный фреймворк для Java
 * 2. DI и IoC - основные принципы Spring
 * 3. Spring Boot упрощает разработку приложений
 * 4. Аннотации помогают конфигурировать приложение
 * 5. REST контроллеры для создания веб-API
 * 6. Spring управляет жизненным циклом объектов
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте простое Spring Boot приложение
 * 2. Реализуйте REST API с CRUD операциями
 * 3. Добавьте Spring Data JPA
 * 4. Настройте Spring Security
 */
