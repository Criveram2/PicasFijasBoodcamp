package com.crivera.utils;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsPicasYFijasTest {

	@Test
	public void ifSizePicasFijasISFour() {
		String number = "1234";
		assertThat(UtilsPicasYFijas.validateSize(number, 4), is(true));
	}

	@Test
	public void zeroToLeftIsValid() {
		String number = "0234";
		assertThat(UtilsPicasYFijas.validateSize(number, 4), is(true));
	}

	@Test
	public void DeleteRepeatNumbersConsecutives() {
		String number = "123";
		assertThat(UtilsPicasYFijas.deleteRepeatElemets("1123"), is(number));
	}

	@Test
	public void DeleteRepeatNumbersNoConsecutives() {
		String number = "623";
		assertThat(UtilsPicasYFijas.deleteRepeatElemets("62632"), is(number));

	}

	@Test
	public void OnlynumbersIsCorrect() {
		String number = "123";
		assertThat(UtilsPicasYFijas.validateOnlynumbers(number), is(true));
	}

	@Test
	public void LettersAreInvalidCharacter() {
		String number = "12a3";
		assertThat(UtilsPicasYFijas.validateOnlynumbers(number), is(false));
	}

	@Test
	public void PointIsInvalidCharacter() {
		String number = "12.3";
		assertThat(UtilsPicasYFijas.validateOnlynumbers(number), is(false));
	}

	@Test
	public void validesizeNumberRandon() {
		String number = UtilsPicasYFijas.randomNumber(4);
		assertThat(UtilsPicasYFijas.validateSize(number, 4), is(true));
	}

	@Test
	public void valideonlyNumbersInRandon() {
		String number = UtilsPicasYFijas.randomNumber(4);
		assertTrue(UtilsPicasYFijas.validateOnlynumbers(number));
		assertThat(UtilsPicasYFijas.validateOnlynumbers(number), is(true));
	}

	@Test
	public void randonNotHaveNumbersRepeat() {
		String number = UtilsPicasYFijas.randomNumber(4);
		assertEquals(UtilsPicasYFijas.deleteRepeatElemets(number), number);
	}

}
