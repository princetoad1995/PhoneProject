import java.util.Scanner;

public class ManagePhoneBook {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String name = null;
		String phone = null;
		PhoneBook phoneBook = new PhoneBook();
		
		do{
			System.out.println("Nhap cac lua chon: ");
			System.out.println("1. Insert Phone");
			System.out.println("2. Remove Phone");
			System.out.println("3. Update Phone");
			System.out.println("4. Search Phone");
			System.out.println("5. Sort");
			System.out.println("6. Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Nhap ten: ");
				name = sc.nextLine();
				System.out.println("Nhap sdt: ");
				phone = sc.nextLine();
				phoneBook.insertPhone(name, phone);
				phoneBook.showListPhone();
				break;
			case 2:
				System.out.println("Nhap ten: ");
				name = sc.nextLine();
				phoneBook.removePhone(name);
				phoneBook.showListPhone();
				break;
			case 3:
				System.out.println("Nhap ten: ");
				name = sc.nextLine();
				System.out.println("Nhap sdt moi: ");
				phone = sc.nextLine();
				phoneBook.updatePhone(name, phone);
				phoneBook.showListPhone();
				break;
			case 4:
				System.out.println("Nhap ten: ");
				name = sc.nextLine();
				phoneBook.searchPhone(name);
				break;
			case 5:
				System.out.println("Sap xep ten theo bang chu cai: ");
				phoneBook.sort();
				phoneBook.showListPhone();
				break;
			case 6:
				break;
			default:
				break;
			}
		}while(choice != 6);
	}
	
	
}
