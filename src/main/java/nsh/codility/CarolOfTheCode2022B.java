package nsh.codility;

public class CarolOfTheCode2022B implements CarolOfTheCode2022Interface {

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
					if(tile[j]==a[0]){
						tile[j] = a[2];
						count[j]++;
					}else if(tile[j]==a[1]){
						tile[j] = a[3];
						count[j] += 2;
					}else if(tile[j]==a[2]){
						tile[j] = a[0];
						count[j]++;
					}else if(tile[j]==a[3]){
						tile[j] = a[1];
					}
				}
			}
		}
		return Math.min(Math.min(count[0], count[1]), Math.min(count[2], count[3]));
	}

}
