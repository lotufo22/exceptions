package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int roomNumber = sc.nextInt();
		System.out.print("Data de check-in (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data de check-out (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: data de check-out deve ser depois da data de check-in");
		} 
		else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Entre com a data para atualziar a reserva:");
			System.out.print("Data de check-in (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de check-out (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Erro na reserva: As datas da reserva para atualização devem ser datas futuras");
			}else if(!checkout.after(checkin)) {
				System.out.println("Erro na reserva: data de check-out deve ser depois da data de check-in");
			}
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}
		}
		
		System.out.println();
		
		sc.close();
	}

}
