import java.util.*;

public class JobSequencing {
    public static class Job {
        public final String id;
        public final int deadline;
        public final int profit;

        public Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static List<Job> schedule(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

        int maxDeadline = 0;
        for (Job job : jobs) maxDeadline = Math.max(maxDeadline, job.deadline);

        Job[] slots = new Job[maxDeadline + 1];

        for (Job job : jobs) {
            for (int t = Math.min(job.deadline, maxDeadline); t >= 1; t--) {
                if (slots[t] == null) {
                    slots[t] = job;
                    break;
                }
            }
        }

        List<Job> result = new ArrayList<>();
        for (int t = 1; t <= maxDeadline; t++) {
            if (slots[t] != null) result.add(slots[t]);
        }
        return result;
    }
}
