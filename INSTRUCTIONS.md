# Инструкции по выполнению уроков Java

## Общие инструкции

### Требования
- Java JDK 17 или выше
- Терминал или командная строка
- Любой текстовый редактор или IDE

### Как компилировать и запускать Java программы

1. **Откройте терминал** в папке проекта
2. **Перейдите в папку урока**: `cd Lesson1`
3. **Скомпилируйте программу**: `javac ИмяФайла.java`
4. **Запустите программу**: `java ИмяКласса`

**Альтернативный способ (из корневой папки):**
1. **Скомпилируйте**: `javac Lesson1/ИмяФайла.java`
2. **Запустите**: `cd Lesson1 && java ИмяКласса`

## Урок 1: Основы синтаксиса Java

```bash
# Способ 1: Из папки урока
cd Lesson1
javac BasicSyntax.java
java BasicSyntax

# Способ 2: Из корневой папки
javac Lesson1/BasicSyntax.java
cd Lesson1 && java BasicSyntax
```

**Что изучить:**
- Структура Java программы
- Комментарии (//, /* */, /** */)
- Вывод в консоль (System.out.println)
- Математические операции
- Логические операции
- Операции сравнения

## Урок 2: Переменные и типы данных

```bash
# Компиляция
javac Lesson2/VariablesAndDataTypes.java

# Запуск
java Lesson2.VariablesAndDataTypes
```

**Что изучить:**
- Примитивные типы данных (8 типов)
- Ссылочные типы данных
- Объявление и инициализация переменных
- Преобразование типов
- Константы (final)

## Урок 3: Управляющие конструкции

```bash
# Компиляция
javac Lesson3/ControlFlow.java

# Запуск
java Lesson3.ControlFlow
```

**Что изучить:**
- Условные операторы (if, else, else if)
- Оператор switch
- Циклы (for, while, do-while, for-each)
- Операторы break и continue
- Тернарный оператор

## Урок 4: Массивы и коллекции

```bash
# Компиляция
javac Lesson4/ArraysAndCollections.java

# Запуск
java Lesson4.ArraysAndCollections
```

**Что изучить:**
- Одномерные и многомерные массивы
- ArrayList (динамический массив)
- LinkedList (связанный список)
- HashSet (множество)
- HashMap (словарь)

## Урок 5: Методы и функции

```bash
# Компиляция
javac Lesson5/MethodsAndFunctions.java

# Запуск
java Lesson5.MethodsAndFunctions
```

**Что изучить:**
- Создание и вызов методов
- Параметры и возвращаемые значения
- Перегрузка методов
- Рекурсия
- Статические методы
- Методы с переменным количеством аргументов

## Урок 6: Объектно-ориентированное программирование

```bash
# Способ 1: Из папки урока
cd Lesson6
javac ObjectOrientedProgramming.java
java ObjectOrientedProgramming

# Способ 2: Из корневой папки
javac Lesson6/ObjectOrientedProgramming.java
cd Lesson6 && java ObjectOrientedProgramming
```

**Что изучить:**
- Классы и объекты
- Конструкторы
- Инкапсуляция (private, public, getter, setter)
- Поля и методы
- Ключевое слово this
- toString() метод

## Урок 7: Наследование и полиморфизм

```bash
# Способ 1: Из папки урока
cd Lesson7
javac InheritanceAndPolymorphism.java
java InheritanceAndPolymorphism

# Способ 2: Из корневой папки
javac Lesson7/InheritanceAndPolymorphism.java
cd Lesson7 && java InheritanceAndPolymorphism
```

**Что изучить:**
- Наследование классов
- Переопределение методов (override)
- Полиморфизм
- Ключевое слово super
- Многоуровневое наследование

## Урок 8: Интерфейсы и абстрактные классы

```bash
# Способ 1: Из папки урока
cd Lesson8
javac InterfacesAndAbstractClasses.java
java InterfacesAndAbstractClasses

# Способ 2: Из корневой папки
javac Lesson8/InterfacesAndAbstractClasses.java
cd Lesson8 && java InterfacesAndAbstractClasses
```

**Что изучить:**
- Абстрактные классы
- Интерфейсы
- Реализация интерфейсов
- Множественная реализация интерфейсов
- Интерфейсы по умолчанию (default methods)

## Урок 9: Обработка исключений

```bash
# Способ 1: Из папки урока
cd Lesson9
javac ExceptionHandling.java
java ExceptionHandling

# Способ 2: Из корневой папки
javac Lesson9/ExceptionHandling.java
cd Lesson9 && java ExceptionHandling
```

**Что изучить:**
- Типы исключений (checked и unchecked)
- Блоки try-catch
- Блок finally
- Множественные catch блоки
- Создание собственных исключений
- Ключевое слово throws

## Урок 10: Работа с файлами

```bash
# Способ 1: Из папки урока
cd Lesson10
javac FileIO.java
java FileIO

# Способ 2: Из корневой папки
javac Lesson10/FileIO.java
cd Lesson10 && java FileIO
```

**Что изучить:**
- Класс File
- Чтение и запись файлов
- BufferedReader и BufferedWriter
- FileReader и FileWriter
- Работа с директориями
- Обработка исключений при работе с файлами

## Урок 11: Обобщения (Generics)

```bash
# Способ 1: Из папки урока
cd Lesson11
javac Generics.java
java Generics

# Способ 2: Из корневой папки
javac Lesson11/Generics.java
cd Lesson11 && java Generics
```

**Что изучить:**
- Обобщенные классы
- Обобщенные методы
- Ограничения типов (bounds)
- Wildcards (подстановочные знаки)
- Обобщенные коллекции
- Type erasure

## Урок 12: Потоки и лямбда-выражения

```bash
# Способ 1: Из папки урока
cd Lesson12
javac StreamsAndLambda.java
java StreamsAndLambda

# Способ 2: Из корневой папки
javac Lesson12/StreamsAndLambda.java
cd Lesson12 && java StreamsAndLambda
```

**Что изучить:**
- Лямбда-выражения
- Функциональные интерфейсы
- Stream API
- Методы потоков (filter, map, reduce)
- Коллекторы

## Советы по изучению

1. **Читайте комментарии** - они объясняют каждую строку кода
2. **Экспериментируйте** - изменяйте код и наблюдайте за результатами
3. **Практикуйтесь** - выполняйте задания в конце каждого урока
4. **Изучайте по порядку** - каждый урок строится на предыдущем
5. **Задавайте вопросы** - если что-то непонятно, ищите дополнительную информацию

## Частые ошибки

- **Забыли точку с запятой** - каждая инструкция должна заканчиваться `;`
- **Неправильный регистр** - Java чувствителен к регистру
- **Неправильные имена файлов** - имя файла должно совпадать с именем класса
- **Неправильный путь** - используйте правильные разделители путей

## Полезные команды

```bash
# Проверка версии Java
java -version

# Компиляция всех файлов в папке
javac *.java

# Запуск с аргументами командной строки
java Lesson1.BasicSyntax arg1 arg2

# Просмотр содержимого файла
cat Lesson1/BasicSyntax.java
```

## Следующие шаги

После изучения всех уроков вы можете:
1. Изучить продвинутые темы Java
2. Изучить фреймворки (Spring, Hibernate)
3. Изучить веб-разработку (Servlets, JSP)
4. Изучить Android разработку
5. Изучить алгоритмы и структуры данных

Удачи в изучении Java! 🚀
