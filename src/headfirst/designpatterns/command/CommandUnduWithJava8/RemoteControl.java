package headfirst.designpatterns.command.CommandUnduWithJava8;

import java.util.concurrent.Callable;

/**
 * Created by psingh on 7/23/16.
 */

// This is the Invoker in the Command Pattern class diagram
public class RemoteControl {
  private static final int NUM_COMMANDS = 7;
  private Command[] offCommands;
  private Command[] onCommands;
  private Callable<Boolean> undoCommand;

  RemoteControl() {
    onCommands = new Command[NUM_COMMANDS];
    offCommands = new Command[NUM_COMMANDS];

    Command noCommand = new Command() {
      @Override
      public void execute() {}

      @Override
      public Boolean undo() { return true; }
    };
    for (int i = 0; i < NUM_COMMANDS; ++i) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
  }

  public void setCommands(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  void onButtonPushed(int slot) { undoCommand = () -> onCommands[slot].undo(); onCommands[slot].execute(); }
  void offButtonPushed(int slot) { undoCommand = () -> offCommands[slot].undo(); offCommands[slot].execute(); }

  void undoButtonPushed() {
    try {
      undoCommand.call();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("\n----- Remote Control -----");
    for(int i = 0; i < NUM_COMMANDS; ++i) {
      sb.append("[slot ").append(i).append("] ")
              .append(onCommands[i].getClass().getName()).append("@").append(onCommands[i].toString())
              .append("\t")
              .append(offCommands[i].getClass().getName()).append("@").append(offCommands[i].toString())
              .append("\n");
    }
    return sb.toString();
  }
}
