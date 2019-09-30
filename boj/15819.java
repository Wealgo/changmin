import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());

		}
		Collections.sort(list);
		System.out.println(list.get(m-1));
	}

}
class word{
	String handle;
	
}