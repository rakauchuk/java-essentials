/**
 * Урок 13: Многопоточность (Threads)
 * 
 * В этом уроке мы изучим:
 * - Создание потоков
 * - Синхронизация потоков
 * - Ключевое слово synchronized
 * - Методы wait(), notify(), notifyAll()
 * - ThreadLocal
 * - ExecutorService и ThreadPool
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Multithreading {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 13: Многопоточность (Threads) ===\n");
        
        // ========================================
        // СОЗДАНИЕ ПОТОКОВ
        // ========================================
        
        System.out.println("--- СОЗДАНИЕ ПОТОКОВ ---");
        
        // Способ 1: Наследование от Thread
        MyThread thread1 = new MyThread("Поток-1");
        MyThread thread2 = new MyThread("Поток-2");
        
        // Способ 2: Реализация Runnable
        MyRunnable runnable = new MyRunnable("Runnable-поток");
        Thread thread3 = new Thread(runnable);
        
        // Способ 3: Лямбда-выражение
        Thread thread4 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Лямбда-поток: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Запуск потоков
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        // Ожидание завершения потоков
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // ========================================
        // СИНХРОНИЗАЦИЯ ПОТОКОВ
        // ========================================
        
        System.out.println("\n--- СИНХРОНИЗАЦИЯ ПОТОКОВ ---");
        
        Counter counter = new Counter();
        
        // Создание потоков, работающих с общим ресурсом
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
        }
        
        // Запуск всех потоков
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Ожидание завершения
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Финальное значение счетчика: " + counter.getValue());
        
        // ========================================
        // SYNCHRONIZED БЛОКИ
        // ========================================
        
        System.out.println("\n--- SYNCHRONIZED БЛОКИ ---");
        
        BankAccount account = new BankAccount(1000);
        
        // Создание потоков для снятия денег
        Thread[] withdrawThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            withdrawThreads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    account.withdraw(10);
                }
            });
        }
        
        // Запуск потоков
        for (Thread thread : withdrawThreads) {
            thread.start();
        }
        
        // Ожидание завершения
        for (Thread thread : withdrawThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Остаток на счете: " + account.getBalance());
        
        // ========================================
        // WAIT И NOTIFY
        // ========================================
        
        System.out.println("\n--- WAIT И NOTIFY ---");
        
        Message message = new Message();
        
        // Поток-отправитель
        Thread sender = new Thread(() -> {
            String[] messages = {"Привет!", "Как дела?", "Пока!"};
            for (String msg : messages) {
                message.send(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Поток-получатель
        Thread receiver = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                message.receive();
            }
        });
        
        // Запуск потоков
        receiver.start();
        sender.start();
        
        // Ожидание завершения
        try {
            sender.join();
            receiver.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // ========================================
        // THREADLOCAL
        // ========================================
        
        System.out.println("\n--- THREADLOCAL ---");
        
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Начальное значение");
        
        // Создание потоков с ThreadLocal
        Thread[] localThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            localThreads[i] = new Thread(() -> {
                threadLocal.set("Значение для потока " + threadId);
                System.out.println("Поток " + threadId + ": " + threadLocal.get());
            });
        }
        
        // Запуск потоков
        for (Thread thread : localThreads) {
            thread.start();
        }
        
        // Ожидание завершения
        for (Thread thread : localThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // ========================================
        // EXECUTORSERVICE И THREADPOOL
        // ========================================
        
        System.out.println("\n--- EXECUTORSERVICE И THREADPOOL ---");
        
        // Создание пула потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Отправка задач в пул
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Задача " + taskId + " выполняется потоком: " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Результат задачи " + taskId;
            });
        }
        
        // Завершение работы пула
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        
        // ========================================
        // ПРАКТИЧЕСКИЕ ПРИМЕРЫ
        // ========================================
        
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        // Пример 1: Параллельная обработка массива
        System.out.println("=== ПАРАЛЛЕЛЬНАЯ ОБРАБОТКА МАССИВА ===");
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AtomicInteger sum = new AtomicInteger(0);
        
        // Создание потоков для обработки частей массива
        int chunkSize = numbers.length / 2;
        Thread[] sumThreads = new Thread[2];
        
        for (int i = 0; i < 2; i++) {
            final int start = i * chunkSize;
            final int end = (i == 1) ? numbers.length : (i + 1) * chunkSize;
            
            sumThreads[i] = new Thread(() -> {
                int localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += numbers[j];
                }
                sum.addAndGet(localSum);
                System.out.println("Поток " + Thread.currentThread().getName() + 
                                 " обработал элементы " + start + "-" + (end-1) + 
                                 ", сумма: " + localSum);
            });
        }
        
        // Запуск потоков
        for (Thread thread : sumThreads) {
            thread.start();
        }
        
        // Ожидание завершения
        for (Thread thread : sumThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Общая сумма: " + sum.get());
        
        // Пример 2: Producer-Consumer
        System.out.println("\n=== PRODUCER-CONSUMER ===");
        
        SharedQueue queue = new SharedQueue(5);
        
        // Producer
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.produce("Элемент " + i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Consumer
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    String item = queue.consume();
                    System.out.println("Потреблен: " + item);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        
        // Запуск потоков
        producer.start();
        consumer.start();
        
        // Ожидание завершения
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // ========================================
        // ЗАВЕРШЕНИЕ УРОКА
        // ========================================
        
        System.out.println("\n=== Урок 13 завершен! ===");
        System.out.println("Вы изучили многопоточность в Java!");
    }
}

// ========================================
// КЛАССЫ ДЛЯ ДЕМОНСТРАЦИИ
// ========================================

// Способ 1: Наследование от Thread
class MyThread extends Thread {
    private String name;
    
    public MyThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

// Способ 2: Реализация Runnable
class MyRunnable implements Runnable {
    private String name;
    
    public MyRunnable(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

// Синхронизированный счетчик
class Counter {
    private int value = 0;
    
    public synchronized void increment() {
        value++;
    }
    
    public synchronized int getValue() {
        return value;
    }
}

// Банковский счет с синхронизацией
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снято: " + amount + ", остаток: " + balance);
        } else {
            System.out.println("Недостаточно средств для снятия: " + amount);
        }
    }
    
    public synchronized double getBalance() {
        return balance;
    }
}

// Класс для демонстрации wait/notify
class Message {
    private String message;
    private boolean empty = true;
    
    public synchronized void send(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        this.message = message;
        empty = false;
        notify();
    }
    
    public synchronized String receive() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        empty = true;
        notify();
        System.out.println("Получено сообщение: " + message);
        return message;
    }
}

// Очередь для Producer-Consumer
class SharedQueue {
    private String[] queue;
    private int size;
    private int count = 0;
    private int head = 0;
    private int tail = 0;
    
    public SharedQueue(int size) {
        this.size = size;
        this.queue = new String[size];
    }
    
    public synchronized void produce(String item) throws InterruptedException {
        while (count == size) {
            wait();
        }
        queue[tail] = item;
        tail = (tail + 1) % size;
        count++;
        System.out.println("Произведен: " + item);
        notify();
    }
    
    public synchronized String consume() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        String item = queue[head];
        head = (head + 1) % size;
        count--;
        notify();
        return item;
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Потоки позволяют выполнять код параллельно
 * 2. Синхронизация необходима для безопасной работы с общими ресурсами
 * 3. synchronized обеспечивает взаимное исключение
 * 4. wait/notify используются для координации потоков
 * 5. ThreadLocal предоставляет локальные переменные для каждого потока
 * 6. ExecutorService управляет пулом потоков
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте программу с несколькими потоками
 * 2. Реализуйте синхронизацию для общего ресурса
 * 3. Используйте wait/notify для координации потоков
 * 4. Создайте пул потоков с ExecutorService
 */
