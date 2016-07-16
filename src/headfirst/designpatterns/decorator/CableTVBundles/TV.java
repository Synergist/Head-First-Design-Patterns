package headfirst.designpatterns.decorator.CableTVBundles;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by psingh on 7/15/16.
 */
public abstract class TV {
  enum Resolution { SD, HD, UHD };
  private Resolution resolution = Resolution.SD;
  int numChannels = 0;
  private String pkgDescription;
  private HashMap<String, TV.Resolution> bundles;

  protected TV() {
    bundles = new HashMap<>();
  }

  public String getPkgDescription() {
    return "Package: " + pkgDescription + " (" + resolution.toString() + ")";
  }
  public String getDescription() {
    StringBuilder sb = new StringBuilder();
    sb.append(getPkgDescription());
    if (bundles.size() > 0) {
      sb.append(" - " + getBundlesDescription());
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return this.getDescription() + " - $" + String.format("%.2f", this.monthlyRate()) + " monthly";
  }

  void setPkgDescription(String pkgDesc) {
    pkgDescription = pkgDesc;
  }

  HashMap<String, TV.Resolution> getBundles() {
    return bundles;
  }

  String getBundlesDescription() {
    return bundles.entrySet()
            .stream()
            .map(entry -> entry.getKey() + ": (" + entry.getValue().toString() + ")")
            .collect(Collectors.joining(", ", "[", "]"));
  }

  void addBundle(String bundle, TV.Resolution res) {
    bundles.put(bundle, res);
  }

  void addBundles(HashMap<String, Resolution> b) {
    bundles.putAll(b);
  }


  public void setResolution(Resolution res) { this.resolution = res; }
  public Resolution getPackage() { return this.resolution; }

  public int getNumChannels() { return this.numChannels; }

  double getRateMultiplier() {
    double rateMult;
    switch (this.resolution) {
      case HD: rateMult = 1.25; break;
      case UHD: rateMult = 1.5; break;
      default: rateMult = 1.0;
    }
    return rateMult;
  }

  public double monthlyRate() {
    return this.baseRateMonthly() * this.getRateMultiplier();
  }

  protected double baseRateMonthly() { return 0.0; }
}
