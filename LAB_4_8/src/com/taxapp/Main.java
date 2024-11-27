package com.taxapp;
import java.util.*;

interface Command {
    void execute();
}

class Tax {
    private String type;
    private double income;
    private double rate;

    public Tax(String type, double income, double rate) {
        this.type = type;
        this.income = income;
        this.rate = rate;
    }

    public double calculateTax() {
        return income * rate / 100;
    }

    public String getType() {
        return type;
    }

    public double getIncome() {
        return income;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Income: %.2f, Rate: %.2f%%, Tax: %.2f",
                type, income, rate, calculateTax());
    }
}

class Menu {
    private Map<Integer, Command> commands = new HashMap<>();
    private boolean isRunning = true;

    public void addCommand(int option, Command command) {
        commands.put(option, command);
    }

    public void displayMenu() {
        System.out.println("\n=== Tax Management Menu ===");
        System.out.println("1. Add a new tax");
        System.out.println("2. Display all taxes");
        System.out.println("3. Calculate total tax");
        System.out.println("4. Sort taxes by amount");
        System.out.println("5. Find taxes in a range");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    public void executeCommand(int option) {
        Command command = commands.get(option);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }

    public void stop() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}

class AddTaxCommand implements Command {
    private List<Tax> taxes;
    private Scanner scanner;

    public AddTaxCommand(List<Tax> taxes, Scanner scanner) {
        this.taxes = taxes;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter tax type: ");
        String type = scanner.nextLine();
        System.out.print("Enter income: ");
        double income = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter tax rate (%): ");
        double rate = Double.parseDouble(scanner.nextLine());
        taxes.add(new Tax(type, income, rate));
        System.out.println("Tax added successfully!");
    }
}

class DisplayTaxesCommand implements Command {
    private List<Tax> taxes;

    public DisplayTaxesCommand(List<Tax> taxes) {
        this.taxes = taxes;
    }

    @Override
    public void execute() {
        if (taxes.isEmpty()) {
            System.out.println("No taxes available.");
            return;
        }
        System.out.println("=== All Taxes ===");
        for (Tax tax : taxes) {
            System.out.println(tax);
        }
    }
}

class CalculateTotalTaxCommand implements Command {
    private List<Tax> taxes;

    public CalculateTotalTaxCommand(List<Tax> taxes) {
        this.taxes = taxes;
    }

    @Override
    public void execute() {
        double totalTax = taxes.stream().mapToDouble(Tax::calculateTax).sum();
        System.out.printf("Total tax amount: %.2f\n", totalTax);
    }
}

class SortTaxesCommand implements Command {
    private List<Tax> taxes;

    public SortTaxesCommand(List<Tax> taxes) {
        this.taxes = taxes;
    }

    @Override
    public void execute() {
        taxes.sort(Comparator.comparingDouble(Tax::calculateTax));
        System.out.println("Taxes sorted by amount!");
    }
}

class FindTaxesInRangeCommand implements Command {
    private List<Tax> taxes;
    private Scanner scanner;

    public FindTaxesInRangeCommand(List<Tax> taxes, Scanner scanner) {
        this.taxes = taxes;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter minimum tax amount: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum tax amount: ");
        double max = Double.parseDouble(scanner.nextLine());

        System.out.println("=== Taxes in Range ===");
        taxes.stream()
                .filter(tax -> tax.calculateTax() >= min && tax.calculateTax() <= max)
                .forEach(System.out::println);
    }
}

class ExitCommand implements Command {
    private Menu menu;

    public ExitCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println("Exiting the program. Goodbye!");
        menu.stop();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tax> taxes = new ArrayList<>();
        Menu menu = new Menu();

        menu.addCommand(1, new AddTaxCommand(taxes, scanner));
        menu.addCommand(2, new DisplayTaxesCommand(taxes));
        menu.addCommand(3, new CalculateTotalTaxCommand(taxes));
        menu.addCommand(4, new SortTaxesCommand(taxes));
        menu.addCommand(5, new FindTaxesInRangeCommand(taxes, scanner));
        menu.addCommand(6, new ExitCommand(menu));

        while (menu.isRunning()) {
            menu.displayMenu();
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            menu.executeCommand(option);
        }
        scanner.close();
    }
}
