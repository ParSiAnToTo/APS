#include <iostream>
using namespace std;

int main(void) {
	int N;
	long long result = 1;

	cin >> N;

	if(N >= 1){
		for (size_t i = 1; i <= N; i++)
		{
			result *= i;
		}
		cout << result << endl;
	} else {
		cout << 1 << endl;
	}

	return 0;
}