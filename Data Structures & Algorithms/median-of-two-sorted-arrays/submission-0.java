class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        boolean medianodd = (l1+l2)%2==0 ? false: true;
        int medianleft = (l1+l2)/2; 
        int nums3[] = new int[l1+l2];
        int i=0;
        int j=0;
        int k=0;
        while(i<l1 && j<l2){
            if(nums1[i]<nums2[j]){
                nums3[k] = nums1[i];
                i++;    
            }
            else{
                nums3[k] =  nums2[j];
                j++;
            }
            if(medianodd && k==medianleft){
                return (double) nums3[k];
            }
            if(!medianodd && k==medianleft){
                return (double)(nums3[k] + nums3[k-1])/2;
            }
            k++;
        }
        while(i<l1){
            nums3[k]= nums1[i];
            i++;
            if(medianodd && k==medianleft){
                return (double) nums3[k];
            }
            if(!medianodd && k==medianleft){
                return (double)(nums3[k] + nums3[k-1])/2;
            }
            k++;
        }
        while(j<l2){
            nums3[k] = nums2[j];
            j++;
            if(medianodd && k==medianleft){
                return (double) nums3[k];
            }
            if(!medianodd && k==medianleft){
                return (double)(nums3[k] + nums3[k-1])/2;
            }
            k++;
        }

        return -1;
    }
}
