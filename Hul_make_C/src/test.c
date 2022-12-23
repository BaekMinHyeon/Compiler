#include <stdio.h>
int main() {
	int _hul;

	int max0 = 1;
	int max1 = 2;
	int max2 = 3;
	for (int i0 = 0; i0 < max0; i0++){
		printf("input: ");
		scanf("%d", &_hul);
		for (int i1 = 0; i1 < max1; i1++){
			_hul++;
			for (int i2 = 0; i2 < max2; i2++){
				_hul--;
			}
		}
		printf("%d", _hul);
	}
	int max0 = 1;
	int max1 = 3;
	for (int i0 = 0; i0 < max0; i0++){
		printf("input: ");
		scanf("%d", &_hul);
		printf("input: ");
		scanf("%d", &_hul);
		for (int i1 = 0; i1 < max1; i1++){
			_hul++;
			_hul--;
		}
	}
	return 0;
}