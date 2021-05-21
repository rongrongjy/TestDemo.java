package lurongrong.java;

import lurongrong.java.java.Constant;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : RAY
 * @date : 11:29 2020/10/20
 */
public class Maze {
    private MazeNode[][] mazeNodes;
    private Stack<MazeNode> stack = new Stack<>();
    private int row;
    private int colum;
 
    
    public Maze(int row, int colum) {
        
        this.row = row;
        this.colum = colum;
        mazeNodes = new MazeNode[this.row][this.colum];
    }
    
  
    private void initValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入迷宫路径");
        for(int i=0;i<row;i++){
            for (int j = 0;j<colum;j++){
                mazeNodes[i][j] = new MazeNode(scanner.nextInt(),i,j);
            }
        }
       
    }
    //该函数主要用来根据用户输入的路径更改迷宫节点四个方向的行走状态
    private void adjustWayState() {
    	for(int i = 0;i<row;i++){
            for(int j = 0;j<colum;j++){
            	//i j get set
                if(mazeNodes[i][j].getValue() == lurongrong.java.java.Constant.WAY_DISABLE){
                    break;
                }
                // 东
                if(j+1 < colum && mazeNodes[i][j+1].getValue() == lurongrong.java.java.Constant.WAY_ABLE){
                	mazeNodes[i][j].setWayState(lurongrong.java.java.Constant.WAY_EAST, lurongrong.java.java.Constant.ISABLE);
                }
                // 西
                if(j-1>=0 && mazeNodes[i][j-1].getValue() == lurongrong.java.java.Constant.WAY_ABLE) {

					mazeNodes[i][j].setWayState(lurongrong.java.java.Constant.WAY_WEST, lurongrong.java.java.Constant.ISABLE);
				
				}
                //南
                if(i+1<row && mazeNodes[i+1][j].getValue() == lurongrong.java.java.Constant.WAY_ABLE) {
              	
                	mazeNodes[i][j].setWayState(lurongrong.java.java.Constant.WAY_SOUTH, lurongrong.java.java.Constant.ISABLE);
				}
                //北
                if(i-1>=0 && mazeNodes[i-1][j].getValue() == lurongrong.java.java.Constant.WAY_ABLE) {
                	
                	mazeNodes[i][j].setWayState(lurongrong.java.java.Constant.WAY_NORTH, lurongrong.java.java.Constant.ISABLE);
                }
                }
    	
    	}}

    public void goMaze(){
        initValue();// 初始化二维数组MazeNode的value属性
      
       
        adjustWayState();
        if(mazeNodes[0][0].getValue() != 0){
//            System.out.println("没有迷宫经");
            return;
        }
        stack.push(mazeNodes[0][0]);
        //判断每一个节点四个方向的路况，如果可以走就入栈，并更新节点的路况状态，不能退回到原来的节点，如果节点无路就出栈
        while(!stack.empty()) {
        	MazeNode top = stack.peek();
            if(top.i!=row-1 && top.j!=colum-1 && top.way_state[lurongrong.java.java.Constant.WAY_EAST]==false
                    &&top.way_state[lurongrong.java.java.Constant.WAY_WEST]==false
                    &&top.way_state[lurongrong.java.java.Constant.WAY_NORTH]==false
                    &&top.way_state[lurongrong.java.java.Constant.WAY_SOUTH]==false) {
                stack.pop();
            }
        	//走到出口break
        	if(top.i==row-1 && top.j==colum-1) {
        		System.out.println("找到迷宫路径");
        		break;

        		}

        	//东向可行就前进一步将东面的节点入栈，更新路况信息
            //将当前节点的东面和东面节点的西面相应的更改为不能过
        	if(top.way_state[lurongrong.java.java.Constant.WAY_EAST]) {

                mazeNodes[top.i][top.j+1].setWayState(lurongrong.java.java.Constant.WAY_WEST, lurongrong.java.java.Constant.ISDISABLE);//回路封掉
        		mazeNodes[top.i][top.j].setWayState(lurongrong.java.java.Constant.WAY_EAST, lurongrong.java.java.Constant.ISDISABLE);//走过的路封掉
                stack.push(mazeNodes[top.i][top.j+1]);

        	}    
            // 西
        	else if(top.way_state[lurongrong.java.java.Constant.WAY_WEST]) {

                mazeNodes[top.i][top.j-1].setWayState(lurongrong.java.java.Constant.WAY_EAST, lurongrong.java.java.Constant.ISDISABLE);//回路封掉
        		mazeNodes[top.i][top.j].setWayState(lurongrong.java.java.Constant.WAY_WEST, lurongrong.java.java.Constant.ISDISABLE);//走过的路封掉
                stack.push(mazeNodes[top.i][top.j-1]);

        	} 
            
            //南
        	else if(top.way_state[lurongrong.java.java.Constant.WAY_SOUTH]) {

                mazeNodes[top.i+1][top.j].setWayState(lurongrong.java.java.Constant.WAY_NORTH, lurongrong.java.java.Constant.ISDISABLE);
				mazeNodes[top.i][top.j].setWayState(lurongrong.java.java.Constant.WAY_SOUTH, lurongrong.java.java.Constant.ISDISABLE );
                stack.push(mazeNodes[top.i+1][top.j]);

			}
            //北
        	else if(top.way_state[lurongrong.java.java.Constant.WAY_NORTH]) {

                mazeNodes[top.i-1][top.j].setWayState(lurongrong.java.java.Constant.WAY_SOUTH, lurongrong.java.java.Constant.ISDISABLE);
            	mazeNodes[top.i][top.j].setWayState(lurongrong.java.java.Constant.WAY_NORTH, Constant.ISDISABLE);
                stack.push(mazeNodes[top.i-1][top.j]);

            }
           
            }
        showMazePath();
    }     
        
      //打印最终的迷宫路径信息，栈空说明迷宫没有路可以出去，不为空将栈中的节点元素更改之后输出显示路径	
        public void showMazePath()
        {
            MazeNode top;
            if(stack.empty())
            {
                System.out.println("迷宫无路径");

            }
            else
            {
                while(!stack.empty())
                {
                    top=stack.peek();
                    top.setValue(2);
                   // top.getValue();
                    stack.pop();    
                }
                System.out.println("迷宫路径为："); 
                for(int i=0;i<row;i++){
                    for (int j = 0;j<colum;j++){
                        System.out.print(mazeNodes[i][j].getValue()+" ");
                    }
                    System.out.println( );
                   
            
                }
    }
        }}
