package novels;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by duyanh on 9/30/17.
 */
public class Story {
    @SerializedName("ID")
    public String id;

    @SerializedName("message")
    public String text;

    @SerializedName("type")
    public String type;

    @SerializedName("time")
    public Time time;

    @SerializedName("answers")
    public List<Choice> choices;

    public Story(String id, String text, Choice... choices){
        this.id = id;
        this.text = text;
        this.choices = Arrays.asList(choices);
    }

    public boolean isType(String t){
        return this.type.equalsIgnoreCase(t);
    }

    @Override
    public String toString() {
        return "Story{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", choices=" + choices +
                '}';
    }
}
