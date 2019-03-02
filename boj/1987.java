import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main{
    public static int output;
    public static char[][] map;
    public static char[] visited;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	map = new char[x][y];
    	output = 0;
    	for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
    		for (int j = 0; j < map[0].length; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
    	br.close();
    	LinkedList<Character> list = new LinkedList<>();
//    	for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
    	dfs(0, 0, list);
    	System.out.println(output);
    }
    
    public static void dfs(int y, int x, LinkedList<Character> list) {
    	LinkedList<Character> tmp = new LinkedList<>();
    	tmp.add(map[y][x]);
    	tmp.addAll(list);
    	if (output < tmp.size()) {
			output = tmp.size();
		}
    	try {
        	if (!tmp.contains(map[y][x+1])) {
    			dfs(y, x+1, tmp);
    		}
    	} catch (Exception e) {
				// TODO: handle exception
		}
        try {
        	if (!tmp.contains(map[y+1][x])) {
    			dfs(y+1, x, tmp);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}

        try {
        	if (!tmp.contains(map[y-1][x])) {
    			dfs(y-1, x, tmp);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
        try {
        	if (!tmp.contains(map[y][x-1])) {
    			dfs(y, x-1, tmp);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}

    }
}