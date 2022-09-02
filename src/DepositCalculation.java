import java.util.Scanner;

public class DepositCalculation {
    public static void main(String[] args) {
        countFinalMoneyQuantity();
    }

    static void countFinalMoneyQuantity() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();
        double finalMoneyQuantity = 0;

        if (depositType == 1) {
            finalMoneyQuantity = calculateTypicalPercentFunction(amount, 0.06, period);
        } else if (depositType == 2) {
            finalMoneyQuantity = calculateCapitalizedPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                + finalMoneyQuantity);
    }

    static double calculateTypicalPercentFunction(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    static double calculateCapitalizedPercentFunction(double amount, double yearRate, int period) {
        double payment = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(payment, 2);
    }

    static double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }
}

