import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) {
        // Използваме GsonBuilder за "красив" JSON (подреден на нов ред)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Map<String, String> data = new HashMap<>();
        data.put("Status", "Success");
        data.put("Message", "Кирилицата вече работи!");
        data.put("File", "config.json");

        String json = gson.toJson(data);

        // Записване във файл
        try (FileWriter writer = new FileWriter("result.json", StandardCharsets.UTF_8)) {
            writer.write(json);
            System.out.println("--- Файлът 'result.json' беше създаден успешно! ---");
        } catch (IOException e) {
            System.out.println("Грешка при запис: " + e.getMessage());
        }
        
        // Принтираме и в конзолата за проверка
        System.out.println(json);
    }
}
