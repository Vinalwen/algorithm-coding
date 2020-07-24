package topic_7_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wenyao
 * @create 2020-07-19 22:06
 * ^-^ Fighting!
 */

/*
展示了树的底层数据实现，add、remove、contains、preOrder-traversal、inorder-traversal、postOrder-traversal(recursion & non—recursion)
 */
class Node<E extends Comparable<E>> {

    E e;
    Node right, left;

    Node(E e,Node left,Node right) {
        this.e = e;
        this.left = left;
        this.right = right;
    }
    Node(E e){
        this.e = e;
    }
}

public class BST<E extends Comparable<E>>{
    Node root;
    int size;

    public void add(E e){
        if (root == null)
            root = new Node(e);
        else
            add(root,e);
    }
    //递归遍历
    /*
    private void add(Node node, E e) {
        if (e.compareTo((E) node.e) > 0) {
            if (node.right == null)
                node.right = new Node(e);
            else
                add(node.left, e);
        }
        else if(e.compareTo((E) node.e) < 0 ){
            if (node.left == null)
                node.left = new Node(e);
            else
                add(node.right,e);
        }
    }
    */


    private Node add(Node node, E e){

        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo((E) node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo((E) node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }


    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e){

        if(node == null)
            return false;

        if(e.compareTo((E) node.e) == 0)
            return true;
        else if(e.compareTo((E) node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }



    //非递归层次遍历
    public void levelOrder(){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.e);
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }
    }

    //非递归前序遍历
    public void preOrder(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

        }
    }

    //递归前序遍历
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){

        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    private void inOrder(Node node){

        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //非递归中序遍历
    //思路：（1）root的左孩子全部进栈
    //     （2）栈非空的情况下，依次出栈并打印，并检查节点是否有右孩子，如果有右孩子，则将右孩子的所有左孩子压入栈
    public void inOrder_non_recursion(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        //stack.push(root);
        leftChildrenInStack(root,stack);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                //stack.push(cur.right);
                leftChildrenInStack(cur.right,stack);
            }
        }

    }

    private void postOrder(Node node){

        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    //非递归后续遍历
    //思路：（1）root的左孩子全部进栈
    //     （2）栈非空的情况下，检查栈顶元素(不出栈)
    //             ----如果栈顶元素有右节点且这个右节点没有被访问过，则将右节点的左子树中的所有左节点压入栈
    //             ----如果不符合以上条件，要么没有右节点，要么右节点已经被访问过了，则打印这个栈顶元素，并出栈。
    public void postOrder_non_recursion(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node pre = null;
        //stack.push(root);
        leftChildrenInStack(root,stack);
        while (!stack.isEmpty()){
            Node cur = stack.peek();

            if (cur.right != null && cur.right != pre){
                //stack.push(cur.right);
                leftChildrenInStack(cur.right,stack);

            }else{
                stack.pop();
                System.out.println(cur.e);
                pre = cur;
            }

        }

    }

    private void rightChildrenInStack(Node node, Stack<Node> stack) {
        stack.push(node);
        while(node.right != null) {
            stack.push(node.right);
            node = node.right;
        }
    }


    private void leftChildrenInStack(Node node,Stack stack){
        stack.push(node);
        while(node.left != null) {
            stack.push(node.left);
            node = node.left;
        }
    }
    

    //查询二分搜索树中的最小元素

    public E minimum(){

        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        
        Node miniNode = minimum(root);
        return (E) miniNode.e;
    }

    private Node minimum(Node node) {
        while(node.left != null)
            node = node.left;
        return node;
    }

    public E removeMinimum(){
        E ret = minimum();
        root = removeMinimum(root);
        return ret;

    }

    private Node removeMinimum(Node node) {

        if (node.left == null){
            if (node.right != null){
                size--;
                return node.right;
            }
            else {
                size--;
                return null;
            }
        }

           /*
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
             */

        node.left = removeMinimum(node.left);
        return node;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        bst.add(9);
//        bst.add(5);
//        bst.add(13);
//        bst.add(2);
//        bst.add(7);
//        bst.add(6);
//        bst.add(8);
//        bst.add(11);
//        bst.add(15);
//        bst.add(11);
//        bst.add(15);
        bst.add(5);
        bst.add(9);
        bst.add(7);


        System.out.println("recursion:");
        bst.postOrder(bst.root);
        System.out.println("non_recuesion:");
        bst.postOrder_non_recursion();
    }

}