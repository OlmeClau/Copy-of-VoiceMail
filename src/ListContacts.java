import java.util.ArrayList;
import java.util.List;

public class ListContacts {
	List<Contact> contacts= new ArrayList<Contact>();;
	 public void add_contact(String name, int number)
	   {
		 Contact new_one = new Contact(name, number);
		 contacts.add(new_one);
	      
	   }
	 
}
