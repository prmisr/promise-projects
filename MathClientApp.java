
package mathclientapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Panda
 */
public class MathClientApp {

    public static void main(String[] args) {
        // declare variables
        InetAddress address = null;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        int option, num1, num2;
        String data ="";
        String op, serverResponse;
        Scanner sc = new Scanner(System.in);
        
        try{
            address = InetAddress.getByName("127.0.0.1");
            System.out.println("IP Address: "+address);
            
            socket = new Socket(address, 8080);
            System.out.println("Socket: "+socket);
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            
            option = displayOptions();
            
            while(option !=4){
                System.out.println("Please enter num1: ");
                num1 = sc .nextInt();
                System.out.println("Please enter num2: ");
                num2 = sc .nextInt();
                
                data = num1 +"#"+ num2; //concatenate the numbers
                
                switch(option){
                    case 1:
                        data = data +"#"+"+";
                        op = " + ";
                        break;
                    case 2:
                        data = data +"#"+"-";
                        op = "-";
                        break;
                    default:
                        data = data +"#"+"*";
                        op = "*";
                }
                // concatenate the operation to the data
//                data = data +"#"+op; 
                
                // send data to the server
                out.print(data);
                
                //get response from the server
                serverResponse = in.readLine(); 
                
                System.out.println(serverResponse);
                option = displayOptions();
            }
            out.println("END");
        } catch (UnknownHostException uex) {
            uex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            System.out.println("Closing...");
            try{
                socket.close();
            }catch(IOException ex){
                ex.printStackTrace();  
            }
        }
    }
    public static int displayOptions(){
        int option = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose option: "+"\n"+
                   "========================="+"\n"+
                   "1 - add numbers"+"\n"+
                   "2 - subtract numbers"+"\n"+
                   "3 - multiply numbers"+"\n"+
                   "4 - exit"+"\n"+
                   "Your choice: ");
        option = sc.nextInt();
        
        return option;
    }
    
}
