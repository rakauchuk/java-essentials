/**
 * Урок 14: Сетевое программирование
 * 
 * В этом уроке мы изучим:
 * - Socket программирование
 * - TCP клиент-сервер
 * - UDP клиент-сервер
 * - URL и HTTP соединения
 * - InetAddress
 */

import java.io.*;
import java.net.*;

public class Networking {
    
    public static void main(String[] args) {
        
        System.out.println("=== Урок 14: Сетевое программирование ===\n");
        
        // InetAddress
        System.out.println("--- INETADDRESS ---");
        
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Локальный хост: " + localhost.getHostName());
            System.out.println("IP адрес: " + localhost.getHostAddress());
            
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Google хост: " + google.getHostName());
            System.out.println("Google IP: " + google.getHostAddress());
            
        } catch (UnknownHostException e) {
            System.out.println("Ошибка получения адреса: " + e.getMessage());
        }
        
        // URL и HTTP соединения
        System.out.println("\n--- URL И HTTP СОЕДИНЕНИЯ ---");
        
        try {
            URL url = new URL("https://httpbin.org/get");
            System.out.println("Протокол: " + url.getProtocol());
            System.out.println("Хост: " + url.getHost());
            System.out.println("Порт: " + url.getPort());
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            
            System.out.println("Код ответа: " + connection.getResponseCode());
            System.out.println("Тип контента: " + connection.getContentType());
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.out.println("Ошибка HTTP соединения: " + e.getMessage());
        }
        
        // TCP клиент-сервер
        System.out.println("\n--- TCP КЛИЕНТ-СЕРВЕР ---");
        
        // Запуск TCP сервера в отдельном потоке
        Thread tcpServerThread = new Thread(() -> {
            try {
                startTCPServer();
            } catch (IOException e) {
                System.out.println("Ошибка TCP сервера: " + e.getMessage());
            }
        });
        tcpServerThread.start();
        
        try {
            Thread.sleep(1000);
            startTCPClient();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ошибка TCP клиента: " + e.getMessage());
        }
        
        // UDP клиент-сервер
        System.out.println("\n--- UDP КЛИЕНТ-СЕРВЕР ---");
        
        Thread udpServerThread = new Thread(() -> {
            try {
                startUDPServer();
            } catch (IOException e) {
                System.out.println("Ошибка UDP сервера: " + e.getMessage());
            }
        });
        udpServerThread.start();
        
        try {
            Thread.sleep(1000);
            startUDPClient();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ошибка UDP клиента: " + e.getMessage());
        }
        
        // Практические примеры
        System.out.println("\n--- ПРАКТИЧЕСКИЕ ПРИМЕРЫ ---");
        
        System.out.println("=== ПРОСТОЙ HTTP КЛИЕНТ ===");
        try {
            simpleHTTPClient();
        } catch (IOException e) {
            System.out.println("Ошибка HTTP клиента: " + e.getMessage());
        }
        
        System.out.println("\n=== Урок 14 завершен! ===");
        System.out.println("Вы изучили сетевое программирование в Java!");
    }
    
    // TCP сервер
    private static void startTCPServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("TCP Сервер запущен на порту 8080");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("TCP Клиент подключен: " + clientSocket.getInetAddress());
            
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                
                String inputLine = in.readLine();
                System.out.println("TCP Сервер получил: " + inputLine);
                out.println("TCP Сервер отвечает: " + inputLine);
            }
        }
    }
    
    // TCP клиент
    private static void startTCPClient() throws IOException {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {
            
            System.out.println("TCP Клиент подключен к серверу");
            
            String message = "Привет, TCP сервер!";
            out.println(message);
            System.out.println("TCP Клиент отправил: " + message);
            
            String response = in.readLine();
            System.out.println("TCP Клиент получил: " + response);
        }
    }
    
    // UDP сервер
    private static void startUDPServer() throws IOException {
        try (DatagramSocket socket = new DatagramSocket(8081)) {
            System.out.println("UDP Сервер запущен на порту 8081");
            
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("UDP Сервер получил: " + message);
            
            String response = "UDP Сервер отвечает: " + message;
            byte[] responseData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(
                responseData, responseData.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        }
    }
    
    // UDP клиент
    private static void startUDPClient() throws IOException {
        try (DatagramSocket socket = new DatagramSocket()) {
            System.out.println("UDP Клиент запущен");
            
            String message = "Привет, UDP сервер!";
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(
                data, data.length, InetAddress.getLocalHost(), 8081);
            socket.send(packet);
            System.out.println("UDP Клиент отправил: " + message);
            
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("UDP Клиент получил: " + response);
        }
    }
    
    // Простой HTTP клиент
    private static void simpleHTTPClient() throws IOException {
        URL url = new URL("https://httpbin.org/ip");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("IP адрес: " + response.toString());
        }
        
        connection.disconnect();
    }
}

/*
 * ВАЖНЫЕ ЗАМЕЧАНИЯ:
 * 
 * 1. Socket - основной класс для сетевого программирования
 * 2. TCP обеспечивает надежную передачу данных
 * 3. UDP - быстрая передача без гарантий доставки
 * 4. ServerSocket используется для создания серверов
 * 5. HttpURLConnection для HTTP запросов
 * 
 * ПОПРОБУЙТЕ САМИ:
 * 1. Создайте простой чат-сервер
 * 2. Реализуйте HTTP клиент для API
 * 3. Создайте файловый сервер
 * 4. Добавьте SSL/TLS шифрование
 */
