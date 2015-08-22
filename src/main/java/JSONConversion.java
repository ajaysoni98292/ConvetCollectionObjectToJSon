import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Convert any nested collection object to JSON.
 * To use ObjectMapper class just include the maven dependency.
 * @author ajay
 */
public class JSONConversion {

    public static void main(String args[]) {

        // Here creating dummy nested collection object.
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
            // ObjectMapper class have method writeValueAsString which
            // is used to covert any collection object to JSON format.
            String json = new ObjectMapper().writeValueAsString(mainMap);
            System.out.println(json);
            // output => {"100":{"1":{"instantSys":["java","testing",".net","php"]}},"101":{"1":{"instantSys":["java","testing",".net","php"]}}}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
