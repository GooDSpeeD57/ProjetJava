import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {
//LocalDate dateNow = LocalDate.now();
//LocalDate dateNowPlusSept = LocalDate.now().plusDays(7);
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        System.out.println(dateNow.format(formatter));
//        System.out.println(dateNowPlusSept.format(formatter));
int a,b;
Scanner input = new Scanner(System.in);
try{System.out.print("Saisir a : ");
    a=input.nextInt();
    System.out.print("Saisir b : ");
    b=input.nextInt();
  System.out.println("a+b = "+(a/b));
        }
catch(InputMismatchException err){
System.out.println(err);
        }
    }
}


