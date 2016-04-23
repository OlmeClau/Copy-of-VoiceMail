
public class ConnectedState implements ConnectionState {

	/**
	      Try to connect the user with the specified mailbox.
	      @param key the phone key pressed by the user
	 * @param connection TODO
	   */
	   public void dial(String key, Connection connection)
	   {
	      if (key.equals("#"))
	      {
	         connection.currentMailbox = connection.system.findMailbox(connection.accumulatedKeys);
	         if (connection.currentMailbox != null)
	         {
	            connection.state = Connection.RECORDING;
	            //phone.speak(currentMailbox.getGreeting());
	            connection.speakToAllUIs(connection.currentMailbox.getGreeting());
	            
	         }
	         else
	            //phone.speak("Incorrect mailbox number. Try again!");
	        	 connection.speakToAllUIs("Incorrect mailbox number. Try again!");
	         connection.accumulatedKeys = "";
	      }
	      else
	         connection.accumulatedKeys += key;
	   }

}
