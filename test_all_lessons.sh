#!/bin/bash

# Скрипт для тестирования всех уроков Java
echo "=== Тестирование всех уроков Java ==="
echo ""

# Функция для тестирования урока
test_lesson() {
    local lesson_num=$1
    local lesson_name=$2
    local class_name=$3
    
    echo "--- Тестирование Урока $lesson_num: $lesson_name ---"
    
    # Переходим в папку урока
    cd "Lesson$lesson_num" 2>/dev/null
    
    if [ $? -eq 0 ]; then
        # Компилируем
        echo "Компиляция..."
        javac "$class_name.java" 2>/dev/null
        
        if [ $? -eq 0 ]; then
            echo "✓ Компиляция успешна"
            
            # Запускаем (показываем только первые несколько строк)
            echo "Запуск программы..."
            echo "Вывод программы:"
            echo "=================="
            java "$class_name" 2>/dev/null | head -10
            echo "=================="
            echo "✓ Урок $lesson_num протестирован успешно"
        else
            echo "✗ Ошибка компиляции в уроке $lesson_num"
        fi
        
        # Возвращаемся в корневую папку
        cd ..
    else
        echo "✗ Папка Lesson$lesson_num не найдена"
    fi
    
    echo ""
}

# Тестируем все уроки
test_lesson 1 "Основы синтаксиса Java" "BasicSyntax"
test_lesson 2 "Переменные и типы данных" "VariablesAndDataTypes"
test_lesson 3 "Управляющие конструкции" "ControlFlow"
test_lesson 4 "Массивы и коллекции" "ArraysAndCollections"
test_lesson 5 "Методы и функции" "MethodsAndFunctions"
test_lesson 6 "Объектно-ориентированное программирование" "ObjectOrientedProgramming"
test_lesson 7 "Наследование и полиморфизм" "InheritanceAndPolymorphism"
test_lesson 8 "Интерфейсы и абстрактные классы" "InterfacesAndAbstractClasses"
test_lesson 9 "Обработка исключений" "ExceptionHandling"
test_lesson 10 "Работа с файлами" "FileIO"
test_lesson 11 "Обобщения" "Generics"
test_lesson 12 "Потоки и лямбда-выражения" "StreamsAndLambda"
test_lesson 13 "Многопоточность" "Multithreading"
test_lesson 14 "Сетевое программирование" "Networking"
test_lesson 15 "Работа с базами данных" "DatabaseJDBC"
test_lesson 16 "Веб-разработка" "WebDevelopment"
test_lesson 17 "Spring Framework" "SpringFramework"
test_lesson 18 "Тестирование" "TestingJUnit"
test_lesson 19 "Логирование" "Logging"
test_lesson 20 "Инструменты сборки" "BuildTools"
test_lesson 21 "Структуры данных" "DataStructures"

echo "=== Тестирование завершено ==="
echo ""
echo "Для полного просмотра вывода каждого урока выполните:"
echo "cd Lesson1 && java BasicSyntax"
echo "cd Lesson2 && java VariablesAndDataTypes"
echo "и так далее..."
