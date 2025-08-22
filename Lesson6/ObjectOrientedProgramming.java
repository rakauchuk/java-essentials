/**
 * Урок 6: Объектно-ориентированное программирование (ООП)
 * 
 * В этом уроке мы изучим:
 * - Классы и объекты
 * - Конструкторы
 * - Инкапсуляция (private, public, getter, setter)
 * - Поля и методы
 * - Ключевое слово this
 * - toString() метод
 */

public class ObjectOrientedProgramming {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 6: Объектно-ориентированное программирование ===\n");
        
        // Создание объектов
        Person person1 = new Person();
        Person person2 = new Person("Анна", 25);
        Person person3 = new Person("Борис", 30, "boris@email.com");
        
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);
        System.out.println("person3: " + person3);
        
        // Работа с методами
        person1.setName("Вера");
        person1.setAge(28);
        person1.setEmail("vera@email.com");
        
        System.out.println("person1 после изменений: " + person1);
        System.out.println("Имя person1: " + person1.getName());
        System.out.println("Возраст person1: " + person1.getAge());
        System.out.println("person1 совершеннолетний: " + person1.isAdult());
        
        // Вызов метода для получения информации
        person2.displayInfo();
        person3.displayInfo();
        
        // Работа с классом Student
        Student student1 = new Student("Иван", 20, "ivan@email.com", "CS101");
        student1.addGrade(85);
        student1.addGrade(92);
        student1.addGrade(78);
        
        System.out.println("student1: " + student1);
        System.out.println("Средний балл student1: " + student1.getAverageGrade());
        
        // Работа с классом Car
        Car car1 = new Car("Toyota", "Camry", 2020, 25000);
        System.out.println("car1: " + car1);
        
        car1.startEngine();
        car1.accelerate(60);
        car1.brake();
        car1.stopEngine();
        
        System.out.println("\n=== Урок 6 завершен! ===");
        System.out.println("Вы изучили основы ООП!");
    }
}

// Класс Person - пример базового класса
class Person {
    // Приватные поля (инкапсуляция)
    private String name;
    private int age;
    private String email;
    
    // Константы
    public static final int ADULT_AGE = 18;
    
    // Конструктор по умолчанию
    public Person() {
        this.name = "Неизвестно";
        this.age = 0;
        this.email = "нет";
    }
    
    // Параметризованный конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "нет";
    }
    
    // Полный конструктор
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Геттеры
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    
    // Сеттеры
    public void setName(String name) { this.name = name; }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным!");
        }
    }
    
    public void setEmail(String email) { this.email = email; }
    
    // Методы для работы с объектом
    public boolean isAdult() {
        return age >= ADULT_AGE;
    }
    
    public void displayInfo() {
        System.out.println("Информация о человеке:");
        System.out.println("  Имя: " + name);
        System.out.println("  Возраст: " + age + " лет");
        System.out.println("  Email: " + email);
        System.out.println("  Совершеннолетний: " + (isAdult() ? "Да" : "Нет"));
    }
    
    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

// Класс Student - наследует от Person
class Student extends Person {
    private String studentId;
    private java.util.ArrayList<Integer> grades;
    
    public Student(String name, int age, String email, String studentId) {
        super(name, age, email); // вызов конструктора родительского класса
        this.studentId = studentId;
        this.grades = new java.util.ArrayList<>();
    }
    
    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Оценка должна быть от 0 до 100!");
        }
    }
    
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    
    @Override
    public String toString() {
        return "Student{name='" + getName() + "', age=" + getAge() + 
               ", studentId='" + studentId + "', averageGrade=" + getAverageGrade() + "}";
    }
}

// Класс Car - пример класса с поведением
class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean isRunning;
    private int currentSpeed;
    
    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isRunning = false;
        this.currentSpeed = 0;
    }
    
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + ": Двигатель запущен");
        } else {
            System.out.println(brand + " " + model + ": Двигатель уже работает");
        }
    }
    
    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            currentSpeed = 0;
            System.out.println(brand + " " + model + ": Двигатель остановлен");
        } else {
            System.out.println(brand + " " + model + ": Двигатель уже остановлен");
        }
    }
    
    public void accelerate(int speed) {
        if (isRunning) {
            currentSpeed += speed;
            System.out.println(brand + " " + model + ": Скорость увеличена до " + currentSpeed + " км/ч");
        } else {
            System.out.println(brand + " " + model + ": Сначала запустите двигатель");
        }
    }
    
    public void brake() {
        if (currentSpeed > 0) {
            currentSpeed = Math.max(0, currentSpeed - 20);
            System.out.println(brand + " " + model + ": Скорость снижена до " + currentSpeed + " км/ч");
        } else {
            System.out.println(brand + " " + model + ": Автомобиль уже остановлен");
        }
    }
    
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', year=" + year + 
               ", price=" + price + ", isRunning=" + isRunning + ", speed=" + currentSpeed + "}";
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Класс - это шаблон для создания объектов
 * 2. Объект - это экземпляр класса
 * 3. Инкапсуляция защищает данные через private поля
 * 4. Геттеры и сеттеры обеспечивают контролируемый доступ
 * 5. Конструкторы инициализируют объекты
 * 6. this ссылается на текущий объект
 * 7. toString() используется для строкового представления объекта
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте класс Rectangle с методами для вычисления площади и периметра
 * 2. Создайте класс Product с полями name, price, quantity
 * 3. Добавьте валидацию данных в сеттеры
 */
