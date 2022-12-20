package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
    // logger 객체를 생성하여 log를 출력할수 있다.


    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public  void start() throws IOException { // 서버 소켓을 만든다
        try(ServerSocket serverSocket = new ServerSocket(port)){ //해당 서버로 소켓을 만든다음
            logger.info("[CustomWebApplicationServer] started {} port.", port);
            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client");

            while ((clientSocket = serverSocket.accept()) != null){ //해당소켓이 해당클라이언트를 기다리게함
                logger.info("[CustomWebApplicationServer] client connected");
                /*
                 Step1 - 사용자 요청을 메인 thread가 처리하도록 한다.
                 */
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    //라인 바이 라인으로 읽고 싶기 때문에 InputStream reader로 읽기위해서
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

//                    String line;
//                    while ((line = br.readLine()) != ""){
//                        System.out.println(line);
//                 }
                    HttpRequest httpRequest =new HttpRequest(br);

                    // Get //calculate?operand1=10&operator=-&operand2=55 HTTP/1.1
                    //Get요청이면서 path가 /calculate와 일치하면 그때서야 query string를 가져옵니다.
                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        // 해당값을 추출하는것을
                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                        byte[] body = String.valueOf(result).getBytes();
                        HttpResponse response = new HttpResponse(dos);
                        response.response200Header("application/json",body.length);
                    }
                }
            }
        }

    }
}
