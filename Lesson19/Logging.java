/**
 * Урок 19: Логирование (Log4j, SLF4J)
 * 
 * В этом уроке мы изучим:
 * - Основы логирования
 * - Уровни логирования
 * - Конфигурация логгеров
 * - SLF4J
 * - Лучшие практики
 */

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 19: Логирование (Log4j, SLF4J) ===\n");
        
        // Основы логирования
        System.out.println("--- ОСНОВЫ ЛОГИРОВАНИЯ ---");
        
        System.out.println("Логирование - запись информации о работе приложения:");
        System.out.println("- Отладка и диагностика проблем");
        System.out.println("- Мониторинг производительности");
        System.out.println("- Аудит и безопасность");
        
        // Уровни логирования
        System.out.println("\n--- УРОВНИ ЛОГИРОВАНИЯ ---");
        
        System.out.println("Уровни логирования (от низкого к высокому):");
        System.out.println("- TRACE - детальная отладочная информация");
        System.out.println("- DEBUG - отладочная информация");
        System.out.println("- INFO - общая информация о работе приложения");
        System.out.println("- WARN - предупреждения");
        System.out.println("- ERROR - ошибки");
        System.out.println("- FATAL - критические ошибки");
        
        // Демонстрация логирования
        System.out.println("\n--- ДЕМОНСТРАЦИЯ ЛОГИРОВАНИЯ ---");
        
        SimpleLogger logger = new SimpleLogger();
        demonstrateLogging(logger);
        
        // SLF4J
        System.out.println("\n--- SLF4J ---");
        
        System.out.println("SLF4J - Simple Logging Facade for Java:");
        System.out.println("- Единый интерфейс для различных логгеров");
        System.out.println("- Возможность смены реализации");
        System.out.println("- Поддержка параметризованного логирования");
        
        demonstrateSLF4J();
        
        // Лучшие практики
        System.out.println("\n--- ЛУЧШИЕ ПРАКТИКИ ---");
        
        System.out.println("Лучшие практики логирования:");
        System.out.println("- Используйте подходящие уровни логирования");
        System.out.println("- Логируйте контекстную информацию");
        System.out.println("- Избегайте логирования чувствительных данных");
        System.out.println("- Используйте структурированное логирование");
        
        demonstrateBestPractices();
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        System.out.println("=== ЛОГИРОВАНИЕ ВЕБ-ПРИЛОЖЕНИЯ ===");
        WebApplicationLogger webLogger = new WebApplicationLogger();
        webLogger.demonstrateWebLogging();
        
        System.out.println("\n=== ЛОГИРОВАНИЕ БАЗЫ ДАННЫХ ===");
        DatabaseLogger dbLogger = new DatabaseLogger();
        dbLogger.demonstrateDatabaseLogging();
        
        System.out.println("\n=== Урок 19 завершен! ===");
        System.out.println("Вы изучили логирование в Java!");
    }
    
    private static void demonstrateLogging(SimpleLogger logger) {
        System.out.println("Демонстрация логирования:");
        
        logger.trace("Это сообщение уровня TRACE");
        logger.debug("Это сообщение уровня DEBUG");
        logger.info("Это сообщение уровня INFO");
        logger.warn("Это сообщение уровня WARN");
        logger.error("Это сообщение уровня ERROR");
        logger.fatal("Это сообщение уровня FATAL");
        
        // Логирование с параметрами
        String user = "john_doe";
        int userId = 123;
        logger.info("Пользователь {} (ID: {}) вошел в систему", user, userId);
        
        // Логирование исключений
        try {
            throw new RuntimeException("Тестовая ошибка");
        } catch (Exception e) {
            logger.error("Произошла ошибка при обработке запроса", e);
        }
    }
    
    private static void demonstrateSLF4J() {
        System.out.println("Демонстрация SLF4J:");
        
        SLF4JLogger slf4jLogger = new SLF4JLogger();
        
        // Параметризованное логирование
        String operation = "создание пользователя";
        String username = "alice";
        slf4jLogger.info("Операция '{}' выполнена для пользователя '{}'", operation, username);
        
        // Логирование с MDC
        slf4jLogger.setMDC("sessionId", "sess-12345");
        slf4jLogger.info("Пользовательская сессия активна");
        slf4jLogger.clearMDC();
        
        System.out.println("SLF4J функциональность продемонстрирована");
    }
    
    private static void demonstrateBestPractices() {
        System.out.println("Демонстрация лучших практик:");
        
        BestPracticesLogger logger = new BestPracticesLogger();
        
        // Правильное использование уровней
        logger.debug("Отладочная информация: значение переменной = " + 42);
        logger.info("Пользователь john_doe успешно аутентифицирован");
        logger.warn("Медленный запрос к базе данных: " + 1500 + " мс");
        logger.error("Ошибка при обработке файла: file.txt");
        
        // Структурированное логирование
        Map<String, Object> context = new HashMap<>();
        context.put("userId", 123);
        context.put("action", "login");
        context.put("ip", "192.168.1.100");
        logger.logStructured(LogLevel.INFO, "Пользовательская активность", context);
        
        // Избегание логирования чувствительных данных
        String password = "secret123";
        String maskedPassword = "***";
        logger.info("Попытка входа с паролем: {}", maskedPassword);
        
        System.out.println("Лучшие практики применены");
    }
}

// ========================================
// КЛАССЫ ДЛЯ ДЕМОНСТРАЦИИ ЛОГИРОВАНИЯ
// ========================================

enum LogLevel {
    TRACE, DEBUG, INFO, WARN, ERROR, FATAL
}

class SimpleLogger {
    private LogLevel level = LogLevel.INFO;
    
    public void setLevel(LogLevel level) {
        this.level = level;
    }
    
    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }
    
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }
    
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
    
    public void info(String message, Object... args) {
        log(LogLevel.INFO, String.format(message, args));
    }
    
    public void error(String message, Throwable throwable) {
        log(LogLevel.ERROR, message + ": " + throwable.getMessage());
    }
    
    protected void log(LogLevel messageLevel, String message) {
        if (messageLevel.ordinal() >= level.ordinal()) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.printf("[%s] %s - %s%n", timestamp, messageLevel, message);
        }
    }
}

class SLF4JLogger {
    private Map<String, String> mdc = new HashMap<>();
    
    public void info(String message, Object... args) {
        String formattedMessage = String.format(message, args);
        log(LogLevel.INFO, formattedMessage);
    }
    
    public void setMDC(String key, String value) {
        mdc.put(key, value);
    }
    
    public void clearMDC() {
        mdc.clear();
    }
    
    private void log(LogLevel level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        StringBuilder mdcStr = new StringBuilder();
        if (!mdc.isEmpty()) {
            mdcStr.append(" [MDC:");
            mdc.forEach((k, v) -> mdcStr.append(" ").append(k).append("=").append(v));
            mdcStr.append("]");
        }
        System.out.printf("[%s] %s%s - %s%n", timestamp, level, mdcStr, message);
    }
}

class BestPracticesLogger extends SimpleLogger {
    public void logStructured(LogLevel level, String message, Map<String, Object> context) {
        StringBuilder structuredMessage = new StringBuilder(message);
        if (!context.isEmpty()) {
            structuredMessage.append(" {");
            context.forEach((k, v) -> structuredMessage.append(k).append("=").append(v).append(", "));
            structuredMessage.setLength(structuredMessage.length() - 2);
            structuredMessage.append("}");
        }
        log(level, structuredMessage.toString());
    }
}

class WebApplicationLogger {
    private SimpleLogger logger = new SimpleLogger();
    
    public void demonstrateWebLogging() {
        logger.info("Веб-приложение запущено");
        
        logger.info("HTTP GET /api/users - 200 OK");
        logger.warn("HTTP POST /api/users - 400 Bad Request");
        logger.error("HTTP GET /api/users/999 - 500 Internal Server Error");
        
        logger.debug("Время обработки запроса: " + 150 + " мс");
        logger.warn("Медленный запрос: " + 2500 + " мс");
    }
}

class DatabaseLogger {
    private SimpleLogger logger = new SimpleLogger();
    
    public void demonstrateDatabaseLogging() {
        logger.info("Подключение к базе данных установлено");
        
        logger.debug("SQL: SELECT * FROM users WHERE id = ?");
        logger.debug("SQL: INSERT INTO users (name, email) VALUES (?, ?)");
        
        logger.info("Транзакция начата: TX-12345");
        logger.info("Транзакция завершена: TX-12345");
        
        logger.error("Ошибка подключения к базе данных: Connection timeout");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Логирование помогает в отладке и мониторинге приложений
 * 2. Выбирайте подходящие уровни логирования
 * 3. SLF4J предоставляет единый интерфейс для различных логгеров
 * 4. Избегайте логирования чувствительных данных
 * 5. Используйте структурированное логирование для анализа
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Настройте логирование в вашем приложении
 * 2. Создайте конфигурацию для разных окружений
 * 3. Добавьте структурированное логирование
 * 4. Настройте мониторинг логов
 */
