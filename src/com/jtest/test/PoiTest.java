package com.jtest.test;

import java.io.InputStream;

import org.junit.Test;

import com.jtest.read.PoiRead;

public class PoiTest {

	@Test
	public void read(){
		InputStream is=null;
		try {
			is = this.getClass().getClassLoader().getResourceAsStream("Êý¾Ý.xlsx");
			PoiRead.readPoi(is);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(is!=null){
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void write(){
		try {
			PoiRead.writePoi();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
