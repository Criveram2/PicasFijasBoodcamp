package com.crivera.model;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PicasYFijasTest {
	@Test
	public void perfectGame() {
		PicasYFijas pyf = new PicasYFijas("1234");
		PicasYFijas mypyf = new PicasYFijas("1234");
		assertThat(pyf.getFijasTo(mypyf), is(4));
	}

	@Test
	public void zeroFijas() {
		PicasYFijas pyf = new PicasYFijas("5678");
		PicasYFijas mypyf = new PicasYFijas("1234");
		assertThat(pyf.getFijasTo(mypyf), is(0));
	}

	@Test
	public void oneFija() {
		PicasYFijas pyf = new PicasYFijas("5278");
		PicasYFijas mypyf = new PicasYFijas("1234");
		assertThat(pyf.getFijasTo(mypyf), is(1));
	}

	@Test
	public void onePica() {
		PicasYFijas pyf = new PicasYFijas("1234");
		PicasYFijas mypyf = new PicasYFijas("0156");
		assertThat(pyf.getPicasTo(mypyf), is(1));
	}

	@Test
	public void fourPicas() {
		PicasYFijas pyf = new PicasYFijas("1234");
		PicasYFijas mypyf = new PicasYFijas("3142");
		assertThat(pyf.getPicasTo(mypyf), is(4));
	}

	@Test
	public void twoPicas() {
		PicasYFijas pyf = new PicasYFijas("1234");
		PicasYFijas mypyf = new PicasYFijas("5642");
		assertThat(pyf.getPicasTo(mypyf), is(2));
	}

	@Test
	public void twoPicasWithFijas() {
		PicasYFijas pyf = new PicasYFijas("1234");
		PicasYFijas mypyf = new PicasYFijas("1324");
		assertThat(pyf.getPicasTo(mypyf), is(2));
	}

	@Test
	public void twoFijasWithPicas() {
		PicasYFijas pyf = new PicasYFijas("5678");
		PicasYFijas mypyf = new PicasYFijas("8675");
		assertThat(pyf.getPicasTo(mypyf), is(2));
	}

}
