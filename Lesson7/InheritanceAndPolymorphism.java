/**
 * Урок 7: Наследование и полиморфизм
 * 
 * В этом уроке мы изучим:
 * - Наследование классов
 * - Переопределение методов (override)
 * - Полиморфизм
 * - Ключевое слово super
 * - Модификаторы доступа в наследовании
 */

public class InheritanceAndPolymorphism {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 7: Наследование и полиморфизм ===\n");
        
        // Создание объектов базового класса
        Animal animal = new Animal("Животное", 5);
        System.out.println("animal: " + animal);
        animal.makeSound();
        animal.eat();
        
        // Создание объектов наследников
        Dog dog = new Dog("Бобик", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2, "Домашняя");
        
        System.out.println("dog: " + dog);
        System.out.println("cat: " + cat);
        
        // Переопределение методов
        dog.makeSound();
        dog.eat();
        dog.fetch();
        
        cat.makeSound();
        cat.eat();
        cat.climb();
        
        // Полиморфизм
        System.out.println("\n--- ПОЛИМОРФИЗМ ---");
        
        Animal[] animals = {animal, dog, cat};
        
        System.out.println("Полиморфный вызов методов:");
        for (Animal a : animals) {
            System.out.print(a.getName() + ": ");
            a.makeSound(); // Полиморфный вызов
        }
        
        // Многоуровневое наследование
        System.out.println("\n--- МНОГОУРОВНЕВОЕ НАСЛЕДОВАНИЕ ---");
        
        Vehicle vehicle = new Vehicle("Транспорт", 2020);
        Car car = new Car("Toyota", "Camry", 2020, 25000);
        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3", 2021, 45000, 350);
        
        System.out.println("vehicle: " + vehicle);
        System.out.println("car: " + car);
        System.out.println("electricCar: " + electricCar);
        
        vehicle.start();
        car.start();
        electricCar.start();
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        Employee employee = new Employee("Иван", 30000);
        Manager manager = new Manager("Анна", 50000, "IT");
        
        System.out.println("employee: " + employee);
        System.out.println("manager: " + manager);
        
        employee.work();
        manager.work();
        manager.manage();
        
        System.out.println("\n=== Урок 7 завершен! ===");
        System.out.println("Вы изучили наследование и полиморфизм!");
    }
}

// Базовый класс
class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
    
    public void eat() {
        System.out.println(name + " ест");
    }
    
    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}

// Наследники
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // Вызов конструктора родительского класса
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав-гав!");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " ест косточку");
    }
    
    public void fetch() {
        System.out.println(name + " приносит мячик");
    }
    
    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }
}

class Cat extends Animal {
    private String type;
    
    public Cat(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяу-мяу!");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " ест рыбу");
    }
    
    public void climb() {
        System.out.println(name + " лазает по деревьям");
    }
    
    @Override
    public String toString() {
        return "Cat{name='" + name + "', age=" + age + ", type='" + type + "'}";
    }
}

// Многоуровневое наследование
class Vehicle {
    protected String brand;
    protected int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    public void start() {
        System.out.println(brand + " запускается");
    }
    
    @Override
    public String toString() {
        return "Vehicle{brand='" + brand + "', year=" + year + "}";
    }
}

class Car extends Vehicle {
    protected String model;
    protected double price;
    
    public Car(String brand, String model, int year, double price) {
        super(brand, year);
        this.model = model;
        this.price = price;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " " + model + " заводится");
    }
    
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', year=" + year + ", price=" + price + "}";
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;
    
    public ElectricCar(String brand, String model, int year, double price, int batteryCapacity) {
        super(brand, model, year, price);
        this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public void start() {
        System.out.println(brand + " " + model + " запускается бесшумно");
    }
    
    @Override
    public String toString() {
        return "ElectricCar{brand='" + brand + "', model='" + model + "', year=" + year + 
               ", price=" + price + ", batteryCapacity=" + batteryCapacity + "}";
    }
}

// Практические примеры
class Employee {
    protected String name;
    protected double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public void work() {
        System.out.println(name + " работает");
    }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

class Manager extends Employee {
    private String department;
    
    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }
    
    @Override
    public void work() {
        System.out.println(name + " управляет отделом " + department);
    }
    
    public void manage() {
        System.out.println(name + " проводит совещание");
    }
    
    @Override
    public String toString() {
        return "Manager{name='" + name + "', salary=" + salary + ", department='" + department + "'}";
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Наследование позволяет создавать иерархию классов
 * 2. Полиморфизм позволяет использовать объекты через ссылки базового класса
 * 3. super используется для вызова методов родительского класса
 * 4. @Override аннотация указывает на переопределение метода
 * 5. Многоуровневое наследование создает цепочку наследования
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте класс Fish, наследующий от Animal
 * 2. Добавьте новый метод в базовый класс и переопределите его в наследниках
 * 3. Создайте массив разных типов животных и продемонстрируйте полиморфизм
 */
