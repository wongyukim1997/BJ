
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

	static int n;
	static int[] cnt = new int[26];
	static List<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st;
		
		int T = Integer.parseInt(str);
		
		for(int t = 0; t < T; t++) {
			str = bf.readLine();
			n = Integer.parseInt(str);
			
			//32개가 넘을 경우
			if(32 < n) {
				System.out.println(0);
				str = bf.readLine();
			}
			//16~32개일 경우
//			else if(16 < n && n < 33) {
//				list = new ArrayList<>();
//				String temp = "";
//				
//				str = bf.readLine();
//				st = new StringTokenizer(str, " ");
//				
//				for(int i = 0; i < n; i++) {
//					String s = st.nextToken();
//					
//					boolean check = false;
//					for(String l : list) {
//						if(s.equals(l)) check = true;
//					}
//					
//					list.add(s);
//					if(check) temp = s;
//				}
//				
//				int min = 5;
//				for(String l : list) {
//					int cnt = 0;
//					if(temp.equals(l)) continue;
//					
//					for(int i = 0; i < 4; i++) {
//						if(l.charAt(i) != temp.charAt(i)) cnt++;
//					}
//					
//					min = Math.min(min, cnt);
//				}
//				
//				System.out.println(min*2);
//			}
			//하나도 같은 게 없는 경우
			else {
				list = new ArrayList<>();
				List<Integer> temp = new ArrayList<>();
				
				str = bf.readLine();
				st = new StringTokenizer(str, " ");
				
				for(int i = 0; i < n; i++) {
					String s = st.nextToken();
					list.add(s);
				}
				
				for(int i = 0; i < n-2; i++) {
					for(int j = i+1; j < n-1; j++) {
						for(int k = j+1; k < n; k++) {
//							if(i == j || i == k || j == k) continue;
							
							int cnt = 0;
							
							for(int l = 0; l < 4; l++) {
								if(list.get(i).charAt(l) != list.get(j).charAt(l)) cnt++;
								if(list.get(i).charAt(l) != list.get(k).charAt(l)) cnt++;
								if(list.get(j).charAt(l) != list.get(k).charAt(l)) cnt++;
							}
							
							temp.add(cnt);
						}
					}
				}
				
				Collections.sort(temp);
//				System.out.println(temp);
				System.out.println(temp.get(0));
			}
		}
	}

}
