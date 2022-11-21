package CompaniesInterview.karat.adconversionrate;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String[] completed_purchase_user_ids = {"3123122444", "234111110", "8321125440", "99911063"};
        String[] adClicks = {"IP_Address,Time,Ad_Text", "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets", "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens", "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats", "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets", "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets", "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens"};
        String[] allUserIps = {"User_ID,IP_Address", "2339985511,122.121.0.155", "234111110,122.121.0.1", "3123122444,92.130.6.145", "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000", "8321125440,82.1.106.8", "99911063,92.130.6.144"};
        adConversionRate(adClicks, allUserIps, completed_purchase_user_ids);
    }

    public static void adConversionRate(String[] adClicks, String[] userIps, String[] userIds) {
        var boughtUserIdsSet = new HashSet<String>();
        for (var userId : userIds) {
            boughtUserIdsSet.add(userId);
        }

        var ipAddressToUserId = new HashMap<String, String>();
        for (int i = 1; i < userIps.length; i++) {
            var splitText = userIps[i].split(",");
            var ip = splitText[1];
            var id = splitText[0];
            if (ipAddressToUserId.containsKey(ip)) continue;
            ipAddressToUserId.put(ip, id);
        }

        var result = new HashMap<String, AdOutput>();
        for (int i = 1; i < adClicks.length; i++) {
            var splitText = adClicks[i].split(",");
            var clickedAdText = splitText[2];
            var currentClickedTime = 0;
            var currentIpClicked = splitText[0];
            if (!result.containsKey(clickedAdText)) {
                currentClickedTime = 1;
                var currentAdUserId = ipAddressToUserId.get(currentIpClicked);
                var boughtTime = 0;
                if (boughtUserIdsSet.contains(currentAdUserId)) {
                    boughtTime = 1;
                }
                var adOutput = new AdOutput(clickedAdText, boughtTime, currentClickedTime);
                result.put(clickedAdText, adOutput);
            } else {
                var updatedAd = result.get(clickedAdText);
                updatedAd.ClickedTimes += 1;
                var currentAdUserId = ipAddressToUserId.get(currentIpClicked);
                if (boughtUserIdsSet.contains(currentAdUserId)) {
                    updatedAd.BoughtTimes += 1;
                }

                result.put(clickedAdText, updatedAd);
            }
        }

        System.out.println("Bought,Clicked Ad Text");
        for (var ad : result.keySet()) {
            var currentAd = result.get(ad);
            var currentClickedTimes = currentAd.ClickedTimes;
            var currentBoughtTimes = currentAd.BoughtTimes;
            System.out.println(currentBoughtTimes + " of " + currentClickedTimes + "  " + ad);
        }
    }

    private static class AdOutput {
        public String ClickedAdText;
        public Integer BoughtTimes;
        public Integer ClickedTimes;

        public AdOutput(String clickedAdText, Integer boughtTimes, Integer clickedTimes) {
            ClickedAdText = clickedAdText;
            BoughtTimes = boughtTimes;
            ClickedTimes = clickedTimes;
        }
    }
}
