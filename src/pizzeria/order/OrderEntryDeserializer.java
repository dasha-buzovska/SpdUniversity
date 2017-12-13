package pizzeria.order;

import com.google.gson.*;

import java.lang.reflect.Type;

public class OrderEntryDeserializer implements JsonDeserializer<OrderEntry> {
    @Override
    public OrderEntry deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonType = jsonObject.get("type");
        if (jsonType.isJsonPrimitive()) {
            return new OrderEntry(jsonType.getAsString());
        } else {
            return new OrderEntry(jsonType.getAsJsonObject().get("name").getAsString());
        }
    }
}
