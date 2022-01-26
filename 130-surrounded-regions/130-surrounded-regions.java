class Solution {
    /*
    Observation:
    1. All O's lying on 4 edges i.e borders will not be flipped at all
    2. Also if any O that is not on the border but connected horizontally or vertically to an O
    lying on vorder will not be flipped
    3. Any other O lying anywhere in grid will be flipped
    
    Approach:
    1. Find all O's lying across all 4 borders. 
    2. Update them as '$' in grid and store that co-ordinate in a queue
    3. Idea here is that one by one we will see all adjacent cells of an invalid cell AND if the adjacent is
    'O' then that cell will also be invalid. Hence we will add that as well in our queue
    4. Once queue is empty, now our grid has 'X', '$' and 'O'. Please note that this 'O' is valid cell which needs to be converted to 'X'.
    5. Convert all 'O' to 'X'.
    6. Also we need to reset '$' back to 'O'. 
    */
    public void solve(char[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;
        
        Queue<Point> queue = new LinkedList<>(); // will add all invalid 'O's co-ordinate
        // across left and right border (1st cloumn and last column)
        for(int i=0; i<rowCount; i++){
            if(board[i][0]=='O'){
                queue.add(new Point(i,0));
                board[i][0] = '$';
            }
            if(board[i][colCount-1]=='O'){
                queue.add(new Point(i,colCount-1));
                board[i][colCount-1] = '$';
            }
        }
        // across top and bottom border (1st row and last row)
        for(int j=0; j<colCount; j++){
            if(board[0][j]=='O'){
                queue.add(new Point(0,j));
                board[0][j] = '$';
            }
            if(board[rowCount-1][j]=='O'){
                queue.add(new Point(rowCount-1,j));
                board[rowCount-1][j] = '$';
            }
        }
        
        while(!queue.isEmpty()){
            Point cell = queue.poll();
            int x = cell.x, y = cell.y;
            if(x+1<rowCount && board[x+1][y]=='O'){
                queue.add(new Point(x+1,y));
                board[x+1][y] = '$';
            }
            if(x-1>=0 && board[x-1][y]=='O'){
                queue.add(new Point(x-1,y));
                board[x-1][y] = '$';
            }
            
            if(y+1<colCount && board[x][y+1]=='O'){
                queue.add(new Point(x,y+1));
                board[x][y+1] = '$';
            }
            
            if(y-1>=0 && board[x][y-1]=='O'){
                queue.add(new Point(x,y-1));
                board[x][y-1] = '$';
            }
        }
        
        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='$'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}