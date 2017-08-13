package narss_gs;

import java.util.Arrays;
import java.util.BitSet;


public class axFrame {
    
     static byte[] frame = new byte[266];
     private byte[] dataBytes = new byte[256];
     private int onesCounter=0;
    
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
    public void removeDataZeros(){
        for(int i=5;i<261;i++){
            dataBytes[i-5]=frame[i];
            dataBytes[i-5]=10;
        }
        BitSet dataBits = BitSet.valueOf(dataBytes);
        System.out.println("Length of bitset = " + dataBits.length());
        for (int i=0; i<dataBits.length(); ++i) {
            System.out.println("bit " + i + ": " + dataBits.get(i));
        }
    }
    public static void main(String[] args){
        axFrame packet = new axFrame();
        //System.out.println(Arrays.toString(packet.frame));
        packet.removeDataZeros();
        
    }
}
