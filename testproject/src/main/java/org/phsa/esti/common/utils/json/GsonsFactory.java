/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 *
 * @author kai.du
 */
public class GsonsFactory {

    private static Gson estiGson;

    /**
     *
     * @return
     */
    public static Gson getCasesGson() {
        if (estiGson == null) {
            estiGson = new GsonBuilder().setDateFormat("MM/dd/yyyy").serializeNulls().create();
        }
        return estiGson;
    }

    /**
     *
     * @return
     */
    public static Gson getLongDateGson() {
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values 
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }

        });

        return builder.create();

    }
}
