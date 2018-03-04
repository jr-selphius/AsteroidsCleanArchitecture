package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AsteroidDeserializer implements JsonDeserializer<List<Asteroid>> {

    @Override
    public List<Asteroid> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement jsonElement = jsonObject.getAsJsonObject("near_earth_objects");

        Type mapType = new TypeToken<Map<String, List<Asteroid>>>() {}.getType();
        Gson gson = new Gson();
        Map<String, List<Asteroid>> map = gson.fromJson(jsonElement, mapType);

        List<List<Asteroid>> values = new ArrayList<>(map.values());

        String date = (String) map.keySet().toArray()[0];

        List<Asteroid> asteroids = values.get(0);
        for (Asteroid asteroid: asteroids) {
            asteroid.setDate(date);
        }

        return asteroids;
    }
}
