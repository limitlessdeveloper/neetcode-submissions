class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxTarget = piles[0];
        long prefixSum = 0;
        int minTarget;
        for(int i=0; i<piles.length; i++){
            maxTarget = Math.max(piles[i], maxTarget);
            prefixSum += piles[i];
        }
        minTarget = Math.max(1,(int)prefixSum/h);
        // System.out.println(minTarget+" "+maxTarget);
        while(minTarget<maxTarget){
            int mid = minTarget + (maxTarget-minTarget)/2;
            // System.out.println("mid: "+mid);
            if(checkSatisfied(piles, h, mid)){
                maxTarget = mid;
            }
            else{
                minTarget = mid+1; 
            }
        }
        return minTarget;
    }

    public boolean checkSatisfied(int[] piles, int h, int target){
        int currHrs=0;
        for(int i=0; i<piles.length; i++){
            // System.out.println("currHrs: "+currHrs+" i: "+i);
            currHrs += (piles[i]/target);
            if(piles[i]%target != 0){
                currHrs+=1;
            }
            if(currHrs>h){
                return false;
            }
        }
        return true;
    }
}