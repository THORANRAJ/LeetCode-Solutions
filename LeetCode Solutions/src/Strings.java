
import java.util.*;

public class Strings {

	public static void main(String[] args) {
// int n = 4;
// String arr[] = {"geethika", "geetho", "geethu",
// "geethoran"};
//
// System.out.println(longPrefixProblem(arr,n));

		System.out.println(isSubsequence("acb", "ahbgdc"));
	}

	public static void stringLengthWithoutInBuild() {
		String name = "ThoranRaj";
		name = name + "\0";
		char len[] = name.toCharArray();
		int count = 0, i = 0;

		while (len[i] != '\0') {
			++count;
			++i;
		}
		System.out.println(count);
	}

	public static void reverseArrayWithAnother() {
		int a[] = { 1, 2, 3, 4, 5 }, b[] = new int[a.length];

		for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
			b[j] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static void reverseArrayWithoutAnother() {
		int a[] = { 5, 4, 3, 2, 1 }, temp1, temp2;

		for (int i = 0, j = a.length - 1; i < j; i++, j--) {
			temp1 = a[i];
			a[i] = a[j];
			a[j] = temp1;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void findSecondLargestInArray() {
		int a[] = { 5, 4, 3, 2, 1, 39, 22, 88 }, fbig, sbig, temp;
		fbig = a[0];
		sbig = a[1];
		if (fbig < sbig) {
			temp = fbig;
			fbig = sbig;
			sbig = temp;
		}
		for (int i = 2; i < a.length; i++) {
			if (a[i] > fbig) {
				sbig = fbig;
				fbig = a[i];
			} else if (a[i] > sbig) {
				sbig = a[i];
			}
		}
		System.out.println(fbig + " " + sbig);
	}

	public static void paranthesis() {
		String s = "{[]}";
		boolean op = false;
		if (s.length() % 2 == 0) {
			int a = 0, b = 2;
			String res;
			for (int i = 0; i < s.length(); i++) {
				res = s.substring(a, b);
				if (res.contains("()") || res.contains("{}") || res.contains("[]")) {
					op = true;
				} else if (res.contains("{[")) {
					op = false;
				}

			}
			a = a + 2;
			b = b + 2;
		} else {
			op = false;
		}
		System.out.println(op);
	}

	public static String reverseWord(String str) {
// Reverse the string str
		str = str + "\0";
		String res = "";
		char a[] = str.toCharArray();
		char b[] = new char[str.length()];
		int i = 0, j = str.length() - 1;
		while (a[i] != '\0') {
			b[j] = a[i];
			i++;
			j--;
		}
		res = String.valueOf(b);
		return res;
	}

	public static void reverseWithoutUsingAnother() {
		String str = "thoran";
		char a[] = str.toCharArray();
		int i = 0;
		int j = a.length - 1;
		char temp;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		str = String.valueOf(a);
		System.out.println(str);
	}

	public static ArrayList<Integer> duplicates(int arr[], int n) {

		Set<Integer> res = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					res.add(arr[i]);
				}
			}
		}
		if (res.isEmpty()) {
			res.add(-1);
		}
		ArrayList<Integer> mainList = new ArrayList<Integer>();
		mainList.addAll(res);

		return mainList;
	}

	public static void checkAnagrams() {
		String s1 = "silent";
		String s2 = "listen";
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		char a[] = s1.toCharArray();
		char b[] = s2.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		boolean result = Arrays.equals(a, b);
		if (result == true) {
			System.out.println("its anagram");
		} else {
			System.out.println("its not anagram");
		}

	}

	public static String getSubString(String a, String b) {
		int i = 0;
		int j = 0;

		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) != b.charAt(j)) {
				break;
			}
			i++;
			j++;
		}
		return a.substring(0, i);
	}

	public static String longPrefixProblem(String a[], int n) {
		String temp = a[0];
		for (int i = 1; i < a.length; i++) {
			temp = getSubString(temp, a[i]);
		}
		return temp;
	}

	public static void lengthOfLastWord() {
		String s = "Hello Wolrd ";
		s = s.toLowerCase();
		char a[] = s.toCharArray();

		int i = 0;
		int j = a.length - 1;
		char temp;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		s = String.valueOf(a);

		System.out.println(s);
		int k = 0;
		while (s.charAt(k) == ' ') {
			k++;
		}

		int y = k;
		int count = 0;
		while (s.charAt(y) != ' ') {
			count++;
			y++;
			if (y == s.length()) {
				break;
			}

		}
		System.out.println(count);

	}

	public static int strStr() {

		String a = "leetcode";
		String b = "leeto";
		int ind = a.indexOf(b);
		return ind;
	}

	public static boolean isPalindrome() {

		String s = "0P";
		s = s.toLowerCase();
		s = s.replace(" ", "");
		char a[] = s.toCharArray();
		char b[];
		int j = 0, spl = 0;
		for (int i = 0; i < s.length(); i++) {
			if (a[i] >= 'a' && a[i] <= 'z' || Character.isDigit(a[i])) {
				continue;
			} else {
				spl++;
			}
		}
		b = new char[a.length - spl];
		for (int i = 0; i < s.length(); i++) {

			if (a[i] >= 'a' && a[i] <= 'z' || Character.isDigit(a[i])) {
				b[j] = a[i];
				j++;

			}
		}
		s = String.valueOf(b);
		String temp = s;
		StringBuilder sb = new StringBuilder(temp);
		sb.reverse();
		temp = sb.toString();
		System.out.println(s);
		System.out.println(temp);

		boolean res = s.equals(temp);
		return res;
	}

	public static String reverseWords1(String s) {
		s = s.trim();
		String[] sArr = s.split(" ");
		String res = "";
		for (int i = sArr.length - 1; i >= 0; i--) {
			if ("".equals(sArr[i]))
				continue;
			res += sArr[i] + " ";
		}
		return res.trim();

	}

	public static String getSortedString(String a) {
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		return sorted;
	}

	public static boolean isSubsequence(String s, String t) {
		s = getSortedString(s);
		t = getSortedString(t);
		System.out.println(s);
		System.out.println(t);
		int val = t.indexOf(s);
		if (val == -1) {
			return false;
		} else {
			return true;
		}
	}
}