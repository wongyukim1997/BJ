
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        n = Integer.parseInt(st.nextToken());
        arr = new int[26][26];
        
        for(int i = 0; i < n; i++) {
        	str = br.readLine();
        	st = new StringTokenizer(str, " ");
        	
        	char c1 = st.nextToken().charAt(0);
        	st.nextToken();
        	char c2 = st.nextToken().charAt(0);
        	
        	arr[c1-97][c2-97] = 1;
        }
        
        str = br.readLine();
    	st = new StringTokenizer(str, " ");
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < m; i++) {
        	str = br.readLine();
        	st = new StringTokenizer(str, " ");
        	
        	char c1 = st.nextToken().charAt(0);
        	st.nextToken();
        	char c2 = st.nextToken().charAt(0);
        	
        	check = false;
        	DFS(c1-97, c2-97);
        	
        	if(check) System.out.println("T");
        	else System.out.println("F");
        }
    }
    
    static void DFS(int a, int b) {
    	if(check) return;
    	for(int i = 0; i < 26; i++) {
    		if(arr[a][i] == 1) {
    			if(i == b) {
    				check = true;
    				return;
    			}else DFS(i, b);
    		}
    	}
    	
    }
}