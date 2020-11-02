package aula4.ex3;
import java.util.*;

import aula3.ex1.Date;

public class VideoClub {
	static Scanner sc = new Scanner(System.in);
	
	private LinkedList<Video> catalog;	
	private LinkedList<Client> clients;
	private int max;
	
	public VideoClub(int N) {
		this.catalog = new LinkedList<Video>();		
		this.clients = new LinkedList<Client>();		
		this.max = N;
	}
	
	public Video getVideo(int id) {
		for(int i = 0; i < this.catalog.size(); i++) {
			if(this.catalog.get(i).getId() == id)
				return this.catalog.get(i);
		}
		return null;	//video not found;
	}
	
	
	public void displayVideos() {
		for(int i = 0; i < this.catalog.size(); i++) {
			System.out.print(this.catalog.get(i).toString());
		}
	}
	
	public void displaySortedVideos() {		
		this.catalog.sort(Comparator.comparing(Video::getRating));
		for(int i = 0; i < this.catalog.size(); i++) {
			System.out.print(this.catalog.get(i).toString());
		}		
	}
	
	public void displayClientHistory() {
		
		System.out.print("Partner Number: ");
		int partner = Integer.parseInt(sc.nextLine());
		int index = getClientIndex(partner);
		if(index == -1) {
			System.out.print("This client is not in the list.\n");
		}		
		this.clients.get(index).showHistory();		
	}
	
	public void checkOut() {			
		
		System.out.print("Partner Number: ");
		int partner = Integer.parseInt(sc.nextLine());
		System.out.print("Video ID: ");
		int video_id = Integer.parseInt(sc.nextLine());
		Video v = getVideo(video_id);
		
		if(v != null) {
			if(this.clients.get(getClientIndex(partner)).getRentedList().size() >= this.max) {
				System.out.print("Client can't rent more books\n");
			}
			else {
				if(v.getStatus()) {
					this.clients.get(getClientIndex(partner)).getRentedList().add(v);
					this.clients.get(getClientIndex(partner)).getHistoryList().add(v);
					this.catalog.get(getVideoIndex(video_id)).setOwner(this.clients.get(getClientIndex(partner)).getPartnerNumber());
					
					System.out.print("Video Rented.\n");
				}
				else {
					System.out.print("Video Not Available.\n");
				}
			}
		}
		else {
			System.out.print("Video Not Found.\n");
		}		
	}
	
	public void checkIn() {		
		
		System.out.print("Partner Number: ");
		int partner = Integer.parseInt(sc.nextLine());
		System.out.print("Video ID: ");
		int video_id = Integer.parseInt(sc.nextLine());
		Video v = getVideo(video_id);
		
		if(v != null) {
			this.clients.get(getClientIndex(partner)).getRentedList().remove(getVideoIndex(video_id));
			this.catalog.get(getVideoIndex(video_id)).setStatus(true);
			System.out.print("Please rate the video between 1-10: ");
			int rating = Integer.parseInt(sc.nextLine());
			this.catalog.get(getVideoIndex(video_id)).addRating(rating);
			System.out.print("Checkin Complete.\n");
			
		}
		else {
			System.out.print("This Video does not belong to the catalog.\n");
		}
	}	
	
	public void addVideo() {		
		System.out.print("Video ID: ");
		int id = Integer.parseInt(sc.nextLine());		
		System.out.print("Video Title: ");
		String title = sc.nextLine();
		System.out.print("Video Category: ");
		String category = sc.nextLine();
		System.out.print("Video minimum Age: ");
		int mAge = Integer.parseInt(sc.nextLine());		
		if(getVideoIndex(id) != -1) {
			System.out.print("This is video is already in the catalog.\n");
		}
		else {
			Video v = new Video(id,title,category,mAge);
			this.catalog.add(v);
			System.out.print("Video added.\n");
		}		
	}
	
	public void removeVideo() {
		
		System.out.print("Video ID: ");
		int id = Integer.parseInt(sc.nextLine());
		
		if(getVideoIndex(id) == -1) {
			System.out.print("This Video is not in the catalog.\n");
		}
		else {
			this.catalog.remove(getVideoIndex(id));
			System.out.print("Video Removed.\n");
		}
	}
	
	public void addStudent() {		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("CC: ");
		int cc = Integer.parseInt(sc.nextLine());		
		System.out.print("Date of Birth: ");
		String birth = sc.nextLine();
		Date d1 = new Date(birth);
		System.out.print("Partner Numer: ");
		int num = sc.nextInt();
		sc.nextLine();		
		Date d2 = Date.today();
		System.out.print("Mec: ");
		int mec = sc.nextInt();
		sc.nextLine();
		System.out.print("Course: ");
		String course = sc.nextLine();
		
		if(getClientIndex(num) == -1) {
			Student s = new Student(name, cc, d1, num, d2, mec, course);
			this.clients.add(s);
			System.out.print("Student Added.\n");
		}
		else {			
			System.out.print("This person is already a partner.\n");
		}		
	}
	
	public void addWorker() {
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("CC: ");
		int cc = Integer.parseInt(sc.nextLine());
		
		System.out.print("Date of Birth: ");
		String birth = sc.nextLine();
		Date d1 = new Date(birth);
		System.out.print("Partner Numer: ");
		int num = sc.nextInt();
		sc.nextLine();		
		Date d2 = Date.today();
		System.out.print("Work ID: ");
		int work = Integer.parseInt(sc.nextLine());
		
		System.out.print("Fiscal ID: ");
		int fiscal = Integer.parseInt(sc.nextLine());
		
		if(getClientIndex(num) == -1) {
			Worker w = new Worker(name, cc, d1, num, d2, work, fiscal);
			this.clients.add(w);
			System.out.print("Worker Added.\n");
		}
		else {			
			System.out.print("This person is already a partner.\n");
		}		
	}
	
	public void removeClient() {
		
		System.out.print("Partner Numer: ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(getClientIndex(num) == -1) {
			System.out.print("This client is not in the list.\n");
		}
		else {
			this.clients.remove(getClientIndex(num));
			System.out.print("Client Removed.\n");
		}
	}	
	
	public int getVideoIndex(int id) {
		for(int i = 0; i < this.catalog.size(); i++) {
			if(this.catalog.get(i).getId() == id)
				return i;
		}
		return -1;	// not in the catalog
	}	
	public int getClientIndex(int id) {
		for(int i = 0; i < this.clients.size(); i++) {
			if(this.clients.get(i).getPartnerNumber() == id)
				return i;
		}
		return -1; // not in the list
	}	
	
}
