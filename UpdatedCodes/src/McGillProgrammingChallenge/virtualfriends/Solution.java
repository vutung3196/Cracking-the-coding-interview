package McGillProgrammingChallenge.virtualfriends;


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

//"""
//https://open.kattis.com/problems/virtualfriends
//A program to determine the number of people in various disjoint sets of friends.
//"""
public class Solution {
    static class DisjointSet {
        private DisjointSet parent;
        private int size;

        public DisjointSet() {
            this.parent = this;
            this.size = 1;
        }

        public DisjointSet find() {
            if (this.parent != this) {
                this.parent = this.parent.find();
            }
            return this.parent;
        }

        public int union(DisjointSet secondSet) {
            DisjointSet firstRoot = this.find();
            DisjointSet secondRoot = secondSet.find();

            if (firstRoot == secondRoot) {
                return firstRoot.size;
            } else if (firstRoot.size > secondRoot.size) {
                secondRoot.parent = firstRoot;
                firstRoot.size += secondRoot.size;
                return firstRoot.size;
            } else {
                firstRoot.parent = secondRoot;
                secondRoot.size += firstRoot.size;
                return secondRoot.size;
            }
        }
    }

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }

    public static void main(String[] args) {
        var scan = new Kattio(System.in);
        int num = scan.getInt();
        for (int i = 0; i < num; i++) {
            int numRelationFormed = scan.getInt();
            var distJoinSetDictionary = new HashMap<String, DisjointSet>();
            for (int j = 0; j < numRelationFormed; j++) {
                String name1 = scan.getWord();
                String name2 = scan.getWord();
                if (!distJoinSetDictionary.containsKey(name1)) {
                    distJoinSetDictionary.put(name1, new DisjointSet());
                }
                if (!distJoinSetDictionary.containsKey(name2)) {
                    distJoinSetDictionary.put(name2, new DisjointSet());
                }

                var unionSize = distJoinSetDictionary.get(name1).union(distJoinSetDictionary.get(name2));
                System.out.println(unionSize);
            }
        }
    }
}
