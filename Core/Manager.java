package Core;

import Actions.MyReader;
import Actions.WriteInFile;

import java.io.IOException;


public class Manager{
    MyReader rd = new MyReader();
    WriteInFile wr = new WriteInFile();
    public Manager() {
    }
    public void Start(){
        System.out.print("""
                
                Введите ФИО, дату рождения формата dd.mm.yyyy, номер телефона, пол формата f/m через пробел.
                Example: Иванов Иван Иванович 01.01.2000 +79999999999 m 
         
                Enter: """);
        try{
            String[] strToWrite = rd.read();
            wr.Add(strToWrite);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}