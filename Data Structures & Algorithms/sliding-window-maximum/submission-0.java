class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         // Through Monotonic Deque -> O(n) stores indices (Used in data strurctures and algo)
        Deque<Integer> dq = new ArrayDeque<>();
        int l = nums.length;
        int result[] = new int[l-k+1];
        for(int i=0; i<l; i++){
            if(!dq.isEmpty() && dq.peekFirst()<(i-k+1)){ // remove the outside window elements
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){ // always push first element as the highest element, and last as the lowest(monotonic queue)
                dq.pollLast();
            }
            dq.offerLast(i); // push from last (first always maximum, so if last==first, meaning all the other element in the present deque is less than the new element nums[i])
            // System.out.println(dq);
            if(i+1>=k){
                result[i-k+1] = nums[dq.peekFirst()]; // only start storing the result when the window is reached from starting and store it continously.
            }
        }
        return result;
    }
}
