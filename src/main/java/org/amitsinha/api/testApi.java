package org.amitsinha.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.amitsinha.model.CustomerObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.amitsinha.annotation.controller.tokenisation;

import java.lang.reflect.Field;

/**
 * Created by amit_sinha on 04/07/2017.
 */
@RestController
public class testApi {
    @RequestMapping(value = "/test-api", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<HttpStatus> testApi(@RequestBody String jsonValue){

        ObjectMapper mapper = new ObjectMapper();
        try {
            CustomerObject object = mapper.readValue(jsonValue, CustomerObject.class);

            /*
            System.out.println("------------------- BEFORE TOKENISATION -------------------");
            Field[] oldFields = CustomerObject.class.getDeclaredFields();
            for (Field f: oldFields){
                f.setAccessible(true);
                System.out.println(f.get(object));
            }
*/
            tokenisation.tokenise(object);
            // Field[] fields = CustomerObject.class.getDeclaredFields();

            /*
            System.out.println("------------------- AFTER TOKENISATION -------------------");
            for (Field f: fields){
                f.setAccessible(true);
                System.out.println(f.get(object));
            }
            */

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
