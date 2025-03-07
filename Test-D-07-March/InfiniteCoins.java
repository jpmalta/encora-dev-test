import java.util.*;

public class InfiniteCoins {
    /**
     * The function below will compute all possible ways to make change for n cents
     * using quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent).
     * It uses recursion and backtracking to explore all possible combinations.
     */
    public static Set<List<Integer>> makeChange(int n) {
        Set<List<Integer>> result = new HashSet<>();
        findCombinations(n, 0, 0, 0, 0, result);
        return result;
    }

    private static void findCombinations(int remaining, int quarters, int dimes, int nickels, int pennies, Set<List<Integer>> result) {
        if (remaining == 0) {
            result.add(Arrays.asList(quarters, dimes, nickels, pennies));
            return;
        }
        
        if (remaining >= 25) findCombinations(remaining - 25, quarters + 1, dimes, nickels, pennies, result);
        if (remaining >= 10) findCombinations(remaining - 10, quarters, dimes + 1, nickels, pennies, result);
        if (remaining >= 5) findCombinations(remaining - 5, quarters, dimes, nickels + 1, pennies, result);
        if (remaining >= 1) findCombinations(remaining - 1, quarters, dimes, nickels, pennies + 1, result);
    }
}