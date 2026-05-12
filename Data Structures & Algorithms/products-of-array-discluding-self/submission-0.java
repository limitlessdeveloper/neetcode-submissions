class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int result[] = new int[l];
        for(int i=0; i<l; i++){
            result[i] = 1;
        }
        int prefixProd = 1;
        int suffixProd = 1;
        for(int i=0; i<l; i++){
           if(i==0){
                prefixProd = nums[i] * 1;
                suffixProd = nums[l-i-1] * 1;
                result[i] = 1;
                result[l-i-1] = 1;
           }
           else{
                result[i] = result[i] * prefixProd;
                result[l-i-1] = result[l-i-1] * suffixProd;
                prefixProd  = prefixProd*nums[i];
                suffixProd = suffixProd*nums[l-1-i];
           }
        }
        // System.out.println(Arrays.toString(result));
        return result;
    }
}