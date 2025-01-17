import java.util.*;

public class _6JobSelection {

    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int deadline, int profit, int id) {
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{ 4, 20}, { 1, 10}, { 1, 40}, { 1, 30}};

        // Job jobs[] = new Job[jobsInfo.length];
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(jobsInfo[i][0], jobsInfo[i][1], i));
        }

        Collections.sort(jobs, (a,b)->b.profit-a.profit);//descending order of profit


        ArrayList<Integer> result = new ArrayList<>();
        int maxDeadline = 0;

        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadline>maxDeadline){
                result.add(curr.id);
                maxDeadline++;
            }
        }

        System.out.println("Maximum jobs selected: "+maxDeadline);
        System.out.println("Jobs selected: ");
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }

        

    }
}
