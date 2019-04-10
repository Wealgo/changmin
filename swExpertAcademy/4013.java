
import java.util.LinkedList;
import java.util.Scanner;


public class Main{
	public static int[][] mag = new int [4][8];
	public static int[]num=new int[4];
	public static void main(String[] args) {
    	//입력받고~
    	Scanner sc = new Scanner(System.in);

    	int t = sc.nextInt();
    	for (int i = 1; i <= t; i++) {
			
		
			int n = sc.nextInt();
			LinkedList<Integer> nMag = new LinkedList<>();
			LinkedList<Integer> dir = new LinkedList<>();
			for (int j = 0; j < mag.length; j++) {
				for (int k = 0; k < mag[0].length; k++) {
					mag[j][k] = sc.nextInt();
				}
			}
			for (int j = 0; j < n; j++) {
				nMag.add(sc.nextInt());
				dir.add(sc.nextInt());
			}
			
			while (!dir.isEmpty()) {
				//초기화.
				for(int x=0;x<4;x++) num[x]=0;
				//명령어 넣어준다.
				solution(nMag.poll(), dir.poll());
				
				for(int x=0;x<4;x++){
					if(num[x]==-1) left(x);
					else if(num[x]==1) right(x);
				}
			}
			
			int sum=0;
			//비트마스크연산.
			for(int x=0;x<4;x++){
				if(mag[x][0]==1){
					sum+=1<<x;
				}
			}
			System.out.println("#"+i+" "+sum);
    	}
	}
	
	public static void solution(int cnt,int t) {
		//자석은 1부터 시작이니 --해준다.
		cnt--;
		//해당자석에 돌릴 방향을 준다.
		num[cnt] = t;
		//현재위치에서 오른쪽의 자석들을 조진다.
		for (int i = cnt; i < 3; i++) {
			if(mag[i][2]!=mag[i+1][6]){
				num[i+1]=num[i]*-1;
			}
			else{
				break;
			}
		}
		//현재위치에서 왼쪽의 자석들을 조진다.
		for(int i = cnt; i > 0; i--) {
			if(mag[i][6]!=mag[i-1][2]){
				num[i-1]=num[i]*-1;
			}
			else{
				break;
			}
		}
		
	}
	//시계방향으로 회전.
	//매개변수는 자석의 번호.
	public static void right(int nmag) {
		int[] tmp = new int [8];
		int ntmp = mag[nmag][7];
		for (int i = 0; i < tmp.length-1; i++) {
			tmp[i+1] = mag[nmag][i];
		}
		tmp[0] = ntmp;
		mag[nmag] = tmp;
	}
	//반시계방향으로 회전.
	//매개변수는 자석의 번호.
	public static void left(int nmag) {
		int [] tmp = new int[8];
		int ntmp = mag[nmag][0];
		for (int i = 1; i < tmp.length; i++) {
			tmp[i-1] = mag[nmag][i];
		}
		tmp[7] = ntmp;
		mag[nmag] = tmp;
	}
}