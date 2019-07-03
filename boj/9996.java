import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static String p1;
	public static String p2;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		StringTokenizer st = new StringTokenizer(pattern, "*");
		p1 = st.nextToken();
		p2 = st.nextToken();

		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		////
		for (int i = 0; i < list.size(); i++) {
			if (check(list.get(i))) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	 /**/
	}
	public static boolean check(String str) {
		if (!str.startsWith(p1)) {
			return false;
		}
		str = str.substring(p1.length());
		if (!str.endsWith(p2)) {
			return false;
		}
		return true;
	}
}