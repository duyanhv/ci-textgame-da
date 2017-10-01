package novels;

import java.util.Arrays;
import java.util.List;

/**
 * Created by duyanh on 9/30/17.
 */
public class Story {
    public String id;
    public String text;
    public List<Choice> choices;

    public Story(String id, String text, Choice... choices){
        this.id = id;
        this.text = text;
        this.choices = Arrays.asList(choices);
    }
}
