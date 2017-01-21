//package com.uischool.pdd.model;
//
//import com.uischool.pdd.MyConstants;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// * Created by Влад on 13.12.2016.
// */
//public class Validation {
//
//    public static void writeToFile(String userLogin, String userPass, String userStatus, int userPercent){
//
//        JSONParser parser = new JSONParser();
//
//        try {
//            //Читаем с обьекта Json
//            Object obj = parser.parse(new FileReader(MyConstants.FILE_NAME));
//
//            JSONObject jsonObject = (JSONObject) obj;
//
//            // По ключу User получаем значения
//            JSONArray valUser = (JSONArray) jsonObject.get("User");
//
//            JSONObject user = new JSONObject();
//            user.put("userLogin", userLogin);
//            user.put("userPassword", userPass);
//            user.put("userStatus", userStatus);
//            user.put("userPercent", userPercent);
//
//            valUser.add(user);//добавить еще одного юсера.
//
//            jsonObject.put("User", valUser);
//
//            FileWriter file = new FileWriter(MyConstants.FILE_NAME);
//            file.write(jsonObject.toJSONString());
//            file.flush();
//            file.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//}
