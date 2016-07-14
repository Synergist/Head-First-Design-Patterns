package headfirst.designpatterns.strategy.AdventureGame;

/**
 * Created by psingh on 7/13/16.
 */
public class Knight extends Character {
  public Knight() {
    weapon = new SwordBehavior();
  }

  void display() {
    System.out.print("Knight: ");
  }
}
