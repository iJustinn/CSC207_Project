package DataStorageExample;// Import for Json Support

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        //New object mapper
        ObjectMapper mapper = new ObjectMapper();
        //Example Use
        HashMap<String, Playlist> map = new HashMap<>();
        Playlist P = new Playlist("nameofplaylist"); // Assuming constructor takes a name argument
        map.put(P.getName(), P);

        try {
            // Writing the map as a JSON string to a file named "data.json"
            mapper.writeValue(new File("src/DataStorageExample/data.json"), map);
            System.out.println("sucess");
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Handle JSON processing errors
        } catch (IOException e) {
            e.printStackTrace(); // Handle I/O errors
        }
        //Set new type to recover from data.json
        TypeReference<HashMap<String, Playlist>> typeRef = new TypeReference<>() {};

        //Recover data from json file
        HashMap<String, Playlist> mapRead = mapper.readValue(new File("src/DataStorageExample/data.json"),
                typeRef);

        //Test result
        System.out.println(mapRead);
        System.out.println(mapRead.get("nameofplaylist"));
        System.out.println(mapRead.get("nameofplaylist").getClass());
        System.out.println(mapRead.get("nameofplaylist").getName());
    }
}