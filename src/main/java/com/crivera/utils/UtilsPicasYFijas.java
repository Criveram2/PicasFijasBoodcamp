package com.crivera.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class UtilsPicasYFijas {

	private UtilsPicasYFijas() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static boolean validateSize(String number, int size) {
		String copyNumber = number.toString();
		if (size == copyNumber.length())
			return true;

		return false;
	}

	public static boolean validateOnlynumbers(String number) {
		String regex = "[0-9]+";
		String data = number;
		return data.matches(regex);
	}

	public static String deleteRepeatElemets(String number) {
		String copyNumber = number.toString();
		List<Character> list = convertStringtoListChars(copyNumber);
		return concatenateValuesList(deleteElementsRepeatInList(list));
	}

	public static String randomNumber(int size) {
		return concatenateValuesList(generateListRandonNumbers(size));
	}

	private static List<Character> deleteElementsRepeatInList(List<Character> list) {
		List<Character> listWithoutRepeat = new ArrayList<>();
		Iterator<Character> iterator = list.iterator();
		while (iterator.hasNext()) {
			char chr = iterator.next();
			if (!listWithoutRepeat.contains(chr)) {
				listWithoutRepeat.add(chr);
			}
		}
		return listWithoutRepeat;
	}

	private static List<Character> generateListRandonNumbers(int size) {
		List<Character> list = new ArrayList<Character>();
		while (list.size() < size) {
			int number = (int) ((Math.random() * 9) + 1);
			char num = Character.forDigit(number, 10);
			if (!list.contains(num)) {
				list.add(num);
			}
		}

		return list;
	}

	private static String concatenateValuesList(List<Character> list) {
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<Character> iterator = list.iterator();
		while (iterator.hasNext()) {
			stringBuilder.append(iterator.next());
		}
		return stringBuilder.toString();
	}

	public static List<Character> convertStringtoListChars(String string) {
		List<Character> copy = new ArrayList<Character>();
		for (int i = 0; i < string.length(); ++i) {
			copy.add(string.charAt(i));

		}
		return copy;
	}

}
