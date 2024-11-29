
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
        generalResponses.put("hola", "¡Hola! ¿Cómo estás?");
        generalResponses.put("how are you", "I'm just a bot; I don't have feelings but I'm here to help you!");
        generalResponses.put("goodbye", "Goodbye! Take care and stay healthy!");
        generalResponses.put("thank you", "You're very welcome! I'm here to help whenever you need.");
        generalResponses.put("thanks", "You're very welcome! Let me know if there's anything else I can do for you.");
        generalResponses.put("yes", "Great! How can I assist you further?");
        generalResponses.put("sores", "If the sores are painful, spreading, or showing signs of infection (like increased redness or pus), I recommend consulting a healthcare professional for a proper evaluation.");
        generalResponses.put("dehydration", "On that you need to take at least 8 glasses of water a day");
        generalResponses.put("dehydrated", "On that you need to take at least 8 glasses of water a day");
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
        generalResponses.put("common cold", "I'm sorry to hear that.\nThe common cold is a viral infection of the upper respiratory tract, primarily affecting the mucosa of the nose and throat.\nIt is one of the most frequent illnesses, with adults experiencing an average of 2-3 colds per year and children often having even more.\nThis condition is caused by over 200 different viruses, with rhinoviruses being the most prevalent, responsible for approximately 30-40% of adult colds.");
        generalResponses.put("sore throat", "A sore throat can be caused by various factors, including viral infections, allergies, or irritants. Staying hydrated and using throat lozenges may help. If symptoms persist or worsen, please consult a healthcare provider.");
        generalResponses.put("stomach ache", "A stomach ache can have various causes, including indigestion, gas, or even stress. Drinking water, avoiding heavy meals, and resting may help ease discomfort. If the pain is severe, persistent, or accompanied by other symptoms like fever or vomiting, please consult a healthcare provider.");
        generalResponses.put("fever", "A fever is usually the body’s response to infection or inflammation. Rest, staying hydrated, and using a cold compress can help manage it. Over-the-counter medications can reduce fever, but if it is high, prolonged, or accompanied by other concerning symptoms, please consult a healthcare provider.");
        generalResponses.put("cough", "A cough may be caused by infections, allergies, or irritants. Drinking warm fluids and using a humidifier may soothe it. Over-the-counter cough medications can help with symptoms, but if the cough persists or is accompanied by other symptoms, please consult a healthcare provider.");
        generalResponses.put("earache", "An earache can result from infections, sinus issues, or even changes in altitude. Applying a warm compress and taking over-the-counter pain relievers may provide relief. If the pain persists or is accompanied by fever or hearing loss, please consult a healthcare provider.");
        generalResponses.put("nausea", "Nausea can be caused by various factors, including motion sickness, food poisoning, or underlying medical conditions. Staying hydrated and consuming bland foods like crackers or toast may help ease the discomfort. Over-the-counter medications like antihistamines can also provide relief. If nausea persists or is accompanied by severe symptoms like vomiting, abdominal pain, or fever, please consult a healthcare provider.");
        generalResponses.put("depression and how to conquer it","I'm really sorry to hear that you're feeling this way. You're not alone, and there are steps you can take to feel better. Talking to someone you trust, like a friend or family member, can help. Consider reaching out to a therapist or counselor—they're trained to support you through this. Taking small steps, like getting some fresh air or engaging in activities you enjoy, can also make a difference. Remember, healing takes time, and it's okay to seek help. You matter."
);



        // Health conditions using the new HealthCondition class
        healthConditions.add(new HealthCondition(
            Arrays.asList("itching", "discharge","painful urination","sores on your private parts"), 
            "These symptoms could indicate an STI. It's crucial to see a healthcare provider for testing and appropriate treatment."
        ));
        
        healthConditions.add(new HealthCondition(
            Arrays.asList("chest pain", "shortness of breath", "fatigue","swelling in legs","dizziness","rapid heartbeat","nausea","cold sweats","indigestion","pain in jaw or back"),
            "These symptoms may indicate a heart condition. Please seek medical advice as soon as possible."
        ));
        healthConditions.add(new HealthCondition(
             Arrays.asList("runny nose", "stuffy nose", "sore throat", "fatigue", "body aches", "sneezing", "coughing"), 
            "These symptoms could indicate a common cold."
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
        userInput = TextUtils.normalizeInput(userInput); // Normalize user input once

        for (String symptom : symptoms) {
            String normalizedSymptom = TextUtils.normalizeInput(symptom); // Normalize each symptom    
            if (userInput.contains(normalizedSymptom)) {
             
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
