package Hash_MapAndFunction;

import java.util.HashSet;

class PairWithGivenSum {
    public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 16;
        System.out.println(hasPair(arr, sum)); // true
    }
}

