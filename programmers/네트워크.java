/**
 * 분발하자.
 * @author quadcore
 *
 */
public class Main {
	public int computers[][];
	public boolean visited[];
	public int size;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        size = n;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			++answer;
			dfs(i);
		}
        return answer;
    }
    public void dfs(int n) {
    	visited[n] = true;
    	for (int i = 0; i < size; i++) {
			if (visited[i]) continue;
			if (computers[n][i] == 0) continue;
			dfs(i);
		}
    }
}
