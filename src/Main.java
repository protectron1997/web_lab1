import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Objects;

import com.fastcgi.FCGIInterface;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int x = 0,y = 0,r = 0;
        var fcgiInterface = new FCGIInterface();


        while (fcgiInterface.FCGIaccept() >= 0) {

            String data = FCGIInterface.request.params.getProperty("QUERY_STRING");
            var content = "";
            if(data != null){
                for(String chunk : data.split("&")){
                    String[] keyValue = chunk.split("=");
                    if(Objects.equals(keyValue[0], "x")){
                        x = Integer.parseInt(keyValue[1]);
                    }
                    if(Objects.equals(keyValue[0], "y")){
                        y = Integer.parseInt(keyValue[1]);
                    }
                    if(Objects.equals(keyValue[0], "r")){
                        r = Integer.parseInt(keyValue[1]);
                    }
                }
                var start = Instant.now();
                content = String.valueOf(AreaCheck.hit(x,y,r));
                var end = Instant.now();

                long time = ChronoUnit.NANOS.between(start,end);

                content += " ";
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
                content += LocalDateTime.now().format(dtf);
                content += " ";
                content += time;
            }




            var httpResponse = """
                    HTTP/1.1 200 OK
                    Content-Type: text/html
                    Content-Length: %d
                    
                    %s
                    """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

            System.out.println(httpResponse);
        }
    }
}