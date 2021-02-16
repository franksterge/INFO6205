package CodeLabProblems.RecursiveBacktracking;

public class CoinCombo {
    public static void main(String[] args) {
        int[] selectedCoins = new int[5];
        int[] coinBucket = {5, 10, 25};
        int currentIndex =  0;
        printCoins(selectedCoins, coinBucket, currentIndex);
    }

    public static void printCoins(int[] selectedCoins, int[] coinBucket, int currentIndex) {
        if (currentIndex == 5) {
            for (int i = 0; i < selectedCoins.length; i++) {
                System.out.print(selectedCoins[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < coinBucket.length; i++) {
            selectedCoins[currentIndex] = coinBucket[i];
            printCoins(selectedCoins, coinBucket, currentIndex + 1);
            selectedCoins[currentIndex] = -1;
        }
    }
}
