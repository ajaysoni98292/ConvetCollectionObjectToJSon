import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ajay
 */
public class JSONConversion {

    public static void main(String args[]) {

        Map<Integer, Map<Integer, Map<String, ArrayList<String>>>> mainMap = new HashMap<Integer, Map<Integer, Map<String, ArrayList<String>>>>();
        ArrayList<String> departments = new ArrayList<String>();
        departments.add("java");
        departments.add("testing");
        departments.add(".net");
        departments.add("php");

        Map<String, ArrayList<String>> nestedMapOne = new HashMap<String, ArrayList<String>>();
        nestedMapOne.put("instantSys", departments);

        Map<Integer, Map<String, ArrayList<String>>> nestedMapTwo = new HashMap<Integer, Map<String, ArrayList<String>>>();
        nestedMapTwo.put(1,nestedMapOne);

        mainMap.put(100,nestedMapTwo);
        mainMap.put(101,nestedMapTwo);

        try {
            String json = new ObjectMapper().writeValueAsString(mainMap);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
