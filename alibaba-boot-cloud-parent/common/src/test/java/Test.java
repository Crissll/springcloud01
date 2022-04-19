import com.powernode.springloud.utils.DateTime;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", ""));

        System.out.println(DateTime.getDate());
        System.out.println(DateTime.getDateTime());
        System.out.println(DateTime.getTime());
    }
}
