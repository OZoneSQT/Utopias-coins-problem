package coin;

public class GreedyCoinCounter {

    // issues with amounts less than 22
    public static void main(String[] args) {
        int[] coins = {1, 7, 10, 22};
        int amount = 22;

        int a = amount % coins[3];
        int rest = amount / coins[3];

        int b = rest % coins[2];
        rest = rest / coins[2];

        int c = rest % coins[1];
        rest = rest / coins[1];

        int numCoins = a + b + c + rest;

        System.out.println("Minimum " + numCoins + " coins are required to make the a value of " + amount);
    }


}
