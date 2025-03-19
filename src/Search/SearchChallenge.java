package Search;

import java.util.Arrays;

public class SearchChallenge {
    public static int findMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] found = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                found[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!found[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findMissingPositive(arr1)); // Output: 2

        int[] arr2 = {1, 3, 5, 7, 9, 11};
        int target = 5;
        System.out.println("Target Index: " + binarySearch(arr2, target)); // Output: 2
    }
}

