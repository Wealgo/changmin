import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static String[] map = new String [5];
	public static int[] dx = {0,0,1,-1, 1,1,-1,-1};
	public static int[] dy = {1,-1,0,0, 1,-1,1,-1};
	public static String word;
	public static boolean output;
	public static boolean[][][] visit = new boolean[5][5][10];;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int sibal = 0; sibal < t; sibal++) {
			
		
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine();
		}
		int cnt = Integer.parseInt(br.readLine());
		LinkedList<String> words = new LinkedList<>();
		for (int i = 0; i < cnt; i++) {
			words.add(br.readLine());
		}
		for (int k = 0; k < words.size(); k++) {
			word = words.get(k);
			output = false;
			visit = new boolean[5][5][15];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
//					if (words.get(k).charAt(0) == map[i].charAt(j)) {
						dfs(i, j, 0);
//					}
				}
			}
			if (output == true) {
				System.out.println(words.get(k)+" YES");
			} else {
				System.out.println(words.get(k)+" NO");
			}
		}
		}
   }

   public static void dfs(int y, int x, int dpt) {
	   if (dpt == word.length()) {
		   output = true;
		   return;
	   }

	   for (int i = 0; i < dx.length; i++) {
		   int nx = x + dx[i];
		   int ny = y + dy[i];
		   if (nx < 5 && ny < 5 && nx >= 0 && ny >= 0) {
			   if (map[ny].charAt(nx) == word.charAt(dpt) && visit[ny][nx][dpt] == false) {
				   visit[ny][nx][dpt] = true;
				   dfs(ny, nx, dpt+1);
			   }
		   }
	   }
   }
}

