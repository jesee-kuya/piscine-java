public class DoOp {
    public static String operate(String[] args) {
        if (args.length < 3) {
            return "it depend on the input";
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[2]);
        int num = 0;
        switch (args[1]) {
            case "*" :
                num = num1 * num2;
                break;
            case "+" :
                num = num1 + num2;
                break;
            case "-" : 
                num = num1 - num2;
                break;
            case "/" : 
                if (num2 != 0) {
                    num = num1 / num2;
                } else {
                    return "Error";
                }
                break;
            case "%" :
                if (num2 != 0) {
                    num = num1 % num2;
                } else {
                    return "Error";
                }
                break;
            default :
                return "Error";
        }

        return Integer.toString(num);
    }
}