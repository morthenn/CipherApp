import java.io.FileNotFoundException;


public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String fileName="wiadomosc.dat";

		CipherManager ciph=new CipherManager();
		DecipherReader deciph=new DecipherReader();
		ciph.cipher();
		ciph.showCryptedMsg();
		ciph.save(fileName);
		
		deciph.decipher();
		
		
	}

}
