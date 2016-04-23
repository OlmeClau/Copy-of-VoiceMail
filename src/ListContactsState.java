import java.util.ArrayList;
import java.util.List;

public class ListContactsState implements ConnectionState {
	List<Contact> contacts= new ArrayList<Contact>();;
	 public void dial(String key, Connection connection)
	   {
		 if (key.equals("1"))
	      {
	         connection.state = Connection.CONTACTS;
	         connection.speakToAllUIs(Connection.CONTACTS_MENU_TEXT);
	         //phone.speak(MESSAGE_MENU_TEXT);
	      }
		 
		 //Contact new_one = new Contact(name, number);
		 //contacts.add(new_one);
	      
	   }
	 
}
