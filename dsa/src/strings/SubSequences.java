package strings;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {
	
	
	public static void main(String args[]) {
		
		String s = "abc";
		char arr[] = s.toCharArray();
		List<Character> list1 ;
		List<List<Character>> list2 = new ArrayList<List<Character>>();
		int n =arr.length;
		
		for(int i=0;i<Math.pow(2, n);i++) {
			list1 = new ArrayList<Character>();
			for(int j=0;j<n;j++) {
				if((i & (1<<j))>0) {
					list1.add(arr[j]);
				}
			}
			list2.add(list1);
		}
		
		
		System.out.println(list2);
		
	}

}
