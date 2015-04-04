import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by arodriguez on 4/3/2015.
 */


public class Main extends JFrame {


    public Main() {

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                HashMap<String, StoryStep> story = MyReader.main();




                CreateUI ex = new CreateUI(story);
                ex.setVisible(true);
            }
        });
    }
}