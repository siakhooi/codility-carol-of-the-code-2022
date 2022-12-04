package nsh.codility;

public class CarolOfTheCode2022A implements CarolOfTheCode2022Interface {

	public int solution(String[] A) {
		int count[] = new int[4];
		char tile[] = new char[4];

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				tile = A[i].toCharArray();
				count[0] = 1;
				count[1] = 0;
				count[2] = 1;
				count[3] = 2;
			} else {
				char[] a = A[i].toCharArray();
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 4; k++) {
						if (tile[j] == a[k]) {
							if (k == 0) {
								tile[j] = a[2];
								count[j]++;
							} else if (k == 1) {
								tile[j] = a[3];
								count[j] += 2;
							} else if (k == 2) {
								tile[j] = a[0];
								count[j]++;
							} else {
								tile[j] = a[1];
							}
							break;
						}
					}
				}
			}
		}
		return Math.min(Math.min(count[0], count[1]), Math.min(count[2], count[3]));
	}

}
