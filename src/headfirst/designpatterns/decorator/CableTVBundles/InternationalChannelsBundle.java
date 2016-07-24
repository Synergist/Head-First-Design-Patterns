package headfirst.designpatterns.decorator.CableTVBundles;

/**
 * Created by psingh on 7/16/16.
 */
public class InternationalChannelsBundle extends TVBundleDecorator {
  InternationalChannelsBundle(TV tv) { this(tv, TV.Resolution.SD); }
  InternationalChannelsBundle(TV tv, TV.Resolution res) {
    super(tv, "International Channels", res);
  }

  @Override
  public String getDescription() {
    return tv.getPkgDescription() + " - " + getBundlesDescription();
  }

  @Override
  public double bundleMonthlyRate() { return 10; }
}
