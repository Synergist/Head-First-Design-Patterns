package headfirst.designpatterns.command.CommandUnduWithJava8;

import headfirst.designpatterns.command.undo.Light;

/**
 * Created by psingh on 7/23/16.
 */
// This is the Client in the Command Pattern class diagram
public class RemoteLoader {

  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light bedRoomLight = new Light("Bed Room");

    Command bedRoomLightOn = new Command() {
      private int level;
      @Override
      public void execute() {
        level = bedRoomLight.getLevel();
        bedRoomLight.on();
      }

      @Override
      public Boolean undo() {
        bedRoomLight.dim(level);
        return true;
      }
    };
    Command bedRoomLightOff = new Command() {
      private int level;
      @Override
      public void execute() {
        level = bedRoomLight.getLevel();
        bedRoomLight.off();
      }

      @Override
      public Boolean undo() {
        bedRoomLight.dim(level);
        return true;
      }
    };

    remoteControl.setCommands(0, bedRoomLightOn, bedRoomLightOff);

    System.out.println(remoteControl);
    remoteControl.onButtonPushed(0);
    remoteControl.offButtonPushed(0);
    remoteControl.undoButtonPushed();
  }

}
