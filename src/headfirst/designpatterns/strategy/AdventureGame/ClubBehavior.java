package headfirst.designpatterns.strategy.AdventureGame;

/**
 * Created by psingh on 7/13/16.
 */
public class ClubBehavior implements WeaponBehavior {
  @Override
  public void useWeapon() {
    System.out.println("smashes a club.");
  }
}
