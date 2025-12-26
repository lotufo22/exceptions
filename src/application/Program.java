package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int roomNumber = sc.nextInt();
			System.out.print("Data de check-in (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data de check-out (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());
			

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Entre com a data para atualziar a reserva:");
			System.out.print("Data de check-in (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de check-out (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Formato inválido");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		

		
		sc.close();
	}

}
