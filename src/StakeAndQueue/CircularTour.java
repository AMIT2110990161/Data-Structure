package StakeAndQueue;

class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0, deficit = 0, balance = 0;

        for (int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - distance[i];
            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(findStartingPoint(petrol, distance)); // 1
    }
}
