import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLength(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop until it isn't.
        do
        {
            System.out.print("\n" + prompt + ": "); // Shows prompt, plus a space
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    // NEXT METHOD------------------------------------------------------------------

    public static int getInt(Scanner pipe, String prompt) {
        int userInt = 0;
        String trash;
        boolean correct = false;
        do
        {
            System.out.print("\n" + prompt + ": "); // Shows prompt, plus a space
            if (pipe.hasNextInt())
            {
                userInt = pipe.nextInt();
                pipe.nextLine();
                correct = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("The input you provided was " + trash + ", which is invalid. Please enter an int.");
            }
        } while (!correct);

        return userInt;
    }

    // NEXT METHOD------------------------------------------------------------------

    public static double getDouble(Scanner pipe, String prompt) {
        double userDouble = 0.00;
        String trash;
        boolean correct = false;
        do
        {
            System.out.print("\n" + prompt + ": "); // Shows prompt, plus a space
            if (pipe.hasNextDouble())
            {
                userDouble = pipe.nextDouble();
                pipe.nextLine();
                correct = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("The input you provided was " + trash + ", which is invalid. Please enter a double.");
            }
        } while (!correct);

        return userDouble;
    }

    // NEXT METHOD------------------------------------------------------------------

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInt = 0;
        String trash;
        boolean correct = false;
        do
        {
            System.out.print("\n" + prompt + ": "); // Shows prompt, plus a space
            if (pipe.hasNextInt())
            {
                userInt = pipe.nextInt();
                if (userInt >= low && userInt <= high)
                {
                    correct = true;
                }
                else
                {
                    System.out.println("The value you entered, " + userInt + ", is outside of the designated range. Please enter a value between 1 and 3.");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("The value you entered, " + trash + ", is not a valid input. Please enter a number between 1 and 3.");
            }
        } while (!correct);

        return userInt;
    }

    // NEXT METHOD------------------------------------------------------------------

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double userDouble = 0.00;
        String trash;
        boolean correct = false;
        do
        {
            System.out.print("\n" + prompt + ": "); // Shows prompt, plus a space
            if (pipe.hasNextDouble())
            {
                userDouble = pipe.nextDouble();
                if (userDouble >= low && userDouble <=high)
                {
                    correct = true;
                }
                else
                {
                    System.out.println("The value you entered, " + userDouble + ", is outside of the designated range. Please enter a value between 1 and 10.");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("The value you entered, " + trash + ", is not a valid input. Please enter a number between 1 and 10.");
            }
        } while (!correct);

        return userDouble;
    }

    // NEXT METHOD------------------------------------------------------------------

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String userYN;
        String trash;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": "); // Shows prompt, plus a space.
            userYN = pipe.nextLine();
            switch (userYN)
            {
                case "Y":
                case "y":
                    break;
                case "N":
                case "n":
                    done = true;
                    break;
                default:
                    System.out.println("Your input is invalid. Please enter Y or N." );
                    break;
            }
        } while (!done);

        return done;
    }

    // NEXT METHOD------------------------------------------------------------------

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean gotAValue = false;
        String value = "";
        do
        {
            System.out.print("\n" + prompt + " :");
            value = pipe.nextLine();
            if (value.matches(regEx))
            {
                gotAValue = true;
            }
            else
            {
                System.out.print("\nInvalid input: " + value);
            }
        } while (!gotAValue);

        return value;
    }
}
