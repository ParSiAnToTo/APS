#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void) {
	int N;
	string nickname;

	cin  >> N;
	cin >> nickname;

	vector<char> list(N);

	for (int i = 0; i < N; i++)
	{
		if(islower(nickname[i])) {
			list[i] = toupper(nickname[i]);
		} else {
			list[i] = tolower(nickname[i]);
		}
	}

	for (size_t i = 0; i < list.size(); i++)
	{
		cout << list[i];
	}		

	return 0;
}