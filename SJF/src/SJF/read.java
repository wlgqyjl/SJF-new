package SJF;

import java.io.*;
import java.util.*;


public class read {
	public List<Task> read(){
		List<Task> list = new ArrayList<Task>();
		String filePath="D:\\FCFS.txt";
		String line=" ";
		String [] array;
		int i=0;
		int taskID;
		int arrivalTime;
		int serviceTime;
		try{
			File file = new File(filePath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			while(line!=null){
				line=br.readLine();
				if (line!=null){
					array=line.split(" ");
					taskID=Integer.parseInt(array[0]);
					arrivalTime=Integer.parseInt(array[1]);
					serviceTime=Integer.parseInt(array[2]);
					Task t = new Task(taskID,arrivalTime,serviceTime);

					list.add(i,t);
					i++;
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
