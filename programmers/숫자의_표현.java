import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		int p = 15;
		System.out.println(m.solution(p));
	}
	public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
			int tmp = 0;
			for (int j = i; j <= n; j++) {
				tmp = tmp + j;
				if (tmp == n) {
					answer++;
					break;
				}
				if (tmp > n) break;
				if (tmp < n) continue;
			}
		}
        return answer;
    }
}