import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        System.out.println("Output: "+calc(in.next()));
     }
    public static String calc (String input){
        int nIndOp=-1;
        float nNum1=0f;
        float nNum2=0f;
        String sOut="";
        char cCh=' ';
        char cCh1=' ';
        char cCh2=' ';

// удалить ВСЕ пробелы
        input=input.replaceAll("\\s+","");
// перевести римские цифры в верхний регистр
        input=input.toUpperCase();
// удалить все пробелы
        if (input.indexOf('+')>=0) {
            nIndOp=input.indexOf('+');
        }else if (input.indexOf('-')>=0) {
            nIndOp=input.indexOf('-');
        }else if (input.indexOf('/')>=0) {
            nIndOp=input.indexOf('/');
        }else if (input.indexOf('*')>=0) {
            nIndOp=input.indexOf('*');
        }

        if (nIndOp>=0) {

            cCh=input.charAt(nIndOp);
            sOut=input.substring(0,nIndOp);
            if(isNumeric(sOut)){
                cCh1='A';
                nNum1=Float.parseFloat(sOut);
            }else {
                cCh1='R';
                nNum1=rimToArab(sOut);
            }
//            System.out.println(sOut+" "+nNum1);
            sOut=input.substring(nIndOp+1,input.length());
            if(isNumeric(sOut)){
                cCh2='A';
                nNum2=Float.parseFloat(sOut);
            }else {
                cCh2='R';
                nNum2=rimToArab(sOut);
            }
//            System.out.println(sOut+" "+nNum2);


            if  ( ((cCh1=='A')&&(cCh2=='A')) || ((cCh1=='R')&&(cCh2=='R')) ) {
// проводим операции
                switch (cCh) {
                    case '+':
                        nNum1 = (float) (nNum1 + nNum2);
                        break;
                    case '-':
                        nNum1 = (float) (nNum1 - nNum2);
                        break;
                    case '*':
                        nNum1 = (float) (nNum1 * nNum2);
                        break;
                    case '/':
                        nNum1 = (float) (nNum1 / nNum2);
                        break;
                }
                if (cCh1=='R'&& cCh2=='R') {
                    if (nNum1>0) {
                        sOut = arabToRim((int) nNum1);
                    } else {
                        sOut="ОШИБКА: Данное исчисление не имеет отрицательных чисел !!! ";
                    }
                } else {
                    sOut = String.valueOf(nNum1);
                }
            } else {sOut="ОШИБКА: Используются одновременно разные системы счисления !!!";}

        } else if (cCh==' ') {
            sOut = "ОШИБКА: Cтрока не является математической операцией !!!";
        } else {
            sOut="ОШИБКА: Такой арифметической операции нет в поставленной задаче !!!";        }
        return sOut;
    }
// проверка на число boolean(String sStr)
   public static boolean isNumeric(String str) {
      try {
         Float.parseFloat(str);
         return true;
      } catch (NumberFormatException e) {
          return false;}
   }
// римские цифры в арабские
    public static int rimToArab(String sStr) {
       String[] aRim={"","I","II","III","IV","V","VI","VII","VIII","IX","X"};

       return Arrays.asList(aRim).indexOf(sStr);
    }
// арабские цифры в римские
    public static String arabToRim(int nRez) {
        String[] aRim={"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] aRim1={"X","IX","VIII","VII","VI","V","IV","III","II","I",""};

        String sOut="";

        if (nRez<11) {
            sOut=aRim[nRez];
        }else if( 11<=nRez && nRez<21){
            sOut="X"+aRim1[20-nRez];
        }else if( 21<=nRez && nRez<31){
            sOut="XX"+aRim1[30-nRez];
        }else if( 31<=nRez && nRez<=39){
            sOut="XXX"+aRim[40-nRez];
        }else if( 40<=nRez && nRez<49){
            sOut="XL"+aRim[50-nRez];
        }else if( 50<=nRez && nRez<59){
            sOut="L"+aRim[50-nRez];
        }else if( 60<=nRez && nRez<69){
            sOut="LX"+aRim[60-nRez];
        }else if( 60<=nRez && nRez<69){
            sOut="LXX"+aRim[70-nRez];
        }else if( 70<=nRez && nRez<79){
            sOut="LXXX"+aRim[80-nRez];
        }else if( 80<=nRez && nRez<89){
            sOut="LXXX"+aRim[80-nRez];
        }else if( 90<=nRez && nRez<99){
            sOut="XC"+aRim[90-nRez];
        }else if( 100<=nRez && nRez<109) {
            sOut = "C" + aRim[100 - nRez];
        }
        return sOut;
    }
}