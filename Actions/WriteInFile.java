package Actions;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class WriteInFile {
//    <Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>

    String path = "Data\\" ;
    public void Add(String[] str) {
        path += str[0] + str[1] + str[2] + ".txt";
        String newStr = "";
        try {
            for (String s : str) {
                newStr += "<" + s + ">";
            }
            PrintWriter output = new PrintWriter(new FileWriter(path, true));
            output.write(newStr+"\n");
            output.close();
        }catch(Exception e)
        {
            e.getStackTrace();
        }
    }
}