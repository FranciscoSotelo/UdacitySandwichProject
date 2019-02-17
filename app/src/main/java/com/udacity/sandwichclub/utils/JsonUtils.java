package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwichObj = null;

        try {
            JSONObject sandwichData = new JSONObject(json);
            JSONObject names = sandwichData.getJSONObject("name");
            String sandwichName = names.getString("mainName");
            String placeOfOrigin = sandwichData.getString("placeOfOrigin");
            String description = sandwichData.getString("description");
            String image = sandwichData.getString("image");

            JSONArray otherNames = names.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for(int i = 0; i < otherNames.length(); i++)
            {
                alsoKnownAs.add(otherNames.getString(i));
            }

            JSONArray ingredientArr = sandwichData.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for(int i = 0; i < ingredientArr.length(); i++)
            {
                ingredients.add(ingredientArr.getString(i));
            }

            sandwichObj = new Sandwich(sandwichName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return sandwichObj;
    }
}
