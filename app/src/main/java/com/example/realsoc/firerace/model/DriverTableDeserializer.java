package com.example.realsoc.firerace.model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by realsoc on 15/06/17.
 */
// Deserializer class aimed to help parse response from RETROFIT's call
public class DriverTableDeserializer implements JsonDeserializer<DriverTable>{
    @Override
    public DriverTable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement content = json.getAsJsonObject().getAsJsonObject("MRData").get("DriverTable");
        return new Gson().fromJson(content, typeOfT);

    }
}
