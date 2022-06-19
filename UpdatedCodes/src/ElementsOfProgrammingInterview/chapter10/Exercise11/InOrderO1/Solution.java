package ElementsOfProgrammingInterview.chapter10.Exercise11.InOrderO1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private class BinaryTreeWithParent<T> {
        public BinaryTreeWithParent<T> left, right, parent;
        public T data;
    }

    static List<Integer> inOrderTraversal(BinaryTreeWithParent<Integer> root) {
        BinaryTreeWithParent<Integer> prev = null, curr = root;
        List<Integer> result = new ArrayList<>();
        while (curr != null) {
            BinaryTreeWithParent<Integer> next;
            // left -> root -> right
            if (curr.parent == prev) {
                // keep going left;
                if (curr.left != null) {
                    next = curr.left;
                } else {
                    result.add(curr.data);
                    next = curr.right != null ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                result.add(curr.data);
                next = curr.right != null ? curr.right : curr.parent;
            } else {
                next = curr.parent;
            }
            prev = curr;
            curr = next;
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
