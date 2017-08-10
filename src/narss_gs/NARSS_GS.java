package narss_gs;

public class NARSS_GS {

    public static void main(String[] args) {
        new Database_connect().connect(); 
       
        int x = new CRC().GenerateChecksumCRC16(new int [] {5,6,8,7,01});
        System.out.println("CRC "+ x);
    }
    
    
    
}
