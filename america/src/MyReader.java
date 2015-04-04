import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by arodriguez on 4/3/2015.
 */
public class MyReader {

    public static HashMap<String, StoryStep> main() {
        HashMap<String, StoryStep> map = new HashMap<>();
        StoryStep step;


        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("src/Resources/Texts/script.txt" ));

            while ((sCurrentLine = br.readLine()) != null) {

                String[] s = sCurrentLine.split("--");

                step = new StoryStep();
                step.setStepKey(s[1].trim());
                step.setDescription(s[2].trim());
                step.setImage(s[3].trim());
                String[] options = s[4].trim().split("-");
                List<String> list = new ArrayList<>();
                for(String option : options){
                    list.add(option.trim());
                }
                step.setStoryOptions(list);
                System.out.println(step.toString());
                map.put(step.getStepKey(), step);

            }
            System.out.println("Finished");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return map;
    }
}