package SJF;

import java.util.*;

public class main {

	public static void main(String[] args) {
		int answer=0;
		List<Task> list = new ArrayList<Task>();
		System.out.println("请输入进程调度类型:\n"
						+  "1.单队列\n"
						+  "2.双队列\n");
		System.out.print("请选择:");
		Scanner scanner = new Scanner(System.in);
		answer=scanner.nextInt();
		read rd = new read();
		list=rd.read();
		if (answer==1){
			SJFONE f=new SJFONE();
			f.sjf(list);
			f.printList(list);
		}
		else if (answer==2){
			SJFTWO f=new SJFTWO();
			f.fcfs(list);
			f.printList(list);
		}	
	}
}
