package headfirst.designpatterns.decorator.CableTVBundles;

/**
 * Created by psingh on 7/16/16.
 */
class CableTV extends TV {
  CableTV() {
    this(Resolution.SD);
  }
  CableTV(Resolution res) {
    setResolution(res);
    setPkgDescription("Cable TV");
    numChannels = 500;
  }

  @Override
  protected double baseRateMonthly() {
    return 39.99;
  }
}
