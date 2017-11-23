package SJF;

public class Task {
	private int taskID;
	private float arrivalTime;
	private float serviceTime;
	private int startingTime;
	private float finishingTime;
	private float turnAroundTime;
	private float weightTurnAround;
	public int getTaskID() {
		return taskID;
	}
	public float getArrivalTime() {
		return arrivalTime;
	}
	public float getServiceTime() {
		return serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public void setFinishingTime(float finishingTime) {
		this.finishingTime = finishingTime;
	}
	public float getFinishingTime() {
		return finishingTime;
	}
	public void setTurnAroundTime(float turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public float getTurnAroundTime() {
		return turnAroundTime;
	}
	public void setWeightTurnAround(float weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	public float getWeightTurnAround() {
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
