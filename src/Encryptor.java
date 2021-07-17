import java.util.*;

public class Encryptor {
	private Scanner scanner;
	//private Random random;
	private ArrayList<Character> list, shuffledList;
	private char character;
	//private String line;
	private char[] letters;// secretLetters;
	
	Encryptor(){
		scanner = new Scanner(System.in);
		//random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		
		newKey();
		askQuestion();
	}
	private void askQuestion() {
		while(true) {
			System.out.println("***********************************");
			System.out.println("Choose what you want to do: ");
			System.out.println("(N) -> New Key");
			System.out.println("(S) -> Show Current Key");
			System.out.println("(E) -> Encrypt");
			System.out.println("(D) -> Decrypt");
			System.out.println("(Q) -> Quit");
			System.out.println("So, you want to: ");
			char choice = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(choice) {
				case 'N':
					newKey();
					break;
				case 'S':
					showCurrentKey();
					break;
				case 'E':
					encrypt();
					break;
				case 'D':
					decrypt();
					break;
				case 'Q':
					quit();
					break;
				default:
					System.out.println("You have inserted a wrong input, :(");
			}
			}
		
	}
	
	private void newKey() {
		character = ' ';
		list.clear();
		//shuffledList.clear();
		
		for(int i = 23;i <= 126;i++) {
			list.add(character++);
		}
		
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("New Key is Generated Successfully!!!");
	}
	private void showCurrentKey() {
		System.out.println("Current Key: ");
		for(Character c : list) {
			System.out.print(c);
		}
		System.out.println();
		for(Character c : shuffledList) {
			System.out.print(c);
		}
		System.out.println();
	}
	private void encrypt() {
		System.out.println("Enter the message you want to encrypt: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i = 0;i < letters.length;i++) {
			for(int j = 0;j < list.size();j++) {
				if(letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		
		System.out.println("You message is encrypted successfully...");
		for(Character c : letters) {
			System.out.print(c);
		}
		System.out.println();
		
	}
	private void decrypt() {
		System.out.println("Enter the message you want to decrypt: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i = 0;i < letters.length;i++) {
			for(int j = 0;j < shuffledList.size();j++) {
				if(letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		
		System.out.println("You message is decrypted successfully...");
		for(Character c : letters) {
			System.out.print(c);
		}
		System.out.println();
		
	}
	
	private void quit() {
		System.out.println("Good Bye :)");
		System.exit(0);
	}
	
	
}
