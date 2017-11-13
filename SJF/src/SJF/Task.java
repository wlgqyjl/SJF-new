package SJF;

public class Task {
	private int taskID;
	private int arrivalTime;
	private int serviceTime;
	private int startingTime;
	private int finishingTime;
	private int turnAroundTime;
	private int weightTurnAround;
	public int getTaskID() {
		return taskID;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public void setWeightTurnAround(int weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	public int getWeightTurnAround() {
		return weightTurnAround;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public Task(int tID,int atime,int setime)
	{
		this.taskID=tID;
		this.arrivalTime=atime;
		this.serviceTime=setime;
		this.finishingTime=this.startingTime+this.serviceTime;
		this.turnAroundTime=this.finishingTime-this.arrivalTime;
		this.weightTurnAround=this.turnAroundTime/this.serviceTime;
	}
	public Task() {}
}
