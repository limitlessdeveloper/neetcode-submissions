class Solution {
    public int findDuplicate(int[] nums) {
          int slow = 0, fast = 0;

        // Phase 1
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2 // now find the meeting point// visualize why?
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}