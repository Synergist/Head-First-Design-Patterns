package headfirst.designpatterns.strategy.AdventureGame;

/**
 * Created by psingh on 7/13/16.
 */
public class GameSimulator {

  public static void main(String[] args) {
    Knight knight = new Knight();
    Troll troll = new Troll();

    knight.fight();
    troll.fight();
    knight.setWeapon(new ClubBehavior());
    knight.fight();
  }
}
