package narss_gs;

import com.fazecast.jSerialComm.*;
import java.util.Scanner;

public class NARSS_GS {

    public static SerialPort comPort;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        new Database_connect().connect();
        /*
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Available ports: ");
        for(int i=1;i<=ports.length;i++){
           System.out.println(i + ": " + ports[i-1].getSystemPortName());
       }
        System.out.print("Choose  " + ports[i-1].getSystemPortName())
        comPort = SerialPort.getCommPort(input.nextLine());
        comPort.setBaudRate(9600);
        comPort.openPort();
        if(comPort.isOpen()){
            System.out.println("Port is opened.");
            byte[] newData = new byte[comPort.bytesAvailable()];
            int numRead = comPort.readBytes(newData, newData.length);
            System.out.println("Read " + numRead + " bytes.");
        }else{
            System.out.println("Port is not available!!");
        }
         */

    }

}
