package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Numero do Quarto: ");
		int number = sc.nextInt();
		System.out.print("Data do check-in (dd/MM/yyyy): ");
		Date checkIn =  sdf.parse(sc.next());		
		System.out.print("Data do check-out (dd/MM/yyyy): ");
		Date checkOut =  sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro chupa meus ovo!!");
		}else {
			Reservation r = new Reservation(number, checkIn, checkOut);
			System.out.println("Dados da reserva: " + r);
			
			System.out.println();
			System.out.println("Entre com a data para update: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn =  sdf.parse(sc.next());		
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut =  sdf.parse(sc.next());
			
		
			String error = r.updateDates(checkIn, checkOut);
				if(error != null) {
					System.out.println("Erro reservado: " + error);
				}else {
					System.out.println("Reserva: "+ r);
				}
		}
		
		
		sc.close();
	}

}
