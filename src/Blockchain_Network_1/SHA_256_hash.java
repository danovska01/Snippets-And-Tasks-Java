package Blockchain_Network_1;

import java.security.MessageDigest;

public class SHA_256_hash {
    public static String hash(String data) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));


            StringBuffer hexString = new StringBuffer();

            for(int i=0; i< hash.length; i++) {

                String hexDecimal = Integer.toHexString(0xff & hash[i]);

                if(hexDecimal.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hexDecimal);


            }

            return hexString.toString();



        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
