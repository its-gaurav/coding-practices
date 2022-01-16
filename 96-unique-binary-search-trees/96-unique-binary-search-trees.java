class Solution {
    /*
    Approach:
    1. Iterate over each number till n. Consider each number as root of a tree, We will form a BST
    2. Let's define a function G(n): Returns no of unique BST for given n.
    3. Let's define a function F(i, n): Returns no of unique BST for given n, given i (1<=i<=n) is the root.
    4. Hence G(n) = sum of all F(i, n) where i lies in (1<=i<=n) = F(1,n) + F(2,n) + ..... + F(n,n)
    5. Considering 'i' as root and 'n' as no of nodes, left sub-tree would contain (i-1) nodes AND
        right sub-tree would contain (n-i) nodes
    6. F(i,n) = G(i-1) * G(n-i)    
    7. Thus, F(i,n) can be calculated as a product of number of unique BFS wit (i-1) nodes AND number of unique
        BFS with (n-i) nodes.
    8. Hence G(n) = F(1,n) + F(2,n) + ..... + F(n,n) = sum of ( G(i-1)*G(n-i) ) where i in 1<=i<=n
    9. We have recurrence eqn as G(n) = sum of ( G(i-1)*G(n-i) )
    10. A plain recursion approach may result in multiple calculation of same value. Hence we would use DP
    
    For Better Clarity: https://leetcode.com/problems/unique-binary-search-trees/discuss/409987/Summary-of-All-Solutions-in-Java-with-Explanations
        
    */
    
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1; dp[1] = 1; // base condition
        find(n, dp);
        return dp[n];
    }
    
    int find(int n, int[] dp){
        
        if(dp[n]!=0) return dp[n]; // if calculation has already been done for n
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += (find(i-1, dp) * find(n-i, dp));
        }
        dp[n] = sum; // store the calculation done for n into dp[n]
        return sum;
    }
}