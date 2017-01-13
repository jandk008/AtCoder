package chow.zidane.ojs.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

import chow.zidane.compiler.MemoryClassLoader;
import chow.zidane.compiler.MemoryJavaCompiler;

public class CreateObjectDynamic {

	public static Class<?> createObject(String objectName, String[] names,
			String[] types) {
		StringBuffer buffer = new StringBuffer();
		// build class name
		buffer.append("public class " + objectName + "{\n");
		// build attributes
		buffer.append("public " + types[0] + " " + names[0] + " = \"test\";\n");
		buffer.append(types[1] + " " + names[1] + ";\n");
		buffer.append("}");
		MemoryJavaCompiler compiler = new MemoryJavaCompiler();
		String source = buffer.toString();
		Map<String, byte[]> map = compiler
				.compile(objectName + ".java", source);
		try {
			MemoryClassLoader classLoader = new MemoryClassLoader(map);
			Class<?> clazz = classLoader.load(objectName);
			classLoader.close();
			return clazz;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Class<?> clazz = CreateObjectDynamic.createObject("Zidane",
				new String[] { "name", "age" },
				new String[] { "String", "int" });
		try{
			Field field = clazz.getDeclaredField("name");
			String string = (String)field.get(clazz.newInstance());
			System.out.println(string);
		}catch(NoSuchFieldException e){
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
