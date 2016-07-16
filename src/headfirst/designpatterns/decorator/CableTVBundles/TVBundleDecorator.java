package headfirst.designpatterns.decorator.CableTVBundles;

/**
 * Created by psingh on 7/16/16.
 */
public abstract class TVBundleDecorator extends TV {
  public TV tv;
  protected String bundleDescription;
  public abstract String getDescription();
  public abstract double bundleMonthlyRate();

  public TVBundleDecorator(TV tv, String bundleDescription, TV.Resolution res) {
    this.tv = tv;
    this.bundleDescription = bundleDescription;
    setResolution(res);
    addBundles(tv.getBundles());
    addBundle(bundleDescription, res);
  }

  @Override
  public String getPkgDescription() { return tv.getPkgDescription(); }

  @Override
  public void setResolution(Resolution res) {
    addBundle(bundleDescription, res);
    super.setResolution(res);
  }

//  @Override
//  protected double getRateMultiplier() {
//    return tv.getRateMultiplier();
//  }

  @Override
  public double monthlyRate() {
    return tv.monthlyRate() + bundleMonthlyRate() * getRateMultiplier();
  }
}
