import java.util.Scanner;

class FibonacciNumber {
    private int index;
    private int value;

    public FibonacciNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}

class FibonacciSumOfSquares {
    public static void main(String[] args) {
        int N = 0;

        if (args.length > 0) {
            try {
                N = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Невірний формат числа. Будь ласка, введіть ціле число.");
                return;
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть кількість чисел Фібоначчі: ");
            N = scanner.nextInt();
        }

        FibonacciNumber[] fibonacciNumbers = new FibonacciNumber[N];

        // Обчислення чисел Фібоначчі
        for (int i = 0; i < N; i++) {
            fibonacciNumbers[i] = new FibonacciNumber(i, fibonacci(i));
        }

        // Обчислення суми квадратів
        int sumOfSquares = 0;
        for (FibonacciNumber num : fibonacciNumbers) {
            sumOfSquares += num.getValue() * num.getValue();
        }
        System.out.println("Сума квадратів перших " + N + " чисел Фібоначчі: " + sumOfSquares);
    }

        // Обчислення n-го числа Фібоначчі
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}