import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
public class raspberrypi {
	static BufferedReader in;
	public static void main(String []args)  {
		ServerSocket sk = null;
		try {sk = new ServerSocket(1234);} catch (IOException e1) {e1.printStackTrace();}
		
		while(true)
		{
	try {
		Socket socket=sk.accept();
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		ReadsD reads=new ReadsD(in);
		reads.start();
		} 
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		
}
}
class ReadsD extends Thread{
	BufferedReader in;
	public ReadsD(BufferedReader bufferedReader) {
		// TODO Auto-generated constructor stub
		in=bufferedReader;
	}
	@Override
	public void run() {
		while(true)
		{
			try {
				String aString=in.readLine();
				if(aString=="null"||aString==null)
				{
					break;
				}
				System.out.println(aString);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
