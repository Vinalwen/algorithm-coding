package topic_7_tree;


import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * @author wenyao
 * @create 2020-07-19 22:07
 * ^-^ Fighting!
 */
public class ConstructTree {

    //第一份大作：
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        //数组长度为0的时候要处理
        if(pre.length == 0){
            return null;
        }

        int rootVal = pre[0];

        //数组长度仅为1的时候就要处理
        if(pre.length == 1){
            return new TreeNode(rootVal);
        }

        //我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i=0;i<in.length;i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
              //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree1(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree1(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;


    }


    //第二份大作：
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }


    public TreeNode reconstructTree(int[] pre, int[] in){

        if (pre.length == 0)
            return null;
        if (pre.length == 1)
            return new TreeNode(pre[0]);

        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = 0;i < in.length;i++){
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = reconstructTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reconstructTree(Arrays.copyOfRange(pre,1+rootIndex,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));
        return root;

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}