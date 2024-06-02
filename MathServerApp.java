
package mathserverapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Panda
 */
public class MathServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declare variables
        ServerSocket ss = null;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        String data = "";
        String outcome;
        
        try{
            ss = new ServerSocket(8080);
            System.out.println("Server socket: "+ss);
            
            socket = ss.accept();
            System.out.println("Connection established..."+socket);
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            data= in.readLine();
            
            while(!data.equals("END")){
                String[] tokens = data.split("#");
                int num1 = Integer.parseInt(tokens[0]);
                int num2 = Integer.parseInt(tokens[1]);
                char op = tokens[2].charAt(0);
                
                if(op == '+'){
                        outcome = Integer.toString(num1+num2);
                }else if(op == '-'){
                        outcome = Integer.toString(num1-num2); 
                }else{
                        outcome = Integer.toString(num1*num2);
                }
                out.println(outcome);//send outcome to the client
                
                System.out.println("Data processed...");
                
                data = in.readLine();
//                System.out.println(data);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{

            try{
                socket.close();
                System.out.println("Closing...");
            }catch(IOException ex){
                ex.printStackTrace();  
            }
        }
        
    }
    
}
