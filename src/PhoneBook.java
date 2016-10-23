import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PhoneBook extends Phone {

	List<NamePhone> phoneList = new ArrayList<>();
	NamePhone namePhone = null;

	@Override
	void insertPhone(String name, String phone) {
		int kt1 = 0, kt2 = 0;
		for (Iterator<NamePhone> list = phoneList.iterator(); list.hasNext();) {
			NamePhone namePhone = list.next();
			if (namePhone.getName().equals(name)) {
				String[] listPhoneNumber = namePhone.getNumber().split("\\s:\\s");  // cat chuoi trong so dien thoai
				for(String s : listPhoneNumber){
					if(s.equals(phone)){
						kt1 = 1;
						break;
					}
				}
				kt2 = 1;
			}
			
		}

		if(kt1 == 1 && kt2 == 1)
			System.out.println("Nhap ten va sdt bi trung!");
		else if (kt1 == 0 && kt2 == 0) {
			this.namePhone = new NamePhone(name, phone);
			phoneList.add(namePhone);
		}
		else if(kt2 == 1 && kt1 == 0){
			namePhone.setNumber(namePhone.getNumber() + " : " + phone);
		}
	}

	@Override
	void removePhone(String name) {
		for (Iterator<NamePhone> list = phoneList.iterator(); list.hasNext();) {
			NamePhone namePhone = list.next();
			if (namePhone.getName().equals(name))
				list.remove();
		}

	}

	@Override
	void updatePhone(String name, String newphone) {
		for (Iterator<NamePhone> list = phoneList.iterator(); list.hasNext();) {
			NamePhone namePhone = list.next();
			if (namePhone.getName().equals(name))
				namePhone.setNumber(newphone);
		}
	}

	@Override
	void searchPhone(String name) {
		for (Iterator<NamePhone> list = phoneList.iterator(); list.hasNext();) {
			NamePhone namePhone = list.next();
			if (namePhone.getName().equals(name))
				System.out.println("Name : " + namePhone.getName() + ", Phone: " + namePhone.getNumber());
		}
	}

	@Override
	void sort() {
		Collections.sort(phoneList, new Comparator<NamePhone>() {  // so sanh trong arraylist

			@Override
			public int compare(NamePhone o1, NamePhone o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});

	}

	void showListPhone() {
		for (NamePhone namePhone : phoneList) {
			System.out.println("Name : " + namePhone.getName() + ", Phone: " + namePhone.getNumber());
		}
	}

}
