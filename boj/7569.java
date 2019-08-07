import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
   public static int[] dx = {1,-1,0,0};
   public static int[] dy = {0,0,-1,1};
   public static int[] dh = {1,-1};
   public static int[][][] map;
   public static int garo;
   public static int sero;
   public static int high;
   public static int day = 0;
   public static boolean[][][] visited;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      StringTokenizer st = new StringTokenizer(sc.nextLine());
      garo = Integer.parseInt(st.nextToken());
      sero = Integer.parseInt(st.nextToken());
      high = Integer.parseInt(st.nextToken());
      map = new int [sero][garo][high];
      visited = new boolean[sero][garo][high];
      for (int h = 0; h < high; h++) {
         for (int i = 0; i < sero; i++) {
            st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < garo; j++) {
               map[i][j][h] = Integer.parseInt(st.nextToken());
            }
         }
      }
      bfs();
   }
   
   /**
    * 새로운 맵에 -1부터 심어주고
    * 익은토마토 돌면서 
    * 익은 토마토 체크해주자
    * 만약 새로운 맵과 파라미터로 들어온 맵이 같다면 변화가 없는것.
    * 
    * 
    */
   public static void bfs() {
      //bfs초기화 && 초기상태가 모두 익은 토마토들로만 이루어져 있는지 체크
      LinkedList<Tomato> list = new LinkedList<Tomato>();
      boolean isGrow = false;
      for (int h = 0; h < high; h++) {
         for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
               if (map[i][j][h] == 1) {
                  Tomato tomato = new Tomato(i,j,h,0);
                  list.add(tomato);
               }
               if (map[i][j][h] == 0) {
                  isGrow = true;
               }
            }
         }
      }
      //만약 모든 토마토가 익은 토마토로 이루어져 있다면,
      if (isGrow == false) {
         System.out.println(0);
         return;
      }
      while (!list.isEmpty()) {
         Tomato tomato = list.poll();
//         System.out.println(tomato.y+":"+tomato.x+":"+tomato.h);
         if (tomato.day > day) {
            day = tomato.day;
         }
         for (int i = 0; i < dx.length; i++) {
            int nx = tomato.x + dx[i];
            int ny = tomato.y + dy[i];
            if (ny < 0 || ny >= sero || nx < 0 || nx >= garo) continue;
            if (map[ny][nx][tomato.h] == 1 || map[ny][nx][tomato.h] == -1) continue;
            map[ny][nx][tomato.h] = 1;
            Tomato tmp = new Tomato(ny,nx,tomato.h,tomato.day+1);
            list.add(tmp);
         }
         for (int i = 0; i < dh.length; i++) {
            int nh = tomato.h + dh[i];
            if (nh < 0 || nh >= high) continue;
            if (map[tomato.y][tomato.x][nh] == 1 || map[tomato.y][tomato.x][nh] == -1) {
               continue;
            }
            map[tomato.y][tomato.x][nh] = 1;
            Tomato tmp = new Tomato(tomato.y,tomato.x,nh,tomato.day+1);
            list.add(tmp);
         }
      }
      boolean canGrow = true;
      for (int h = 0; h < high; h++) {
         for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
               if (map[i][j][h] == 0) {
                  canGrow = false;
               }
            }
         }
      }
      if (canGrow) {
         System.out.println(day);
      } else {
         System.out.println(-1);
      }

   }
}
class Tomato {
   int x;
   int y;
   int h;
   int day;
   public Tomato() {
      // TODO Auto-generated constructor stub
   }   
   public Tomato(int y, int x, int h, int day) {
      this.x = x;
      this.y = y;
      this.h = h;
      this.day = day;
   }
}