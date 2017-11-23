package SJF;

import java.util.*;

public class SJFONE {
	public List<Task> sjf(List<Task> list){
		List<Task> l=new ArrayList<Task>();
		int result=0;
		float weightTurnAround=0;  
		float turnAroundTime=0;        
		float finishingTime=0;		
		int startingTime=0;			
		float serviceTime=0;			
		float arrivalTime=0;			
		int taskID=0;				
		Task t = new Task();		 
		int i=0;					
		float s=0;					
		int number=0;
		l.add(list.get(i));
		System.out.println("总用时\t到达任务\t开始任务\t完成任务");
		for(int time=0;number<list.size();time++){
			if (taskID==0){         
				t=new Task();  
				result=judge(l);
				delete(l,result);
				t=list.get(result-1);       
				taskID=t.getTaskID();
				arrivalTime=t.getArrivalTime();
				serviceTime=t.getServiceTime();
				startingTime=time;
				s=serviceTime;
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID()+"\t"+taskID);  
				}
				else{
					System.out.println(time+"\t"+"\t"+taskID);
				}
			}
			else if (s==0){        
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID()+"\t\t"+taskID);
				}
				else{
					System.out.println(time+"\t"+"\t\t"+taskID);
				}
				finishingTime=time;			
				turnAroundTime=finishingTime-arrivalTime;
				weightTurnAround=turnAroundTime/serviceTime;
				t.setStartingTime(startingTime);
				t.setFinishingTime(finishingTime);
				t.setTurnAroundTime(turnAroundTime);
				t.setWeightTurnAround(weightTurnAround);
				list.set(taskID-1,t);
				taskID=0;		
				number++;
			}
			else{				
				if (i<list.size()){
					System.out.println(time+"\t"+list.get(i).getTaskID());
				}
				else{
					System.out.println(time);
				}
			}
			if (i<list.size()){			
				i++;
			}
			if (i<list.size()){
				l.add(list.get(i));
			}
			s--;		
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
		float shortest=100000;
		int number=0;
		int n=0;
		float first=100000;
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
			System.out.println(t.getTaskID()+"\t"+(int)t.getArrivalTime()+"\t"+(int)t.getServiceTime()+"\t"+
			(int)t.getStartingTime()+"\t"+(int)t.getFinishingTime()+"\t"+(int)t.getTurnAroundTime()+"\t"+t.getWeightTurnAround());
		}
	}
}
