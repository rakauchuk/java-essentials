/**
 * Урок 20: Maven/Gradle
 * 
 * В этом уроке мы изучим:
 * - Инструменты сборки
 * - Maven
 * - Gradle
 * - Управление зависимостями
 * - Жизненный цикл сборки
 */

import java.util.*;

public class BuildTools {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 20: Maven/Gradle ===\n");
        
        // Инструменты сборки
        System.out.println("--- ИНСТРУМЕНТЫ СБОРКИ ---");
        
        System.out.println("Инструменты сборки автоматизируют процесс разработки:");
        System.out.println("- Компиляция исходного кода");
        System.out.println("- Управление зависимостями");
        System.out.println("- Тестирование");
        System.out.println("- Создание артефактов");
        System.out.println("- Развертывание");
        
        // Maven
        System.out.println("\n--- MAVEN ---");
        
        System.out.println("Maven - популярный инструмент сборки:");
        System.out.println("- XML-конфигурация (pom.xml)");
        System.out.println("- Стандартная структура проекта");
        System.out.println("- Центральный репозиторий");
        System.out.println("- Жизненный цикл сборки");
        
        demonstrateMaven();
        
        // Gradle
        System.out.println("\n--- GRADLE ---");
        
        System.out.println("Gradle - современный инструмент сборки:");
        System.out.println("- DSL на основе Groovy/Kotlin");
        System.out.println("- Гибкая конфигурация");
        System.out.println("- Инкрементальная сборка");
        System.out.println("- Многопроектная сборка");
        
        demonstrateGradle();
        
        // Управление зависимостями
        System.out.println("\n--- УПРАВЛЕНИЕ ЗАВИСИМОСТЯМИ ---");
        
        System.out.println("Управление зависимостями:");
        System.out.println("- Автоматическое разрешение зависимостей");
        System.out.println("- Транзитивные зависимости");
        System.out.println("- Конфликты версий");
        System.out.println("- Сканирование уязвимостей");
        
        demonstrateDependencyManagement();
        
        // Жизненный цикл сборки
        System.out.println("\n--- ЖИЗНЕННЫЙ ЦИКЛ СБОРКИ ---");
        
        System.out.println("Жизненный цикл Maven:");
        System.out.println("1. validate - проверка проекта");
        System.out.println("2. compile - компиляция");
        System.out.println("3. test - тестирование");
        System.out.println("4. package - упаковка");
        System.out.println("5. verify - проверка");
        System.out.println("6. install - установка в локальный репозиторий");
        System.out.println("7. deploy - развертывание");
        
        demonstrateBuildLifecycle();
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        System.out.println("=== ПРОСТОЙ MAVEN ПРОЕКТ ===");
        SimpleMavenProject mavenProject = new SimpleMavenProject();
        mavenProject.demonstrateMavenProject();
        
        System.out.println("\n=== ПРОСТОЙ GRADLE ПРОЕКТ ===");
        SimpleGradleProject gradleProject = new SimpleGradleProject();
        gradleProject.demonstrateGradleProject();
        
        System.out.println("\n=== Урок 20 завершен! ===");
        System.out.println("Вы изучили инструменты сборки Maven и Gradle!");
    }
    
    private static void demonstrateMaven() {
        System.out.println("Демонстрация Maven:");
        
        // Создание pom.xml
        System.out.println("Создание pom.xml:");
        System.out.println("""
            <?xml version="1.0" encoding="UTF-8"?>
            <project xmlns="http://maven.apache.org/POM/4.0.0">
                <modelVersion>4.0.0</modelVersion>
                <groupId>com.example</groupId>
                <artifactId>my-app</artifactId>
                <version>1.0.0</version>
                <dependencies>
                    <dependency>
                        <groupId>junit</groupId>
                        <artifactId>junit</artifactId>
                        <version>4.13.2</version>
                        <scope>test</scope>
                    </dependency>
                </dependencies>
            </project>
            """);
        
        // Maven команды
        System.out.println("Основные Maven команды:");
        System.out.println("- mvn compile - компиляция");
        System.out.println("- mvn test - запуск тестов");
        System.out.println("- mvn package - создание JAR");
        System.out.println("- mvn install - установка в локальный репозиторий");
        System.out.println("- mvn clean - очистка");
        
        System.out.println("Maven проект создан");
    }
    
    private static void demonstrateGradle() {
        System.out.println("Демонстрация Gradle:");
        
        // Создание build.gradle
        System.out.println("Создание build.gradle:");
        System.out.println("""
            plugins {
                id 'java'
                id 'application'
            }
            
            group = 'com.example'
            version = '1.0.0'
            
            repositories {
                mavenCentral()
            }
            
            dependencies {
                testImplementation 'junit:junit:4.13.2'
            }
            
            application {
                mainClass = 'com.example.App'
            }
            """);
        
        // Gradle команды
        System.out.println("Основные Gradle команды:");
        System.out.println("- gradle build - сборка проекта");
        System.out.println("- gradle test - запуск тестов");
        System.out.println("- gradle run - запуск приложения");
        System.out.println("- gradle clean - очистка");
        System.out.println("- gradle dependencies - просмотр зависимостей");
        
        System.out.println("Gradle проект создан");
    }
    
    private static void demonstrateDependencyManagement() {
        System.out.println("Демонстрация управления зависимостями:");
        
        // Зависимости
        List<Dependency> dependencies = Arrays.asList(
            new Dependency("org.springframework", "spring-core", "5.3.20"),
            new Dependency("org.springframework", "spring-web", "5.3.20"),
            new Dependency("com.fasterxml.jackson.core", "jackson-databind", "2.13.3"),
            new Dependency("junit", "junit", "4.13.2")
        );
        
        System.out.println("Зависимости проекта:");
        for (Dependency dep : dependencies) {
            System.out.println("- " + dep.getGroupId() + ":" + dep.getArtifactId() + ":" + dep.getVersion());
        }
        
        // Разрешение конфликтов
        System.out.println("\nРазрешение конфликтов версий:");
        System.out.println("- Использование dependencyManagement");
        System.out.println("- Исключение конфликтующих зависимостей");
        System.out.println("- Принудительное использование определенной версии");
        
        System.out.println("Управление зависимостями настроено");
    }
    
    private static void demonstrateBuildLifecycle() {
        System.out.println("Демонстрация жизненного цикла сборки:");
        
        BuildLifecycle lifecycle = new BuildLifecycle();
        
        // Выполнение фаз
        System.out.println("Выполнение фаз сборки:");
        lifecycle.executePhase("validate");
        lifecycle.executePhase("compile");
        lifecycle.executePhase("test");
        lifecycle.executePhase("package");
        lifecycle.executePhase("verify");
        lifecycle.executePhase("install");
        
        System.out.println("Жизненный цикл сборки выполнен");
    }
}

// ========================================
// КЛАССЫ ДЛЯ ДЕМОНСТРАЦИИ
// ========================================

class Dependency {
    private String groupId;
    private String artifactId;
    private String version;
    
    public Dependency(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }
    
    public String getGroupId() { return groupId; }
    public String getArtifactId() { return artifactId; }
    public String getVersion() { return version; }
}

class BuildLifecycle {
    private List<String> phases = Arrays.asList(
        "validate", "compile", "test", "package", "verify", "install", "deploy"
    );
    
    public void executePhase(String phase) {
        if (phases.contains(phase)) {
            System.out.println("Выполняется фаза: " + phase);
            
            switch (phase) {
                case "validate":
                    System.out.println("  - Проверка структуры проекта");
                    System.out.println("  - Валидация pom.xml");
                    break;
                case "compile":
                    System.out.println("  - Компиляция исходного кода");
                    System.out.println("  - Создание .class файлов");
                    break;
                case "test":
                    System.out.println("  - Запуск unit тестов");
                    System.out.println("  - Генерация отчетов");
                    break;
                case "package":
                    System.out.println("  - Создание JAR файла");
                    System.out.println("  - Упаковка ресурсов");
                    break;
                case "verify":
                    System.out.println("  - Проверка качества кода");
                    System.out.println("  - Валидация артефакта");
                    break;
                case "install":
                    System.out.println("  - Установка в локальный репозиторий");
                    System.out.println("  - Обновление метаданных");
                    break;
            }
        }
    }
}

class SimpleMavenProject {
    public void demonstrateMavenProject() {
        System.out.println("Демонстрация простого Maven проекта:");
        
        // Структура проекта
        System.out.println("Структура проекта:");
        System.out.println("my-app/");
        System.out.println("├── src/");
        System.out.println("│   ├── main/");
        System.out.println("│   │   ├── java/");
        System.out.println("│   │   └── resources/");
        System.out.println("│   └── test/");
        System.out.println("│       ├── java/");
        System.out.println("│       └── resources/");
        System.out.println("├── target/");
        System.out.println("└── pom.xml");
        
        // Команды сборки
        System.out.println("\nКоманды сборки:");
        System.out.println("mvn clean compile");
        System.out.println("mvn test");
        System.out.println("mvn package");
        System.out.println("mvn install");
        
        // Результат сборки
        System.out.println("\nРезультат сборки:");
        System.out.println("- Скомпилированные .class файлы");
        System.out.println("- JAR файл с приложением");
        System.out.println("- Отчеты о тестировании");
        System.out.println("- Документация");
        
        System.out.println("Maven проект собран успешно");
    }
}

class SimpleGradleProject {
    public void demonstrateGradleProject() {
        System.out.println("Демонстрация простого Gradle проекта:");
        
        // Структура проекта
        System.out.println("Структура проекта:");
        System.out.println("my-app/");
        System.out.println("├── src/");
        System.out.println("│   ├── main/");
        System.out.println("│   │   ├── java/");
        System.out.println("│   │   └── resources/");
        System.out.println("│   └── test/");
        System.out.println("│       ├── java/");
        System.out.println("│       └── resources/");
        System.out.println("├── build/");
        System.out.println("├── build.gradle");
        System.out.println("└── settings.gradle");
        
        // Команды сборки
        System.out.println("\nКоманды сборки:");
        System.out.println("gradle build");
        System.out.println("gradle test");
        System.out.println("gradle run");
        System.out.println("gradle clean");
        
        // Результат сборки
        System.out.println("\nРезультат сборки:");
        System.out.println("- Скомпилированные .class файлы");
        System.out.println("- JAR файл с приложением");
        System.out.println("- Отчеты о тестировании");
        System.out.println("- Кэш Gradle");
        
        System.out.println("Gradle проект собран успешно");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Maven и Gradle - популярные инструменты сборки для Java
 * 2. Maven использует XML конфигурацию, Gradle - DSL
 * 3. Оба инструмента поддерживают управление зависимостями
 * 4. Жизненный цикл сборки автоматизирует процесс разработки
 * 5. Плагины расширяют функциональность инструментов сборки
 * 6. Многопроектная сборка ускоряет разработку больших проектов
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте простой Maven проект
 * 2. Создайте простой Gradle проект
 * 3. Настройте зависимости и плагины
 * 4. Создайте многопроектную сборку
 */
