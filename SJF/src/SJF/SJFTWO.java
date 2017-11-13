package SJF;

import java.util.*;

public class SJFTWO {
	public List<Task> fcfs(List<Task> list){
		List<Task> l=new ArrayList<Task>();
		int result=0;
		int weightTurnAround[]={0,0};		
		int turnAroundTime[]={0,0};
		int finishingTime[]={0,0};
		int startingTime[]={0,0};
		int serviceTime[]={0,0};
		int arrivalTime[]={0,0};
		int taskID[]={0,0};
		Task t1 = new Task();				
		Task t2 = new Task();				
		int i=0;							
		int s1=-1;							
		int s2=-1;
		int number=0;
		//System.out.println("默认队列一先执行任务");
		System.out.println("总用时   到达任务   队列1开始任务         队列1已完成任务            队列2开始任务              队列2已完成任务");
		for(int time=0;;time++){
			if (i<list.size()){
				l.add(list.get(i));
			}
			if (number>=list.size()){	
				if (s1<0){
					if (s2<0){			
						break;
					}
				}
				if (s2<0){
					if (s1<0){
						break;
					}
				}
			}
			if (taskID[0]==0){				
				if (l.size()>=1){		
					t1=new Task();
					result=judge(l);
					
					delete(l,result);
					t1=list.get(result-1); 		
					taskID[0]=t1.getTaskID();
					arrivalTime[0]=t1.getArrivalTime();
					serviceTime[0]=t1.getServiceTime();
					startingTime[0]=time;
					s1=serviceTime[0];
					if (i<list.size()){
						System.out.print(time+"\t"+list.get(i).getTaskID()+"\t"+taskID[0]+"\t\t\t\t");
					}
					else{
						System.out.print(time+"\t"+"\t"+taskID[0]+"\t\t\t\t");
					}
				}
				else{
					System.out.print(time+"\t\t\t\t\t\t");
				}
			}
			else if (s1==0){			
				if (i<list.size()){
					System.out.print(time+"\t"+list.get(i).getTaskID()+"\t\t\t"+taskID[0]+"\t\t");
				}
				else{
					System.out.print(time+"\t"+"\t\t\t"+taskID[0]+"\t\t");
				}
				finishingTime[0]=time;
				turnAroundTime[0]=finishingTime[0]-arrivalTime[0];
				weightTurnAround[0]=turnAroundTime[0]/serviceTime[0];
				t1.setStartingTime(startingTime[0]);
				t1.setFinishingTime(finishingTime[0]);
				t1.setTurnAroundTime(turnAroundTime[0]);
				t1.setWeightTurnAround(weightTurnAround[0]);
				list.set(taskID[0]-1,t1);
				taskID[0]=0;
				number++;
			}
			else{
				if (i<list.size()){
					System.out.print(time+"\t"+list.get(i).getTaskID()+"\t\t\t\t\t");
				}
				else{
					System.out.print(time+"\t\t\t\t\t\t");
				}
			}
			
			if (taskID[1]==0){
				if (l.size()>=1){
					t2=new Task();
					result=judge(l);
					
					delete(l,result);
					t2=list.get(result-1); 
					taskID[1]=t2.getTaskID();
					arrivalTime[1]=t2.getArrivalTime();
					serviceTime[1]=t2.getServiceTime();
					startingTime[1]=time;
					s2=serviceTime[1];
					if (i<list.size()){
						System.out.print(taskID[1]);
					}
					else{
						System.out.print(taskID[1]);
					}
				}
			}
			else if (s2==0){
				if (i<list.size()){
					System.out.print("\t\t"+taskID[1]);
				}
				else{
					System.out.print("\t\t"+taskID[1]);
				}
				finishingTime[1]=time;
				turnAroundTime[1]=finishingTime[1]-arrivalTime[1];
				weightTurnAround[1]=turnAroundTime[1]/serviceTime[1];
				t2.setStartingTime(startingTime[1]);
				t2.setFinishingTime(finishingTime[1]);
				t2.setTurnAroundTime(turnAroundTime[1]);
				t2.setWeightTurnAround(weightTurnAround[1]);
				list.set(taskID[1]-1,t2);
				taskID[1]=0;
				number++;
			}
			if (i<list.size()){
				i++;
			}
			System.out.println();
			s1--;
			s2--;
		}
		return list;
	}
	public void delete(List<Task> list,int taskID){
		for (int i=0;i<list.size();i++){
			 if (list.get(i).getTaskID()==taskID){
				 list.remove(i);
			 }
		}
	}
	public int judge(List<Task> list){
		int	[] result=new int[100];
		int shortest=100000;
		int number=0;
		int n=0;
		int first=100000;
		for(int i=0;i<list.size();i++){
			if (list.get(i).getServiceTime()<shortest){
				shortest=list.get(i).getServiceTime();
			}
		}
		for (int j=0;j<list.size();j++){
			if (list.get(j).getServiceTime()==shortest){
				result[number]=list.get(j).getTaskID();
				if (first>list.get(j).getArrivalTime()){
					first=list.get(j).getArrivalTime();
					n=number;
				}
				number++;
			}
		}
		return result[n];			
	}
	public void printList(List<Task> list){
		Task t=new Task();
		System.out.println("任务ID\t到达时间\t服务时间\t开始时间\t完成时间\t周转时间\t带权周转时间");
		for(int i=0;i<list.size();i++){
			t=list.get(i);
			System.out.println(t.getTaskID()+"\t"+t.getArrivalTime()+"\t"+t.getServiceTime()+"\t"+
			t.getStartingTime()+"\t"+t.getFinishingTime()+"\t"+t.getTurnAroundTime()+"\t"+t.getWeightTurnAround());
		}
	}
}
