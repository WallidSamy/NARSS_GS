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
        for(int i=5;i<100;i++){
            dataBytes[i-5]=frame[i];
            dataBytes[i-5]=0x7F;
        }
        BitSet dataBits = BitSet.valueOf(dataBytes);
        BitSet dataBitsBuffer = new BitSet(2048);
        int j=0;
        for(int i=0;i<dataBits.length();i++){
            if(dataBits.get(i))
                onesCounter++;
            else
                onesCounter=0;
            dataBitsBuffer.set(j,dataBits.get(i));
            j++;
            if(onesCounter==5){
                onesCounter =0;
                dataBitsBuffer.set(++j,false);
            }
        }
        System.out.println("Length of bitset = " + dataBitsBuffer.length());
        for (int i=0; i<dataBitsBuffer.length(); ++i) {
            System.out.println("bit " + i + ": " + dataBitsBuffer.get(i));
        }
        
    }
    public static void main(String[] args){
        axFrame packet = new axFrame();
        //System.out.println(Arrays.toString(packet.frame));
        packet.removeDataZeros();
        
    }
}
