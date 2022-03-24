class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        reverse(people);
        int i = 0;
        int j = people.length - 1;
        int boatCount = 0;
        while(i<=j){
            boatCount++;
            int weight = people[i];
            int remainingWeight = limit - people[i];
            if(remainingWeight >= people[j]){
                j--;
            }
            i++;
        }
        
        return boatCount;
    }
    
    static void reverse(int[] people){
        int n = people.length;
        
        for(int i=0; i<n/2; i++){
            int temp = people[i];
            people[i] = people[n-i-1];
            people[n-i-1] = temp;
        }
    }
}