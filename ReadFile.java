import java.io.*;

public class ReadFile {
    public static String readFile(){
        File file = new File("./src/addresses.json");
        StringBuilder builder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = bufferedReader.readLine();

            while(readLine!=null){
                builder.append(readLine);
                readLine = bufferedReader.readLine();
            }
            builder.append(builder);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
