package programmers.lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BT{
    Node1 root;
    int idx;

    public BT() {
        this.root = null; this.idx = 0;
    }

    public Node1 getRoot() {
        return root;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void add(Node1 node){
        if(root == null){
            root = node;
            return;
        }
        Node1 p = root;
        while(true){
            if(node.getX() > p.getX()){
                if(p.getRight() == null) {
                    p.setRight(node);
                    return;
                }
                p = p.getRight();
            }else{
                if(p.getLeft() == null) {
                    p.setLeft(node);
                    return;
                }
                p = p.getLeft();
            }
        }
    }

    public void preorder(Node1 node, int[] list){
        if(node == null) return ;
        list[this.idx++] = node.getValue();
        preorder(node.getLeft(),list);
        preorder(node.getRight(),list);
    }

    public void postorder(Node1 node, int[] list){
        if(node == null) return;
        postorder(node.getLeft(),list);
        postorder(node.getRight(),list);
        list[this.idx++] = node.getValue();
    }
}

class Node1 implements Comparable<Node1>{
    int x;
    int y;
    int value;
    Node1 left;
    Node1 right;

    public Node1(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public Node1 getLeft() {
        return left;
    }

    public Node1 getRight() {
        return right;
    }

    public void setLeft(Node1 left) {
        this.left = left;
    }

    public void setRight(Node1 right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node1 o) {
        return o.y - this.y;
    }
}

public class FindRoadGame {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        /*value를 포함한 nodeinfo 재구성*/
        Node1[] nodeInfoCpy = new Node1[nodeinfo.length];
        for(int i=0; i < nodeinfo.length; i++){
            nodeInfoCpy[i] = new Node1(nodeinfo[i][0],nodeinfo[i][1], i+1);
        }

        Arrays.sort(nodeInfoCpy);

        /*BT 생성*/
        BT tree = new BT();
        for(int i=0; i < nodeInfoCpy.length; i++) tree.add(nodeInfoCpy[i]);

        tree.preorder(tree.getRoot(), answer[0]);
        tree.setIdx(0);
        tree.postorder(tree.getRoot(), answer[1]);

        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[][]{{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}},
                solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}));
    }
}
