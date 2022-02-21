class Solution {
    
    public int majorityElement(int[] nums) {
        /*
        Majority element is an element which count is greater than (size/2).
        moore's voting algorithm
        testcase: 1 1 2 3 4 3 3 3 3
        If we see till 1st 3 (till index 3 i.e in 1 1 2 3) there is no majority element as overall count would come to 0. 1 occurs twice, 2 occurs once, 3 occurs once 
        Similarly from index 4 to index 5 (i.e in 4 3) there is no majority element. Both occurs once
        But from index 6 to index 8 (i.e in 3 3 3) 3 is majority element. 3 occurs thrice.
        */
        
        int voteCount = 0;
        int candidate = -1;
        for(int i=0; i<nums.length; i++){
            if(voteCount == 0){
                candidate = nums[i];
                voteCount = 1;
            }else if(candidate == nums[i]){
                voteCount++;
            }else{
                voteCount--;
            }
        }
        
        return candidate;
    }
}