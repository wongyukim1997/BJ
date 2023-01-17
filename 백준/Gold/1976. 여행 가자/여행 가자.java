
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static boolean[] visit;
	static List<Integer>[] list;
	static boolean check = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = bf.readLine();
		StringTokenizer st;
		n = Integer.parseInt(str);
		
		list = new List[n+1];
		visit = new boolean[n+1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		str = bf.readLine();
		m = Integer.parseInt(str);
		
		for(int i = 1; i <= n; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str, " ");
			for(int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) list[i].add(j);
			}
		}
		
//		for(int i = 1; i <= n; i++) System.out.println(list[i]);
		
		arr = new int[m+1];
		str = bf.readLine();
		st = new StringTokenizer(str, " ");
		
		for(int i = 1; i <= m; i++) arr[i] = Integer.parseInt(st.nextToken());
	
		DFS(2, arr[1]);
		
		if(check) System.out.println("YES");
		else System.out.println("NO");
	}
	
	//num: 방문해야하는 순서, state: 현재 위치
	//arr[num]: 방문해야할 위치
	
	static void DFS(int num, int state) {
		if(check) return;
		if(arr[num] == state) {
			if(num == m) {
				check = true;
				return;
			}
			
			init();
			visit[state] = true;
			DFS(num+1, state);
		}
		
		for(int i : list[state]) {
			if(!visit[i]) {
				visit[i] = true; 
				DFS(num, i);
			}
		}
	}
	
	static void init() {
		for(int i = 1; i <= n; i++) visit[i] = false;
	}

}
