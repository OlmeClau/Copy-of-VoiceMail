
public class ChangePasscodeState implements ConnectionState {

	/**
	      Change passcode.
	      @param key the phone key pressed by the user
	 * @param connection TODO
	   */
	   public void dial(String key, Connection connection)
	   {
	      if (key.equals("#"))
	      {
	         connection.currentMailbox.setPasscode(connection.accumulatedKeys);
	         connection.state = Connection.MAILBOX_MENU;
	         connection.speakToAllUIs(Connection.MAILBOX_MENU_TEXT);
	         //phone.speak(MAILBOX_MENU_TEXT);
	         connection.accumulatedKeys = "";
	      }
	      else
	         connection.accumulatedKeys += key;
	   }

}
