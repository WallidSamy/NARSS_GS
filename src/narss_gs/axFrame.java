package narss_gs;

import java.util.Arrays;


public class axFrame {
    
     static byte[] frame = new byte[266];
    
    public axFrame(){
        frame[0]=0x7E;
        frame[2]=7;
        frame[265]=0x7E;
    }
    public void setDestination(byte dest){
        frame[1]=dest;
    }
    public byte getSource(){
        return frame[1];
    }
    public static void main(String[] args){
        axFrame packet = new axFrame();
        System.out.println(Arrays.toString(packet.frame));
    }
}
