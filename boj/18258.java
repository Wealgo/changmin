import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st;
		int last = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "push":
				int input = Integer.parseInt(st.nextToken());
				queue.add(input);
				last = input;
				break;
			case "pop":
				if (queue.isEmpty()) {
					bw.append(-1+"\n");
					break;
				}
				bw.append(queue.poll() + "\n");
				break;
			case "size":
				bw.append(queue.size()+"\n");
				break;
			case "empty":
				if (queue.isEmpty()) {
					bw.append(1+"\n");
				} else {
					bw.append(0+"\n");
				}
				break;
			case "front":
				if (queue.isEmpty()) {
					bw.append(-1+"\n");
					break;
				}
				bw.append(queue.peek()+"\n");
				break;
			case "back":
				if (queue.isEmpty()) {
					bw.append(-1+"\n");
					break;
				}
				bw.append(last+"\n");
				break;
			default:
				break;
			}
		}
		bw.flush();
	}
}