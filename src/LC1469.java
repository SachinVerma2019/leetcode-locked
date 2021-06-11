import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1469 {
    //https://leetcode.ca/2019-12-08-1469-Find-All-The-Lonely-Nodes/

    public List<TreeNode> findLonelyNode (TreeNode root){
        if (root == null && (root.left == null || root.right == null) ) {
            return null;
        }
        List <TreeNode> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
                if (curr.right == null) {
                    res.add(curr.left);
                }
            }
            if (curr.right != null) {
                q.offer(curr.right);
                if (curr.left == null) {
                    res.add(curr.right);
                }
            }
        }
        return res;
    }

}



/*
Approach : 1
* BFS - level order traversal
*Approach : 2

*
*
* */