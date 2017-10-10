/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kai.du
 * @param <T>
 */
public class DateDeserializer<T extends Date> implements JsonDeserializer<T> {

    //private static final String TAG = DateDeserializer.class.getSimpleName();
    private final SimpleDateFormat mSimpleDateFormat;
    private final Class<T> mClazz;

    /**
     *
     * @param simpleDateFormat
     * @param clazz
     */
    public DateDeserializer(SimpleDateFormat simpleDateFormat, Class<T> clazz) {
        mSimpleDateFormat = simpleDateFormat;
        mClazz = clazz;
    }

    /*
     private static final String[] DATE_FORMATS = new String[] {
     "MMM dd, yyyy HH:mm:ss",
     "MMM dd, yyyy"
     };
     @Override
     public Date deserialize(JsonElement jsonElement, Type typeOF,
     JsonDeserializationContext context) throws JsonParseException {
     for (String format : DATE_FORMATS) {
     try {
     return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
     } catch (ParseException e) {
     }
     }
     throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
     + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
     }
     */

    /**
     *
     * @param element
     * @param type
     * @param context
     * @return
     * @throws JsonParseException
     */
    
    @Override
    public T deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        String dateString = element.getAsString();
        try {
            T date = mClazz.newInstance();
            date.setTime(mSimpleDateFormat.parse(dateString).getTime());
            return date;
        } catch (InstantiationException | IllegalAccessException | ParseException e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }
}
