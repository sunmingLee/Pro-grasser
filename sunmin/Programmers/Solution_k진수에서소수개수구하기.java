package Programmers;

class Solution_k진수에서소수개수구하기 {
	public int solution(int n, int k) {
		int answer = 0;

		// k진수 변환
		String changed = "";
		if (k == 10) {
			changed = Integer.toString(n);
		} else {
			while (n > 0) {
				int remain = n % k;
				n /= k;
				changed = remain + changed;
			}
		}

		// 조건에 맞는 소수 구하기
		int len = changed.length();
		String temp = "";
		for (int i = 0; i < len; i++) {
			temp = "";
			while (i < len && changed.charAt(i) != '0') {
				temp += changed.charAt(i++);
			}
			if (temp != "" && isPrime(Long.parseLong(temp))) {
				answer++;
			}
		}

		return answer;
	}

	/**
	 * num이 소수면 true 반환
	 */
	public boolean isPrime(long num) {
		if (num == 1) {
			return false;
		}

		for (long i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}