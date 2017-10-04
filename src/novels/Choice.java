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
//        System.out.println(String.format("%s vs %s", answer, this.value));
        return value.equalsIgnoreCase(answer) || value.equalsIgnoreCase("other");
    }

    @Override
    public String toString() {
        return "Choice{" +
                "value='" + value + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
