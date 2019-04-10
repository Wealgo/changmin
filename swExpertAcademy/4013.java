
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
				for(int x=0;x<4;x++) num[x]=0;
				
				solution(nMag.poll(), dir.poll());
				for(int x=0;x<4;x++){
					if(num[x]==-1) left(x);
					else if(num[x]==1) right(x);
				}
			}
			
			int sum=0;
			for(int x=0;x<4;x++){
				if(mag[x][0]==1){
					sum+=1<<x;
				}
			}
			System.out.println("#"+i+" "+sum);
    	}
	}
	public static void solution(int cnt,int t) {
		cnt--;
		
		num[cnt]=t;
		for (int i = cnt; i < 3; i++) {
			if(mag[i][2]!=mag[i+1][6]){
				num[i+1]=num[i]*-1;
			}
			else{
				break;
			}
		}
		
		for(int i=cnt;i>0;i--){
			if(mag[i][6]!=mag[i-1][2]){
				num[i-1]=num[i]*-1;
			}
			else{
				break;
			}
		}
		
	}
	public static void right(int nmag) {
		int[] tmp = new int [8];
		int ntmp = mag[nmag][7];
		for (int i = 0; i < tmp.length-1; i++) {
			tmp[i+1] = mag[nmag][i];
		}
		tmp[0] = ntmp;
		mag[nmag] = tmp;
	}
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