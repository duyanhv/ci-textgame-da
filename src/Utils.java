import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by duyanh on 10/7/17.
 */
public class Utils {
    public static String loadStringContent(String url){
       /**static: khong can tao object cung co the goi duoc
        * (Utils utils = new Utils(); <--- cai nay goi la tao obj
        * static khong phu thuoc vao obj ma phu thuoc vao class
        *
        * thuong dung de su dung 1 cai ham de dung ngay (khong phai tao obj)
        */
        //Step 1: read text file

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(url));
            String content = new String(bytes, StandardCharsets.UTF_8);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
