import java.util.*;

class Solution {
    
    static int[][] moveDir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }

        for (String req : requests) {
            char letter = req.charAt(0);

            if (req.length() == 2) {
                removeWithCrane(grid, letter); 
            } else {
                removeWithForklift(grid, letter, n, m);
            }
        }

        return countRemainingContainers(grid, n, m);
    }

    private void removeWithCrane(char[][] grid, char letter) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == letter) {
                    grid[y][x] = '.';
                }
            }
        }
    }

    private boolean[][] findReachableAreas(char[][] grid, int n, int m) {
        boolean[][] reachable = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int y = 0; y < n; y++) {
            if (grid[y][0] == '.') {
                queue.add(new int[]{y, 0});
                reachable[y][0] = true;
            }
            if (grid[y][m - 1] == '.') {
                queue.add(new int[]{y, m - 1});
                reachable[y][m - 1] = true;
            }
        }

        for (int x = 0; x < m; x++) {
            if (grid[0][x] == '.') {
                queue.add(new int[]{0, x});
                reachable[0][x] = true;
            }
            if (grid[n - 1][x] == '.') {
                queue.add(new int[]{n - 1, x});
                reachable[n - 1][x] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];

            for (int[] dir : moveDir) {
                int nextY = y + dir[0];
                int nextX = x + dir[1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) continue;
                if (grid[nextY][nextX] == '.' && !reachable[nextY][nextX]) {
                    queue.add(new int[]{nextY, nextX});
                    reachable[nextY][nextX] = true;
                }
            }
        }

        return reachable;
    }

    private void removeWithForklift(char[][] grid, char letter, int n, int m) {
        boolean[][] reachable = findReachableAreas(grid, n, m);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] != letter) continue;

                boolean accessible = false;
                if (y == 0 || y == n - 1 || x == 0 || x == m - 1) {
                    accessible = true;
                } else {
                    for (int[] dir : moveDir) {
                        int nextY = y + dir[0];
                        int nextX = x + dir[1];

                        if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                            accessible = true;
                            break;
                        }

                        if (grid[nextY][nextX] == '.' && reachable[nextY][nextX]) {
                            accessible = true;
                            break;
                        }
                    }
                }

                if (accessible) {
                    grid[y][x] = '.';
                }
            }
        }
    }

    private int countRemainingContainers(char[][] grid, int n, int m) {
        int count = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] != '.') {
                    count++;
                }
            }
        }
        return count;
    }
}
