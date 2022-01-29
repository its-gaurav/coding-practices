class Solution {
    /*
    Understanding And Approach:
    Let's maintain a stack of different indices
    Add an index i to the stack only if heights[i] >= stack.top. 
    It tells that stack.top can be used in finding possible maximum rectagle's area till ith index.
    If height[i] < stack.top --> it tells we need to find possible maximum rectangle's area using stack.top as
    this stack.top cannot be used further in ractangle's area calculation
    
    In the example below I have taken elements in stack for clarity. 
    But actually we will be storing index of element there. 
    Example
    heights = [2,1,5,6,2,3]
    i=0 --> Inserted 2 into the stack --> i=1  [stack is 2]
    i=1 --> 1 < stack.top --> stack.pop() --> [stack is empty] --> area = 2*(i) = 2 
    i=1 --> 1 --> Inserted 1 into stack --> i=2 [stack is 1]
    i=2 --> 5 >= stack.top --> Inserted 5 into stack --> i=3 [stack is 1, 5]
    i=3 --> 6 >= stack.top --> Inserted 6 into stack --> i=4 [stack is 1, 5, 6]
    i=4 --> 2 < stack.top --> stack.pop() --> [stack is 1, 5] --> area = 6*(i - 1 - stack.peek())
    
    We are doing i - (stack.peek() + 1) because for the range (stack.peek(), i) we will have bars of atleast 6 length 
    things to note: Why we are using (i - 1 - stack.peek()) in our calculation?
     i=3 --> we have 6 >  5 (stack.top) and 5 is at index i=2. Hence one thing here we are sure about is that 5 can be used to find possible maximum rectangle's area from its index which is i=2 to bar of length 6 which is at index 3. But similar to 6 we can find more bars having length >= 5 hence we will not do calculation here.
     Still we will add 6 to our stack.
     i=4 --> we have 2 < 6 (stack.top) and 6 is at index 3. So 6 cannot be used further. So we have to calculate area using bar of length 6 here.
     We have to find here that for what width this 6 is spread upon?
     This can be found using (i - 1 - stack.peek())
     
     Dry run for examples like
     [3,6,5,7,4,8,1,0]
     [4,2,0,3,2,5]
    */
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int i=0;
        int maxArea = 0;
        while(i<n){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){
                stack.add(i++);
            }else{
                int index = stack.pop();
                int area = heights[index] * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
                maxArea = Math.max(area, maxArea);
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
                int area = heights[index] * (stack.isEmpty() ? i : (i - 1 - stack.peek()));
                maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
        
    }
}