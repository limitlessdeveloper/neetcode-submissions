class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> ms = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<= heights.length; i++){
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while(!ms.isEmpty() && heights[ms.peek()] > currHeight){
                int topIndex = ms.pop();
                int right = i;
                int width = ms.isEmpty()? i : right - ms.peek() - 1;
                int area = heights[topIndex] * width;
                maxArea = Math.max(maxArea, area);
            }
            ms.push(i);
        }
        return maxArea;
    }
}