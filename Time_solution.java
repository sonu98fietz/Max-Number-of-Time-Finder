import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Time_solution {
	
	public static boolean check(String i) {
//		System.out.println(i);
		int j=Integer.parseInt(i);  
		ArrayList<Integer> list = new ArrayList<>();
		int b=4;
		while(b>0) {
			int a=j%10;
			list.add(a);
			j/=10;
			b--;
		}
//		for(Integer r:list) {
//			System.out.println(r);
//		}System.out.println("--------------------");
		boolean flag=false;
		String time="";
		// First digit of hours can be from the range [0, 2]
		for (int q = 2; q >= 0; q--) {
			if (list.get(0)==q) {
				int u=list.indexOf(q);
				list.remove(u);
				flag = true;
				time += q;
				break;
			}
		}

		// If no valid digit found
		if (!flag) {
			return false;
		}

		flag = false;

		// If first digit of hours was chosen as 2 then
		// the second digit of hours can be
		// from the range [0, 3]
		if (time.charAt(0) == '2') {
			for (int q = 3; q >= 0; q--) {
				if (list.get(0)==q) {
					int u=list.indexOf(q);
					list.remove(u);
					flag = true;
					time += q;
					break;
				}
			}
		}

		// Else it can be from the range [0, 9]
		else {
			for (int q = 9; q >= 0; q--) {
				if (list.get(0)==q) {
					int u=list.indexOf(q);
					list.remove(u);
					flag = true;
					time += q;
					break;
				}
			}
		}
		if (!flag) {
			return false;
		}

		// Hours and minutes separator
		time += ":";

		flag = false;

		// First digit of minutes can be from the range [0, 5]
		for (int q = 5; q >= 0; q--) {
			if (list.get(0)==q) {
				int u=list.indexOf(q);
				list.remove(u);
				flag = true;
				time += q;
				break;
			}
		}
		if (!flag) {
			return false;
		}

		flag = false;

		// Second digit of minutes can be from the range [0, 9]
		for (int q = 9; q >= 0; q--) {
			if (list.get(0)==q) {
				int u=list.indexOf(q);
				list.remove(u);
				flag = true;
				time += q;
				break;
			}
		}
		if (!flag) {
			return false;
		}
		System.out.println(time);
		return flag;
	}
	
	
	public static class Solution {
		
		public int solution(int A,int B, int C ,int D) {
		int time1=0;
		Set<String> set = new HashSet<String>();

		ArrayList<Integer>  mylist = new ArrayList<Integer>();
        mylist.add(A);
        mylist.add(B);
        mylist.add(C);
        mylist.add(D);
    
        String value="";
        while(set.size()!=24) {
        	Collections.shuffle(mylist);
        	for(Integer i:mylist) {
        		value= value+i;
        	}
        	if(!set.contains(value)) {
        		set.add(value);
        	}value="";
        }
		for(String i:set) {
//			System.out.println(i);
			if(check(i)==true) {
				time1++;
			}
		}
		
		return time1;
		}
	}

	public static void main(String[] args) {
		Solution sol= new Solution();
		int A=6,B=4,C=2,D=1;
		int time2=sol.solution(A, B, C, D);
		System.out.println(time2);
	}

}
