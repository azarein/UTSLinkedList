import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * M. Yamin
 * NIM 20200040077
 * Teknik Informatika 20E
 */


public class JavaLinkedList {
	
	private static LinkedList<String> dataStorage = new LinkedList<String>();
	
	private static Scanner extracted() {
		return new Scanner(System.in);
	}
	
	private static void displayData(){
		System.out.println("\nData dalam List: " + dataStorage);
		System.out.println("Total Data     : " + dataStorage.size());
	}
	
	private static void addData() {
		System.out.print("Masukkan Data: ");
		String tempData = extracted().nextLine();
		dataStorage.add(tempData);
		displayData();
	}
	
	private static void addDataToFirst() {
		System.out.print("Masukkan Data: ");
		String tempData = extracted().nextLine();
		dataStorage.addFirst(tempData);
		displayData();
	}
	
	private static void addDataToLast() {
		System.out.print("Masukkan Data: ");
		String tempData = extracted().nextLine();
		dataStorage.addLast(tempData);
		displayData();
	}
	
	private static void addDataAtLocation() {
		boolean status = true;
		int indexData = 0;
		displayData();
		while(status) {
			System.out.print("Pilih Index Data yang ingin disisipi data: [0-" + (dataStorage.size() - 1) + "]: ");
			try {
				status = false;
				indexData = extracted().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Data harus berupa Angka!");
				status = true;
			}
		}
		System.out.print("Data yang ingin disisipkan pada index data ke- " + indexData + ": ");
		String tempData = extracted().nextLine();
		dataStorage.add(indexData, tempData);
		displayData();
	}
	
	private static boolean searchData(String data) {
		return dataStorage.contains(data);
	}
	
	private static void removeData() {
		boolean status = true;
		int indexData = 0;
		displayData();
		while(status) {
			System.out.print("Pilih Index Data yang ingin dihapus: [0-" + (dataStorage.size() - 1) + "]: ");
			try {
				status = false;
				indexData = extracted().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Data harus berupa Angka!");
				status = true;
			}
		}
		dataStorage.remove(indexData);
		displayData();
	}
	
	private static void removeDataAtFirst() {
		dataStorage.removeFirst();
		displayData();
	}
	
	private static void removeDataAtLast() {
		dataStorage.removeLast();
		displayData();
	}
	
	private static void removeDataByContent() {
		displayData();
		System.out.print("Masukkan Data yang ingin dihapus: ");
		String data = extracted().nextLine();
		if(searchData(data)) {
			dataStorage.remove(data);
		}
		else {
			System.out.println("Anda memasukkan data yang tidak tersimpan di dalam list");
		}
		displayData();
	}
	
	private static void programExit() {
		System.exit(0);
	}
	
	private static void programTitle() {
		System.out.println("\nTugas UTS Linked List Java"
				         + "\nDitulis oleh M. Yamin"
				         + "\nNIM : 20200040077"
				         + "\nTeknik Informatika 20E Universitas Nusa Putra\n");
	}
	
	private static void programSwitcher() {
		boolean status = true;
		int indexMenu = 0;
		while(status) {
			try {
				status = false;
				System.out.print("Pilih Menu [1~9]: ");
				indexMenu = extracted().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Masukan harus berupa Angka!");
				status = true;
			}
		}
		
		switch(indexMenu) {
			case 1: addData(); break;
			case 2: addDataToFirst(); break;
			case 3: addDataToLast(); break;
			case 4: addDataAtLocation(); break;
			case 5: removeData(); break;
			case 6: removeDataAtFirst(); break;
			case 7: removeDataAtLast(); break;
			case 8: removeDataByContent(); break;
			case 9: programTitle(); break;
			case 10: programExit(); break;
		}
		programMenu();
	}
	
	private static void programMenu() {
		System.out.println("\n.: PROGRAM MENU :."
				         + "\n 1. Tambahkan Data"
				         + "\n 2. Tambahkan Data di Awal"
				         + "\n 3. Tambahkan Data di Akhir"
				         + "\n 4. Tambahkan Data di N Indeks"
				         + "\n 5. Hilangkan Data di N Indeks"
				         + "\n 6. Hilangkan Data di Awal"
				         + "\n 7. Hilangkan Data di Akhir"
				         + "\n 8. Hilangkan Data dengan Data Content"
				         + "\n 9. Tentang Program"
				         + "\n10. Keluar Program");
		programSwitcher();
	}
	
	public static void main(String[] args) {
		programTitle();
		programMenu();
	}
}