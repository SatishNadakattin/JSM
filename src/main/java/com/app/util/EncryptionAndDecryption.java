package com.app.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class EncryptionAndDecryption {
//	private static Logger logger = LoggerFactory.getLogger("master-log");

	//Normal EncryptionAndDecryption   used for staff and student upload
	public String getEncryptedString(String encr) {
		String strs = encr;
	//	logger.info(">>>>>>>>strs>>>>>>>>>>>>>" + strs);
		String encryptnokey = Base64.getEncoder().encodeToString(strs.getBytes());
	//	logger.info(">>>>>>>>strsewithoutkey>>>>>>>>>>>>>" + encryptnokey);
		String key = " 23$%df%$^ttrr!@#786";
		String code = strs + key;
		String encrypt = Base64.getEncoder().encodeToString(code.getBytes());
	//	logger.info(">>>>>>>>strsewithkey>>>>>>>>>>>>>" + encrypt);
		return encrypt;
	}
    

	public String getDecryptedString(String decr) {
		String encoded = decr;
	//	System.out.println("Encoded String:" + encoded);
		byte[] actualByte = Base64.getDecoder().decode(encoded);
		String decrypt = new String(actualByte);
		return decrypt;

	}
    public String getEncrypted(String encr) {
        String strs=encr;
        String encrypt = Base64.getEncoder().encodeToString(strs.getBytes());

        return encrypt; 
      }

    
	// EncryptionAndDecryption with Key     used for user
    public String getDecryptedStringaddhexkey(String decr) {
        String encoded = decr; 
        String key =" 23$%df%$^ttrr!@#786";
        byte[] actualByte = Base64.getDecoder().decode(encoded); 
        String decrypt = new String(actualByte); 
	//	logger.info(">>>>>>>>decrypt>>>>>>>>>>>>>"+decrypt);
        String code =decrypt+key ; 
	//	logger.info(">>>>>>>>decrypt value and Key>>>>>>>>>>>>>"+code);
        String encpy2nd = getEncrypted(code);
	//    logger.info(">>>>>>>>Encrypted String with Key>>>>>>>>>>>>>"+encpy2nd);
        return encpy2nd;  //will store the value to db

      }
    
    public String getEncryptedStringwithhexkey(String encr) {
    	String strs=encr;
        byte[] actualByte = Base64.getDecoder().decode(strs); 
        String decrypt = new String(actualByte); 
        //remove key from original word
        String Original = decrypt.substring(0, decrypt.lastIndexOf(" "));
	 //   logger.info(">>>>>>>>Original String>>>>>>>>>>>>>"+Original);
        String encrypt = Base64.getEncoder().encodeToString(Original.getBytes());
	//    logger.info(">>>>>>>>Original String encrypt>>>>>>>>>>>>>"+encrypt);
        String key = decrypt.substring(decrypt.lastIndexOf(" ") + 1);
	 //   logger.info(">>>>>>>>Key>>>>>>>>>>>>>"+key);
        return encrypt;    // retrive the orignal plane text value from db
    	
  	
      
} 
    
    
    
    
  
    
}   




