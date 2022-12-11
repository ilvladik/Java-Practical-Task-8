import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание треугольная последовательность");
        int n = (int)getNumber("Введите положительное число: ");
        triangleRow(1, 0, n);

        System.out.println("Задание от 1 до n");
        n = (int)getNumber("Введите число: ");
        System.out.println(fromOneToN(n));

        System.out.println("Задание от А до Б");
        int a = (int)getNumber("Введите a: ");
        int b = (int)getNumber("Введите b: ");
        System.out.println(fromAToB(a, b));

        System.out.println("Задание сумма цифр");
        int k = (int)getNumber("Введите количество разрядов: ");
        int s = (int)getNumber("Введите сумму чисел: ");
        System.out.println(recCount(0, 0, k, s));

        System.out.println("Задание сумма цифр числа");
        n = (int)getNumber("Введите число: ");
        System.out.println(sumOfNumber(n));

        System.out.println("Задание проверка числа на простоту");
        n = (int)getNumber("Введите число: ");
        System.out.println(primeNumber(n, 2));
    }

    public static double getNumber(String interaction) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(interaction);
        return scanner.nextDouble();
    }

    public static void triangleRow(int number, int count, int last) {
        for (int i = 0; i < number; i++) {
            System.out.print(number + " ");
            if (++count >= last) {
                System.out.println();
                return;
            }
        }
        triangleRow(++number, count, last);
    }

    public static String fromOneToN(int n) {
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }

        return fromOneToN(n - 1) + " " + n;
    }

    public static String fromAToB(int a, int b) {
        if (a == b) {
            return Integer.toString(a);
        } else if (a < b) {
            return a + " " + fromAToB(a + 1, b);
        } else {
            return a + " " + fromAToB(a - 1, b);
        }
    }

    public static int recCount(int len, int sum, int k, int s) {
        if (len == k) {
            if (sum == s) {
                return 1;
            } else {
                return 0;
            }
        }
        int c = (len == 0 ? 1 : 0);
        int count = 0;
        for (int i = c; i < 10; i++) {
            count += recCount(len + 1, sum + i, k, s);
        }
        return count;
    }

    public static int sumOfNumber(int n) {
        if (n == 0) {
            return n;
        }

        return n % 10 + sumOfNumber(n / 10);
    }

    public static String primeNumber(int n, int i) {
        if (n <= 2) {
            return "Yes";
        } else if (n % i == 0) {
            return "No";
        } else if (i < n/2) {
            return primeNumber(n, i + 1);
        }
        return "Yes";

    }
}
