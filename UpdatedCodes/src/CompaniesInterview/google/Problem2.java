package CompaniesInterview.google;


/**
 * Alice array
 * bai 2
 * long long solve(int N, vector<string> A) {
 *   map<char, long long> weight;
 *   map<char, bool> leading;
 *   for (string s : A) {
 *     long long mul = 1;
 *     for (int i = 0; i < s.size(); ++i) {
 *       char c = s[s.size() - 1 - i];
 *       if ('A' <= c && c <= 'Z') {
 *         weight[c] += mul;
 *         if (i + 1 == s.size()) {
 *           leading[c] = true;
 *         }
 *       }
 *       mul *= 10;
 *     }
 *   }
 *   vector<pair<long long, char>> sortedWeights;
 *   map<char, int> assignment;
 *   for (auto p : weight) {
 *     sortedWeights.push_back(make_pair(p.second, p.first));
 *   }
 *   sort(sortedWeights.rbegin(), sortedWeights.rend());
 *   for (auto p : sortedWeights) {
 *     char c = p.second;
 *     if (!leading[c]) {
 *       assignment[c] = 0;
 *       break;
 *     }
 *   }
 *   int i = 1;
 *   for (auto p : sortedWeights) {
 *     char c = p.second;
 *     if (assignment.count(c)) {
 *       continue;
 *     }
 *     assignment[c] = i++;
 *   }
 *   long long result = 0;
 *   for (string s : A) {
 *     long long mul = 1;
 *     for (int i = 0; i < s.size(); ++i) {
 *       char c = s[s.size() - 1 - i];
 *       if ('A' <= c && c <= 'Z') {
 *         c = '0' + assignment[c];
 *       }
 *       result += mul * (c - '0');
 *       mul *= 10;
 *     }
 *   }
 *   return result;
 * }
 */
public class Problem2 {
    public static void main(String[] args) {

    }

    private static void sayHello() {
        System.out.println("Hello World!!!");
    }
}
