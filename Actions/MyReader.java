package Actions;

import java.util.Scanner;

public class MyReader {
    Scanner console;
    public MyReader() {
    }
    public String[] read() throws Exception{
        boolean check = true;
        while (check){
            String str;
            console = new Scanner(System.in);
            str = console.nextLine();
            String[] arr = str.split(" ");
            try {
                if(arr.length != 6){
                    if(arr.length > 6){
                        throw new RuntimeException("Вы ввели больше данных чем требовалось!");
                    }else{
                        throw new RuntimeException("Вы ввели не все данные!");
                    }
                }
                if(!(arr[4].length() == 12 && (arr[4].contains("+7")) || (arr[4].contains("8") && arr[4].length() == 11))){
                    throw new RuntimeException("Неправильно введен номер телефона! ( +7**********, 8********** )");
                }
                if(!(arr[5].contains("f") || arr[5].contains("m")) && arr[5].length() != 1){
                    throw new RuntimeException("Пол указан неверного формата! ( m, f ) ");
                }
                if(!checkDate(arr[3])){
                    throw new RuntimeException("Неправильно введена дата рождений! ( dd.mm.yyyy )");
                }
                return arr;
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }
        }
        return null;
    }

    private boolean checkDate(String str){
        try {
            String[] arr = str.split("\\.");
            int[] arrInt = convertToInt(arr);
            int day = arrInt[0];
            int mounth = arrInt[1];
            int year = arrInt[2];
            if(day <= 0 || mounth <= 0 || mounth > 12 || day > 31){
                return false;
            }
            if(arr.length != 3){
                return false;
            }
            if(day == 31 && (mounth == 2 || mounth == 4 || mounth == 6 || mounth == 9 || mounth == 11)){
                return false;
            }
            if (mounth == 2 && day > 28 && year%4 != 0){
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private int[] convertToInt(String[] arr){
        int[] arrInt = new int[3];
        try{
            for(int i = 0; i < arr.length; i++){
                arrInt[i] = Integer.parseInt(arr[i]);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return arrInt;
    }
}