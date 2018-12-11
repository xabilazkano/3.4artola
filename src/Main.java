import java.util.Scanner;



import com.zubiri.agenda.Contact;
import com.zubiri.agenda.Person;
import com.zubiri.agenda.Agenda;

public class Main {

	public static void main(String[] args) {
		Person pertsona = new Person("");
		Contact kontaktua = new Contact(pertsona,"","");
		Agenda agend=new Agenda();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("What do you want to do?");
			System.out.println("1.- Add a contact");
			System.out.println("2.- View a contact");
			System.out.println("3.- Delete a contact");
			System.out.println("4.- Modify a contact");
			System.out.println("0.- Quit");

			if (sc.hasNextInt()) {
				int option = sc.nextInt();
				if (option >= 0 && option < 5) {
					switch (option) {

					case 0:
						System.out.println("Bye!");
						flag = false;
						break;

					case 1:
						System.out.println("Enter the name of the contact:");
						String name = sc.next();
						System.out.println("Age:");
						int age = sc.nextInt();
						System.out.println("Weight:");
						int weight = sc.nextInt();
						System.out.println("Height:");
						int height =sc.nextInt();
						System.out.println("DNI:");
						String dni = sc.next();
						System.out.println("Telephone number");
						String phone = sc.next();
						System.out.println("Address");
						String address = sc.next();
						Person create = new Person(name, age, weight,height, dni);
						Contact sortu = new Contact(create, phone, address);
						agend.addContact(sortu);
						System.out.println("Succesfuly added.");

						break;

					case 2:
						System.out.println("Enter the name of the contact:");
						name = sc.next();
						if (agend.findContact(name)==-1) {
							System.out.println("Contact not found");
						}
						else {
							System.out.println(agend.getContact(agend.findContact(name)).contactToString());
						}
						

						break;

					case 3:
						System.out.println("Enter the name of the contact");
						name = sc.next();
						agend.deleteContact(agend.findContact(name));

						break;

					case 4:
						System.out.println("Enter the name of the contact");
						name = sc.next();
						System.out.println("New name:");
						String name2 = sc.next();
						System.out.println("New age:");
						 age = sc.nextInt();
						System.out.println("New weight:");
						 weight = sc.nextInt();
						System.out.println("New height:");
						 height =sc.nextInt();
						System.out.println("New DNI:");
						 dni = sc.next();
						System.out.println("New telephone number");
						 phone = sc.next();
						System.out.println("New address");
						 address = sc.next();
						Person person = new Person(name2, age, weight,height, dni);
						Contact contact = new Contact(person, phone, address);
					
						agend.modifyContact(contact,agend.findContact(name));
						break;

					}

				}

			} else {
				sc.next();
				System.out.println("Enter a valid number");
			}

		}
	}
}
