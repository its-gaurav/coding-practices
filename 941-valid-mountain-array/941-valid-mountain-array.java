class Solution {
    /*
    Idea is simple. 
    1.We will find first index where array starts decreasing (let's say this as downStart).
    2.Till finding downStart, the array should be strictly increasing.
    3.From downStart, the remaining array should be strictly decreasing.
    4.If either of the two cases 2 or 3 fails, return false
    
    Edge Case: If start of array is decreasing itselg, then downStart will be 1
    */
    public boolean validMountainArray(int[] arr) {
        int size = arr.length;
        if(size<3) return false;
        int downStart = -1;
        for(int i=1; i<size; i++){
            // no two values should be equal
            if(arr[i]==arr[i-1]){
                return false;
            }
            // array starts decreasing
            if(arr[i]<arr[i-1]){
                downStart = i;
                break;
            }
        }
        if(downStart==-1 || downStart==1) return false;
        // the remaining array should be strictly decreasing
        for(int i=downStart+1; i<size; i++){
            if(arr[i]>=arr[i-1]){
                return false;
            }
        }
        
        return true;
    }
}