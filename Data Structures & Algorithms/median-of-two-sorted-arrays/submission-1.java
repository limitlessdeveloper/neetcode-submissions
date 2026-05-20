class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1>l2){
            return findMedianSortedArrays(nums2, nums1);
        }
        // if(l2==0){
        //     return 0.0;
        // }
        boolean medianodd = (l1+l2)%2==0 ? false : true;
        int medianInd = (l1+l2+1)/2;
        // if(medianInd==1){
        //     return nums2[0];
        // }
        int low = 0;
        int high = l1;
        while(low<=l1){
            int i = (low+high)/2;
            int j =  medianInd - i;
            int nums1Left  = (i == 0)  ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == l1) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left  = (j == 0)  ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == l2) ? Integer.MAX_VALUE : nums2[j];
            int leftMax = Math.max(nums1Left, nums2Left);
            int rightMin = Math.min(nums1Right, nums2Right);
            if(leftMax<=rightMin){
                if(medianodd){
                    return leftMax;
                }
                else{
                    return (leftMax+rightMin)/2.0;
                }
            }
            else{
                if(nums1Left > nums2Right){
                    high = i-1; 
                }
                else{
                    low = i+1;
                }
            }
        }
        return -1;
    }
}
