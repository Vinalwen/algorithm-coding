package topic_7_tree;

import com.sun.istack.internal.localization.NullLocalizable;

/**
 * @author wenyao
 * @create 2020-07-19 22:12
 * ^-^ Fighting!
 */
public class GetNext {
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        if(pNode == null) return null;
        TreeLinkNode res;
        if(pNode.right == null){
            res = pNode;
            while(res.next != null && res.next.right == res){
                res = res.next;
            }
            return res.next;
        }
        res = pNode.right;
        while(res.left != null){
            res = res.left;
        }
        return res;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }


    //自己写的！最好！
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {

        //如果给节点有右子树，则返回该右子树最左的节点
        //如果节点的右节点，没有左节点，那么最左节点就是节点的右节点。
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }

        while(pNode.next != null){
            if (pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }

        return null;

    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}