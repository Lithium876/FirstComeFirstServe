package com.anuj;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    static List<Job> execOrder;
    public static void main(String[] args) {
        int jobs, i;
        Random rand = new Random();
        jobs = Math.abs(rand.nextInt(5)+2);
        System.out.printf("No. of jobs: "+jobs+"\n");
        execOrder = new ArrayList<>(jobs);

        //priority=0 -- lowest, priority= 9 highest
        List<Job> jobList = new ArrayList<>();
        for(i=0; i<jobs; i++){
            jobList.add( new Job(""+(i+1), Math.abs(rand.nextInt(10)+1), Math.abs(rand.nextInt(10)+1), 0));
            System.out.println("Job "+jobList.get(i).getJobName()+": burst time "+
                    jobList.get(i).getBurstTime()+" arrival time: "+ jobList.get(i).getArrivalTime());

        }   //filling the jobs list.

        System.out.println("\nSummary: \n");
        while (!jobList.isEmpty()){
            jobList = getJobList(jobList);
        }   //do this until the list is empty.
        printSummary(execOrder);
    }

    private static List<Job> getJobList(List<Job> jobs){
        int min =Integer.MAX_VALUE, i, pos=0, sum=0, prevMin=0, prevMinPos=0;
        if(!jobs.isEmpty()){
            for(i=0; i<jobs.size(); i++){
                if(jobs.get(i).getArrivalTime()<min){
                    min = jobs.get(i).getArrivalTime();
                    jobs.get(i).setRemainingTime(jobs.get(i).getRemainingTime());
                    pos = i;
                    prevMin = jobs.get(i).getPriority();
                    prevMinPos = i;
                }
                else if(jobs.get(i).getPriority()==prevMin){
                    pos=prevMinPos;
                }
            }
            jobs.get(pos).printStat();
            if(!execOrder.isEmpty()){
                sum = execOrder.get(execOrder.size()-1).getTimeWaited()+ execOrder.get(execOrder.size()-1).getBurstTime();
            }
            jobs.get(pos).setWaitingTime(sum);  //setting the waiting time.
            execOrder.add(jobs.get(pos));
            jobs.remove(pos);   //remove the job from the list
        }
        return jobs;
    }

    private static void printSummary(List<Job> jobs){
        System.out.println("\n\nSummary:");
        int i, sum=0;
        for(i=0; i<jobs.size(); i++){
            jobs.get(i).printStat(true);
            sum = sum+jobs.get(i).getTimeWaited();
        }
        DecimalFormat format = new DecimalFormat("#.00");
        System.out.println("Average Waiting Time: "+ format.format((double)sum/jobs.size()));
    }

}
