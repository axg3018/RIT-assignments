/*
 *  HangmanClient.java
 *
 *  @version 1.0
 *
 */
/**
 *  @author Vidhathri Kota
 *  @author Arjun Gupta
 *
 */
import java.util.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.FileInputStream;

public class MultiClient {

  static boolean a = true;
  /**
   * Takes the number of wrong guesses as input and generates the graphics accordingly
   *
   * @param wrong - number of wrong guesses
   */
  public static void Mcfly( int wrong ){    
    if ( wrong == 0 )
      System.out.println( "                        ###     " );
    if ( wrong < 2 )
      System.out.println( "                        ###     " ); 
    if ( wrong < 3 )
      System.out.println( "                         #      " ); 
    if ( wrong < 4 ) 
      System.out.println( "                       #####    " );
    if ( wrong < 5 )
      System.out.println( "                      # ### #   " );
    if ( wrong < 6 )
      System.out.println( "                        ###     " );
    if ( wrong < 7 )
      System.out.println( "                       #  #     " );
    if ( wrong < 8 )
      System.out.println( "                      ##   ##   " );
    if ( wrong < 9 )
      System.out.println( "################################" );
  }
  /**
   * The main program.
   *
   * @param    args    command line arguments - host name, port number
   */ 
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("Usage: java EchoClient <host name> <portNumber>");
      System.exit(1);
    }
    char again = 'y';
    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);
    Scanner s = new Scanner(System.in);
	
    try {Socket echoSocket = new Socket(hostName, portNumber);
      PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); 
      while(again == 'y'){
        System.out.println( "Welcome to HangMan! You know what to do, go for it!" );

        while(in.readLine().equals("true")){
          System.out.println(in.readLine());
          Mcfly(Integer.parseInt(in.readLine()));
          System.out.println( "\nEnter character: " );
          out.println(s.next());
          if(in.readLine().equals("1"))
            System.out.println(in.readLine());

        }
        System.out.println("Do you want to play again  (y/n)?");
        again = s.next().charAt(0);

        out.println(again);
      }
    }catch (UnknownHostException e) {
       System.err.println("Don't know about host " + hostName);
       System.exit(1);
    }catch (IOException e) {
       System.err.println("Couldn't get I/O for the connection to " + hostName);
       System.exit(1);
    } 
  }
}
