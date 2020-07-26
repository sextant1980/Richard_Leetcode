import java.util.*;

public class Leetcode_994_rotten_oranges {
    public static int orangesRotting(int[][] grid){
        int[] ewj = new int[]{-1, 0, 1, 0};
        int[] nsi = new int[]{0, -1, 0, 1};

        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> depth = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    int pos = i * m + j;
                    queue.add(pos);
                    depth.put(pos, 0);
                }
            }
        }

        int second = 0;
        while(!queue.isEmpty()){
            int pos = queue.poll();
            int ii = pos/m;
            int jj = pos%m;
            for(int k=0; k<4; k++){
                int nsii = ii + nsi[k];
                int ewjj = jj + ewj[k];
                if(nsii >= 0 && nsii < n && ewjj >= 0 && ewjj < m && grid[nsii][ewjj] == 1){
                    grid[nsii][ewjj] = 2;
                    int tmp = nsii * m + ewjj;
                    queue.add(tmp);
                    depth.put(tmp, depth.get(pos) + 1);
                    second = depth.get(tmp);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return second;
    }








//    static int[] dr = new int[]{-1, 0, 1, 0};
//    static int[] dc = new int[]{0, -1, 0, 1};
//
//    public static int orangesRotting(int[][] grid) {
//        int R = grid.length, C = grid[0].length;
//
//        // queue : all starting cells with rotten oranges
//        Queue<Integer> queue = new ArrayDeque();
//        Map<Integer, Integer> depth = new HashMap();
//        for (int r = 0; r < R; ++r)
//            for (int c = 0; c < C; ++c)
//                if (grid[r][c] == 2) {
//                    int code = r * C + c;
//                    queue.add(code);
//                    depth.put(code, 0);
//                }
//
//        int ans = 0;
//        while (!queue.isEmpty()) {
//            int code = queue.remove();
//            int r = code / C, c = code % C;
//            for (int k = 0; k < 4; ++k) {
//                int nr = r + dr[k];
//                int nc = c + dc[k];
//                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
//                    grid[nr][nc] = 2;
//                    int ncode = nr * C + nc;
//                    queue.add(ncode);
//                    depth.put(ncode, depth.get(code) + 1);
//                    ans = depth.get(ncode);
//                }
//            }
//        }
//
//        for (int[] row: grid)
//            for (int v: row)
//                if (v == 1)
//                    return -1;
//        return ans;
//
//    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        int result = orangesRotting(grid);
        System.out.println("result is: " + result);
    }
}
