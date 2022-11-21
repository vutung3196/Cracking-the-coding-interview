package CompaniesInterview.karat.commonancestor;

/* Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

               15
              / \
         14  13  21
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

pairs = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (15, 21), (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
    (12, 9), (15, 13)
]

Write a function that takes this data and the identifiers of two individuals as inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(pairs, 3, 8)   => false
hasCommonAncestor(pairs, 5, 8)   => true
hasCommonAncestor(pairs, 6, 8)   => true
hasCommonAncestor(pairs, 6, 9)   => true
hasCommonAncestor(pairs, 1, 3)   => false
hasCommonAncestor(pairs, 3, 1)   => false
hasCommonAncestor(pairs, 7, 11)  => true
hasCommonAncestor(pairs, 6, 5)   => true
hasCommonAncestor(pairs, 5, 6)   => true
hasCommonAncestor(pairs, 3, 6)   => true
hasCommonAncestor(pairs, 21, 11) => true

n: number of pairs in the input */


import java.util.*;
public class Solution {
    public static class Result {
        public static Set<Integer> result1;
        public static List<Integer> result2;
    }

    public static void main(String[] argv) {
        int[][] pairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {15, 21},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
                {15, 13}
        };

        var result = solution2(pairs, 5, 8);
        // expect false
        System.out.println(result);
    }

    public static boolean solution2(int[][] pairs, int x, int y) {
        if (pairs == null || pairs.length == 0) {
            return false;
        }

        var integerToParents = new HashMap<Integer, Set<Integer>>();
        for (var pair : pairs) {
            var parent = pair[0];
            var children = pair[1];
            if (integerToParents.containsKey(children)) {
                var updatedHashSet = integerToParents.get(children);
                updatedHashSet.add(parent);
                integerToParents.put(children, updatedHashSet);
            } else {
                var a = new HashSet<Integer>();
                a.add(parent);
                integerToParents.put(children, a);
            }
        }

        var parentsOfX = findAllParentsOfElement(x, integerToParents);
        var parentsOfY = findAllParentsOfElement(y, integerToParents);

        for (var parentOfX : parentsOfX) {
            if (parentsOfY.contains(parentOfX))
                return true;
        }
        return false;
    }

    public static Set<Integer> findAllParentsOfElement(int element, Map<Integer, Set<Integer>> map) {
        var result = new HashSet<Integer>();
        var stack = new Stack<Integer>();
        stack.add(element);
        while (stack.size() != 0) {
            var current = stack.pop();
            var parents = map.get(current);
            if (parents == null || parents.size() == 0) continue;
            for (var parent : parents) {
                if (result.contains(parent)) {
                    continue;
                }
                result.add(parent);
                stack.push(parent);
            }

        }

        return result;
    }


    public static Result solution(int[][] pairs) {
        var result = new Result();
        if (pairs == null || pairs.length == 0) {
            return null;
        }

        result.result1 = new HashSet<Integer>();
        result.result2 = new ArrayList<Integer>();
        var integerToParents = new HashMap<Integer, Set<Integer>>();
        var allElements = new HashSet<Integer>();
        for (var pair : pairs) {
            var parent = pair[0];
            var children = pair[1];
            allElements.add(parent);
            allElements.add(children);
            if (integerToParents.containsKey(children)) {
                var updatedHashSet = integerToParents.get(children);
                updatedHashSet.add(parent);
                integerToParents.put(children, updatedHashSet);
            } else {
                var a = new HashSet<Integer>();
                a.add(parent);
                integerToParents.put(children, a);
            }
        }

        for (var child : integerToParents.keySet()) {
            var currentParent = integerToParents.get(child);
            // if (currentParent.size() == 0) {
            //   result1.add(child);
            // }
            if (currentParent.size() == 1) {
                result.result2.add(child);
            }
        }


        for (var a : allElements) {
            if (!integerToParents.containsKey(a)) {
                result.result1.add(a);
            }
        }
        return result;
    }
}
