package lurongrong.java;

import lurongrong.java.java.Constant;

/**
 *
 * 
 */
public class MazeNode {
    private int value;
    int i;//当前节点在二维数组的行下标
    int j;
    boolean[] way_state;
    public MazeNode(int value,int i,int j) {
        this.value = value;
        this.i=i;
        this.j=j;
        way_state = new boolean[Constant.WAY_SIZE];
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
    	this.value=value;
    }
    public void setWayState(int direction,boolean isAble) {
    	
        this.way_state[direction] = isAble;
    }
    
  
    	
}
