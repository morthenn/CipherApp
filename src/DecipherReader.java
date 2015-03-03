import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecipherReader {

	CipherManager cipher = new CipherManager();

	public void decipher() throws FileNotFoundException {
		// TODO code application logic here

		String token1 = "";

		Scanner inFile1 = new Scanner(new File("wiadomosc.dat"))
				.useDelimiter("%");

		List<String> temps = new ArrayList<String>();

		while (inFile1.hasNext()) {

			token1 = inFile1.next();
			temps.add(token1);
		}
		inFile1.close();
		String[] tempsArray = temps.toArray(new String[0]);
		String[] array = new String[tempsArray.length];

		for (int j = 0; j < tempsArray.length; j++) {

			int litera = Integer.parseInt(tempsArray[j])-cipher.getKlucz()-cipher.getBasic();
			char odkoduj = (char) litera;
			String wkoncu = Character.toString(odkoduj);
			array[j] = wkoncu;

		}
		System.out.println("Decrypted message: ");
		for (String s : array) {
			System.out.print(s);
		}
	}
}
