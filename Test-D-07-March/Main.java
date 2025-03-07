import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 12; //Example input
        Set<List<Integer>> combinations = InfiniteCoins.makeChange(n);
        
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}