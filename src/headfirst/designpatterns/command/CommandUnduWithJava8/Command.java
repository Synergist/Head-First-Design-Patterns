package headfirst.designpatterns.command.CommandUnduWithJava8;

/**
 * Created by psingh on 7/23/16.
 */
public interface Command {

  void execute();
  Boolean undo();
}
