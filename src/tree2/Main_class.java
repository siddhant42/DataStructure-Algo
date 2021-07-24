package tree2;

import java.util.ArrayList;
import java.util.Collections;

public class Main_class {
public static void main(String args[] ) {
Main_class obj=new Main_class();
    //first create tree
    Node rootNode = new Node ('A' , new Node('B',null,
                                             new Node('D',
                                                      new Node('K',
                                                               new Node('Z',null,
                                                               null),null),
                                                      new Node('L',null,null))),
                                    new Node('C',
                                             new Node('E',
                                                      null,
                                                      new Node('M',null,null)),null) );

    ArrayList <Node> path = new ArrayList<Node>();
    System.out.println(obj.getPath(rootNode,'Z',path));
    Collections.reverse(path);
    System.out.println(path);
    path = new ArrayList<Node>();
    System.out.println(obj.getPath(rootNode,'M',path));
    System.out.println(path);

}
boolean getPath(Node rootNode, char key, ArrayList<Node> path ){
    //return true if the node is found
    if( rootNode==null)
        return false;
    if (rootNode.getVal()==key){
        path.add(rootNode);
        return true;
    }
    boolean left_check = getPath( rootNode.left,key,path);
    boolean right_check = getPath( rootNode.right,key,path);
    if ( left_check || right_check){
        path.add(rootNode);
        return true;
    }
    return false;

}
static class Node {
    char val;
    Node left;
    Node right;
    public Node( char val, Node left, Node right){
        this.left=left;
        this.right=right;
        this.val=val;
    }
    public char getVal(){
        return val;
    }
   public String toString(){
        return " " + val + " ";
    }
}

}
