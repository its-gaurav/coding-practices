class Solution {
    /*
    Start iterating from right of nums array. Find first index i1 where nums is smaller than that of at i1 + 1.
    Find first i1 where nums[i1] is smaller than its right adjacent. If found then next permutation can be found.
    e.g 3,4,7 Here i1=1 meets above criteria.
    
    If not found, that means nums is already sorted in decreasing order (eg 3,2,1)
    
    Again we would start iterating from right, and find first index i2 where nums[i2] is greater than that of i1.
    Once we found i1 and i2, we will swap the elements at i1 and i2.
    Idea behind doing this?
    When element at i2 is greater than element at i1 such that i1 < i2, 
    Swapping them will always give us a greater permutation P1.
    
    But this P1 need not necessarily to be a next greater permutation. 
    But all elements lying nums[ind+1 .... size-1] will be in decreasing order. 
    Hence sorting them in increasing order would give us a smaller number.
    */
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int ind1 = -1, ind2 = -1;
        for(int i=size-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind1 = i;
                break;
            }
        }
        
        if(ind1 == -1){ // means elements are in decreasing order
            Arrays.sort(nums);
            return;
        }
        
        for(int i=size-1; i>=0; i--){
            if(nums[i] > nums[ind1]){
                ind2 = i;
                break;
            }
        }
        
        // swapping nums ind1 and ind2
        swap(nums, ind1, ind2);
        /*
        After swapping ind1 and ind2, all elements lying from ind1+1 to end will be sorted in decresing order
        After swapping itself, we have got a permutation which is greater than given nums array.
        But since we need to find next greater permutation, we will sort the elements from ind1+1 to end in 
        non-decreasing order. After sorting nums[ind+1 .... size-1], we will get next greater permutation.
        */
        // sort all elements of nums lying from ind1+1 to size-1
        sort(nums, ind1+1, size-1);
    }
    
    void swap(int[] nums, int i, int j){
        System.out.println("i: "+i+" j: "+j);
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    void sort(int[] nums, int start, int end){
        while(start<=end){
            swap(nums, start, end);
            start++; end--;
        }
    }
}