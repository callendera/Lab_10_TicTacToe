import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {

        pipe = new Scanner(System.in);

        do {
            System.out.println(prompt + ": ");
            if (pipe.hasNextInt()) {
                int toReturn = pipe.nextInt();
                if (pipe.hasNextLine())
                    pipe.nextLine();

                return toReturn;
            } else {
                System.out.println("Ooops.. that's not quite right, Try entering a numerical value.\n");
                return getInt(pipe, prompt);
            }
        } while (true);

    }


    public static double getDouble(Scanner pipe, String prompt) {

        pipe = new Scanner(System.in);

        do {
            System.out.println(prompt);
            if (pipe.hasNextDouble()) {
                int toReturn = (int) pipe.nextDouble();
                if (pipe.hasNextLine())
                    pipe.nextLine();
                return toReturn;
            } else {
                System.out.println("Ooops.. that's not quite right, Try entering a numerical value.\n");
                return getDouble(pipe, prompt);
            }
        } while (true);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        pipe = new Scanner(System.in);

        do {
            System.out.print(prompt + " [" + low + "-" + high + "] " + ": ");
            if (pipe.hasNextInt()) {
                int value = pipe.nextInt();

                if (pipe.hasNextLine())
                    pipe.nextLine();

                if (value >= low && value <= high)
                    return value;
            } else {
                System.out.println("Ooops.. that's not quite right, Try entering a numerical value.\n");
                return getRangedInt(pipe, prompt, low, high);
            }
        } while (true) ;

    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {

        pipe = new Scanner(System.in);

        do {
            System.out.print(prompt + " [" + low + "-" + high + "] " + ": ");

            if (pipe.hasNextDouble()) {
                double value = pipe.nextDouble();

                if (pipe.hasNextLine())
                    pipe.nextLine();

                if (value >= low && value <= high)
                    return value;
            } else {
                System.out.println("Ooops.. that's not quite right, Try entering a numerical value.\n");
                return getRangedDouble(pipe, prompt, low, high);
            }
        } while (true) ;
    }

    public static boolean getYNConfirm(Scanner in, String input) {

        String User_input = "";

        do {
            System.out.print(input + ": ");

            if (in.hasNextLine())
                User_input = in.nextLine();

        } while (User_input == null || (User_input.trim().length() == 1
                && !(User_input.trim().equalsIgnoreCase("y") || User_input.trim().equalsIgnoreCase("n"))));

        if (User_input.trim().equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {

        String User_input = "";

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextLine())
                User_input = pipe.nextLine();
        } while (User_input == null || !User_input.matches(regEx));

        return User_input;

    }

    public static void prettyHeader(String msg) {

        int stars = 60;

        while (stars-- > 0) {
            System.out.print("*");
        }

        System.out.println();
        int div = (60 - msg.length()) / 2;
        int left = 1;

        while (left <= div) {
            System.out.print("*");
            left++;
        }

        System.out.print(msg);
        int right = 0;

        if (msg.length() % 2 == 0)
            right = 1;

        while (right <= div) {
            System.out.print("*");
            right++;
        }

        System.out.println();
        stars = 60;

        while (stars-- > 0) {
            System.out.print("*");
        }

    }

}
