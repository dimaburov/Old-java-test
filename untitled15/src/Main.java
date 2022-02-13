import java.util.Scanner;

// Задача нахождения минимального количества скалярных умножений матриц
public class Main {
    public static int multiplyOrder(int[] p) {
        int n = p.length - 1;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }

        for (int l = 1; l < n; ++l) {
            for (int i = 0; i < n - l; ++i) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько надо перемножить матриц? >");
        int count = sc.nextInt();
        int[] array = new int[count+1];
        System.out.print("Введите последовательно размеров матриц(Например для матриц 10×100, 100×5 и 5×50:" +
                " 10 100 5 50)\n> ");
        for(int i = 0; i<count+1; i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Минимальное количество перемножений: "+Main.multiplyOrder(array));
    }
}

