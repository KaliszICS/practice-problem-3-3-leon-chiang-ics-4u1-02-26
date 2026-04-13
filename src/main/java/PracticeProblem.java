import java.util.ArrayList;
public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static ArrayList<String> perms(String str) {
		ArrayList<String> x=new ArrayList<String>();
		permsHelper(str, x, "");
		return x;
	}
	public static void permsHelper (String remain, ArrayList<String> x, String used) {
		if (remain.strip()=="") {
			x.add(used);
		}

		for (int i = 0; i < remain.length(); i++) {
			String usedLetters = used + remain.charAt(i);
			String remainingLetters = remain.substring(0, i) + remain.substring(i + 1);
			permsHelper(remainingLetters, x, usedLetters);
		}
	}

	public static ArrayList<String> permsUnique(String str) {
		ArrayList<String> x = new ArrayList<String>();

		permsUniqueHelper(str, x, "");
		return x;
	}

	public static void permsUniqueHelper(String remain, ArrayList<String> x, String used) {
		if (remain.strip() == "") {
			x.add(used);
		}

		String unique = "";

		for (int i = 0; i < remain.length(); i++) {
			if (unique.contains(String.valueOf(remain.charAt(i)))) {
				continue;
			}
			if (!unique.contains(String.valueOf(remain.charAt(i)))) {
				unique += String.valueOf(remain.charAt(i));
			}
			String usedLetters = used + remain.charAt(i);
			String remainingLetters = remain.substring(0, i) + remain.substring(i + 1);
			permsUniqueHelper(remainingLetters, x, usedLetters);
		}
	}
}
