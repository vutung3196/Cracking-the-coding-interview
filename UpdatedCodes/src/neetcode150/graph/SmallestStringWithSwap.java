package neetcode150.graph;

import java.util.*;

public class SmallestStringWithSwap {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        System.out.println(new SmallestStringWithSwap().smallestStringWithSwaps(s, pairs));
    }


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        // got the idea
        for (var pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            var root = uf.find(i);
            var componentList = rootToComponent.getOrDefault(root, new ArrayList<Integer>());
            componentList.add(i);
            rootToComponent.put(root, componentList);
        }

        // find the smallest string here!
        char[] smallestString = new char[s.length()];
        for (List<Integer> indices : rootToComponent.values()) {
            List<Character> characters = new ArrayList<>();
            for (int index : indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);

            for (int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }
        }

        return new String(smallestString);
    }

    private class UnionFind {
        int[] root;
        int[] rank;
        int count;

        // O(n)
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = size;
        }

        // O(n)
        public int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]);
            }

            return root[x];
        }

        // O(n)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        // O(n)
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int getCount() {
            return count;
        }
    }
}
