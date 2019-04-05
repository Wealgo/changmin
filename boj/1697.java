
import java.util.LinkedList;
import java.util.Scanner;


public class Main{
	public static int time = 0;
	public static int[] visit = new int [100001];
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int subin = sc.nextInt();
    	int sister = sc.nextInt();
    	sc.close();
    	bfs(subin, sister);
    	
    }
    
    public static void bfs(int subin, int sister) {
    	LinkedList<Integer> list = new LinkedList<>();
    	list.add(subin);
    	visit[subin] = 1;
		while (!list.isEmpty()) {
			subin = list.poll();
			if (subin == sister) {
				break;
			}
			//범위가 십만을 넘는것과 이미 방문한 위치는 스킵한다.
			if ( subin+1 <= 100000 && visit[subin+1] == 0) {
				list.add(subin+1);
				visit[subin+1] = visit[subin]+1;
			}
			//범위가 0이하로 내려가는 것과 이미 방문한 위치는 스킵한다.
			if ( subin-1 >= 0 && visit[subin-1] == 0) {
				list.add(subin-1);
				visit[subin-1] = visit[subin]+1;
			}
			if ( subin*2 <= 100000 && visit[subin*2] == 0) {
				list.add(subin*2);
				visit[subin*2] = visit[subin]+1;
			}
		}
		System.out.println(visit[sister]-1);
    }
}