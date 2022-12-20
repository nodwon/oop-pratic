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
    // logger ��ü�� �����Ͽ� log�� ����Ҽ� �ִ�.


    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public  void start() throws IOException { // ���� ������ �����
        try(ServerSocket serverSocket = new ServerSocket(port)){ //�ش� ������ ������ �������
            logger.info("[CustomWebApplicationServer] started {} port.", port);
            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client");

            while ((clientSocket = serverSocket.accept()) != null){ //�ش������ �ش�Ŭ���̾�Ʈ�� ��ٸ�����
                logger.info("[CustomWebApplicationServer] client connected");
                /*
                 Step1 - ����� ��û�� ���� thread�� ó���ϵ��� �Ѵ�.
                 */
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    //���� ���� �������� �а� �ͱ� ������ InputStream reader�� �б����ؼ�
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

//                    String line;
//                    while ((line = br.readLine()) != ""){
//                        System.out.println(line);
//                 }
                    HttpRequest httpRequest =new HttpRequest(br);

                    // Get //calculate?operand1=10&operator=-&operand2=55 HTTP/1.1
                    //Get��û�̸鼭 path�� /calculate�� ��ġ�ϸ� �׶����� query string�� �����ɴϴ�.
                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        // �ش簪�� �����ϴ°���
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
