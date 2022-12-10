import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class JSON_Transalator {
    public static Addresses readJSON(String jsonString){
        Addresses addresses = new Addresses();
        ArrayList<Address> addressArrayList = new ArrayList<>();
        addresses.setAddress(addressArrayList);
        JSONArray objects = new JSONArray(jsonString);
        for(int x=0;x< objects.length();x++){

            Address address = new Address();
            String id = objects.getJSONObject(x).getString("id");
            String cityOrTown = objects.getJSONObject(x).getString("cityOrTown");
            String postalCode = objects.getJSONObject(x).getString("postalCode");
            String lastUpdated = objects.getJSONObject(x).getString("lastUpdated");
            String typeCode = objects.getJSONObject(x).getJSONObject("type").getString("code");
            String typeName = objects.getJSONObject(x).getJSONObject("type").getString("name");

            boolean addressLineDetailExist = objects.getJSONObject(x).isNull("addressLineDetail");
            String line1 = addressLineDetailExist  ? null : objects.getJSONObject(x).getJSONObject("addressLineDetail").getString("line1");
            String line2 = addressLineDetailExist  ? null : objects.getJSONObject(x).getJSONObject("addressLineDetail").getString("line2");

            boolean provinceOrStateExist = objects.getJSONObject(x).isNull("provinceOrState");
            String provinceOrStateCode = provinceOrStateExist  ? null : objects.getJSONObject(x).getJSONObject("provinceOrState").getString("code");
            String provinceOrStateName = provinceOrStateExist  ? null : objects.getJSONObject(x).getJSONObject("provinceOrState").getString("name");

            String countryCode = objects.getJSONObject(x).getJSONObject("country").getString("code");
            String countryName = objects.getJSONObject(x).getJSONObject("country").getString("name");

            address.setId(id);
            address.setCityOrTown(cityOrTown);
            address.setPostalCode(postalCode);
            address.setLastUpdated(lastUpdated);

            Type type = new Type();
            type.setCode(typeCode);
            type.setName(typeName);
            address.setType(type);

            AddressLineDetail addressLineDetail = new AddressLineDetail();
            addressLineDetail.setLine1(line1);
            addressLineDetail.setLine2(line2);
            address.setAddressLineDetail(addressLineDetail);

            ProvinceOrState provinceOrState = new ProvinceOrState();
            provinceOrState.setCode(provinceOrStateCode);
            provinceOrState.setName(provinceOrStateName);
            address.setProvinceOrState(provinceOrState);

            Country country = new Country();
            country.setCode(countryCode);
            country.setName(countryName);
            address.setCountry(country);

            addresses.getAddress().add(address);
        }
        return addresses;
    }
}
