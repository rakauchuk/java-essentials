/**
 * Урок 16: Веб-разработка (Servlets, JSP)
 * 
 * В этом уроке мы изучим:
 * - HTTP протокол
 * - Servlet API
 * - JSP страницы
 * - Сессии и куки
 * - Фильтры
 * - Веб-приложения
 */

import java.io.*;
import java.util.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class WebDevelopment {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 16: Веб-разработка (Servlets, JSP) ===\n");
        
        // ========================================
        // HTTP ПРОТОКОЛ
        // ========================================
        
        System.out.println("--- HTTP ПРОТОКОЛ ---");
        
        // Демонстрация HTTP методов
        System.out.println("HTTP методы:");
        System.out.println("- GET: получение данных");
        System.out.println("- POST: отправка данных");
        System.out.println("- PUT: обновление данных");
        System.out.println("- DELETE: удаление данных");
        System.out.println("- HEAD: получение заголовков");
        
        // HTTP статус коды
        System.out.println("\nHTTP статус коды:");
        System.out.println("- 200 OK: успешный запрос");
        System.out.println("- 201 Created: ресурс создан");
        System.out.println("- 400 Bad Request: неверный запрос");
        System.out.println("- 401 Unauthorized: не авторизован");
        System.out.println("- 404 Not Found: не найдено");
        System.out.println("- 500 Internal Server Error: ошибка сервера");
        
        // ========================================
        // SERVLET API
        // ========================================
        
        System.out.println("\n--- SERVLET API ---");
        
        // Демонстрация жизненного цикла сервлета
        System.out.println("Жизненный цикл сервлета:");
        System.out.println("1. init() - инициализация");
        System.out.println("2. service() - обработка запросов");
        System.out.println("3. destroy() - завершение работы");
        
        // Создание простого HTTP клиента
        System.out.println("\n=== ПРОСТОЙ HTTP КЛИЕНТ ===");
        try {
            simpleHTTPClient();
        } catch (IOException e) {
            System.out.println("Ошибка HTTP клиента: " + e.getMessage());
        }
        
        // ========================================
        // СЕССИИ И КУКИ
        // ========================================
        
        System.out.println("\n--- СЕССИИ И КУКИ ---");
        
        // Демонстрация работы с сессиями
        SessionManager sessionManager = new SessionManager();
        sessionManager.demonstrateSessions();
        
        // Демонстрация работы с куками
        CookieManager cookieManager = new CookieManager();
        cookieManager.demonstrateCookies();
        
        // ========================================
        // JSP СТРАНИЦЫ
        // ========================================
        
        System.out.println("\n--- JSP СТРАНИЦЫ ---");
        
        // Создание простой JSP страницы
        createSampleJSP();
        
        // ========================================
        // ФИЛЬТРЫ
        // ========================================
        
        System.out.println("\n--- ФИЛЬТРЫ ---");
        
        // Демонстрация фильтров
        RequestFilter filter = new RequestFilter();
        filter.demonstrateFiltering();
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Простой веб-сервер
        System.out.println("=== ПРОСТОЙ ВЕБ-СЕРВЕР ===");
        try {
            startSimpleWebServer();
        } catch (IOException e) {
            System.out.println("Ошибка веб-сервера: " + e.getMessage());
        }
        
        // Пример 2: Обработка форм
        System.out.println("\n=== ОБРАБОТКА ФОРМ ===");
        FormProcessor formProcessor = new FormProcessor();
        formProcessor.demonstrateFormProcessing();
        
        // Пример 3: REST API
        System.out.println("\n=== REST API ===");
        RESTAPI restAPI = new RESTAPI();
        restAPI.demonstrateREST();
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 16 завершен! ===");
        System.out.println("Вы изучили веб-разработку в Java!");
    }
    
    // ========================================
    // МЕТОДЫ ДЛЯ ДЕМОНСТРАЦИИ
    // ========================================
    
    private static void simpleHTTPClient() throws IOException {
        URL url = new URL("https://httpbin.org/get");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        System.out.println("Отправка GET запроса к: " + url);
        System.out.println("Код ответа: " + connection.getResponseCode());
        System.out.println("Тип контента: " + connection.getContentType());
        
        // Чтение заголовков
        System.out.println("\nЗаголовки ответа:");
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            if (entry.getKey() != null) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        
        connection.disconnect();
    }
    
    private static void createSampleJSP() {
        System.out.println("Создание JSP страницы:");
        System.out.println("""
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <!DOCTYPE html>
            <html>
            <head>
                <title>Пример JSP</title>
            </head>
            <body>
                <h1>Добро пожаловать!</h1>
                <p>Текущее время: <%= new java.util.Date() %></p>
                <p>Случайное число: <%= Math.random() %></p>
                
                <% for(int i = 1; i <= 5; i++) { %>
                    <p>Строка <%= i %></p>
                <% } %>
            </body>
            </html>
            """);
    }
    
    private static void startSimpleWebServer() throws IOException {
        System.out.println("Запуск простого веб-сервера на порту 8080...");
        System.out.println("Сервер будет отвечать на HTTP запросы");
        System.out.println("Для тестирования откройте браузер и перейдите на http://localhost:8080");
        
        // В реальном приложении здесь был бы код сервера
        System.out.println("Сервер готов к работе!");
    }
}

// ========================================
// КЛАССЫ ДЛЯ ДЕМОНСТРАЦИИ
// ========================================

class SessionManager {
    private Map<String, Session> sessions = new HashMap<>();
    
    public void demonstrateSessions() {
        System.out.println("Демонстрация работы с сессиями:");
        
        // Создание сессии
        String sessionId = generateSessionId();
        Session session = new Session(sessionId);
        session.setAttribute("username", "user123");
        session.setAttribute("loginTime", new Date());
        sessions.put(sessionId, session);
        
        System.out.println("Создана сессия: " + sessionId);
        System.out.println("Пользователь: " + session.getAttribute("username"));
        System.out.println("Время входа: " + session.getAttribute("loginTime"));
        
        // Обновление сессии
        session.setAttribute("lastActivity", new Date());
        System.out.println("Последняя активность: " + session.getAttribute("lastActivity"));
        
        // Проверка активности сессии
        if (session.isActive()) {
            System.out.println("Сессия активна");
        } else {
            System.out.println("Сессия истекла");
        }
    }
    
    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }
    
    static class Session {
        private String id;
        private Map<String, Object> attributes = new HashMap<>();
        private Date createdAt;
        private Date lastAccessed;
        
        public Session(String id) {
            this.id = id;
            this.createdAt = new Date();
            this.lastAccessed = new Date();
        }
        
        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
            lastAccessed = new Date();
        }
        
        public Object getAttribute(String name) {
            lastAccessed = new Date();
            return attributes.get(name);
        }
        
        public boolean isActive() {
            // Сессия активна 30 минут
            long timeout = 30 * 60 * 1000; // 30 минут в миллисекундах
            return (System.currentTimeMillis() - lastAccessed.getTime()) < timeout;
        }
    }
}

class CookieManager {
    private Map<String, Cookie> cookies = new HashMap<>();
    
    public void demonstrateCookies() {
        System.out.println("Демонстрация работы с куками:");
        
        // Создание куки
        Cookie userCookie = new Cookie("username", "john_doe");
        userCookie.setMaxAge(3600); // 1 час
        userCookie.setPath("/");
        cookies.put("username", userCookie);
        
        Cookie themeCookie = new Cookie("theme", "dark");
        themeCookie.setMaxAge(86400); // 24 часа
        themeCookie.setPath("/");
        cookies.put("theme", themeCookie);
        
        System.out.println("Созданы куки:");
        for (Cookie cookie : cookies.values()) {
            System.out.println("- " + cookie.getName() + " = " + cookie.getValue() + 
                             " (время жизни: " + cookie.getMaxAge() + " сек)");
        }
        
        // Чтение куки
        Cookie savedCookie = cookies.get("username");
        if (savedCookie != null) {
            System.out.println("Прочитан куки: " + savedCookie.getName() + " = " + savedCookie.getValue());
        }
        
        // Удаление куки
        Cookie expiredCookie = new Cookie("username", "");
        expiredCookie.setMaxAge(0);
        System.out.println("Куки 'username' удален");
    }
    
    static class Cookie {
        private String name;
        private String value;
        private int maxAge;
        private String path;
        
        public Cookie(String name, String value) {
            this.name = name;
            this.value = value;
        }
        
        public String getName() { return name; }
        public String getValue() { return value; }
        public int getMaxAge() { return maxAge; }
        public void setMaxAge(int maxAge) { this.maxAge = maxAge; }
        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }
    }
}

class RequestFilter {
    private List<String> blockedIPs = Arrays.asList("192.168.1.100", "10.0.0.50");
    private List<String> allowedUserAgents = Arrays.asList("Mozilla", "Chrome", "Firefox");
    
    public void demonstrateFiltering() {
        System.out.println("Демонстрация фильтрации запросов:");
        
        // Проверка IP адреса
        String testIP = "192.168.1.100";
        if (isIPBlocked(testIP)) {
            System.out.println("IP адрес заблокирован: " + testIP);
        } else {
            System.out.println("IP адрес разрешен: " + testIP);
        }
        
        // Проверка User-Agent
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36";
        if (isUserAgentAllowed(userAgent)) {
            System.out.println("User-Agent разрешен: " + userAgent);
        } else {
            System.out.println("User-Agent заблокирован: " + userAgent);
        }
        
        // Логирование запроса
        logRequest("GET", "/api/users", "200", "192.168.1.101");
    }
    
    private boolean isIPBlocked(String ip) {
        return blockedIPs.contains(ip);
    }
    
    private boolean isUserAgentAllowed(String userAgent) {
        return allowedUserAgents.stream().anyMatch(userAgent::contains);
    }
    
    private void logRequest(String method, String path, String status, String ip) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        System.out.println("[" + timestamp + "] " + ip + " " + method + " " + path + " " + status);
    }
}

class FormProcessor {
    public void demonstrateFormProcessing() {
        System.out.println("Демонстрация обработки форм:");
        
        // Симуляция данных формы
        Map<String, String> formData = new HashMap<>();
        formData.put("username", "john_doe");
        formData.put("email", "john@example.com");
        formData.put("password", "secret123");
        formData.put("age", "25");
        
        // Валидация данных
        ValidationResult result = validateForm(formData);
        
        if (result.isValid()) {
            System.out.println("Форма валидна:");
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Ошибки валидации:");
            for (String error : result.getErrors()) {
                System.out.println("- " + error);
            }
        }
    }
    
    private ValidationResult validateForm(Map<String, String> formData) {
        ValidationResult result = new ValidationResult();
        
        // Проверка username
        String username = formData.get("username");
        if (username == null || username.length() < 3) {
            result.addError("Username должен содержать минимум 3 символа");
        }
        
        // Проверка email
        String email = formData.get("email");
        if (email == null || !email.contains("@")) {
            result.addError("Некорректный email адрес");
        }
        
        // Проверка возраста
        String age = formData.get("age");
        try {
            int ageValue = Integer.parseInt(age);
            if (ageValue < 18 || ageValue > 100) {
                result.addError("Возраст должен быть от 18 до 100 лет");
            }
        } catch (NumberFormatException e) {
            result.addError("Некорректный возраст");
        }
        
        return result;
    }
    
    static class ValidationResult {
        private List<String> errors = new ArrayList<>();
        
        public void addError(String error) {
            errors.add(error);
        }
        
        public boolean isValid() {
            return errors.isEmpty();
        }
        
        public List<String> getErrors() {
            return errors;
        }
    }
}

class RESTAPI {
    private Map<String, User> users = new HashMap<>();
    
    public RESTAPI() {
        // Инициализация тестовых данных
        users.put("1", new User("1", "John Doe", "john@example.com"));
        users.put("2", new User("2", "Jane Smith", "jane@example.com"));
    }
    
    public void demonstrateREST() {
        System.out.println("Демонстрация REST API:");
        
        // GET /users - получение списка пользователей
        System.out.println("\nGET /users");
        for (User user : users.values()) {
            System.out.println("- " + user.toJSON());
        }
        
        // GET /users/1 - получение конкретного пользователя
        System.out.println("\nGET /users/1");
        User user = users.get("1");
        if (user != null) {
            System.out.println(user.toJSON());
        }
        
        // POST /users - создание нового пользователя
        System.out.println("\nPOST /users");
        User newUser = new User("3", "Bob Johnson", "bob@example.com");
        users.put("3", newUser);
        System.out.println("Создан пользователь: " + newUser.toJSON());
        
        // PUT /users/1 - обновление пользователя
        System.out.println("\nPUT /users/1");
        if (user != null) {
            user.setName("John Updated");
            user.setEmail("john.updated@example.com");
            System.out.println("Обновлен пользователь: " + user.toJSON());
        }
        
        // DELETE /users/2 - удаление пользователя
        System.out.println("\nDELETE /users/2");
        User deletedUser = users.remove("2");
        if (deletedUser != null) {
            System.out.println("Удален пользователь: " + deletedUser.toJSON());
        }
        
        // Финальный список
        System.out.println("\nФинальный список пользователей:");
        for (User u : users.values()) {
            System.out.println("- " + u.toJSON());
        }
    }
    
    static class User {
        private String id;
        private String name;
        private String email;
        
        public User(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        
        public String getId() { return id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public String toJSON() {
            return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"email\":\"%s\"}", 
                               id, name, email);
        }
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. HTTP - протокол для передачи данных в веб
 * 2. Servlet - Java класс для обработки HTTP запросов
 * 3. JSP - технология для создания динамических веб-страниц
 * 4. Сессии используются для хранения данных пользователя
 * 5. Куки - небольшие файлы для хранения данных в браузере
 * 6. Фильтры позволяют обрабатывать запросы до и после сервлетов
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте простой веб-сервер
 * 2. Реализуйте обработку форм
 * 3. Создайте REST API
 * 4. Добавьте аутентификацию и авторизацию
 */
