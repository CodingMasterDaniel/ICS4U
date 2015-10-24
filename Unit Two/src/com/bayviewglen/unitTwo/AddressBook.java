package com.bayviewglen.unitTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	
	private static ArrayList<Contact> addressBook = new ArrayList<Contact>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		Scanner load1 = new Scanner(new File("input/AddressBooks/AddressBook1"));
		Scanner load2 = new Scanner(new File("input/AddressBooks/AddressBook2"));
		
		
		
		System.out.println("Please choose which address book to load: 1.\t 2.");
		Boolean validInput = false;
		while (!validInput) {
			String x = input.nextLine();
			if (x.equals("1")) {
				while (load1.hasNextLine()) {
					String y = load1.nextLine();
					String ln = y.substring(0, y.indexOf(" "));
					String fn = y.substring(y.indexOf(" ") + 1, y.indexOf(","));
					String phoneNumber = y.substring(y.indexOf(",") + 1);
					addContact(ln, fn, phoneNumber);
				}
				System.out.println("Address Book #1 loaded.");
				validInput = true;
			}else if (x.equals("2")) {
				while (load2.hasNextLine()) {
					String y = load2.nextLine();
					String ln = y.substring(0, y.indexOf(" "));
					String fn = y.substring(y.indexOf(" ") + 1, y.indexOf(","));
					String phoneNumber = y.substring(y.indexOf(",") + 1);
					addContact(ln, fn, phoneNumber);
				}
				System.out.println("Address Book #2 loaded.");
				validInput = true;
			}else{
				System.out.println("Please enter a correct address book number.");
			}
		}
		
		
		boolean done = false;
		while (!done) {
			
			System.out.println("What would you like to do?");
			System.out.println("1. Search");
			System.out.println("2. Add");
			System.out.println("3. Delete");
			System.out.println("4. Display");
			System.out.println("5. Quit");
			
			String x = input.nextLine();
			
			if (x.equals("4") || x.equals("Quit")) {
				done = true;
			} else if (x.equals("1") || x.equals("Search")) {
				System.out.println("Search generally (1) or search specifically (2)?");
				String next = input.nextLine();
				if (next.equals("Search generally") || next.equals("1")) {
					System.out.print("Input keyword: ");
					String a = input.nextLine();
					search(a);
				}else if (next.equals("Search specifically") || next.equals("2")) {
					System.out.print("Last name? ");
					String a = input.nextLine();
					System.out.print("First name?");
					String b = input.nextLine();
					System.out.print("Phone number?");
					String c = input.nextLine();
					
					searchSpecific(a, b, c);
				}else{
					System.out.println("Wrong action input.");
				}				
			} else if (x.equals("2") || x.equals("Add")) {
				System.out.print("Last name? ");
				String a = input.nextLine();
				System.out.print("First name?");
				String b = input.nextLine();
				System.out.print("Phone number?");
				String c = input.nextLine();
				
				addContact(a, b, c);
			} else if (x.equals("3") || x.equals("Delete")) {
				System.out.print("Last name? ");
				String a = input.nextLine();
				System.out.print("First name?");
				String b = input.nextLine();
				System.out.print("Phone number?");
				String c = input.nextLine();
				
				delete(a, b, c);
			} else if (x.equals("4") || x.equals("Display")) {
				displayContact();
			} else {
				System.out.println("Wrong action input.");
			}
		}
		
		input.close();
		load1.close();
		load2.close();
		
	}
	
	private static void addContact(String x, String y, String z) {
		addressBook.add(new Contact(x, y, z));
		System.out.println("That contact is added.");
	}
	
	private static void displayContact() {
		if (addressBook.isEmpty()) {
			System.out.println("This address book is empty.");
		}else{
			for (int i = 0; i < addressBook.size(); i++) {
				Contact temp = addressBook.get(i);
				System.out.println(temp.getLname() + " " + temp.getFname() + " " + temp.getPhone());
			}
		}
	}
	
	private static void search(String x) {
		int y = 0;
		for (int i = 0; i < addressBook.size(); i++) {
			Contact temp = addressBook.get(i);
			if (temp.getLname().equals(x)) {
				System.out.println(temp.getLname() + " " + temp.getFname() + " " + temp.getPhone());
				y++;
			}else if (temp.getFname().equals(x)) {
				System.out.println(temp.getLname() + " " + temp.getFname() + " " + temp.getPhone());
				y++;
			}else if (temp.getPhone().equals(x)) {
				System.out.println(temp.getLname() + " " + temp.getFname() + " " + temp.getPhone());
				y++;
			}
		}
		
		if (y == 0)
			System.out.println("No such contact found.");
	}
	
	private static Contact searchSpecific(String x, String y, String z) {
		for (int i = 0; i < addressBook.size(); i++) {
			Contact temp = addressBook.get(i);
			if (temp.getLname().equals(x) && temp.getFname().equals(y) && temp.getPhone().equals(z))
				return temp;
		}
		
		System.out.println("No such contact found.");
		return null;
	}
	
	private static void delete(String x, String y, String z) {
		int a = addressBook.size();
		for (int i = 0; i < addressBook.size(); i++) {
			Contact temp = addressBook.get(i);
			if (temp.getLname().equals(x) && temp.getFname().equals(y) && temp.getPhone().equals(z)) {
				addressBook.remove(i);
				System.out.println("That contact is deleted.");
				break;
			}
		}
		
		if (a == addressBook.size())
			System.out.println("No such contact found.");
	}

}
