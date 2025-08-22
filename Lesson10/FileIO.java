/**
 * Урок 10: Работа с файлами
 * 
 * В этом уроке мы изучим:
 * - Класс File
 * - Чтение и запись файлов
 * - BufferedReader и BufferedWriter
 * - FileReader и FileWriter
 * - Работа с директориями
 * - Обработка исключений при работе с файлами
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileIO {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 10: Работа с файлами ===\n");
        
        // ========================================
        // КЛАСС FILE
        // ========================================
        
        System.out.println("--- КЛАСС FILE ---");
        
        // Создание объекта File
        File file = new File("test.txt");
        File directory = new File("test_folder");
        
        System.out.println("Файл существует: " + file.exists());
        System.out.println("Директория существует: " + directory.exists());
        
        // Создание директории
        if (!directory.exists()) {
            boolean created = directory.mkdir();
            System.out.println("Директория создана: " + created);
        }
        
        // Информация о файле
        if (file.exists()) {
            System.out.println("Имя файла: " + file.getName());
            System.out.println("Путь: " + file.getPath());
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Размер: " + file.length() + " байт");
            System.out.println("Можно читать: " + file.canRead());
            System.out.println("Можно писать: " + file.canWrite());
        }
        
        // ========================================
        // ЗАПИСЬ В ФАЙЛ
        // ========================================
        
        System.out.println("\n--- ЗАПИСЬ В ФАЙЛ ---");
        
        // Запись с помощью FileWriter
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Привет, мир!\n");
            writer.write("Это тестовый файл.\n");
            writer.write("Строка 3\n");
            writer.write("Строка 4\n");
            System.out.println("Файл записан успешно");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
        
        // Запись с помощью BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("buffered_test.txt"))) {
            writer.write("Строка 1");
            writer.newLine();
            writer.write("Строка 2");
            writer.newLine();
            writer.write("Строка 3");
            System.out.println("Файл записан с буферизацией");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
        
        // ========================================
        // ЧТЕНИЕ ИЗ ФАЙЛА
        // ========================================
        
        System.out.println("\n--- ЧТЕНИЕ ИЗ ФАЙЛА ---");
        
        // Чтение с помощью FileReader
        System.out.println("Чтение файла test.txt:");
        try (FileReader reader = new FileReader("test.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        
        // Чтение с помощью BufferedReader
        System.out.println("\nЧтение файла buffered_test.txt:");
        try (BufferedReader reader = new BufferedReader(new FileReader("buffered_test.txt"))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Строка " + lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        
        // ========================================
        // РАБОТА С ДИРЕКТОРИЯМИ
        // ========================================
        
        System.out.println("\n--- РАБОТА С ДИРЕКТОРИЯМИ ---");
        
        // Создание вложенных директорий
        File nestedDir = new File("test_folder/nested/deep");
        if (!nestedDir.exists()) {
            boolean created = nestedDir.mkdirs();
            System.out.println("Вложенные директории созданы: " + created);
        }
        
        // Список файлов в директории
        File currentDir = new File(".");
        System.out.println("Файлы в текущей директории:");
        File[] files = currentDir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("  Файл: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("  Директория: " + f.getName());
                }
            }
        }
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Дневник
        System.out.println("=== ДНЕВНИК ===");
        
        Diary diary = new Diary("my_diary.txt");
        
        diary.addEntry("2024-01-15", "Сегодня изучал Java");
        diary.addEntry("2024-01-16", "Изучил работу с файлами");
        diary.addEntry("2024-01-17", "Создал свой первый проект");
        
        System.out.println("Записи в дневнике:");
        diary.readAllEntries();
        
        // Пример 2: Конфигурационный файл
        System.out.println("\n=== КОНФИГУРАЦИОННЫЙ ФАЙЛ ===");
        
        ConfigManager config = new ConfigManager("config.properties");
        
        config.setProperty("database.url", "localhost:3306");
        config.setProperty("database.user", "admin");
        config.setProperty("database.password", "secret");
        config.setProperty("app.name", "MyApp");
        config.setProperty("app.version", "1.0");
        
        System.out.println("Конфигурация:");
        config.loadProperties();
        
        // Пример 3: Логгер
        System.out.println("\n=== ЛОГГЕР ===");
        
        Logger logger = new Logger("app.log");
        
        logger.log("INFO", "Приложение запущено");
        logger.log("DEBUG", "Загружены настройки");
        logger.log("ERROR", "Произошла ошибка при подключении к БД");
        logger.log("INFO", "Приложение завершено");
        
        System.out.println("Логи:");
        logger.readLogs();
        
        // ========================================
        // РАБОТА С NIO (Java 7+)
        // ========================================
        
        System.out.println("\n--- РАБОТА С NIO ---");
        
        // Запись с помощью Files
        try {
            List<String> lines = Arrays.asList(
                "Строка 1 из NIO",
                "Строка 2 из NIO",
                "Строка 3 из NIO"
            );
            Files.write(Paths.get("nio_test.txt"), lines);
            System.out.println("Файл записан с помощью NIO");
        } catch (IOException e) {
            System.out.println("Ошибка записи NIO: " + e.getMessage());
        }
        
        // Чтение с помощью Files
        try {
            List<String> lines = Files.readAllLines(Paths.get("nio_test.txt"));
            System.out.println("Чтение с помощью NIO:");
            for (String line : lines) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения NIO: " + e.getMessage());
        }
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 10 завершен! ===");
        System.out.println("Вы изучили работу с файлами!");
        
        // Очистка созданных файлов
        cleanupFiles();
    }
    
    // Метод для очистки созданных файлов
    private static void cleanupFiles() {
        String[] filesToDelete = {
            "test.txt", "buffered_test.txt", "my_diary.txt", 
            "config.properties", "app.log", "nio_test.txt"
        };
        
        System.out.println("\nОчистка тестовых файлов:");
        for (String filename : filesToDelete) {
            File file = new File(filename);
            if (file.exists() && file.delete()) {
                System.out.println("  Удален: " + filename);
            }
        }
        
        // Удаление директорий
        File testFolder = new File("test_folder");
        if (testFolder.exists()) {
            deleteDirectory(testFolder);
            System.out.println("  Удалена директория: test_folder");
        }
    }
    
    // Рекурсивное удаление директории
    private static void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        dir.delete();
    }
}

// ========================================
// ПРАКТИЧЕСКИЕ ПРИМЕРЫ
// ========================================

class Diary {
    private String filename;
    
    public Diary(String filename) {
        this.filename = filename;
    }
    
    public void addEntry(String date, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("[" + date + "] " + content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка записи в дневник: " + e.getMessage());
        }
    }
    
    public void readAllEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения дневника: " + e.getMessage());
        }
    }
}

class ConfigManager {
    private String filename;
    private Properties properties;
    
    public ConfigManager(String filename) {
        this.filename = filename;
        this.properties = new Properties();
    }
    
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    public void saveProperties() {
        try (FileOutputStream out = new FileOutputStream(filename)) {
            properties.store(out, "Конфигурация приложения");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения конфигурации: " + e.getMessage());
        }
    }
    
    public void loadProperties() {
        try (FileInputStream in = new FileInputStream(filename)) {
            properties.load(in);
            for (String key : properties.stringPropertyNames()) {
                System.out.println("  " + key + " = " + properties.getProperty(key));
            }
        } catch (IOException e) {
            System.out.println("Ошибка загрузки конфигурации: " + e.getMessage());
        }
    }
}

class Logger {
    private String filename;
    
    public Logger(String filename) {
        this.filename = filename;
    }
    
    public void log(String level, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            String timestamp = new java.util.Date().toString();
            writer.write("[" + timestamp + "] [" + level + "] " + message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка записи лога: " + e.getMessage());
        }
    }
    
    public void readLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения логов: " + e.getMessage());
        }
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Всегда используйте try-with-resources для автоматического закрытия потоков
 * 2. BufferedReader/BufferedWriter эффективнее для больших файлов
 * 3. FileWriter/FileReader работают с символами, FileInputStream/FileOutputStream с байтами
 * 4. NIO (Files, Paths) предоставляет более современный API
 * 5. Всегда обрабатывайте IOException при работе с файлами
 * 6. Используйте буферизацию для улучшения производительности
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте программу для копирования файлов
 * 2. Реализуйте простой текстовый редактор
 * 3. Создайте систему резервного копирования
 * 4. Добавьте шифрование при записи файлов
 */
