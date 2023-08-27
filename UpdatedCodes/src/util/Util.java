package util;

public class Util {
    public String compare(StringCompare stringCompare) {
        if (stringCompare == null) return null;

        if (stringCompare.first == null || stringCompare.second == null) {
            return stringCompare.second;
        }

        if (stringCompare.first.length() + stringCompare.second.length() > 10) {
            return null;
        } else {
            return stringCompare.second;
        }
    }
}
