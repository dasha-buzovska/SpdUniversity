package pizzeria.order;

import com.google.gson.*;

import java.lang.reflect.Type;

public class OrderEntryDeserializer implements JsonDeserializer<OrderEntry> {
    @Override
    public OrderEntry deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return new OrderEntry(jsonObject.get("type").getAsString());
    }
}
