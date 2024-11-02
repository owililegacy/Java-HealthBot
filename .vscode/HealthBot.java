

import java.util.*;
import java.util.regex.Pattern;
import java.text.Normalizer;

public class HealthBot {
    private Map<String, String> generalResponses;
    private List<HealthCondition> healthConditions; // List to hold health conditions with modular handling

    public HealthBot() {
        generalResponses = new HashMap<>();
        healthConditions = new ArrayList<>(); // Initialize health conditions list
        initializeResponses();
    }

    private void initializeResponses() {
        // General responses initialization
        generalResponses.put("hello", "Hi there! How can I assist you with your health today?");
        generalResponses.put("hae", "Hi there! How can I assist you with your health today?");
        generalResponses.put("hi", "Hi there! How can I assist you with your health today?");
        generalResponses.put("hola", "¡Hola! ¿Cómo estás? How are you doing today?");
        generalResponses.put("how are you", "I'm just a bot; I don't have feelings but I'm here to help you!");
        generalResponses.put("goodbye", "Goodbye! Take care and stay healthy!");
        generalResponses.put("thank you", "You're very welcome! I'm here to help whenever you need.");
        generalResponses.put("thanks", "You're very welcome! Let me know if there's anything else I can do for you.");
        generalResponses.put("yes", "Great! How can I assist you further?");
        generalResponses.put("feeling lonely", "I'm here for you! Feeling lonely can be tough, but it's important to remember that you're not alone in experiencing these feelings.Have you tried reaching out to some one.");
        generalResponses.put("no", "Alright, feel free to ask if you have any questions.");
        generalResponses.put("help", "Of course! Please tell me what you need help with, and I'll do my best to assist.");
        generalResponses.put("who are you", "I'm a health bot created to help answer health-related questions and provide useful information.");
        generalResponses.put("what is your name", "You can call me HealthBot! I'm here to assist with any health queries you may have.");
        generalResponses.put("fine", "I'm glad to hear that! Is there anything else I can help you with?");
        generalResponses.put("not okay", "I'm sorry to hear that. Could you tell me your symptoms?");
        generalResponses.put("sick", "Oh no! What symptoms are you experiencing?");
        generalResponses.put("feeling unwell", "I'm sorry to hear that. Let me know what symptoms you're experiencing, and I'll do my best to assist.");
        generalResponses.put("okay", "Alright. I'm here if you need any help.");
        generalResponses.put("feeling sleepy", "Feeling sleepy is natural, especially if you've had a long day. Are you finding yourself feeling this way frequently?");
        generalResponses.put("how do you work", "I respond to keywords related to health and provide helpful information based on your input.");
        generalResponses.put("what can you do", "I can provide information on general health, symptoms of various conditions, and recommend seeing a healthcare provider when necessary.");
        generalResponses.put("feel sad", "I'm sorry you're feeling this way. Remember, you're not alone. Consider talking to a friend, family member, or professional for support.");
        generalResponses.put("stress", "Stress can be tough. Try taking deep breaths or going for a short walk. If it persists, consider speaking with a professional.");
        generalResponses.put("i am worried", "Worry is natural. If you'd like, you can share your concerns, and I'll do my best to provide helpful information.");
        generalResponses.put("do you have emotions", "I'm just a bot, so I don't have emotions, but I'm here to support you with any health concerns you may have.");
        generalResponses.put("are you a doctor", "I'm not a doctor, but I can provide general health information. For personalized advice, please consult a healthcare professional.");
        generalResponses.put("how can i stay healthy", "Staying healthy includes a balanced diet, regular exercise, adequate sleep, and managing stress. Always consult a healthcare provider for personalized advice.");
        generalResponses.put("what should i eat", "A balanced diet rich in fruits, vegetables, whole grains, and lean proteins is a great start. For specific dietary advice, consult a nutritionist.");
        generalResponses.put("do you know about mental health", "Yes! Mental health is crucial. If you're feeling overwhelmed or down, consider talking to a friend, family member, or mental health professional.");
        generalResponses.put("can you give medical advice", "I'm here to provide general health information. For specific medical advice, please consult a qualified healthcare provider.");
        generalResponses.put("what time is it", "I'm focused on health inquiries, so I recommend checking your device for the current time!");
        generalResponses.put("do you work 24/7", "Yes, I'm here to help whenever you need, 24/7!");
        generalResponses.put("blood pressure", "Blood pressure measures the force of blood against artery walls. Maintaining a healthy range is crucial to prevent heart disease.");
        generalResponses.put("cholesterol", "Cholesterol is a fatty substance in the blood. High levels can increase the risk of heart disease, so it's essential to keep it within a healthy range.");
        generalResponses.put("headache", "I'm sorry to hear that. Is it a frequent issue? Consider staying hydrated, and if it persists, please consult a healthcare provider.");

        // Health conditions using the new HealthCondition class
        healthConditions.add(new HealthCondition(
            Arrays.asList("itching", "discharge","painful urination","sores on your private parts"), 
            "These symptoms could indicate an STI. It's crucial to see a healthcare provider for testing and appropriate treatment."
        ));
        
        healthConditions.add(new HealthCondition(
            Arrays.asList("chest pain", "shortness of breath", "fatigue","swelling in legs","dizziness","rapid heartbeat","nausea","cold sweats","indigestion","pain in jaw or back"),
            "These symptoms may indicate a heart condition. Please seek medical advice as soon as possible."
        ));
    }


    public String getResponse(String userInput) {
        String normalizedInput = TextUtils.normalizeInput(userInput);

        // Check health conditions first
        for (HealthCondition condition : healthConditions) {
            if (condition.matches(normalizedInput)) {
                return condition.getResponse();
            }
        }

        // Check general responses if no health condition matched
        for (Map.Entry<String, String> entry : generalResponses.entrySet()) {
            if (normalizedInput.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "I'm sorry, I don't have information on that yet.";
    }

    public static void main(String[] args) {
        HealthBot bot = new HealthBot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hey there! How can I help you today?");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("goodbye")) {
                System.out.println("HealthBot: " + bot.getResponse(userInput));
                break;
            }
            System.out.println("HealthBot: " + bot.getResponse(userInput));
        }
        scanner.close();
    }
}

// HealthCondition class for modular handling of health symptoms and responses
class HealthCondition {
    private List<String> symptoms;
    private String response;

    public HealthCondition(List<String> symptoms, String response) {
        this.symptoms = symptoms;
        this.response = response;
    }

    // Method to check if any of the symptoms match the user input
    public boolean matches(String userInput) {
        for (String symptom : symptoms) {
            if (userInput.contains(symptom)) {
                return true;
            }
        }
        return false;
    }

    public String getResponse() {
        return response;
    }
}

// TextUtils class for normalizing user input
class TextUtils {
    public static String normalizeInput(String input) {
        input = input.toLowerCase().trim().replaceAll("[^a-zA-Z0-9\\s]", "");
        input = Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return input;
    }
}