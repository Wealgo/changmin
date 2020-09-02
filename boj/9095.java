import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static int[] mem = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		mem[1] = 1;
		mem[2] = 2;
		mem[3] = 4;
		mem[4] = 7;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			if (mem[n] != 0) {
				bw.append(mem[n]+"\n");
				continue;
			}
			for (int j = 5; j <= n; j++) {
				mem[j] = mem[j-1] + mem[j-2] + mem[j-3];
			}
			bw.append(mem[n]+"\n");
		}
		bw.flush();
	}
}