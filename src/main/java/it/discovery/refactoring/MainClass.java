package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Eto kalkulyator
 * 
 * 
 */
public class MainClass {
	public static String otchet = null;

	// Primer ispolzovaniya: zapustit is IDE s argumentami
	// 1) znak operacii
	// 2) argument #1,
	// 3) argument #2
	// 4) sistema schisleniya - 2, 8, 10 ili 16 (opcionalno, default 10)
	// 5) vyvod v konsol(false) ili file(true) (opcionalno)
	// naprimer, + 2 2 true
	public static void main(String[] argumenty) {
		String operaciya = argumenty[0];
		String pervoe = argumenty[1];
		//String vtoroe = argumenty[1];
		String vtoroe = argumenty[2];
		String schis = null;
		try {
			schis = argumenty[3];
		} catch (ArrayIndexOutOfBoundsException iskl) {
			schis = "10";
		}

		String konsol = null;
		try {
			konsol = argumenty[4];
		} catch (ArrayIndexOutOfBoundsException iskl) {
			konsol = "false";
		}

		work(operaciya, pervoe, vtoroe, schis, konsol, "");
	}

	/**
	 * Glavnaya function
	 * 
	 * @param argumenty
	 */
	public static int work(String oper, String per, String vt, String schis, String kon, String temp) {
		otchet = "";
		//otchet = "";
		otchet += "Nachali rabotu\n";
//		String operaciya = argumenty[10];
//		boolean probel = operaciya.equals("");
//		if (probel) {
//			operaciya = "+";
//		}		

		boolean con = false;
		if (kon != null && kon.equals("true")) {
			con = true;
		}

		switch (oper) {
		case "+": {
			otchet += "Operaciya slojit\n";
			int pervoeInt = 0;
			try {
				pervoeInt = Integer.parseInt(per);
			} catch (Exception ex) {
				System.out.println("Oshibka");
				return -1;
			}
			int vtoroeInt = 0;
			try {
				vtoroeInt = Integer.parseInt(vt);
			} catch (Exception ex) {
				System.out.println("Oshibka");
				return -1;
			}

			otchet += "Argument 1 " + preobraz(pervoeInt, schis) + "\n";
			otchet += "Argument 2 " + preobraz(vtoroeInt, schis) + "\n";
			int summa = pervoeInt + vtoroeInt;
			otchet += "Rezultat " + preobraz(summa, schis) + "\n";
			System.out.println(summa);
			try {
				otchet += "Zakonchili rabotu\n";
				if (con) {
					System.out.println(otchet);
				} else {
					FileWriter w = new FileWriter("c:\\test.txt");
					BufferedWriter out = new BufferedWriter(w);
					out.write(otchet);
					out.close();
				}

			} catch (Exception e) {
				System.out.println("Oshibka");
				return -1;
			}
		}
			;
			break;

		case "-": {
			otchet += "Operaciya vychitanie\n";
			int pervoeInt = 0;
			try {
				pervoeInt = Integer.parseInt(per);
			} catch (Exception ex) {
				System.out.println("Oshibka");
				return -1;
			}
			int vtoroeInt = 0;
			try {
				vtoroeInt = Integer.parseInt(vt);
			} catch (Exception ex) {
				System.out.println(oshib());
				return -1;
			}

			otchet += "Argument 1 " + preobraz(pervoeInt, schis) + "\n";
			otchet += "Argument 2 " + preobraz(vtoroeInt, schis) + "\n";
			pervoeInt -= vtoroeInt;
			otchet += "Rezultat " + preobraz(pervoeInt, schis) + "\n";
			System.out.println(pervoeInt);
			try {
				otchet += "Zakonchili rabotu\n";
				if (con) {
					System.out.println(otchet);
				} else {
					FileWriter w = new FileWriter("c:\\test.txt");
					BufferedWriter out = new BufferedWriter(w);
					out.write(otchet);
					out.close();
				}

			} catch (Exception e) {
				System.out.println(oshib());
				return -1;
			}
		}
			;
			break;
		case "*": {
			otchet += "Operaciya umnojeniya\n";
			int pervoeInt = 0;
			try {
				pervoeInt = Integer.parseInt(per);
			} catch (Exception ex) {
				System.out.println(oshib());
				return -1;
			}
			int vtoroeInt = 0;
			try {
				vtoroeInt = Integer.parseInt(vt);
			} catch (Exception ex) {
				System.out.println(oshib());
				return -1;
			}
			otchet += "Argument 1 " + konvert(pervoeInt, schis) + "\n";
			otchet += "Argument 2 " + konvert(vtoroeInt, schis) + "\n";
			int itogo = pervoeInt * vtoroeInt;
			otchet += "Rezultat " + konvert(itogo, schis) + "\n";
			System.out.println(itogo);
			try {
				otchet += "Zakonchili rabotu\n";
				if (con) {
					System.out.println(otchet);
				} else {
					FileWriter w = new FileWriter("c:\\test.txt");
					BufferedWriter out = new BufferedWriter(w);
					out.write(otchet);
					out.close();
				}

			} catch (Exception e) {
				System.out.println(oshib());
				return -1;
			}

		}
			;
			break;
		}
		return 0;

	}

	private static String preobraz(int znach, String schis) {
		switch (schis) {
		case "2":
			String rez = Integer.toBinaryString(znach);
			return rez;
		case "8":
			String rez2 = Integer.toOctalString(znach);
			return rez2;
		case "16":
			String rez3 = Integer.toHexString(znach);
			return rez3;
		default:
			String rez4 = "" + znach;
			return rez4;
		}
	}

	private static String konvert(int data, String schis) {
		int sc = 10;
		try {
			sc = Integer.parseInt(schis);
		} catch (NumberFormatException iskl) {
			
		}
		
		String rez = Integer.toString(data, sc);
		return rez;		
	}
	
	private static String oshib() {
		return "Oshibka";
	}
}

//class OtchetTools {
//	public static void zapusk() {
//		String otchet = MainClass.otchet;
//		System.out.println(otchet);
//	}
//	
//	public static void main(String[] argumenty) {
//		OtchetTools otchet = new OtchetTools();
//		otchet.zapusk();
//	}
//}
