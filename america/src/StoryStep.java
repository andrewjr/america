import java.util.ArrayList;
import java.util.List;

/**
 * Created by arodriguez on 4/3/2015.
 */
public class StoryStep {

    private String stepKey = "";
    private List<String> storyOptions = new ArrayList<>();
    private String description = "";
    private String image = "";

    public String getStepKey() {
        return stepKey;
    }

    public void setStepKey(String stepKey) {
        this.stepKey = stepKey;
    }

    public List<String> getStoryOptions() {
        return storyOptions;
    }

    public void setStoryOptions(List<String> storyOptions) {
        this.storyOptions = storyOptions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {

        return "StepKey: " + getStepKey() + ", Description: " + getDescription() + ", Image name: " +getImage();
    }
}
