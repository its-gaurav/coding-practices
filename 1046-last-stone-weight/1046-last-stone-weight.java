class Solution {
    /*
    Create a max-heap such that max-element of the current array will always be at the top
    Pop top two elements from the heap, do the operation and push the result again to the heap
    If there is only 1 element left, return that
    If there is no element left, return 0
    */
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int len = stones.length;
        for(int i=0; i<len; i++){
            maxHeap.add(stones[i]);
        }
        
        int ans = 0;
        while(maxHeap.size()>0){
            int y = maxHeap.poll();
            int x = 0;
            if(maxHeap.size()>0){
                x = maxHeap.poll();
                if(x!=y){
                    maxHeap.add(y-x);
                }
            }else{
                ans = y;
            }
        }
        return ans;
    }
}