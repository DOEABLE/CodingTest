import java.util.*;

class Coordinate{
    private int x;
    private int y;
    private int count;
    
    Coordinate(int x, int y, int count){
        this.x=x;
        this.y=y;
        this.count=count;
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getCount(){
        return this.count;
    }
}

class Solution {
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        Queue<Coordinate> queue = new LinkedList<>();
        
        int[] moveX = {1,0,-1,0};
        int[] moveY = {0,1,0,-1};
        
        queue.offer(new Coordinate(0,0,1));
        
        while(queue.size()>0){
            Coordinate c = queue.poll();
            
            if(c.getX()==maps.length - 1 && c.getY() == maps[0].length - 1){
                answer = c.getCount();
                break;
            }
            for(int i=0; i < moveX.length; i++){
                int tempX = c.getX()+moveX[i];
                int tempY = c.getY()+moveY[i];
                
                if(tempX >= 0 && tempY >=0 && tempX< maps.length && tempY < maps[0].length && maps[tempX][tempY] != 0){
                    queue.offer(new Coordinate(tempX, tempY, c.getCount()+1));
                    maps[tempX][tempY] =0;
                }
            }
        }
        return answer;
    }
}