import java.util.ArrayList;
import java.util.List;
/**Connects a phone to the mail system. The purpose of this
   class is to keep track of the state of a connection, since
   the phone itself is just a source of individual key presses.
*/
public class Connection
{
	   MailSystem system;
	   Mailbox currentMailbox;
	   String currentRecording;
	   String accumulatedKeys;
	   //private UserInterface phone;
	   int state;
	   List<UserInterface> uis= new ArrayList<UserInterface>();;
	   private String globalMessage;

	   private static final int CONNECTED = 1;
	   static final int RECORDING = 2;
	   static final int MAILBOX_MENU = 3;
	   static final int MESSAGE_MENU = 4;
	   static final int CHANGE_PASSCODE = 5;
	   static final int CHANGE_GREETING = 6;

	   private static final String INITIAL_PROMPT = 
	         "Enter mailbox number followed by #";      
	   static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting";
	   static final String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";

   /**
      Construct a Connection object.
      @param s a MailSystem object
      @param p a Telephone object
   */
   public Connection(MailSystem s)
   {
      system = s;
   }
   
   public void addUI(UserInterface ui){
	   uis.add(ui);	 
	   resetConnection(); 
   }

   /**
      Respond to the user's pressing a key on the phone touchpad
      @param key the phone key pressed by the user
   */
   public void dial(String key)
   {
	   ConnectionState currentState= null;
      if (state == CONNECTED)
        currentState= new ConnectedState();
      
      else if (state == RECORDING)
    	  currentState= new RecordingState();
      else if (state == CHANGE_PASSCODE)
    	  currentState= new ChangePasscodeState();
      else if (state == CHANGE_GREETING)
    	  currentState= new ChangeGreetingState();
      else if (state == MAILBOX_MENU)
    	  currentState=new MailBoxState();
      else if (state == MESSAGE_MENU)
    	  currentState=new MessageMenuState();
      
      currentState.dial(key, this);
   }

   /**
      Record voice.
      @param voice voice spoken by the user
   */
   public void record(String voice)
   {
      if (state == RECORDING || state == CHANGE_GREETING)
         currentRecording += voice;
   }

   /**
      The user hangs up the phone.
   */
   public void hangup()
   {
      if (state == RECORDING)
         currentMailbox.addMessage(new Message(currentRecording));
      	resetConnection();
   }
   
   public boolean isConnected() {
	    return state == CONNECTED;
	 }

	 public boolean isRecording() {
	    return state == RECORDING;
	 }

	 public boolean isInMailBoxMenu() {
	    return state == MAILBOX_MENU;
	 }

	 public boolean isInMessageMenu() {
	    return state == MESSAGE_MENU;
	 }

	 public boolean isInChangePassword() {
	    return state == CHANGE_PASSCODE;
	 }

	 public boolean isInChangeGreeting() {
	    return state == CHANGE_GREETING;
	 }

   /**
      Reset the connection to the initial state and prompt
      for mailbox number
   */
   private void resetConnection(){
      currentRecording = "";
      accumulatedKeys = "";
      state = CONNECTED;
      speakToAllUIs(INITIAL_PROMPT);
//      phone.speak(INITIAL_PROMPT);
   }
   
   void speakToAllUIs(String output) {
	   	for(UserInterface ui : uis) {
	   		ui.speak(output);
	   	}
   }


}











