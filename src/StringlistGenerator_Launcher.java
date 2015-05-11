import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class StringlistGenerator_Launcher {
	
	public static String chartable[] = {"a", "b", "c", "d", "e", "f"};
	
	public static boolean useFilewriter = true;
	
	
	public static void main(String args[]) throws IOException, InterruptedException {
        String filename = "output.txt";
        String input[] = chartable;
        
        int tableLength = chartable.length;
        
        log("Strings: " + (int)Math.pow(tableLength, 6) + "\n");
        
        File file = new File(filename);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        Thread threads[] = new Thread[tableLength];
        
        log("Initializing threads...");
        
        
        for(int a = 0; a < tableLength; a++) {
            Runnable r = new StringlistGenerator_Thread(a, input, tableLength, writer);
            Thread thread = new Thread(r);
            threads[a] = thread;
            thread.setName(chartable[a]);
            thread.start();
        }
        
        log("Waiting for threads to continue...");
        
        for(int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            thread.join();
        }
        
        log("All threads have finished.\n");
        
        writer.flush();
        writer.close();
		System.exit(1);
	}
	
	
	public static void log(String message) {
		if(useFilewriter) {
			System.out.println(message);
		}
	}
}