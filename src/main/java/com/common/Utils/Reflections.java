package com.common.Utils;
import java.lang.reflect.*;
public class Reflections {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		SamplePrograms smp=new SamplePrograms();
		Class<?>cls=SamplePrograms.class;
		Field fie=cls.getDeclaredField("dbl");
		fie.setAccessible(true);;
		System.out.println(fie.getDouble(smp));
		//Method[] mrth=cls.getMethods();
		//Constructor[]consts=cls.getConstructors();
	}

}
