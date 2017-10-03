package novels;

/**
 * Created by duyanh on 9/30/17.
 */
public class Choice {
    public String value;
    public String to;

    public Choice(String value, String to){
        this.value = value;
        this.to = to;

    }


    public boolean match(String answer){
        return value.equals(answer) || value.equals("other");
    }
}
