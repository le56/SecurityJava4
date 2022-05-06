package java4;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Decryption {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("E:\\privateKey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();
			
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = factory.generatePrivate(spec);
			
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.DECRYPT_MODE, privateKey);
			byte decryptOut[] = c.doFinal(Base64.getDecoder().decode("cTjsDKf9mdk/6p1pSCUpGTWLKZ3WudTId8A07F3Y+iufZDkHas9wl0euoKUgF/OP+T/+0/u0vC31EnSXfXfP8WXYRwERYKh6mfN+xvQi2Ey9nd/l8XoEiyJmr/U4fS8PUTrqlEaYZhkdb5f2IMxgoK975CECCpsIjIjgd2Ml1pA="));
			System.out.print("Du lieu sau giai ma: "+ new String(decryptOut));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
