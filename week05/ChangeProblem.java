import java.util.*;
import java.io.*;

public class ChangeProblem {

	public static void main(String[] args) {

		int[] coins = {20,8,1};

		System.out.println(greedyChange(24, coins).toString());

		System.out.println(recursiveChange(24, coins));

		System.out.println(Arrays.toString(dynamicChange(24, coins)));

	}

	public static ArrayList greedyChange(int amount, int[] coins) {

		ArrayList result = new ArrayList();

		int coinIdx = 0;
		int currDenom = coins[coinIdx];

		while (amount > 0) {

			if (currDenom <= amount) {

				result.add(currDenom);
				amount -= currDenom;

			} else {

				coinIdx += 1;
				currDenom = coins[coinIdx];

			}

		}

		return result;

	}

	public static int recursiveChange(int amount, int[] coins) {

		if (amount == 0) {
			return 0;
		}

		int minNumCoins = 100000;

		for (int i = 0; i < coins.length; i++) {

			// crappy and takes forever, since every one makes n coins calls

			if (amount >= coins[i]) {

				int numCoins = recursiveChange(amount - coins[i], coins);

				if (numCoins + 1 < minNumCoins) {

					minNumCoins = numCoins + 1;

				}

			} 

		}

		return minNumCoins;

	}

	public static int[] dynamicChange(int amount, int[] coins) {

		int numCoins = 0;

		int[] minNumCoinsArray = new int[amount+1];

		for (int m = 1; m <= amount; m++) {

			minNumCoinsArray[m] = 10000;

			for (int i = 0; i < coins.length; i++) {

				if (m >= coins[i]) {

					numCoins = minNumCoinsArray[m - coins[i]] + 1;

					if (numCoins < minNumCoinsArray[m]) {

						minNumCoinsArray[m] = numCoins;

					}

				}

			}

		}

		return minNumCoinsArray;

	}

}