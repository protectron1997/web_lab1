import java.nio.charset.StandardCharsets;

public class SendString {
    public static void send(String content){

        var httpResponse = """
                    HTTP/1.1 200 OK
                    Content-Type: text/html
                    Content-Length: %d
                    
                    %s
                    """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

        System.out.println(httpResponse);
    }
}
