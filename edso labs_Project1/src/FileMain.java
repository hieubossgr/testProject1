import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileMain {

    public static void readFile() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file muốn đọc: ");     // src/text.txt
        String url = in.nextLine();
        System.out.print("Nhập số hàng cuối cùng muốn xem: ");
        int n = in.nextInt();

        FileModel file = new FileModel(url);
        //Xóa comment để đọc những dòng lớn hơn 256 kí tự
        //file.setLengOfCharacter(false);
        List<String> list = new ArrayList<String>();
        FileInputStream fileInput = null;
        BufferedReader bufferedReader = null;
        try {
            fileInput = new FileInputStream(file.getUrl());
            bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
            String line = bufferedReader.readLine();
            int i=1;
            //doc so hang
            while(line!=null) {
                if(i>n) list.remove(0);
                if(line.length() > file.getLengOfCharacterOfLine() && file.isLengOfCharacter()) {
                    throw new CheckFile();
                }
                list.add(line);
                line = bufferedReader.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (CheckFile e) {
            e.ErrorLimitCharacter();
        }  finally {
            fileInput.close();
            bufferedReader.close();
        }

        System.out.println("--------------------------------------------------------------------------");
        if(n<=list.size()) {
            int length = list.size();
            for(int i=0; i<length; i++) {
                System.out.println(list.get(i));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
