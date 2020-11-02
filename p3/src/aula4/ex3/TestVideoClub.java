package aula4.ex3;
import java.util.*;

public class TestVideoClub {

static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {		
		
		VideoClub vc = new VideoClub(5);
		
		int option;
		
		do {
			System.out.println("Menu:");
			System.out.println("1  - Add Video");
			System.out.println("2  - Remove Video");
			System.out.println("3  - Display Videos");
			System.out.println("4  - Display Videos By Rating");
			System.out.println("5  - Add Client");
			System.out.println("6  - Remove Client");
			System.out.println("7  - Display Client Rent History");
			System.out.println("8  - Checkin");
			System.out.println("9  - CheckOut");
			System.out.println("10 - Exit");
			System.out.print("Option -> ");			
			option = sc.nextInt();
			sc.nextLine();			
			
			switch(option) {
				case 1:
					vc.addVideo();
					break;
				case 2:
					vc.removeVideo();
					break;
				case 3:
					vc.displayVideos();
					break;
				case 4:
					vc.displaySortedVideos();
					break;
				case 5:
					addClient(vc);					
					break;
				case 6:
					vc.removeClient();
					break;
				case 7:
					vc.displayClientHistory();
					break;
				case 8:
					vc.checkIn();
					break;					
				case 9:
					vc.checkOut();
					break;
				case 10:
					System.exit(0);
					break;				
				default:
					break;
			}
			
		}while(option != 10);
		sc.close();

	}
	
	public static void addClient(VideoClub vc) {
		System.out.print("Student(1) or Worker(2) ? ");
		int x = sc.nextInt();
		switch(x) {
			case 1:
				vc.addStudent();
				break;
			case 2:
				vc.addWorker();
		}		
	}

}
