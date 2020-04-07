import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 1;
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<Integer>();
        
        boolean isAble = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            
            if(isAble) {
                if(num <= arr[i]) {
                    while(num <= arr[i]) {
                        stack.push(num++);
                        sb.append("+ \n");
                    }
                }
                if(stack.isEmpty()) isAble = false;
                else { 
                    while(stack.peek() >= arr[i]) {
                        stack.pop();
                        sb.append("- \n");
                        if(stack.isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }
        if(isAble) {
            System.out.println(sb.toString());
        }else {
            System.out.println("NO");
        }
    }
}