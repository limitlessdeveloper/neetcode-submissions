class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // mid is in the left sorted portion
                // min must be to the RIGHT of mid
                left = mid + 1;
            } else {
                // mid is in the right sorted portion
                // mid itself could be the min
                right = mid;
            }
        }

        return nums[left];
    }
}