package com.example.fork;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiTest
{
    @Test
    public void RegistrationSuccessful()
    {
        RestAssured.baseURI = "https://pokeapi.co/api/v2";
        RequestSpecification request = RestAssured.given();
        List<String> result = new ArrayList<>();
        Response response = request.get("/pokemon?limit=30");

        assertEquals(response.getStatusCode(), 200);
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> allPokemon = jsonPathEvaluator.getList("results.url");
        JsonPath jsonEachPokemon;
        List<String[]> allTypes;

        for (String pokemonUrl : allPokemon)
        {

            response = request.get(pokemonUrl);
            assertEquals(response.getStatusCode(), 200);
            jsonEachPokemon = response.jsonPath();

            allTypes = jsonEachPokemon.getList("types.type");

            for (int i = 0; i < allTypes.size(); i++)
            {
                if ((jsonEachPokemon.get("types.type[" + i + "].name").toString()).equals("normal"))
                {
                    result.add(jsonEachPokemon.get("types.type[" + i + "].url").toString());
                }
            }
        }

        for (String res : result)
        {
            System.out.println(res);
        }
    }

}

