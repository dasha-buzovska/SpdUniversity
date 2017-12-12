package pizzeria.order;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class OrderDeserializer implements JsonDeserializer<Order> {
    @Override
    public Order deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {

        Order order = new Order();

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject date = jsonObject.getAsJsonObject("date").getAsJsonObject("date");
        JsonObject time = jsonObject.getAsJsonObject("date").getAsJsonObject("time");

        order.setDate(
                LocalDateTime.of(
                        date.get("year").getAsInt(),
                        date.get("month").getAsInt(),
                        date.get("day").getAsInt(),
                        time.get("hour").getAsInt(),
                        time.get("minute").getAsInt(),
                        time.get("second").getAsInt()
                )
        );

        JsonArray goodsList = jsonObject.getAsJsonArray("goodsList");
        for (JsonElement element : goodsList) {
            OrderEntry entry = jsonDeserializationContext.deserialize(element, OrderEntry.class);
            order.add(entry);
        }
        return order;
    }
}
