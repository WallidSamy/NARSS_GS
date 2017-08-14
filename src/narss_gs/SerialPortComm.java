package narss_gs;

import com.fazecast.jSerialComm.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hani
 */
public class SerialPortComm {

    String[] availablePorts = new String[10];
    public int selectedPort = 0;
    public Object selected = null;

    public SerialPortComm() {

        for (int i = 0; i < SerialPort.getCommPorts().length; i++) {
            availablePorts[i] = SerialPort.getCommPorts()[i].getSystemPortName().toString();
        }

        selected = JOptionPane.showInputDialog(null, "Choose the serial port: ", "Selection", JOptionPane.DEFAULT_OPTION, null, availablePorts, "0");
        if (selected != null) {//null if the user cancels. 
            int index = 0;
            for (Object o : availablePorts) {
                if (selected == o) {
                    break;
                }
                selectedPort++;
            }
            //do something
        } else {
            System.out.println("User cancelled");
        }

    }

    public static void main(String[] args) {
        new SerialPortComm();
    }

    public void readSerial() {
        SerialPort comPort = SerialPort.getCommPorts()[selectedPort];
        comPort.openPort();
        comPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    return;
                }
                byte[] newData = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(newData, newData.length);
                System.out.println("Read " + numRead + " bytes.");
            }
        });
    }

    public void writeSerial() {
        SerialPort comPort = SerialPort.getCommPorts()[selectedPort];
        comPort.openPort();
        comPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_WRITTEN;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_WRITTEN) {
                    System.out.println("All bytes were successfully transmitted!");
                }
            }
        });
    }

    public boolean isSlected() {
        if (selected != null) {
            return true;
        }
        return false;
    }
}
