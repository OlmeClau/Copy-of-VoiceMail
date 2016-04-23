
public class RecordingState implements ConnectionState{

	/**
	      Try to log in the user.
	      @param key the phone key pressed by the user
	 * @param connection TODO
	   */
	   public void dial(String key, Connection connection)
	   {
	      if (key.equals("#"))
	      {
	         if (connection.currentMailbox.checkPasscode(connection.accumulatedKeys))
	         {
	            connection.state = Connection.MAILBOX_MENU;
	            connection.speakToAllUIs(Connection.MAILBOX_MENU_TEXT);
	            //phone.speak(MAILBOX_MENU_TEXT);
	         }
	         else
	            //phone.speak("Incorrect passcode. Try again!");
	        	 connection.speakToAllUIs("Incorrect passcode. Try again!");
	         connection.accumulatedKeys = "";
	      }
	      else
	         connection.accumulatedKeys += key;
	   }

}
