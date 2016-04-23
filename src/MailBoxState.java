
public class MailBoxState {

	/**
	      Respond to the user's selection from mailbox menu.
	      @param key the phone key pressed by the user
	 * @param connection TODO
	   */
	   void mailboxMenu(String key, Connection connection)
	   {
	      if (key.equals("1"))
	      {
	         connection.state = Connection.MESSAGE_MENU;
	         connection.speakToAllUIs(Connection.MESSAGE_MENU_TEXT);
	         //phone.speak(MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("2"))
	      {
	         connection.state = Connection.CHANGE_PASSCODE;
	         connection.speakToAllUIs("Enter new passcode followed by the # key");
	         //phone.speak("Enter new passcode followed by the # key");
	      }
	      else if (key.equals("3"))
	      {
	         connection.state = Connection.CHANGE_GREETING;
	         connection.speakToAllUIs("Record your greeting, then press the # key");
	         //phone.speak("Record your greeting, then press the # key");
	      }
	   }

}
