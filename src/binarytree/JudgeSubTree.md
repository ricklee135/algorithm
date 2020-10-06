判断一个树是否是另外一个树的子树

```java
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root2 != null && root1 != null){
            if(root1.val == root2.val){
                result = Tree1HaveTree2(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    public boolean Tree1HaveTree2(TreeNode node1, TreeNode node2){
        if(node2 == null){
            return true;
        }
        if(node1 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return Tree1HaveTree2(node1.left, node2.left)&& Tree1HaveTree2(node1.right,node2.right);
    }
}
```

