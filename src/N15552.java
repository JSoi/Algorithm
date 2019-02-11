import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N15552 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase_input = 0;
		try {
			testcase_input = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int testcase = 0; testcase < testcase_input; testcase++) {
			String raw_input = br.readLine();
			int a = Integer.parseInt(raw_input.split(" ")[0]);
			int b = Integer.parseInt(raw_input.split(" ")[1]);
			bw.write(a+b+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
