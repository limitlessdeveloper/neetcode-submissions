class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> positinalSpeed = new HashMap<>();
        for(int i =0; i<position.length; i++){
            positinalSpeed.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        int n = position.length-1;
        for(int i=0; i<(n+1)/2; i++){
            int temp = position[i];
            position[i] = position[n-i];
            position[n-i] = temp;
        }
        Stack<Double> stack = new Stack<>();
        for(int currpos: position){
            // System.out.println(i);
            int distLeft = target - currpos;
            int currspeed = positinalSpeed.get(currpos);
            double currtime = (double)distLeft/(double)currspeed;
            if(stack.isEmpty()){
                stack.push(currtime);
            }
            else if(stack.peek()<currtime){
                stack.push(currtime);
            }
            else{
                // stack.topTime > currTime
                // it will add to fleet, so can get ignore
                continue;
            }
        }
        return stack.size();
    }
}