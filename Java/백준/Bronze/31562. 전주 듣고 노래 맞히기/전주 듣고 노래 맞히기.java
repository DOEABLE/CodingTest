import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws IOException {
		
		HashMap<String, String[]> songMap = new HashMap<>();
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] count = (br.readLine().split(" "));
	    
	    for (int i=0; i<Integer.parseInt(count[0]); i++) {
	    	String[] arr = br.readLine().split(" ");
	    	
	    	songMap.put(arr[1], Arrays.copyOfRange(arr, 2, 5));
	    }
	    
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    for (int j=0; j<Integer.parseInt(count[1]); j++) {
	    	int same = 0;
	    	String songName = "";
	    	String[] sound = (br.readLine().split(" "));
	    	for(String song : songMap.keySet()) {
	    		if(Arrays.equals(sound, songMap.get(song))) {
	    			same++;
	    			songName = song;
	    		}
	    	}
	    	
	    	if(same == 1) {
	    		bw.write(songName);
	    	} else if(same > 1) {
	    		bw.write("?");
	    	} else {
	    		bw.write("!");
	    	}
	    	bw.write("\n");
	    }
	    
	    br.close();
	    
	    bw.flush();
	    bw.close();
		
	}
}