package headfirst.designpatterns.decorator.CableTVBundles;

/**
 * Created by psingh on 7/16/16.
 */
public class TVCompanySimulator {
  public static void main(String args[]) {
    TV localTV = new LocalTV(TV.Resolution.UHD);
    TV cableTV = new CableTV(TV.Resolution.HD);
    TV cableTVInternational = new InternationalChannelsBundle(cableTV, TV.Resolution.HD);

    System.out.println(localTV);
    System.out.println(cableTV);
    System.out.println(cableTVInternational);

    TV cableTVInterPremium = new PremiumChannelsBundle(cableTVInternational, TV.Resolution.HD);
    System.out.println(cableTVInterPremium);
    cableTVInterPremium.setResolution(TV.Resolution.UHD);
    System.out.println(cableTVInterPremium);
  }
}
