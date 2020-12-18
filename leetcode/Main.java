import java.io.*;

public class Main {

    public static void main(String[] args) {
        String taskFile = "source_leetcode_data.txt";
        String intervalsFile = "intervals.md";

        try {
            BufferedReader intervalsBr = new BufferedReader(new FileReader(intervalsFile));
            TaskItems tasks = new TaskItems(intervalsBr);
            intervalsBr.close();

            BufferedReader itemBr = new BufferedReader(new FileReader(taskFile));
            TaskItem item = new TaskItem(itemBr, false);
            itemBr.close();

            tasks.AddTaskItem(item);

            BufferedWriter intervalsBw = new BufferedWriter(new FileWriter(intervalsFile));
            intervalsBw.write(tasks.toString());
            intervalsBw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
