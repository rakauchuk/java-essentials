/**
 * Урок 8: Интерфейсы и абстрактные классы
 * 
 * В этом уроке мы изучим:
 * - Абстрактные классы
 * - Интерфейсы
 * - Реализация интерфейсов
 * - Множественная реализация интерфейсов
 * - Интерфейсы по умолчанию (default methods)
 */

public class InterfacesAndAbstractClasses {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 8: Интерфейсы и абстрактные классы ===\n");
        
        // Абстрактные классы
        System.out.println("--- АБСТРАКТНЫЕ КЛАССЫ ---");
        
        // Shape shape = new Shape(); // Ошибка! Нельзя создать экземпляр абстрактного класса
        
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        
        System.out.println("circle: " + circle);
        System.out.println("rectangle: " + rectangle);
        
        System.out.println("Площадь круга: " + circle.calculateArea());
        System.out.println("Периметр круга: " + circle.calculatePerimeter());
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());
        System.out.println("Периметр прямоугольника: " + rectangle.calculatePerimeter());
        
        // Интерфейсы
        System.out.println("\n--- ИНТЕРФЕЙСЫ ---");
        
        Car car = new Car("Toyota", "Camry");
        Bicycle bicycle = new Bicycle("Giant", "Defy");
        
        System.out.println("car: " + car);
        System.out.println("bicycle: " + bicycle);
        
        // Использование методов интерфейса
        car.start();
        car.stop();
        car.accelerate(60);
        
        bicycle.start();
        bicycle.stop();
        bicycle.accelerate(25);
        
        // Множественная реализация интерфейсов
        System.out.println("\n--- МНОЖЕСТВЕННАЯ РЕАЛИЗАЦИЯ ---");
        
        SmartPhone phone = new SmartPhone("iPhone", "14");
        System.out.println("phone: " + phone);
        
        phone.call("123-456-789");
        phone.sendMessage("Привет!");
        phone.takePhoto();
        phone.playMusic();
        
        // Интерфейсы по умолчанию
        System.out.println("\n--- ИНТЕРФЕЙСЫ ПО УМОЛЧАНИЮ ---");
        
        ModernCar modernCar = new ModernCar("Tesla", "Model S");
        modernCar.start();
        modernCar.stop();
        modernCar.accelerate(80);
        modernCar.autoPilot(); // Метод по умолчанию
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Система животных
        System.out.println("=== СИСТЕМА ЖИВОТНЫХ ===");
        
        Dog dog = new Dog("Бобик");
        Bird bird = new Bird("Чижик");
        Fish fish = new Fish("Немо");
        
        dog.makeSound();
        dog.move();
        dog.eat();
        
        bird.makeSound();
        bird.move();
        bird.eat();
        bird.fly();
        
        fish.makeSound();
        fish.move();
        fish.eat();
        fish.swim();
        
        // Система сотрудников
        System.out.println("\n=== СИСТЕМА СОТРУДНИКОВ ===");
        
        Developer developer = new Developer("Иван", "Java");
        Designer designer = new Designer("Анна", "UI/UX");
        Manager manager = new Manager("Борис", "IT");
        
        developer.work();
        developer.code();
        developer.attendMeeting();
        
        designer.work();
        designer.design();
        designer.attendMeeting();
        
        manager.work();
        manager.manage();
        manager.attendMeeting();
        
        System.out.println("\n=== Урок 8 завершен! ===");
        System.out.println("Вы изучили интерфейсы и абстрактные классы!");
    }
}

// ========================================
// АБСТРАКТНЫЕ КЛАССЫ
// ========================================

abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
    
    // Абстрактные методы - должны быть реализованы в наследниках
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Конкретные методы - могут быть переопределены
    public void displayInfo() {
        System.out.println("Фигура: " + name);
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Круг");
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return "Circle{name='" + name + "', radius=" + radius + "}";
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        super("Прямоугольник");
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public String toString() {
        return "Rectangle{name='" + name + "', width=" + width + ", height=" + height + "}";
    }
}

// ========================================
// ИНТЕРФЕЙСЫ
// ========================================

interface Vehicle {
    void start();
    void stop();
    void accelerate(int speed);
}

class Car implements Vehicle {
    private String brand;
    private String model;
    
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " " + model + " заводится");
    }
    
    @Override
    public void stop() {
        System.out.println(brand + " " + model + " останавливается");
    }
    
    @Override
    public void accelerate(int speed) {
        System.out.println(brand + " " + model + " разгоняется до " + speed + " км/ч");
    }
    
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "'}";
    }
}

class Bicycle implements Vehicle {
    private String brand;
    private String model;
    
    public Bicycle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " " + model + " начинает движение");
    }
    
    @Override
    public void stop() {
        System.out.println(brand + " " + model + " останавливается");
    }
    
    @Override
    public void accelerate(int speed) {
        System.out.println(brand + " " + model + " разгоняется до " + speed + " км/ч");
    }
    
    @Override
    public String toString() {
        return "Bicycle{brand='" + brand + "', model='" + model + "'}";
    }
}

// ========================================
// МНОЖЕСТВЕННАЯ РЕАЛИЗАЦИЯ ИНТЕРФЕЙСОВ
// ========================================

interface Phone {
    void call(String number);
    void sendMessage(String message);
}

interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class SmartPhone implements Phone, Camera, MusicPlayer {
    private String brand;
    private String model;
    
    public SmartPhone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    @Override
    public void call(String number) {
        System.out.println(brand + " " + model + " звонит на номер " + number);
    }
    
    @Override
    public void sendMessage(String message) {
        System.out.println(brand + " " + model + " отправляет сообщение: " + message);
    }
    
    @Override
    public void takePhoto() {
        System.out.println(brand + " " + model + " делает фото");
    }
    
    @Override
    public void playMusic() {
        System.out.println(brand + " " + model + " играет музыку");
    }
    
    @Override
    public String toString() {
        return "SmartPhone{brand='" + brand + "', model='" + model + "'}";
    }
}

// ========================================
// ИНТЕРФЕЙСЫ ПО УМОЛЧАНИЮ
// ========================================

interface ModernVehicle extends Vehicle {
    // Метод по умолчанию - не нужно реализовывать
    default void autoPilot() {
        System.out.println("Автопилот включен");
    }
}

class ModernCar implements ModernVehicle {
    private String brand;
    private String model;
    
    public ModernCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " " + model + " запускается бесшумно");
    }
    
    @Override
    public void stop() {
        System.out.println(brand + " " + model + " останавливается");
    }
    
    @Override
    public void accelerate(int speed) {
        System.out.println(brand + " " + model + " разгоняется до " + speed + " км/ч");
    }
    
    @Override
    public String toString() {
        return "ModernCar{brand='" + brand + "', model='" + model + "'}";
    }
}

// ========================================
// ПРАКТИЧЕСКИЕ ПРИМЕРЫ
// ========================================

// Система животных
interface Animal {
    void makeSound();
    void move();
    void eat();
}

interface Flying {
    void fly();
}

interface Swimming {
    void swim();
}

abstract class AbstractAnimal implements Animal {
    protected String name;
    
    public AbstractAnimal(String name) {
        this.name = name;
    }
    
    @Override
    public void eat() {
        System.out.println(name + " ест");
    }
}

class Dog extends AbstractAnimal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав-гав!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " бегает");
    }
}

class Bird extends AbstractAnimal implements Flying {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " поет: Чик-чирик!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " ходит");
    }
    
    @Override
    public void fly() {
        System.out.println(name + " летает");
    }
}

class Fish extends AbstractAnimal implements Swimming {
    public Fish(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " молчит");
    }
    
    @Override
    public void move() {
        System.out.println(name + " плавает");
    }
    
    @Override
    public void swim() {
        System.out.println(name + " плавает в воде");
    }
}

// Система сотрудников
interface Worker {
    void work();
}

interface MeetingAttendee {
    void attendMeeting();
}

abstract class Employee implements Worker, MeetingAttendee {
    protected String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    @Override
    public void attendMeeting() {
        System.out.println(name + " участвует в совещании");
    }
}

class Developer extends Employee {
    private String language;
    
    public Developer(String name, String language) {
        super(name);
        this.language = language;
    }
    
    @Override
    public void work() {
        System.out.println(name + " программирует на " + language);
    }
    
    public void code() {
        System.out.println(name + " пишет код");
    }
}

class Designer extends Employee {
    private String specialty;
    
    public Designer(String name, String specialty) {
        super(name);
        this.specialty = specialty;
    }
    
    @Override
    public void work() {
        System.out.println(name + " занимается дизайном " + specialty);
    }
    
    public void design() {
        System.out.println(name + " создает дизайн");
    }
}

class Manager extends Employee {
    private String department;
    
    public Manager(String name, String department) {
        super(name);
        this.department = department;
    }
    
    @Override
    public void work() {
        System.out.println(name + " управляет отделом " + department);
    }
    
    public void manage() {
        System.out.println(name + " проводит управление");
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Абстрактные классы не могут быть инстанцированы
 * 2. Абстрактные методы должны быть реализованы в наследниках
 * 3. Интерфейсы определяют контракт для классов
 * 4. Класс может реализовывать несколько интерфейсов
 * 5. Интерфейсы по умолчанию предоставляют реализацию методов
 * 6. Абстрактные классы могут содержать как абстрактные, так и конкретные методы
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте абстрактный класс для разных типов транспорта
 * 2. Создайте интерфейс для устройств с батареей
 * 3. Реализуйте множественное наследование через интерфейсы
 * 4. Добавьте методы по умолчанию в интерфейсы
 */
