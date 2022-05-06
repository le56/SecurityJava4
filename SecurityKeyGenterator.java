package java4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class SecurityKeyGenterator {
	public static void main(String[] args) {
		try {
			SecureRandom sr = new SecureRandom();
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024,sr);
			
			// Khoi tao cap khoa
			KeyPair kp = kpg.genKeyPair();
			//Publickey
			PublicKey publicKey = kp.getPublic();
			//PrivateKey
			PrivateKey privateKey = kp.getPrivate();
			
			File publicKeyFile = createKeyFile(new File("E:\\publicKey.rsa"));
			File privateKeyFile = createKeyFile(new File("E:\\privateKey.rsa"));
			
			//luu publickey
			
			FileOutputStream fos = new FileOutputStream(publicKeyFile);
			fos.write(publicKey.getEncoded());
			fos.close();
			
			//luu privateKey
			
			fos = new FileOutputStream(privateKeyFile);
			fos.write(privateKey.getEncoded());
			fos.close();
			
			System.out.print("Thanh Cong Roi Nhe");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static File createKeyFile(File file) throws IOException {
		if(!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		return file;
	}
}
