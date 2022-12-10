public class PrintAddress {
    Addresses addresses;
    Address address;
    public PrintAddress(Addresses addresses){
        this.addresses = addresses;
    }
    public PrintAddress(Address address){
        this.address = address;
    }
    public  String prettyPrintAddress() {
        StringBuilder builder =new StringBuilder();
        builder.append("Type :" + address.getType().getCode()+" - Line Details line 1 : " + address.getAddressLineDetail().getLine1() +
                        " - Line Details line 2 : " + address.getAddressLineDetail().getLine2() + " - City : " +address.getCityOrTown() +
                        " - province/state : " + address.getProvinceOrState().getName()+ " - postal code : " + address.getPostalCode() + "  - country : " + address.getCountry().getCode());

        return builder.toString();
    }
    public String printAll(){
        StringBuilder builder =new StringBuilder();
        for(Address address : addresses.getAddress()){

            builder.append("Type code: " + address.getType().code + " - Type name : " + address.getType().getName()+" - Line Details line 1 : " + address.getAddressLineDetail().getLine1() +
                    " - Line Details line 2 : " + address.getAddressLineDetail().getLine2() + " - City : " +address.getCityOrTown() +
                    " - province/state code : " + address.getProvinceOrState().getCode() +  " - province/state name :" +address.getProvinceOrState().getName()+
                    " - postal code : " + address.getPostalCode() + " - country : " + address.getCountry().getCode() + " - lastUpdated : " + address.getLastUpdated() +"\n");
        }
        return builder.toString();
    }
    public String printSpecificAddress(String addressTypeCode,String postal ){
        StringBuilder builder =new StringBuilder();

        if(postal.equalsIgnoreCase(address.getPostalCode())&&
           addressTypeCode.equalsIgnoreCase(address.getType().getCode())){

            builder.append("Type code: " + address.getType().getCode() + " - Type name : " + address.getType().getName()+" - Line Details line 1 : " + address.getAddressLineDetail().getLine1() +
                    " - Line Details line 2 : " + address.getAddressLineDetail().getLine2() + " - City : " +address.getCityOrTown() +
                    " - province/state code : " + address.getProvinceOrState().getCode() +  " - province/state name :" +address.getProvinceOrState().getName()+
                    " - postal code : " + address.getPostalCode() + " - country : " + address.getCountry().getCode() + " - lastUpdated : " + address.getLastUpdated() +"\n");

        }


        return builder.toString();
    }
}
