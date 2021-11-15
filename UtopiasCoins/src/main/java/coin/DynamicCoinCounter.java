package coin;

public class DynamicCoinCounter {
    public static void main(String[] args){

        int[] coins = {1, 7, 10, 22};
        int amount = 21;

        DynamicCoinCounter m = new DynamicCoinCounter();
        System.out.println("Minimum " + m.coinChangeProblem(coins, amount)
                + " coins are required to make the a value of " + amount);
    }

    private static int coinChangeProblem(int[] coins, int sum){
        int totalCoins = coins.length;
        double[][] subProblemsSolutions = new double[totalCoins + 1][sum + 1];

        for(int j = 0; j <= sum; j++){
            subProblemsSolutions[0][j] = Double.POSITIVE_INFINITY;
        }

        for(int i = 1; i <= totalCoins; i++){
            subProblemsSolutions[i][0] = 0;
        }

        for(int i = 1; i <= totalCoins; i++){
            for(int j = 1; j <= sum; j++){
                if(coins[i - 1] <= j)
                    subProblemsSolutions[i][j] = findMin(1 + subProblemsSolutions[i][j - coins[i - 1]], subProblemsSolutions[i - 1][j]);
                else
                    subProblemsSolutions[i][j] = subProblemsSolutions[i - 1][j];
            }
        }

        return (int)subProblemsSolutions[totalCoins][sum];
    }

    private static double findMin(double a, double b){
        if(a <= b){
            return a;
        } else{
            return b;
        }
    }

}
