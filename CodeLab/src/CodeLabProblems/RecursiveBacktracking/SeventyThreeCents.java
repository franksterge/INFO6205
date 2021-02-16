package CodeLabProblems.RecursiveBacktracking;

import java.util.ArrayList;
import java.util.List;

public class SeventyThreeCents {
    public static void main(String[] args) {
        int[] coinBucket = {1,1,1,1,1,5,5,5,10,10,10,10, 25,25};
        List<Integer> selectedCoins = new ArrayList<>();
        int sum = 0;
        findSolution(coinBucket, selectedCoins, sum, 0);
    }

    public static void findSolution(int[] coinBucket, List<Integer> selectedCoins, int sum, int currentIndex) {
        if (sum == 37) {
            for (Integer i: selectedCoins) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else if (sum > 37) {
            return;
        }

        for (int i = currentIndex; i < coinBucket.length; i++) {
            if (i != currentIndex) {
                selectedCoins.add(coinBucket[i]);
                findSolution(coinBucket, selectedCoins, sum + coinBucket[i], i);
                selectedCoins.remove(selectedCoins.size() - 1);
            }

        }
    }
}
