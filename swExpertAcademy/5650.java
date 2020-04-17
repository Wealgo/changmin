import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 찬찬히 침착하게 풀면된다!
 */
public class Main {
	public static int tCase, N, ans;
    public static int[][] map;
    public static int[][][] holes;
    public static boolean[][] visited;
    public static int[] dirX = new int[] { 0, 0, 1, -1 }; // 동 서 남 북
    public static int[] dirY = new int[] { 1, -1, 0, 0 };
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws Exception {
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        tCase = Integer.parseInt(st.nextToken());
 
        for (int t = 1; t <= tCase; t++) {
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N + 2][N + 2];
            holes = new int[5][2][2];
            boolean isExistHole[] = new boolean[5];
            ans = 0;
 
            for (int i = 0; i < N + 2; i++)
                map[i][0] = map[i][N + 1] = map[0][i] = map[N + 1][i] = 5;
 
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
 
                for (int j = 1; j <= N; j++) {
 
                    map[i][j] = Integer.parseInt(st.nextToken());
 
                    if (map[i][j] >= 6 && map[i][j] <= 10) {
 
                        int hole = map[i][j] - 6;
 
                        if (!isExistHole[hole]) {
                            isExistHole[hole] = true;
                            holes[hole][0][0] = i;
                            holes[hole][0][1] = j;
                        } else {
                            holes[hole][1][0] = i;
                            holes[hole][1][1] = j;
                        }
                    }
                }
            }
 
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int dir = 0; dir < 4; dir++)
                        if (map[i][j] == 0)
                            bfs(i, j, dir);
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
 
    public static void bfs(int startRow, int startCol, int startDir) {
 
        int row = startRow;
        int col = startCol;
        int dir = startDir;
        int score = 0;
 
        while (true) {
 
            row += dirX[dir];
            col += dirY[dir];
 
            if ((row == startRow && col == startCol) || map[row][col] == -1) {
                ans = Math.max(ans, score);
                break;
            }
 
            if (map[row][col] >= 1 && map[row][col] <= 5) {
 
                dir = getDirection(dir, map[row][col]);
                score += 1;
 
            } else if (map[row][col] >= 6 && map[row][col] <= 10) {
 
                int hole = map[row][col] - 6;
 
                if (holes[hole][0][0] == row && holes[hole][0][1] == col) {
                    row = holes[hole][1][0];
                    col = holes[hole][1][1];
                } else {
                    row = holes[hole][0][0];
                    col = holes[hole][0][1];
                }
            }
 
        }
    }
 
    public static int getDirection(int dir, int wall) {
 
        if (dir == 0) {
            if (wall == 1 || wall == 2 || wall == 5)
                return 1;
            else if (wall == 3) {
                return 2;
            } else {
                return 3;
            }
 
        } else if (dir == 1) {
            if (wall == 3 || wall == 4 || wall == 5)
                return 0;
            else if (wall == 1) {
                return 3;
            } else {
                return 2;
            }
 
        } else if (dir == 2) {
            if (wall == 2 || wall == 3 || wall == 5)
                return 3;
            else if (wall == 1) {
                return 0;
            } else {
                return 1;
            }
 
        } else {
            if (wall == 1 || wall == 4 || wall == 5)
                return 2;
            else if (wall == 2) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}