package eu.happycoders.adventofcode2015.day12;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Analyzer for the JSON input.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class JsonAnalyzer {

  private static final Pattern PATTERN = Pattern.compile("-?\\d+");

  static int getSumOfAllNumbers(String json) {
    int result = 0;
    Matcher matcher = PATTERN.matcher(json);
    while (matcher.find()) {
      String number = matcher.group();
      result += Integer.parseInt(number);
    }
    return result;
  }

  static int getSumOfAllNonRedNumbers(String json) {
    JsonElement rootNode = JsonParser.parseString(json);
    return getSumOfAllNonRedNumbers(rootNode);
  }

  private static int getSumOfAllNonRedNumbers(JsonElement element) {
    int result = 0;

    if (element.isJsonArray()) {
      result += getSumOfNonRedNumbersInArray(element.getAsJsonArray());
    } else if (element.isJsonObject()) {
      result += getSumOfNonRedNumbersInObject(element.getAsJsonObject());
    } else if (element.isJsonPrimitive()) {
      JsonPrimitive jsonPrimitive = element.getAsJsonPrimitive();
      if (jsonPrimitive.isNumber()) {
        return jsonPrimitive.getAsInt();
      }
    }

    return result;
  }

  private static int getSumOfNonRedNumbersInArray(JsonArray jsonArray) {
    int result = 0;

    for (JsonElement arrayElement : jsonArray) {
      result += getSumOfAllNonRedNumbers(arrayElement);
    }

    return result;
  }

  private static int getSumOfNonRedNumbersInObject(JsonObject jsonObject) {
    int result = 0;

    Collection<JsonElement> values = jsonObject.asMap().values();
    for (JsonElement value : values) {
      if (value.isJsonPrimitive() && value.getAsString().equals("red")) {
        return 0;
      }

      result += getSumOfAllNonRedNumbers(value);
    }

    return result;
  }
}
