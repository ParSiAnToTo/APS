#include <iostream>
#include <string.h>
using namespace std;

void fn(int n) {
	if(n >= 2){
		int now = n;
		int prev = now -1;

		cout << "int ";
		for (size_t i = 0; i < now; i++) {
			cout << "*";
		}

		if(prev == 1){
			cout << "ptr" << now << " = &ptr" << ";" << endl;
		} else {
			cout << "ptr" << now << " = &ptr" << prev << ";" << endl;
		}

		
	} else {
		cout << "int a;" << endl;
		cout << "int *ptr = &a;" << endl;
	}
}

int main(void) {
	int N;	
	cin >> N;
	for (size_t i = 1; i <= N; i++)
	{
		fn(i);
	}

	return 0;
}