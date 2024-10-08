import java.nio.charset.StandardCharsets;

import com.fastcgi.FCGIInterface;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var fcgiInterface = new FCGIInterface();
        while (fcgiInterface.FCGIaccept() >= 0) {
            var content = """
                    <html>
                        <head><title>Java FastCGI Hello World</title></head>
                        <body><h1>Hello, World!</h1></body>
                    </html>""";
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