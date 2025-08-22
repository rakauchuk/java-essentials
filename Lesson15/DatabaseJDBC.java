/**
 * Урок 15: Работа с базами данных (JDBC)
 * 
 * В этом уроке мы изучим:
 * - Подключение к базе данных
 * - Выполнение SQL запросов
 * - PreparedStatement
 * - ResultSet
 * - Транзакции
 * - Обработка исключений SQL
 */

import java.sql.*;
import java.util.*;

public class DatabaseJDBC {
    
    // Данные для подключения к базе данных
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 15: Работа с базами данных (JDBC) ===\n");
        
        // ========================================
        // ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ
        // ========================================
        
        System.out.println("--- ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ ---");
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Подключение к базе данных успешно!");
            System.out.println("URL: " + connection.getMetaData().getURL());
            System.out.println("База данных: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("Версия: " + connection.getMetaData().getDatabaseProductVersion());
            
            // ========================================
            // СОЗДАНИЕ ТАБЛИЦ
            // ========================================
            
            System.out.println("\n--- СОЗДАНИЕ ТАБЛИЦ ---");
            
            createTables(connection);
            
            // ========================================
            // ВСТАВКА ДАННЫХ
            // ========================================
            
            System.out.println("\n--- ВСТАВКА ДАННЫХ ---");
            
            insertData(connection);
            
            // ========================================
            // ВЫБОРКА ДАННЫХ
            // ========================================
            
            System.out.println("\n--- ВЫБОРКА ДАННЫХ ---");
            
            selectData(connection);
            
            // ========================================
            // ОБНОВЛЕНИЕ ДАННЫХ
            // ========================================
            
            System.out.println("\n--- ОБНОВЛЕНИЕ ДАННЫХ ---");
            
            updateData(connection);
            
            // ========================================
            // УДАЛЕНИЕ ДАННЫХ
            // ========================================
            
            System.out.println("\n--- УДАЛЕНИЕ ДАННЫХ ---");
            
            deleteData(connection);
            
            // ========================================
            // PREPAREDSTATEMENT
            // ========================================
            
            System.out.println("\n--- PREPAREDSTATEMENT ---");
            
            preparedStatementExample(connection);
            
            // ========================================
            // ТРАНЗАКЦИИ
            // ========================================
            
            System.out.println("\n--- ТРАНЗАКЦИИ ---");
            
            transactionExample(connection);
            
            // ========================================
            // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
            // ========================================
            
            System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
            
            // Пример 1: Поиск пользователей
            System.out.println("=== ПОИСК ПОЛЬЗОВАТЕЛЕЙ ===");
            searchUsers(connection);
            
            // Пример 2: Статистика
            System.out.println("\n=== СТАТИСТИКА ===");
            getStatistics(connection);
            
            // Пример 3: Сложный запрос с JOIN
            System.out.println("\n=== СЛОЖНЫЙ ЗАПРОС ===");
            complexQuery(connection);
            
        } catch (SQLException e) {
            System.out.println("Ошибка работы с базой данных: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n=== Урок 15 завершен! ===");
        System.out.println("Вы изучили работу с базами данных через JDBC!");
    }
    
    // ========================================
    // МЕТОДЫ ДЛЯ РАБОТЫ С БАЗОЙ ДАННЫХ
    // ========================================
    
    private static void createTables(Connection connection) throws SQLException {
        // Создание таблицы пользователей
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE,
                age INT,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
        """;
        
        // Создание таблицы заказов
        String createOrdersTable = """
            CREATE TABLE IF NOT EXISTS orders (
                id INT AUTO_INCREMENT PRIMARY KEY,
                user_id INT,
                product_name VARCHAR(100),
                price DECIMAL(10,2),
                order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY (user_id) REFERENCES users(id)
            )
        """;
        
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createOrdersTable);
            System.out.println("Таблицы созданы успешно!");
        }
    }
    
    private static void insertData(Connection connection) throws SQLException {
        // Вставка пользователей
        String insertUsers = """
            INSERT INTO users (name, email, age) VALUES 
            ('Анна Иванова', 'anna@email.com', 25),
            ('Борис Петров', 'boris@email.com', 30),
            ('Вера Сидорова', 'vera@email.com', 28),
            ('Григорий Козлов', 'grigory@email.com', 35)
        """;
        
        // Вставка заказов
        String insertOrders = """
            INSERT INTO orders (user_id, product_name, price) VALUES 
            (1, 'Ноутбук', 50000.00),
            (1, 'Мышь', 1500.00),
            (2, 'Клавиатура', 3000.00),
            (3, 'Монитор', 25000.00),
            (4, 'Принтер', 15000.00)
        """;
        
        try (Statement stmt = connection.createStatement()) {
            int usersInserted = stmt.executeUpdate(insertUsers);
            int ordersInserted = stmt.executeUpdate(insertOrders);
            System.out.println("Добавлено пользователей: " + usersInserted);
            System.out.println("Добавлено заказов: " + ordersInserted);
        }
    }
    
    private static void selectData(Connection connection) throws SQLException {
        // Простая выборка
        String selectUsers = "SELECT * FROM users";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectUsers)) {
            
            System.out.println("Список пользователей:");
            System.out.println("ID | Имя | Email | Возраст | Дата создания");
            System.out.println("---|-----|-------|---------|--------------");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Timestamp createdAt = rs.getTimestamp("created_at");
                
                System.out.printf("%d | %s | %s | %d | %s%n", 
                    id, name, email, age, createdAt);
            }
        }
    }
    
    private static void updateData(Connection connection) throws SQLException {
        // Обновление возраста пользователя
        String updateAge = "UPDATE users SET age = ? WHERE name = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(updateAge)) {
            pstmt.setInt(1, 26);
            pstmt.setString(2, "Анна Иванова");
            
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Обновлено записей: " + rowsUpdated);
        }
        
        // Проверка обновления
        String selectUser = "SELECT * FROM users WHERE name = 'Анна Иванова'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectUser)) {
            
            if (rs.next()) {
                System.out.println("Обновленный пользователь: " + 
                    rs.getString("name") + ", возраст: " + rs.getInt("age"));
            }
        }
    }
    
    private static void deleteData(Connection connection) throws SQLException {
        // Удаление пользователя
        String deleteUser = "DELETE FROM users WHERE name = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(deleteUser)) {
            pstmt.setString(1, "Григорий Козлов");
            
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Удалено записей: " + rowsDeleted);
        }
        
        // Проверка количества пользователей
        String countUsers = "SELECT COUNT(*) FROM users";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(countUsers)) {
            
            if (rs.next()) {
                System.out.println("Количество пользователей после удаления: " + 
                    rs.getInt(1));
            }
        }
    }
    
    private static void preparedStatementExample(Connection connection) throws SQLException {
        // Поиск пользователей по возрасту
        String selectByAge = "SELECT * FROM users WHERE age > ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(selectByAge)) {
            pstmt.setInt(1, 25);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Пользователи старше 25 лет:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("name") + 
                        " (возраст: " + rs.getInt("age") + ")");
                }
            }
        }
        
        // Поиск по email
        String selectByEmail = "SELECT * FROM users WHERE email LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectByEmail)) {
            pstmt.setString(1, "%@email.com");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Пользователи с email на @email.com:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("name") + 
                        " (" + rs.getString("email") + ")");
                }
            }
        }
    }
    
    private static void transactionExample(Connection connection) throws SQLException {
        // Начало транзакции
        connection.setAutoCommit(false);
        
        try {
            // Первая операция
            String insertUser = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertUser)) {
                pstmt.setString(1, "Дмитрий Волков");
                pstmt.setString(2, "dmitry@email.com");
                pstmt.setInt(3, 32);
                pstmt.executeUpdate();
            }
            
            // Вторая операция
            String insertOrder = "INSERT INTO orders (user_id, product_name, price) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertOrder)) {
                pstmt.setInt(1, 5); // ID нового пользователя
                pstmt.setString(2, "Планшет");
                pstmt.setDouble(3, 35000.00);
                pstmt.executeUpdate();
            }
            
            // Подтверждение транзакции
            connection.commit();
            System.out.println("Транзакция выполнена успешно!");
            
        } catch (SQLException e) {
            // Откат транзакции при ошибке
            connection.rollback();
            System.out.println("Транзакция отменена: " + e.getMessage());
        } finally {
            // Восстановление автокоммита
            connection.setAutoCommit(true);
        }
    }
    
    // ========================================
    // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
    // ========================================
    
    private static void searchUsers(Connection connection) throws SQLException {
        // Поиск пользователей с заказами
        String searchQuery = """
            SELECT u.name, u.email, COUNT(o.id) as order_count, SUM(o.price) as total_spent
            FROM users u
            LEFT JOIN orders o ON u.id = o.user_id
            GROUP BY u.id, u.name, u.email
            ORDER BY total_spent DESC
        """;
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(searchQuery)) {
            
            System.out.println("Пользователи с заказами:");
            System.out.println("Имя | Email | Количество заказов | Общая сумма");
            System.out.println("----|-------|-------------------|-------------");
            
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                int orderCount = rs.getInt("order_count");
                double totalSpent = rs.getDouble("total_spent");
                
                System.out.printf("%s | %s | %d | %.2f%n", 
                    name, email, orderCount, totalSpent);
            }
        }
    }
    
    private static void getStatistics(Connection connection) throws SQLException {
        // Статистика по заказам
        String statsQuery = """
            SELECT 
                COUNT(*) as total_orders,
                AVG(price) as avg_price,
                MIN(price) as min_price,
                MAX(price) as max_price,
                SUM(price) as total_revenue
            FROM orders
        """;
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(statsQuery)) {
            
            if (rs.next()) {
                System.out.println("Статистика заказов:");
                System.out.println("Общее количество заказов: " + rs.getInt("total_orders"));
                System.out.println("Средняя цена: " + rs.getDouble("avg_price"));
                System.out.println("Минимальная цена: " + rs.getDouble("min_price"));
                System.out.println("Максимальная цена: " + rs.getDouble("max_price"));
                System.out.println("Общая выручка: " + rs.getDouble("total_revenue"));
            }
        }
    }
    
    private static void complexQuery(Connection connection) throws SQLException {
        // Сложный запрос с условиями
        String complexQuery = """
            SELECT 
                u.name,
                u.age,
                o.product_name,
                o.price,
                o.order_date
            FROM users u
            INNER JOIN orders o ON u.id = o.user_id
            WHERE u.age BETWEEN 25 AND 35
            AND o.price > 1000
            ORDER BY o.order_date DESC
        """;
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(complexQuery)) {
            
            System.out.println("Заказы пользователей 25-35 лет с ценой > 1000:");
            System.out.println("Имя | Возраст | Товар | Цена | Дата заказа");
            System.out.println("----|---------|-------|------|------------");
            
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String product = rs.getString("product_name");
                double price = rs.getDouble("price");
                Timestamp orderDate = rs.getTimestamp("order_date");
                
                System.out.printf("%s | %d | %s | %.2f | %s%n", 
                    name, age, product, price, orderDate);
            }
        }
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. JDBC - стандартный API для работы с базами данных в Java
 * 2. Connection управляет подключением к базе данных
 * 3. Statement для простых запросов, PreparedStatement для параметризованных
 * 4. ResultSet содержит результаты запросов
 * 5. Транзакции обеспечивают целостность данных
 * 6. Всегда закрывайте ресурсы (Connection, Statement, ResultSet)
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте таблицу для хранения книг
 * 2. Реализуйте CRUD операции для книг
 * 3. Добавьте поиск по различным критериям
 * 4. Используйте транзакции для сложных операций
 */
