import java.util.*;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {

            int max = 0;
            int id = -1;

            // Find maximum element index from 0 to i
            for (int j = 0; j <= i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    id = j;
                }
            }

            // If max element is at first position
            if (id == 0) {
                ans.add(i + 1);
                reverse(arr, 0, i);
            }

            // If max element is not already at correct position
            else if (id != i) {
                ans.add(id + 1);
                ans.add(i + 1);

                reverse(arr, 0, id);
                reverse(arr, 0, i);
            }
        }

        return ans;
    }

    // Reverse function
    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}