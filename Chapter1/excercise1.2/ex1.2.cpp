#include <iostream>
#include <cstring>
using namespace std;

void swap(char *start, char *end) {
	char temp;
	temp = *start;
	*start = *end;
	*end = temp;
}

void reverse(char *s) {
	int n = strlen(s);
	for (int i=0; i < n/2; i++) {
		swap(s[i], s[n-i-1]);
	}
}

int main() {
	char s[] = "vuhuyhai  ";
	reverse(s);
	cout << s << endl;
	return 0;
}