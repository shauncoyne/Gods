/*
 * 
 */
package com.CS4398.spc51.gods;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceAdapter.
 *
 * @author Mauricio Silva Manrique
 * https://technology.finra.org/code/serialize-deserialize-interfaces-in-java.html
 * The Class InterfaceAdapter.
 */
public class InterfaceAdapter implements JsonSerializer, JsonDeserializer{

    /** The Constant CLASSNAME. */
    private static final String CLASSNAME = "CLASSNAME";
    
    /** The Constant DATA. */
    private static final String DATA = "DATA";

    /**
     * Deserialize.
     *
     * @param jsonElement the json element
     * @param type the type
     * @param jsonDeserializationContext the json deserialization context
     * @return the object
     * @throws JsonParseException the json parse exception
     */
    public Object deserialize(JsonElement jsonElement, Type type,
        JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class klass = getObjectClass(className);
            return jsonDeserializationContext.deserialize(jsonObject.get(DATA), klass);
        }
        
        /**
         * Serialize.
         *
         * @param jsonElement the json element
         * @param type the type
         * @param jsonSerializationContext the json serialization context
         * @return the json element
         */
        public JsonElement serialize(Object jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(CLASSNAME, jsonElement.getClass().getName());
            jsonObject.add(DATA, jsonSerializationContext.serialize(jsonElement));
            return jsonObject;
        }
    
    /**
     * **** Helper method to get the className of the object to be deserialized ****.
     *
     * @param className the class name
     * @return the object class
     */
        public Class getObjectClass(String className) {
            try {
                return Class.forName(className);
                } catch (ClassNotFoundException e) {
                    //e.printStackTrace();
                    throw new JsonParseException(e.getMessage());
                }
        }

}