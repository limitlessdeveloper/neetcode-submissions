class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum==target){
                int result[] = new int[2];
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
            else if(sum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return null;
    }
}