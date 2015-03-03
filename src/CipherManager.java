import java.io.PrintWriter;
import java.util.Scanner;

public class CipherManager {

	String wiadomosc;
	private int klucz;
	private int basic = 600;
	int tablica[];

	public int getKlucz() {
		return klucz;
	}

	public void setKlucz(int klucz) {
		this.klucz = klucz;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public void cipher() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wpisz wiadomosc do zaszyfrowania: ");
		wiadomosc = sc.nextLine();
		System.out
				.println("Podaj klucz liczbowy do zaszyfrowania wiadomoœci: ");
		while (!sc.hasNextInt()) {

			if (sc.hasNextInt()) {
				setKlucz(sc.nextInt());
				sc.nextLine();
			} else {
				System.out.println("B£¹d, wpisz klucz LICZBOWY: ");
				sc.next();
			}

		}
		
		tablica = new int[wiadomosc.length()];
		for (int i = 0; i < wiadomosc.length(); i++) {
			
			char litera = wiadomosc.charAt(i);
			int koder=(int) litera+getKlucz()+getBasic();
			tablica[i] = koder;

		}
		sc.close();
	}

	public void save(String fileName) {

		try

		{
			PrintWriter pr = new PrintWriter(fileName);

			for (int i = 0; i < tablica.length; i++) {
				pr.print(tablica[i]+"%");
			}
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No such file exists.");
		}

	}

	public void showCryptedMsg() {
		System.out.println("START-------------");
		for (int x : tablica){
			System.out.print(x);}
		System.out.println("\n-------------- END");
		
	}


}
