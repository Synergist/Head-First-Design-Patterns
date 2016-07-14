package headfirst.designpatterns.strategy.AdventureGame;

/**
 * Created by psingh on 7/13/16.
 */
public class Troll extends Character {
  public Troll() {
    weapon = new ClubBehavior();
  }

  @Override
  void display() {
    System.out.print("Troll: ");
  }
}
