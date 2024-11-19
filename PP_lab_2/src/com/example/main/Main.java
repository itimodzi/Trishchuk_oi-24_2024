package com.example.main;

import com.example.house.House;
import java.util.Scanner;

public class Main {

    // створення масиву квартир
    public static House[] createHouseArray() {
        return new House[] {
                new House(1, 322, 80.5, 3, 3, "Львівська 65"),
                new House(2, 621, 120.0, 6, 4, "Київська 23"),
                new House(3, 223, 65.0, 2, 2, "Трускавецька 43"),
                new House(4, 714, 150.0, 7, 5, "Івана Мазепи 18"),
                new House(5, 102, 65.5, 1, 2, "Бориславська 21"),
                new House(6, 442, 85.5, 4, 3, "Самбісрська 3 "),
                new House(7, 552, 180.0, 5, 5, "Стебницька 2 "),
                new House(8, 682, 100.5, 6, 3, "Кульпарківська 147 "),
        };
    }

    // виведення квартир за кількістю кімнат
    public static void ByRooms(House[] houses, int rooms) {
        System.out.println("Квартири з кількістю кімнат: " + rooms);
        boolean found = false; //
        for (House house : houses) {
            if (house.getRooms() == rooms) {
                System.out.println(house);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Таку квартиру не знайдено.");
        }
    }

    // виведення квартир за кількістю кімнат і поверхом в заданому діапазоні
    public static void ByRoomsAndFloor(House[] houses, int rooms, int minFloor, int maxFloor) {
        System.out.println("Квартири з кількістю кімнат: " + rooms + " і поверхом у діапазоні від " + minFloor + " до " + maxFloor);
        boolean found = false; // лічильник знайдених квартир
        for (House house : houses) {
            if (house.getRooms() == rooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor) {
                System.out.println(house);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Таку квартиру не знайдено.");
        }
    }

    // виведення квартир, площа яких перевищує задану
    public static void ByArea(House[] houses, double area) {
        System.out.println("Квартири з площею більше ніж: " + area + " кв.м.");
        boolean found = false;
        for (House house : houses) {
            if (house.getArea() > area) {
                System.out.println(house);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Таку квартиру не знайдено.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        House[] houses = createHouseArray();

        while (true) {
            System.out.println("\n1. Пошук квартири з заданою кількістю кімнат");
            System.out.println("2. Пошук квартири з заданою кількістю кімнат і поверхом у діапазоні");
            System.out.println("3. Пошук квартири з площею більшою за задану");
            System.out.println("4. Вийти");

            int choice = scanner.nextInt();
            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.print("Кількість кімнат: ");
                    int rooms = scanner.nextInt();
                    ByRooms(houses, rooms);
                    break;
                case 2:
                    System.out.print("Кількість кімнат: ");
                    rooms = scanner.nextInt();
                    System.out.print("Введіть мінімальний поверх: ");
                    int minFloor = scanner.nextInt();
                    System.out.print("Введіть максимальний поверх: ");
                    int maxFloor = scanner.nextInt();
                    ByRoomsAndFloor(houses, rooms, minFloor, maxFloor);
                    break;
                case 3:
                    System.out.print("Введіть мінімальну площу: ");
                    double area = scanner.nextDouble();
                    ByArea(houses, area);
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }
}
