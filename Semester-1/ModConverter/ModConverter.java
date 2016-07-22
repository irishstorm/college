import java.util.Scanner;

/*  irishstorm
    13/12/2015
    Semester 1
    I built this as a study aid to correct my work in preparation for semester 1 exams.
*/
public class ModConverter {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int option = 0,
            mod = 26;


        do{   
            System.out.println("******** Modulo Converter ******** \n1.\tEnter a number to convert \n2.\tChange Mod (26 by Default) \n3.\tExit Program ");
            option = input.nextInt();

            switch(option){
                case 1:
                    System.out.print("Enter a number : ");
                    int number = input.nextInt();
                    FindModulo(number, mod);
                break;

                case 2:
                    System.out.print("Enter a mod : ");
                    mod = input.nextInt(); 
                    System.out.print("\n");
                break;

                case 3:
                    System.out.print("Exiting Program...\n\n");
                    System.exit(0);
                break;

                default: 
                    System.out.print("Invalid Option - Please select an option 1 - 3.\n\n");
            }
        }
        while(true);
    }

    public static void FindModulo(int num, int mod){
        int result = num % mod;

        if (result < 0)
            result = result + mod;

        System.out.print(num + " mod " + mod + " is " + result + "\n\n");
    }

}
