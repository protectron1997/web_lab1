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



    public static void errorSend(String content){
        var httpResponse = """
                    Status: 400 Bad Request
                    Content-Type: application/json
                    Content-Length: %d
                    
                    %s
                    """.formatted(content.getBytes(StandardCharsets.UTF_8).length, content);

        System.out.println(httpResponse);


    }
}
