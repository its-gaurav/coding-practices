class Solution {
    /*
    Observing carefully headId would always be root of a tree if we try to
    create tree using given information
    informTime[i] is time taken by ith employee to inform all its direct sub-ordinates
    Also manager[i] is direct manager of ith employee
    Hence time taken to inform ith employee by its manager would be informTime[ manager[i] ]
    But to calculate total time taken to inform ith employee, we need to find time taken to inform its direct manager as well
    Also, all bottom-most layer employees will be informed by a max of time taken to inform each employee
    */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        // n is number of employees
        int totalTime = 0;
        for(int i=0; i<n; i++){
            totalTime = Math.max(totalTime, test(i, manager, informTime, dp));
        }
        
        return totalTime;
    }
    
    int test(int empId, int[] manager, int[] informTime, HashMap<Integer, Integer> dp){
        if(dp.containsKey(empId)){
            return dp.get(empId);
        }
        // if empId is head, then time to inform head is 0
        if(manager[empId]==-1){
            return 0;
        }
        int managerOfEmpId = manager[empId];
        // time taken by manager to inform employee empId
        int time = informTime[managerOfEmpId];
        // time taken to inform manager
        int timeToInformManager = test(managerOfEmpId, manager, informTime, dp);
        dp.put(empId, time + timeToInformManager);
        return dp.get(empId);
    }
}