package com.crivera.model;

import java.util.Iterator;
import java.util.List;
import com.google.common.base.Preconditions;
import com.crivera.utils.UtilsPicasYFijas;

public class PicasYFijas {
	private static final int SIZE = 4;
	private String value;

	public PicasYFijas(String value) {
		Preconditions.checkArgument(UtilsPicasYFijas.validateOnlynumbers(value),
				"El elemento solo debe contener numeros");
		String realValue = UtilsPicasYFijas.deleteRepeatElemets(value);
		Preconditions.checkArgument(UtilsPicasYFijas.validateSize(realValue, SIZE), "El tamaño debe ser " + SIZE);
		this.value = realValue;
	}

	public String getValue() {
		return value;
	}

	public int getFijasTo(PicasYFijas numeroPicaYFija) {
		List<Character> list1 = UtilsPicasYFijas.convertStringtoListChars(numeroPicaYFija.value);
		List<Character> list2 = UtilsPicasYFijas.convertStringtoListChars(this.value);
		int fijas = 0;
		Iterator<Character> iterator1 = list1.iterator();
		Iterator<Character> iterator2 = list2.iterator();
		while (iterator1.hasNext() && iterator2.hasNext()) {
			if (iterator1.next() == iterator2.next())
				fijas++;
		}
		return fijas;
	}

	public int getPicasTo(PicasYFijas numeroPicaYFija) {
		List<Character> list1 = UtilsPicasYFijas.convertStringtoListChars(numeroPicaYFija.value);
		Iterator<Character> iterator = list1.iterator();
		int picas = 0;
		int postElementIterator = 0;
		while (iterator.hasNext()) {
			int valueElement = iterator.next();
			if (elementIsPica(valueElement, postElementIterator))
				picas++;
			postElementIterator++;
		}
		return picas;
	}

	private boolean elementIsPica(int valueElement, int contIterator1) {
		List<Character> list2 = UtilsPicasYFijas.convertStringtoListChars(this.value);
		Iterator<Character> iterator2 = list2.iterator();
		int contIterator2 = 0;
		while (iterator2.hasNext()) {
			if (valueElement == iterator2.next()) {
				if (contIterator1 != contIterator2)
					return true;
			}
			contIterator2++;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PicasYFijas other = (PicasYFijas) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value;
	}

}
