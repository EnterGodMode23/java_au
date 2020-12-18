import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaskItems {
    private ArrayList<TaskItem> tasks;
    public TaskItems(ArrayList<TaskItem> tasks) {
        this.tasks = tasks;
    }

    public TaskItems(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null){
            this.tasks = new ArrayList<>();
        }
        else {
            br.readLine();
            int n = 0;
            while ((line = br.readLine()) != null && !line.isEmpty()){
                n++;
            }
            this.tasks = new ArrayList<>();
            for (int i=0; i<n; i++){
                this.tasks.add(new TaskItem(br, true));
            }
        }
    }

    public void AddTaskItem(TaskItem item){
        this.tasks.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("# Intervals\n\n");
        for (TaskItem task : this.tasks) {
            sb.append(String.format("+ [%s](#%s)\n",
                    task.GetTitle(),
                    task.GetShortTitle()));
        }
        sb.append("\n");
        for (TaskItem task : this.tasks){
            sb.append(task.toString());
        }
        return sb.toString();
    }
}
