#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool uniqueCharacters(string str) {
	for (int i = 0; i < str.length(); i++) {
		for (int j = i + 1; j  < str.length(); j ++) {
			if (str[i] == str[j]) {
				return false;
			}
		}
	}
	return true;
}

int main() {
	string ranStr;
	cout << "Please enter a random string: " << endl;
	cin >> ranStr;
	if (uniqueCharacters(ranStr)) {
		cout << "This string has all unique characters!" << endl;
	}
	else {
		cout << "This string doesn't have all unique characters!" << endl;
	}
	return 0;
}