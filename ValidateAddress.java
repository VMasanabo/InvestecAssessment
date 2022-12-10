import java.io.StringWriter;
import java.text.NumberFormat;

public class ValidateAddress {
    Addresses addresses;
    Address address;
    public ValidateAddress(Addresses addresses){
        this.addresses = addresses;
    }
    public ValidateAddress(Address address){
        this.address = address;
    }
    public boolean checkValidAddress(){
        if(isNumber(address.getPostalCode()) &&
                !isNullorEmpty(address.getCountry().getName()) &&
                !isNullorEmpty(address.getAddressLineDetail().getLine1()) ||
                !isNullorEmpty(address.getAddressLineDetail().getLine2())){

                return true;
        }
        else {
            return false;
        }
    }

    public boolean checkRSAAddress(){
        if(address.getCountry().getCode().equalsIgnoreCase("ZA")){
            if(!isNullorEmpty(address.getProvinceOrState().getCode())){
                return true;
            }
        }
        return false;
    }

    private boolean isNumber(String numberStr){
        try{
            int number = Integer.parseInt(numberStr);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }

    }
    private boolean isNullorEmpty(String value){
        if(value==null || value ==""){
            return true;
        }
        else{
            return false;
        }
    }
    public String verifyAddress(){
        String message="";
        if(!isNumber(this.address.getPostalCode())){
            message = "Invalid Post Code, Please use number";
            return message;
        }
        else if(isNullorEmpty(this.address.getAddressLineDetail().getLine1()) && isNullorEmpty(this.address.getAddressLineDetail().getLine2())){
            message = "Address Line 1 or Line 2 required";
            return message;
        }
        else if(isNullorEmpty(this.address.getType().getCode()) || isNullorEmpty(this.address.getType().getName())){
            message = "Address Type code and name are required";
            return message;
        }
        else if(isNullorEmpty(this.address.getProvinceOrState().getCode()) || isNullorEmpty(this.address.getProvinceOrState().getName())){
            message = "ProvinceOrState code and name are required";
            return message;
        }
        else if(isNullorEmpty(this.address.getCountry().getCode()) || isNullorEmpty(this.address.getCountry().getName())){
            message = "Country code and name are required";
            return message;
        }
        else if(isNullorEmpty(this.address.getCityOrTown())){
            message = "CityOrTown code and name are required";
            return message;
        }

        return "Address is valid";
    }
}
