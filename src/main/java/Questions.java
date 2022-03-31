import java.util.InputMismatchException;
import java.util.Scanner;

public class Questions {


    public int Questions1 ()  {

        int quantityKej;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę sztuk: ");
        try {
            quantityKej = scanner.nextInt();
            if (quantityKej < 1) {
                System.out.println("Ta liczba nie zadziała");
            } else if (quantityKej <= 5) {
                return quantityKej;
            } else {
                System.out.println("Wyluzuj.. 5 wystarczy ;) ");
                return 5;
            }
        } catch (InputMismatchException e) {
            System.out.println(" Tak się nie bawimy.. Za kare zrobimy 5");
           quantityKej = 5;
        }

        return quantityKej;
    }

}


