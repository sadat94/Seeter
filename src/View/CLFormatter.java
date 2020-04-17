package View;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Message;

/**
 * A helper class for the current prototype {@link Client client}.  <i>E.g.</i>,
 * for formatting Command Line messages.
 */
public class CLFormatter {

  static ClientChannel chan;  // Client-side channel for talking to a Seeter server

  public CLFormatter(String host, int port) {
    this.chan = new ClientChannel(host, port);
  }

  /* Interact with Seeter server */

  private void send(Message msg) throws IOException {
    this.chan.send(msg);
  }

  private Message receive() throws IOException, ClassNotFoundException {
    return this.chan.receive();
  }

  /* Following are the auxiliary methods for formatting the UI text */
  
  
   public static String formatWelcome() {
        return "\nWelcome!\n"
                + "Please provide your userName";
    }

  static String formatSplash(String user) {
    return "\nHello " + user + "!\n"
        + "Note:  Commands can be abbreviated to any prefix, "
        + "e.g., fe [mytopic].\n";
  }

  public static String formatMainMenuPrompt() {
    return "\n[Main] Enter command: "
        + "fetch [mytopic], "
        + "compose [mytopic], "
        + "exit"
        + "\n> ";
  }

  public static String formatDraftingMenuPrompt(String topic,
      List<String> lines) {
    return "\nDrafting: " + formatDrafting(topic, lines)
        + "\n[Drafting] Enter command: "
        + "body [mytext], "
        + "send, "
        + "exit"
        + "\n> ";
  }

  public static String formatDrafting(String topic, List<String> lines) {
    StringBuilder b = new StringBuilder("#");
    b.append(topic);
    int i = 1;
    for (String x : lines) {
      b.append("\n");
      b.append(String.format("%12d", i++));
      b.append("  ");
      b.append(x);
    };
    return b.toString();
  }

  public static String formatFetched(String topic, List<String> users,
      List<String> fetched) {
    StringBuilder b = new StringBuilder("Fetched: #");
    b.append(topic);
    Iterator<String> it = fetched.iterator();
    for (String user : users) {
      b.append("\n");
      b.append(String.format("%12s", user));
      b.append("  ");
      b.append(it.next());
    };
    b.append("\n");
    return b.toString();
  }

    public static ClientChannel getChan() {
        return chan;
    }
  
  
}
