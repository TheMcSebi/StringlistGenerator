import java.io.FileWriter;
import java.io.IOException;

public class StringlistGenerator_Thread implements Runnable {
	private int a, maxn;
	private String[] chars;
	private FileWriter writer;

	public StringlistGenerator_Thread(int index, String[] stringtable, int arraySize, FileWriter fileWriter) {
		this.a = index;
		this.chars = stringtable;
		this.maxn = arraySize-1;
		this.writer = fileWriter;
	}

	public void run() {
        // add/remove for-loops of the same style when fiddling with combination length 
		try {
			for(int b = 0; b <= maxn; b++) {
			    for(int c = 0; c <= maxn; c++) {
			        for(int d = 0; d <= maxn; d++) {
			            for(int e = 0; e <= maxn; e++) {
			                for(int f = 0; f <= maxn; f++) {
			                	String str = chars[a] + chars[b] + chars[c] + chars[d] + chars[e] + chars[f] + "\n";
	                        	
			                	if(StringlistGenerator_Launcher.useFilewriter) {
			                		writer.append(str);
			                	} else {
                                    System.out.print(str);
                                }
			                }
			            }
			        }
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
