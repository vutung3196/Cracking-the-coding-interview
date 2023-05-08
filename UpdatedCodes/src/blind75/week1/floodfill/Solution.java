package blind75.week1.floodfill;

public class Solution {
    public static void main(String[] args) {

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] marked = new boolean[image.length][image[0].length];
        var valueToCompare = image[sr][sc];
        dfs(image, sr, sc, valueToCompare, marked, color);
        return image;
    }

    public static void dfs(int[][] image, int x, int y, int valueToCompare, boolean[][] marked, int color) {
        // if color equals => marked visited and change the color
        marked[x][y] = true;
        image[x][y] = color;
        // if satisfies == equal to valueToCompare, marked == false
        if (x + 1 < image.length && image[x+1][y] == valueToCompare && marked[x+1][y] == false) {
            dfs(image, x+1, y, valueToCompare, marked, color);
        }
        if (y + 1 < image[0].length && image[x][y+1] == valueToCompare && marked[x][y+1] == false) {
            dfs(image, x, y+1, valueToCompare, marked, color);
        }
        if (x >= 1 && image[x-1][y] == valueToCompare && marked[x-1][y] == false) {
            dfs(image, x-1, y, valueToCompare, marked, color);
        }
        if (y >= 1 && image[x][y-1] == valueToCompare && marked[x][y-1] == false) {
            dfs(image, x, y-1, valueToCompare, marked, color);
        }
    }
}
