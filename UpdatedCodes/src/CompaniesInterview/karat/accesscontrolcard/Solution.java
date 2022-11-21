package CompaniesInterview.karat.accesscontrolcard;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        var a1 = Arrays.asList("Martha", "exit");
        var a2 = Arrays.asList("Paul", "enter");
        var a3 = Arrays.asList("Martha", "enter");
        var a4 = Arrays.asList("Martha", "exit");
        var a5 = Arrays.asList("Jennifer", "enter");
        var a6 = Arrays.asList("Paul", "enter");
        var a7 = Arrays.asList("Curtis", "enter");
        var a8 = Arrays.asList("Paul", "exit");
        var a9 = Arrays.asList("Martha", "enter");
        var a10 = Arrays.asList("Martha", "exit");
        var a11 = Arrays.asList("Jennifer", "exit");
        var input = new ArrayList<List<String>>();
        input.add(a1);
        input.add(a2);
        input.add(a3);
        input.add(a4);
        input.add(a5);
        input.add(a6);
        input.add(a7);
        input.add(a8);
        input.add(a9);
        input.add(a10);
        input.add(a11);
        var a = findBadges(input);
        System.out.println("Enter WithoutBadge first!");
        for(var ai : a) {
            for (var element : ai) {
                System.out.println(element);
            }
            System.out.println("======");
        }


    }

    // Given a list of people who enter and exit, find the people who entered without
    // their badge and who exited without their badge.
    //
    // Input: List of people who entered and exited
    // Output: List of people who entered without their badge and who exited without
    // their badge
    //
    // Example:
    // badge_records = [
    //   ["Martha",   "exit"],
    //   ["Paul",     "enter"],
    //   ["Martha",   "enter"],
    //   ["Martha",   "exit"],
    //   ["Jennifer", "enter"],
    //   ["Paul",     "enter"],
    //   ["Curtis",   "enter"],
    //   ["Paul",     "exit"],
    //   ["Martha",   "enter"],
    //   ["Martha",   "exit"],
    //   ["Jennifer", "exit"],
    // ]

    // Expected output: ["Paul", "Curtis"], ["Martha"]
    public static ArrayList<List<String>> findBadges(List<List<String>> badge_records) {
        var result1 = new ArrayList<String>();
        var result2 = new ArrayList<String>();
        // if number of entered == number of exit ==> correct else not correct
        var nameToNumberOfEnteredMinusExit = new HashMap<String, Integer>();
        for(var record : badge_records) {
            var name = record.get(0);
            var action = record.get(1);
            if (Objects.equals(action, "enter")) {
                if (nameToNumberOfEnteredMinusExit.containsKey(name)) {
                    nameToNumberOfEnteredMinusExit.put(name, nameToNumberOfEnteredMinusExit.get(name) + 1);
                } else {
                    nameToNumberOfEnteredMinusExit.put(name, 1);
                }
            } else {
                if (nameToNumberOfEnteredMinusExit.containsKey(name)) {
                    nameToNumberOfEnteredMinusExit.put(name, nameToNumberOfEnteredMinusExit.get(name) - 1);
                } else {
                    nameToNumberOfEnteredMinusExit.put(name, -1);
                }
            }
        }

        for (var name : nameToNumberOfEnteredMinusExit.keySet()) {
            var action = nameToNumberOfEnteredMinusExit.get(name);
            if (action > 0) {
                result1.add(name);
            } else if (action < 0) {
                result2.add(name);
            }
        }
        var result = new ArrayList<List<String>>();
        result.add(result1);
        result.add(result2);
        return result;
    }

//    给 list of [name, time], time is string format: '1300' //下午一点
//            return: list of names and the times where their swipe badges within one hour.
//            if there are multiple intervals that satisfy the condition, return any one of them.
//    name1: time1, time2, time3...
//    name2: time1, time2, time3, time4, time5...
//    example:
//    input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']]
//    output: {
//        'Martha': ['1600', '1620', '1530']
//    }
//    input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530'], ['Martha', '1531']]
//    output: {
//        'Martha': ['1600', '1620', '1530', '1531']
//    }
//    input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530'], ['Martha', '1531'], ['Martha', '1532']]
//    output: {
//        'Martha': ['1600', '1620', '1530', '1531', '1532']
//    }
//    input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530'], ['Martha', '1531'], ['Martha', '1532'], ['Martha', '1533']]
//    output: {
//        'Martha': ['1600', '1620', '1530', '1531', '1532', '1533']
//    }

    public static Map<String, List<String>> findSwipes(List<List<String>> swipes) {
        var result = new HashMap<String, List<String>>();
        var nameToTime = new HashMap<String, List<String>>();
        for(var swipe : swipes) {
            var name = swipe.get(0);
            var time = swipe.get(1);
            if (nameToTime.containsKey(name)) {
                nameToTime.get(name).add(time);
            } else {
                var timeList = new ArrayList<String>();
                timeList.add(time);
                nameToTime.put(name, timeList);
            }
        }
        for (var name : nameToTime.keySet()) {
            var timeList = nameToTime.get(name);
            Collections.sort(timeList);
            var timeListResult = new ArrayList<String>();
            for (int i = 0; i < timeList.size(); i++) {
                var time = timeList.get(i);
                if (i == 0) {
                    timeListResult.add(time);
                } else {
                    var previousTime = timeList.get(i - 1);
                    if (Integer.parseInt(time) - Integer.parseInt(previousTime) <= 100) {
                        timeListResult.add(time);
                    } else {
                        if (timeListResult.size() >= 3) {
                            result.put(name, timeListResult);
                        }
                        timeListResult = new ArrayList<String>();
                        timeListResult.add(time);
                    }
                }
            }
            if (timeListResult.size() >= 3) {
                result.put(name, timeListResult);
            }
        }
        return result;
    }
}
