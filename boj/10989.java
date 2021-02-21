import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int[] map = new int[10001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) map[(Integer.parseInt(br.readLine()))]++;
		
		for (int i = 0; i < 10001; i++) {
			if (map[i] == 0) continue;
			for (int j = 0; j < map[i]; j++) bw.append(i+" ");
		}
		bw.flush();
	}
}