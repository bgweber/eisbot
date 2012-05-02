package eisbot.abl;
 
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import abl.compiler.Abl;

/**
 *  Script for compiling ABL source, compiling generated Java, and running the agent. 
 */
public class Launcher { 

	public static void main(String[] args) {

		String botName = "EISBot";		
		System.setProperty("ABLBotName", botName); 

		Abl.main(new String[] { "-d", "src", "src/eisbot/abl/abl/" + botName + ".abl" });

		// Run the java compiler on generated classes  
		try {					
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			ArrayList<File> files = new ArrayList<File>();
			for (File file : new File("src/eisbot/abl/java").listFiles()) {
				if (file.getName().endsWith(".java")) {
					files.add(file);
				}
			} 
			
			ArrayList<String> opts = new ArrayList<String>();
			opts.add("-d"); 
			opts.add("bin");
			
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> compilationUnits =
				fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files.toArray(new File[0])));
						
			compiler.getTask(null, fileManager, null, opts, null, compilationUnits).call();
			fileManager.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// Run it
		ABLStarCraftBot.main(new String[] {});
	}
}
