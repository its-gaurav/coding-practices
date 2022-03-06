Observing carefully headId would always be root of a tree if we try to create tree using given information
* informTime[i] is time taken by ith employee to inform all its direct sub-ordinate
*     Also manager[i] is direct manager of ith employee
*     Hence time taken to inform ith employee by its manager would be informTime[ manager[i] ]
*     But to calculate total time taken to inform ith employee, we need to find time taken to inform its direct manager as well
*     Also, all bottom-most layer employees will be informed by a max of time taken to inform each employee