package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do Quarto: ");
			int number = sc.nextInt();
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			Date checkIn =  sdf.parse(sc.next());		
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			Date checkOut =  sdf.parse(sc.next());
			
			Reservation r = new Reservation(number, checkIn, checkOut);
			System.out.println("Dados da reserva: " + r);
				
			System.out.println();
			System.out.println("Entre com a data para update: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn =  sdf.parse(sc.next());		
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut =  sdf.parse(sc.next());
				
			r.updateDates(checkIn, checkOut);
			System.out.println("Reserva: "+ r);
		
		}catch(ParseException e) {
			System.out.println("Data invalida");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Error in reservation");
		}

		
		sc.close();
	}

}
