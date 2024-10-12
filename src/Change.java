//

public class Change {
    private String name;
    private int totalAmount;

    // 1st Default Constructor
    public Change () {
    }

    // 2nd Constructor that accepts a name and the total coin amount
    public Change(String name, int totalAmount) {
        this.name = name;
        this.totalAmount = totalAmount;
    }

    // Getters for name and totalAmount
    public String getName() {
        return name;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    // Method to add an additional coin value to the existing total (Helper)
    public void addAmount(int additionalAmount) {
        this.totalAmount += additionalAmount;
    }

    // Method to display the breakdown of coins (Helper)
    public void displayChangeBreakdown() {
        int remainingAmount = totalAmount;
        int twoDollarCoins = remainingAmount / 200;
        remainingAmount %= 200;
        int oneDollarCoins = remainingAmount / 100;
        remainingAmount %= 100;
        int fiftyCentCoins = remainingAmount / 50;
        remainingAmount %= 50;
        int twentyCentCoins = remainingAmount / 20;
        remainingAmount %= 20;
        int tenCentCoins = remainingAmount / 10;
        remainingAmount %= 10;
        int fiveCentCoins = remainingAmount / 5;

        System.out.println("Breakdown of change for " + name + ":");
        if (twoDollarCoins > 0) System.out.println("$2 coins: " + twoDollarCoins);
        if (oneDollarCoins > 0) System.out.println("$1 coins: " + oneDollarCoins);
        if (fiftyCentCoins > 0) System.out.println("50 cents: " + fiftyCentCoins);
        if (twentyCentCoins > 0) System.out.println("20 cents: " + twentyCentCoins);
        if (tenCentCoins > 0) System.out.println("10 cents: " + tenCentCoins);
        if (fiveCentCoins > 0) System.out.println("5 cents: " + fiveCentCoins);
    }

    // To calculate the coin denomination of change record
    public void calculateTotalCoinsPerDenomination(Change[] changeRecords, int numRecords) {
        int totalTwoDollarCoins = 0;
        int totalOneDollarCoins = 0;
        int totalFiftyCentCoins = 0;
        int totalTwentyCentCoins = 0;
        int totalTenCentCoins = 0;
        int totalFiveCentCoins = 0;

        for (int v = 0; v < numRecords; v++) {
            int remainingAmount = changeRecords[v].getTotalAmount();
            totalTwoDollarCoins += remainingAmount / 200;
            remainingAmount %= 200;
            totalOneDollarCoins += remainingAmount / 100;
            remainingAmount %= 100;
            totalFiftyCentCoins += remainingAmount / 50;
            remainingAmount %= 50;
            totalTwentyCentCoins += remainingAmount / 20;
            remainingAmount %= 20;
            totalTenCentCoins += remainingAmount / 10;
            remainingAmount %= 10;
            totalFiveCentCoins += remainingAmount / 5;
        }

        // Display the total for each denomination
        System.out.println("\nTotal coins across all persons:");
        if (totalTwoDollarCoins > 0) System.out.println("$2 coins: " + totalTwoDollarCoins);
        if (totalOneDollarCoins > 0) System.out.println("$1 coins: " + totalOneDollarCoins);
        if (totalFiftyCentCoins > 0) System.out.println("50 cent coins: " + totalFiftyCentCoins);
        if (totalTwentyCentCoins > 0) System.out.println("20 cent coins: " + totalTwentyCentCoins);
        if (totalTenCentCoins > 0) System.out.println("10 cent coins: " + totalTenCentCoins);
        if (totalFiveCentCoins > 0) System.out.println("5 cent coins: " + totalFiveCentCoins);
    }

   // Find person with smallest total
    public static Change CalculateLargestTotal(int numRecords, Change[] changeRecords) {
        Change largest = changeRecords[0];
        for (int v = 1; v < numRecords; v++) {
            if (changeRecords[v].getTotalAmount() > largest.getTotalAmount()) {
               largest = changeRecords[v];
            }
        }
        return largest;
    }

    // Find person with smallest total
    public static Change CalculateSmallestTotal(int numRecords, Change[] changeRecords) {
        Change smallest = changeRecords[0];
        for (int v = 1; v < numRecords; v++) {
            if (changeRecords[v].getTotalAmount() < smallest.getTotalAmount()) {
                smallest = changeRecords[v];
            }
        }
        return smallest;
    }

    // Find total for each person
     public static void CalculateTotalAmount(int numRecords, Change[] changeRecords) {
         int totalCents = 0;
         for (int v = 0; v < numRecords; v++) {
            totalCents += changeRecords[v].getTotalAmount();
            changeRecords[v].displayChangeBreakdown();
         }
         double total = totalCents/100.0;
         System.out.println("\nTotal Amount: " + total );
     }

}
