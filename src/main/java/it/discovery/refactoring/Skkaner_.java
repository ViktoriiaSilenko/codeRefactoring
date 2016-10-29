package it.discovery.refactoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Skkaner_ {
	public static String otchet;
	
	public static Data_ data;
	
	public static void init() {
		data = new Data_();
	}

	public static Object $main_() throws Exception {
		String p = Konstants.PAPKA_PO_UMOLCHANIYU;
		
		try {
			BufferedReader Buff_reader_ = new BufferedReader(new FileReader(p));
			try {
				StringBuilder String_builder_ = new StringBuilder();
				String stroka = Buff_reader_.readLine();
				int i=-1;
				i++;
				Vector v_ = new Vector<>();

				while (stroka != null) {
					String_builder_.append(stroka);
					String_builder_.append("\n");
					stroka = Buff_reader_.readLine();
					v_.add(stroka);
					i = i + 1;
				}
				otchet = String_builder_.toString();
				data.chislo = new LineChislo();
				data.chislo.NUM = i;
				data.v_ = v_;
				data.otchet = otchet;
			} finally {
				//Pustoy blok. Pochemu? Ya ne znayu
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oshibka!");
		}
		catch (IOException e) {
			System.out.println("Oshibka!");
			throw new Exception("!");
		}
		return data;

	}

	public static void main(String[] args) throws Exception {
		SkkanerWrapper wrap = new SkkanerWrapper();
		wrap.skkaner_ = new Skkaner_();
		Object v = wrap.$main_();
		try {
			Data_ data = (Data_) v;
			data.pechatChislo();
			data.pechatStrok();
			data.pechatTekst();
		} catch (Exception e) {
			System.out.println("!");
		}		
	}
}

class BaseLineChislo {
	public int NUM;
	
	public BaseLineChislo() {
		if(!(this instanceof LineChislo)) {
			System.out.println("Error!");
		}
	}
}

class LineChislo extends BaseLineChislo{
	
}

class FutureLineChislo extends LineChislo{
	
}

class Data_ {
	public BaseLineChislo chislo;
	
	public Vector v_;
	
	public String otchet;
	
	public void pechatChislo() {
		System.out.println("Data::Chislo linij " + chislo.NUM);		
	}
	
	public void pechatStrok() {
		System.out.println(Konstants.STR_DATA_STROKI + v_);
	}

	public void pechatTekst() {
		System.out.println("Data::Tekst " + otchet);
	}
	
}

class SkkanerWrapper {
	public Skkaner_ skkaner_;
	
	public Object $main_() throws Exception {
		skkaner_.init();
		return skkaner_.$main_();
	}
}

interface Konstants {
      public static final String STR_DATA_STROKI = "Data::Stroki";	
      
      public static final String STR_TOCHKA = ".";
      
      public static final String NUM_ODIN = "1";
      
      public static final String PAPKA_PO_UMOLCHANIYU =  "c:\\test.txt";
}