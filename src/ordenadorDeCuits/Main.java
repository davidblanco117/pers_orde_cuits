package ordenadorDeCuits;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input;
		String line = "";
		FileWriter fichero = null;
		PrintWriter pw = null;
		String resp = "";
		try {
			fichero = new FileWriter("cuitsOrdenado.txt");
			pw = new PrintWriter(fichero);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			input = new Scanner(new File("cuits.txt"));
			while (input.hasNextLine()) {
				line = input.nextLine();
				String[] campos = {line.substring(0,9),line.substring(9,10)};
				System.out.println(campos[0]+"--"+campos[1]);
				if (campos[1].equals("J")) {
					for (int i = 2; i < 7; i++) {
						//String[] cuits = { campos[2], campos[3], campos[4], campos[5], campos[6] };
						String[] cuits = { line.substring(10,21),line.substring(21,32),line.substring(32,43),
								line.substring(43,54),line.substring(54,65) };
						
						Arrays.sort(cuits);
/*						resp = "" + campos[0] + ";" + campos[1] + ";" + cuits[4] + ";" + cuits[3] + ";" + cuits[2] + ";"
								+ cuits[1] + ";" + cuits[0];
	*/
	
						resp = "" + campos[0] + "" + campos[1] + "" + cuits[4] + "" + cuits[3] + "" + cuits[2] + ""
								+ cuits[1] + "" + cuits[0];
	
					}
				} else {
					resp = line;
				}

				try {
					pw.println(resp);

				} catch (Exception e) {
					e.printStackTrace();
				} 

			}

			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}finally {
			try {
				fichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
