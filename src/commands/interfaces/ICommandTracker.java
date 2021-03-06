package commands.interfaces;

/**
 * An Interface expressing the concept of a command tracker which 'tracks' 
 * a collection of commands and allows them to be undone or redone.
 * @author rtucker
 */
public interface ICommandTracker {
    
    /**
     * Executes the provided command and if it completes adds it to the collection
     * of executed commands being tracked
     * @param _command - Interface to the command object to execute
     * @return boolean True if command completed and was added to the 
     * collection of executed commands, False otherwise.
     * @throws Exception Something went wrong.
     */
    boolean executeCommand(ICommand _command) throws Exception;
    /**
     * This method reverses the last command added to the collection of executed commands.
     * Repeated calls to this method will provide an in order reversal of executed commands.
     * Undone commands will be added to their own collection
     * @return boolean True if a command was reversed, False otherwise.
     * @throws Exception Something went wrong.
     */
    boolean undoLastCommand() throws Exception;
    /**
     * This method executes the last command added to the collection of undone commands.
     * @return boolean True if a previously undone command was re-executed, False otherwise
     * @throws Exception Something went wrong.
     */
    boolean redoLastCommand() throws Exception;
}
