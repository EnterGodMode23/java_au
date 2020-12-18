import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaskItem {
    private String title;
    private String link;
    private ArrayList<String> code;

    public TaskItem(String title, String link, ArrayList<String> code){
        this.title = title;
        this.link = link;
        this.code = code;
    }

    public TaskItem(BufferedReader br, boolean isMdFormat) throws IOException {
        if (isMdFormat){
            this.title = br.readLine().substring(3);
            br.readLine();
            this.link = br.readLine();
            br.readLine();
            br.readLine();
            this.code = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null && !line.startsWith("```")){
                code.add(line);
            }
            br.readLine();
        }
        else {
            this.title = br.readLine();
            this.link = br.readLine();
            this.code = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null){
                code.add(line);
            }
        }
    }

    public String GetTitle(){
        return this.title;
    }

    public String GetShortTitle(){
        return this.title.toLowerCase().replace(' ', '-');
    }

    @Override
    public String toString() {
        return String.format("## %s\n\n%s\n\n```java\n%s\n```\n\n",
                this.title,
                this.link,
                String.join("\n", this.code));
    }
}
