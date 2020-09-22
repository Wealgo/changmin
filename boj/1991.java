import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static char[] tree = new char[26*2+1];
	public static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(br.readLine());
		tree[0] = '.';
		tree[1] = 'A';
		int idx = 2;
		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			int rootIdx = 0;
			for (int j = 0; j < tree.length; j++) {
				if (root == tree[j]) {
					rootIdx = j;
					break;
				}
			}
			tree[rootIdx*2] = st.nextToken().charAt(0);
			tree[rootIdx*2+1] = st.nextToken().charAt(0);
		}
		pre(1);
		System.out.println();
		in(1);
		System.out.println();
		post(1);
	}
	public static void pre(int start) {
		if (tree[start] == '.' || tree[start] == ' ') return;
		System.out.print(tree[start]);
		pre(start*2);
		pre(start*2+1);
	}
	public static void in(int start) {
		if (tree[start] == '.' || tree[start] == ' ') return;
		in(start*2);
		System.out.print(tree[start]);
		in(start*2+1);
	}
	public static void post(int start) {
		if (tree[start] == '.' || tree[start] == ' ') return;
		post(start*2);
		post(start*2+1);
		System.out.print(tree[start]);
	}
}