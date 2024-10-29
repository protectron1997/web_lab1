package view;

import java.nio.charset.StandardCharsets;

public class View {
    public static void send(String content){

        var httpResponse = """
                    HTTP/1.1 200 OK
                    Content-Type: application/json
                    Content-Length: %d
                    
                    %s
                    """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

        System.out.println(httpResponse);
    }
}
