class Solution {
    /*
    Sort the array
    Iterate over each element (arr[i]) and find new target `T` as (target - arr[i])
    New target `T` is similar to 2-sum problem now
    Now find target `T` in new array arr[i+1.....k] where k <= arr.length - 1
    In the new array, 
    
    if arr[j] + arr[k] == `T` then
    if arr[j] != arr[k] and say arr[j] occurs 3 times and arr[k] occurs 4 times in the array
    then ans = ans + (3*4)
    if arr[j] == arr[k] and say arr[j] occurs m times
    then ans = ans + (mC2) = ans + ( m*(m-1)/2 )
    
    if arr[j] + arr[k] < `T`
        j++
    if arr[j] + arr[k] > `T`
        k--    
    */
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int MOD = 1_000_000_007;
        long count = 0;
        for(int i=0; i<n; i++){
            int t = target - arr[i]; // new target
            int j = i+1, k = n-1;
            while(j<k){
                int twosum = arr[j] + arr[k];
                if(twosum==t){
                    if(arr[j]!=arr[k]){
                        int countJ = 1; // count of occurences of arr[j];
                        int countK = 1; // count of occurences of arr[k];
                        while(j+1<k && arr[j]==arr[j+1]){
                            countJ++;
                            j++;
                        }
                        while(k-1>j && arr[k]==arr[k-1]){
                            countK++;
                            k--;
                        }
                        
                        count = count + (countJ*countK);
                        count %= MOD;
                        j++;
                        k--;
                        
                    }else{ // if arr[j] == arr[k]
                        // m = k-j+1
                        count = count + ((k-j+1)*(k-j)/2);
                        count %= MOD;
                        break;
                    }
                }else if(twosum<t){
                    j++;
                }else if(twosum>t){
                    k--;
                }
            }
        }
        
        return (int) count;
    }
}