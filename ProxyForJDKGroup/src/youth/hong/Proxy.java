package youth.hong;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {
	public static Object newProxyInstance(Class infc, InvocationHandler h) throws Exception {
		Method[] methods = infc.getMethods();
		String methodStr = "";
		String rt = "\r\n";
		for (Method method : methods) {
			Class[] pty = method.getParameterTypes();
			StringBuilder pStr = new StringBuilder(" ");
			StringBuilder pStr2 = new StringBuilder(" ");
			char c = 'a';
			for (Class class1 : pty) {
				//System.out.println(class1);
				pStr.append(class1.getName() + " " + (c++) + ",");
				pStr2.append(class1.getName() + ".class,");
			}
			pStr = pStr.deleteCharAt(pStr.length()-1);
			pStr2 = pStr2.deleteCharAt(pStr2.length()-1);
			System.out.println(pStr);
			System.out.println(pStr2);
			methodStr += "@Override" + rt + "public " + method.getReturnType().getName() + " " + method.getName()
			+ "(" + pStr + ") {" + rt +
			"try {"
		+ "		h.invoke(this," + infc.getName() + ".class.getMethod(\"" + method.getName() + "\"," +  "new Class[]{" + pStr2 + "}));" + rt +
		"} catch(Exception e){" + rt + 
		"}" + rt 
		+ "}"
		+ rt;
		}
		System.out.println(methodStr);
		String str = 
		"package youth.hong;" + rt +

		"public class $Proxy implements " + infc.getName() + "{" + rt +
		"	InvocationHandler h = null;" + rt +
		"	public $Proxy(InvocationHandler h) { " + rt +
		"		this.h = h;" + rt +
		"	}" + rt +
		methodStr + rt +
			
		"}" + rt;
		//����javaԴ�ļ�
		System.out.println(System.getProperty("user.dir"));
		//String fileName = System.getProperty("user.dir") + "/src/youth/hong/$Proxy.java";
		String fileName = "D:/src/youth/hong/";
		File f = new File(fileName, "$Proxy.java");
		if(!f.exists()) {
			f.getParentFile().mkdirs();//�õ���·��������
			//f.mkdirs();//����������ȫ����Ŀ¼����$Proxy�������ļ��С�
			f.createNewFile();//��·�����ɺ󣬲������ɵ�ǰ�ļ���
		}
		FileWriter fw = new FileWriter(f);
		fw.write(str);
		fw.flush();
		fw.close();
		//compile ���ɵ�Դ�ļ�$Proxy.java
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(compiler);
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(f);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		//load to �ڴ�
		URL[] urls = new URL[] {new URL("file://D:\\src/")};//��ȡ�ļ�Ӧ��ʹ��file�ļ�Э��
		URLClassLoader url = new URLClassLoader(urls);
		System.out.println(url.getURLs()[0]);
		Class c = url.loadClass("youth.hong.$Proxy");
		System.out.println(c);
		System.out.println(infc);
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		Object m = ctr.newInstance(h);
		return m;
		
	}
}
