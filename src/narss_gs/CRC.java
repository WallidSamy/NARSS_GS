/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narss_gs;

/**
 *
 * @author maxxi
 */
public class CRC {

    public int GenerateChecksumCRC16(int bytes[]) {

        int crc = 0xFFFF;
        int temp;
        int crc_byte;

        for (int byte_index = 0; byte_index < bytes.length; byte_index++) {

            crc_byte = bytes[byte_index];

            for (int bit_index = 0; bit_index < 8; bit_index++) {

                temp = ((crc >> 15)) ^ ((crc_byte >> 7));

                crc <<= 1;
                crc &= 0xFFFF;

                if (temp > 0) {
                    crc ^= 0x1021;
                    crc &= 0xFFFF;
                }

                crc_byte <<= 1;
                crc_byte &= 0xFF;

            }
        }

        return crc;
    }

}
