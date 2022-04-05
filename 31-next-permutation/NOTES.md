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