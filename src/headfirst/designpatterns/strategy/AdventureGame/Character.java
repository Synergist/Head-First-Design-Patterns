package headfirst.designpatterns.strategy.AdventureGame;

/**
 * Created by psingh on 7/13/16.
 */
public abstract class Character {
  WeaponBehavior weapon;

  public Character() {}

  abstract void display();
  public void fight() { display(); weapon.useWeapon(); }
  public void setWeapon(WeaponBehavior w) { this.weapon = w; }
}
