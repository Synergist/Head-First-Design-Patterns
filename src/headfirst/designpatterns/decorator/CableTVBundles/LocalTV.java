package headfirst.designpatterns.decorator.CableTVBundles;

/**
 * Created by psingh on 7/16/16.
 */
class LocalTV extends TV {
  LocalTV() {
    this(Resolution.SD);
  }
  LocalTV(Resolution res) {
    setResolution(res);
    setPkgDescription("Local TV");
    numChannels = 20;
  }

  @Override
  protected double baseRateMonthly() {
    return 24.99;
  }

}
