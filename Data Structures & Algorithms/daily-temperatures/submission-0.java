class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> ms = new Stack<>();
        int l = temperatures.length;
        int result[] = new int[l];
        for(int i=0; i<l; i++){
            while(!ms.isEmpty() && temperatures[ms.peek()]<temperatures[i]){
                int ind = ms.pop();
                result[ind] = i-ind;
            }
            ms.push(i);
        }
        return result;
    }
}
