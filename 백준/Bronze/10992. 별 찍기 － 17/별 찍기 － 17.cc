#include <iostream>
#include <string.h>
using namespace std;


int main(void) {
	int N, star;	
	cin >> N;
	for (star = 1; star <= N; star++)
	{
		if(star == 1){
			for (size_t i = 1; i < N; i++)
			{
				cout << " ";
			}
			cout << "*";			
		} else if (star < N) {
			for (size_t i = 0; i < N - star; i++)
			{
				cout << " ";
			}
			cout << "*";
			for (size_t i = 0; i < 2*(star - 1) - 1; i++)
			{
				cout << " ";
			}
			cout << "*";			
		} else {
			for (size_t i = 0; i < 2*star - 1; i++)
			{
				cout << "*";
			}			
		}
		cout << endl;
	}

	return 0;
}