import java.util.*;

public class Test {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.println("Select Option:\n" +
                "1) Highest Common Factor\n" +
                "2) Pretty Version\n" +
                "3) Print All\n" +
                "4) Specific Address\n" +
                "5) Validate Address\n"+
                "6) Validate RSA Address\n"+
                "7) Validate Entire Address");
        String option = input.nextLine();

        if(option.equals("1")){
          System.out.println("Enter array separated by commas");
          String array [] = input.nextLine().split(",");
            int[] values = Arrays.stream(array)
                    .mapToInt(Integer::parseInt)
                    .toArray();
          NumberCalculator numberCalculator = new NumberCalculator();
          System.out.println("Highest Common Factor is:" + numberCalculator.highestCommonFactor(values));
          System.exit(0);
        }
        Addresses addresses = JSON_Transalator.readJSON(ReadFile.readFile());
        if(option.equals("2")){
            PrintAddress printAddress;
            for(Address address:addresses.getAddress()){
                printAddress = new PrintAddress(address);
                System.out.println(printAddress.prettyPrintAddress());
            }

            System.exit(0);
        }
        if(option.equals("3")){
            PrintAddress printAddress = new PrintAddress(addresses);
            System.out.println(printAddress.printAll());
            System.exit(0);
        }
        if(option.equals("4")){
            System.out.println("Enter address type and postal code separated by a comma");
            String array [] = input.nextLine().split(",");
            PrintAddress printAddress;
            for(Address address:addresses.getAddress()){
                printAddress = new PrintAddress(address);
                String message = printAddress.printSpecificAddress(array[0],array[1]);
                System.out.print(message);
            }
            System.exit(0);
        }
        ValidateAddress validateAddress;
        if(option.equals("5")){
            System.out.println("Input address type: 1,2 or 5");
            String addressType = input.nextLine();
            for(Address address:addresses.getAddress()){
                if(address.getType().getCode().equalsIgnoreCase(addressType)){
                    validateAddress = new ValidateAddress(address);
                    if(validateAddress.checkValidAddress()){
                        System.out.println("Address is valid");
                    }
                    else{
                        System.out.println("Invalid address");
                    }

                }
            }
            System.exit(0);
        }

        if(option.equals("6")){
            System.out.println("Input address type: 1,2 or 5");
            String addressType = input.nextLine();
            for(Address address:addresses.getAddress()){
                if(address.getType().getCode().equalsIgnoreCase(addressType)){
                    validateAddress = new ValidateAddress(address);
                    if(validateAddress.checkRSAAddress()){
                        System.out.println("RSA Address is valid");
                    }
                    else{
                        System.out.println("RSA Invalid address");
                    }

                }
            }
            System.exit(0);
        }
        if(option.equals("7")){
            for(Address address:addresses.getAddress()){
                validateAddress = new ValidateAddress(address);
                System.out.println(validateAddress.verifyAddress());
            }
        }

    }
}
