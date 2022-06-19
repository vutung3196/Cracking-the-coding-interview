package ElementsOfProgrammingInterview.chapter10.Exercise17.LockBinaryTree;

public class Solution {
    private static class BinaryTree {
        private BinaryTree left, right, parent;
        private boolean locked = false;
        private int numLockedDescendants = 0;

        public boolean isLocked() {
            return locked;
        }

        public boolean lock() {
            if (numLockedDescendants > 0 || locked) {
                return false;
            }

            // cannot lock if any of this node's ancestors are locked
            for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                if (iter.locked)
                    return false;
            }

            locked = true;
            for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                ++iter.numLockedDescendants;
            }
            return true;
        }

        public void unlock() {
            if (locked) {
                locked = false;
                for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                    --iter.numLockedDescendants;
                }
            }
        }
    }
}
