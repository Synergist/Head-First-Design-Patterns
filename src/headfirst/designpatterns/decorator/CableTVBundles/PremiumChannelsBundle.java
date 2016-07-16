package headfirst.designpatterns.decorator.CableTVBundles;

/**
 * Created by psingh on 7/16/16.
 */
public class PremiumChannelsBundle extends TVBundleDecorator {
  PremiumChannelsBundle(TV tv) { this(tv, TV.Resolution.SD); }
  PremiumChannelsBundle(TV tv, TV.Resolution res) {
    super(tv, "Premium Channels", res);
  }

  @Override
  public String getDescription() {
    return tv.getPkgDescription() + " - " + getBundlesDescription();
  }

  @Override
  public double bundleMonthlyRate() { return 10; }
}
