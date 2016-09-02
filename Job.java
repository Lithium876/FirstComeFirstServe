package com.anuj;

public class Job{

    private String jobName;
    private int burstTime;   //units unspecified
    private int remainingTime;
    private int waitingTime;
    private int priority;
    private int arrivalTime;

    public Job(){}

    public Job(String name, int burstTime, int priority){
        this.jobName=name;
        this.burstTime =burstTime;
        this.remainingTime =this.burstTime;
        this.waitingTime = 0;   //just for fun.
        this.priority=priority;
    }   //used for priority cpu scheduling

    public Job(String name, int burstTime){
        this.jobName=name;
        this.burstTime =burstTime;
        this.remainingTime =this.burstTime;
        this.waitingTime = 0;
    }

    public Job(String name, int burstTime, int arrivalTime,int priority){
        this.jobName=name;
        this.burstTime =burstTime;
        this.remainingTime =this.burstTime;
        this.waitingTime = 0;   //just for fun.
        this.arrivalTime = arrivalTime;
        this.priority=priority;
    }   //used for priority cpu scheduling

    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public String getJobName(){
        return this.jobName;
    }

    public void setWaitingTime(int x){
        this.waitingTime = x;
    }

    public void setPriority(int x){
        this.priority = x;
    }

    public int getPriority(){
        return this.priority;
    }

    public int getBurstTime(){
        return this.burstTime;
    }

    public void setRemainingTime(int x){
        if(x>=this.remainingTime){
            this.remainingTime =0;
        }
        else {
            this.remainingTime =this.remainingTime -x;
        }
    }

    public int getTimeWaited(){
        return this.waitingTime;
    }
    public int getRemainingTime(){
        return this.remainingTime;
    }

    public void printStat(){
        System.out.println("JOB: "+ this.getJobName());
        System.out.println("\t Time Required: "+ this.getBurstTime());
        System.out.println("\t Time Remaining: "+ this.getRemainingTime());
        System.out.println("\t Priority: "+ this.getPriority());
    }

    public void printStat(boolean x){
        if(x){
            System.out.println("JOB: "+ this.getJobName()+""+" Time waited:"+ this.getTimeWaited());
        }
    }

    public boolean isDone(){
        return this.remainingTime ==0;
    }

}
