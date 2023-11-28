package com.TheEcommerce.SpringBootTheECommerceProjectKafkaProducer.data;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;


@Component
public class RandomDataGenerator {

    public static final Random random = new Random();

    private static final String[] FIRST_NAMES = {
            "John", "Mary", "Michael", "Jennifer", "David", "Linda", "James", "Elizabeth", "Robert", "Barbara",
            "William", "Susan", "Richard", "Jessica", "Joseph", "Sarah", "Charles", "Karen", "Thomas", "Nancy",
            "Christopher", "Lisa", "Daniel", "Betty", "Matthew", "Margaret", "Donald", "Sandra", "Anthony", "Ashley",
            "Mark", "Kimberly", "Paul", "Emily", "Steven", "Donna", "Andrew", "Michelle", "Kenneth", "Dorothy",
            "George", "Carol", "Joshua", "Amanda", "Kevin", "Melissa", "Brian", "Deborah", "Edward", "Stephanie",
            "Ronald", "Rebecca", "Timothy", "Laura", "Jason", "Helen", "Jeffrey", "Sharon", "Ryan", "Cynthia",
            "Gary", "Kathleen", "Jacob", "Amy", "Nicholas", "Shirley", "Eric", "Angela", "Stephen", "Anna",
            "Jonathan", "Ruth", "Larry", "Brenda", "Justin", "Pamela", "Scott", "Nicole", "Brandon", "Katherine",
            "Frank", "Samantha", "Benjamin", "Christine", "Gregory", "Catherine", "Raymond", "Virginia", "Samuel", "Debra",
            "Patrick", "Rachel", "Alexander", "Janet", "Jack", "Emma", "Dennis", "Carolyn", "Jerry", "Maria",
            "Tyler", "Heather", "Aaron", "Diane", "Henry", "Julie", "Jose", "Joyce", "Douglas", "Evelyn",
            "Peter", "Joan", "Adam", "Victoria", "Zachary", "Kelly", "Nathan", "Christina", "Walter", "Lauren",
            "Harold", "Frances", "Kyle", "Martha", "Carl", "Judith", "Arthur", "Cheryl", "Gerald", "Megan",
            "Roger", "Andrea", "Keith", "Olivia", "Jeremy", "Ann", "Terry", "Jean", "Lawrence", "Alice",
            "Sean", "Jacqueline", "Christian", "Hannah", "Albert", "Doris", "Joe", "Kathryn", "Ethan", "Gloria",
            "Austin", "Teresa", "Jesse", "Sara", "Willie", "Janice", "Billy", "Marie", "Bryan", "Julia",
            "Jordan", "Grace", "Ralph", "Judy", "Roy", "Theresa", "Noah", "Rose", "Dylan", "Beverly",
            "Eugene", "Denise", "Wayne", "Marilyn", "Alan", "Amber", "Juan", "Danielle", "Louis", "Abigail",
            "Russell", "Brittany", "Randy", "Natalie", "Philip", "Sophia", "Vincent", "Isabella", "Bobby", "Charlotte",
            "Johnny", "Eleanor", "Logan", "Madison", "Scott", "Ella", "Victor", "Faith", "Fred", "Grace",
            "Dale", "Haley", "Danny", "Elizabeth", "Shawn", "Lillian", "Lloyd", "Makayla", "Tony", "Melanie",
            "Edwin", "Aria", "Calvin", "Layla", "Philip", "Scarlett", "Harvey", "Avery", "Derek", "Zoe",
            "Darren", "Hailey", "Leonard", "Ellie", "Curtis", "Paisley", "Warren", "Anna", "Lance", "Brooklyn",
            "Jerome", "Aubrey", "Stanley", "Camila", "Alvin", "Violet", "Frederick", "Savannah", "Derrick", "Addison",
            "Marvin", "Skylar", "Alberto", "Samantha", "Glenn", "Maya", "Travis", "Autumn", "Jared", "Aaliyah",
            "Gerard", "Ariana", "Wesley", "Allison", "Antonio", "Alexa", "Charlie", "Audrey", "Ramon", "Bella",
            "Edgar", "Brielle", "Colin", "Claire", "Nelson", "Penelope", "Martin", "Chloe", "Levi", "Delilah",
            "Vernon", "Elena", "Brent", "Emilia", "Geoffrey", "Hazel", "Liam", "Kylie", "Jake", "Luna",
            "Trevor", "Maya", "Cameron", "Naomi", "Ivan", "Nora", "Gordon", "Reagan", "Maurice", "Sarah",
            "Ricky", "Sophia"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
            "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson",
            "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King",
            "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter",
            "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins",
            "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey",
            "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez",
            "James", "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross",
            "Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores", "Washington",
            "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz", "Hayes",
            "Myers", "Ford", "Hamilton", "Graham", "Sullivan", "Wallace", "Woods", "Cole", "West", "Jordan",
            "Owens", "Reynolds", "Fisher", "Ellis", "Harrison", "Gibson", "Mcdonald", "Cruz", "Marshall", "Ortiz",
            "Gomez", "Murray", "Freeman", "Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter",
            "Hicks", "Crawford", "Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren", "Dixon", "Ramos",
            "Reyes", "Burns", "Gordon", "Shaw", "Holmes", "Rice", "Robertson", "Hunt", "Black", "Daniels",
            "Palmer", "Mills", "Nichols", "Grant", "Knight", "Ferguson", "Rose", "Stone", "Hawkins", "Dunn",
            "Perkins", "Hudson", "Spencer", "Gardner", "Stephens", "Payne", "Pierce", "Berry", "Matthews", "Arnold",
    };

    private static final String[] EMAIL_DOMAINS = {
            "gmail.com",
            "yahoo.com",
            "outlook.com",
            "hotmail.com",
            "icloud.com",
            "aol.com",
            "protonmail.com",
            "mail.com",
            "zoho.com", "yandex.com"
    };

    private static final String[] STREETS = {
            "Main Street",
            "Oak Avenue",
            "Maple Lane",
            "Elm Street",
            "Cedar Road",
            "Pine Drive",
            "Birch Court",
            "Willow Way",
            "Spruce Avenue",
            "Sycamore Lane",    };

    private static final String[] CITIES = {
            "New York Cityq",
            "Los Angeles, CA",
            "Chicago, IL",
            "Houston, TX",
            "Miami, FL",
            "San Francisco, CA",
            "Seattle, WA",
            "Boston, MA",
            "Atlanta, GA",
            "Dallas, TX",
    };

    private static final String[] STATES = {
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "Georgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah"
    };

    private static final String[] POSTAL_CODES = {
            "99501", "99502", "99503", "99504", "99505",
            "85001", "85002", "85003", "85004", "85005",
            "72201", "72202", "72203", "72204", "72205",
            "90001", "90002", "90003", "90004", "90005",
            "80201", "80202", "80203", "80204", "80205",
            "06101", "06102", "06103", "06104", "06105",
            "19901", "19902", "19903", "19904", "19905",
            "33101", "33102", "33103", "33104", "33105",
            "30301", "30302", "30303", "30304", "30305",
    };

    private static final String[] COUNTRIES = {
            "United States",
            "Canada",
            "United Kingdom",
            "Australia",
            "Germany"
    };

    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private static final String[] CARD_BRANDS = {
            "Visa",
            "Mastercard",
            "American Express",
            "Discover",
            "Diners Club",
            "JCB",
            "Maestro",
            "UnionPay",
            "Visa Electron",
            "Verve",
    };

    private static final String[] CARD_TYPES = {
            "Credit Card",
            "Debit Card",
            "Prepaid Card",
            "Charge Card",
    };

    private static final String[] PRODUCT_ADJECTIVES = {
            "Premium", "Deluxe", "Luxurious", "Elegant", "Stylish", "Sleek", "Modern", "Innovative", "Cutting-edge", "High-end",
            "Exclusive", "Chic", "Trendy", "Sophisticated", "Glamorous", "Refined", "Handcrafted", "Artisanal", "Durable", "Reliable",
            "Efficient", "Versatile", "Functional", "Practical", "User-friendly", "Compact", "Portable", "Powerful", "Sustainable", "Eco-friendly",
            "Organic", "Natural", "Wholesome", "Refreshing", "Invigorating", "Revitalizing", "Nourishing", "Enriching", "Comfortable", "Cozy",
            "Plush", "Soft", "Gentle", "Smooth", "Silky", "Resilient", "Resistant", "Aesthetic", "Timeless", "Classic",
            "Whimsical", "Quirky", "Adorable", "Cute", "Playful", "Colorful", "Vibrant", "Bold", "Energetic", "Dynamic",
            "Effortless", "Effervescent", "Radiant", "Glowing", "Soothing", "Calming", "Harmonious", "Balanced", "Enchanting", "Captivating",
            "Captivating", "Mesmerizing", "Fascinating", "Intriguing", "Exquisite", "Captivating", "Alluring", "Enticing", "Appealing", "Tempting",
            "Irresistible", "Magical", "Whispering", "Enigmatic", "Mystical", "Divine", "Graceful", "Ravishing", "Ethereal", "Heavenly",
            "Regal", "Empowering", "Inspiring", "Uplifting", "Transformative", "Futuristic", "Groundbreaking", "Revolutionary", "Remarkable", "Exceptional",
            "Ingenious", "Clever", "Brilliant", "Innovative", "Extraordinary", "Outstanding", "Sensational", "Splendid", "Superb", "Phenomenal",
            "Astounding", "Astonishing", "Breathtaking", "Dazzling", "Magnificent", "Marvelous", "Wonderful", "Spectacular", "Glorious", "Gorgeous",
            "Exhilarating", "Thrilling", "Electrifying", "Daring", "Fearless", "Adventurous", "Robust", "Sturdy", "Powerful", "Efficient",
            "Precision", "Reliable", "Trusted", "Secure", "Dependable", "Innovative", "Advanced", "Intelligent", "Smart", "Eco-friendly",
    };

    private static final String[] PRODUCT_NOUNS = {
            "Phone", "Laptop", "Tablet", "Smartwatch", "Camera", "Headphones", "Speaker", "Television", "Monitor", "Printer",
            "Keyboard", "Mouse", "Router", "Modem", "Drone", "Game Console", "Fitness Tracker", "Projector", "Scanner", "Smart Home Device",
            "Blender", "Coffee Maker", "Toaster", "Microwave", "Refrigerator", "Oven", "Dishwasher", "Washing Machine", "Dryer", "Vacuum Cleaner",
            "Air Purifier", "Thermostat", "Smart Bulb", "Robot Vacuum", "Electric Toothbrush", "Shaver", "Hair Dryer", "Curling Iron", "Straightener",
            "Electric Scooter", "Electric Bike", "Hoverboard", "Segway", "Drill", "Screwdriver", "Circular Saw", "Hammer", "Wrench", "Power Drill",
            "Table Saw", "Nail Gun", "Jigsaw", "Cordless Drill", "Leaf Blower", "Chainsaw", "Pressure Washer", "Lawn Mower", "Hedge Trimmer",
            "Electric Grill", "Portable Grill", "Electric Kettle", "Food Processor", "Rice Cooker", "Slow Cooker", "Immersion Blender", "Juicer", "Air Fryer",
            "Stand Mixer", "Digital Camera", "Mirrorless Camera", "DSLR Camera", "Action Camera", "Instant Camera", "Camcorder", "Compact Camera", "Drone Camera",
            "Bluetooth Speaker", "Wireless Earbuds", "Noise-Canceling Headphones", "Gaming Headset", "True Wireless Earbuds", "Over-Ear Headphones", "In-Ear Headphones",
            "Portable Speaker", "Soundbar", "LED TV", "OLED TV", "QLED TV", "Curved TV", "Smart TV", "Ultra HD TV", "4K TV",
            "Curved Monitor", "Ultrawide Monitor", "Gaming Monitor", "Touchscreen Monitor", "LED Monitor", "Inkjet Printer", "Laser Printer", "All-in-One Printer",
            "Photo Printer", "3D Printer", "Wireless Keyboard", "Mechanical Keyboard", "Gaming Keyboard", "Bluetooth Keyboard", "Ergonomic Keyboard", "Wireless Mouse",
            "Gaming Mouse", "Bluetooth Mouse", "Laser Mouse", "Trackball Mouse", "Wi-Fi Router", "Gigabit Router", "Mesh Wi-Fi System", "AC Router", "Gaming Router",
            "Modem Router", "Quadcopter", "Mini Drone", "FPV Drone", "Racing Drone", "Camera Drone", "Toy Drone", "GPS Drone", "VR Headset", "AR Glasses",
            "Fitness Band", "Activity Tracker", "Smart Scale", "Heart Rate Monitor", "Pedometer", "Sleep Tracker", "Blood Pressure Monitor", "Projector Screen",
            "Document Scanner", "Flatbed Scanner", "Portable Scanner", "Sheetfed Scanner", "Photo Scanner", "Smart Lock", "Smart Thermostat", "Smart Plug", "Smart Switch",
            "Smart Doorbell", "Smart Speaker", "Smart Camera", "Smart Vacuum", "Smart Fridge", "Smart Oven", "Smart Washing Machine", "Smart Dryer", "Smart Vacuum Cleaner",
            "Smart Air Purifier", "Smart Fan", "Smart Mirror", "Smart Toothbrush", "Smart Shaver"

    };

    public static String generateRandomCardBrand() {
        return Stream.of(CARD_BRANDS)
                .skip(random.nextInt(CARD_BRANDS.length))
                .findFirst()
                .orElse(null);
    }

    public static String generateRandomCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            cardNumber.append(digit);
            if (i > 0 && (i + 1) % 4 == 0 && i < 15) {
                cardNumber.append(" ");
            }
        }
        return cardNumber.toString();
    }

    public static String generateRandomCustomerId() {
        // Define the range of customer IDs you want to generate
        int minCustomerId = 100000;
        int maxCustomerId = 999999;

        Random random = new Random();
        // Generate a random number within the specified range
        int randomCustomerId = random.nextInt(maxCustomerId - minCustomerId + 1) + minCustomerId;

        return String.format("CUST%s", randomCustomerId);
    }

    public static String generateRandomFirstName() {

        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }

    public static String generateRandomLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    public static String generateRandomEmail() {
        String randomFirstName = generateRandomFirstName().toLowerCase();
        String randomLastName = generateRandomLastName().toLowerCase();
        String randomDomain = EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)];
        return randomFirstName + "." + randomLastName + "@" + randomDomain;
    }

    public static String generateRandomEmail(String randomFirstName, String randomLastName){
        String randomDomain = EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)];
        return randomFirstName.toLowerCase() + "." + randomLastName.toLowerCase() + "@" + randomDomain;
    }


    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String generateRandomStreet() {
        return STREETS[random.nextInt(STREETS.length)];
    }

    public static String generateRandomCity() {
        return CITIES[random.nextInt(CITIES.length)];
    }

    public static String generateRandomState() {
        return STATES[random.nextInt(STATES.length)];
    }

    public static String generateRandomPostalCode() {
        return POSTAL_CODES[random.nextInt(POSTAL_CODES.length)];
    }

    public static String generateRandomCountry() {
        return COUNTRIES[random.nextInt(COUNTRIES.length)];
    }

    public static String generateRandomLoremIpsum(){
        StringBuilder sb = new StringBuilder();
        String[] words = LOREM_IPSUM.split(" ");

        int wordCount = random.nextInt(words.length);
        for (int i = 0; i < wordCount; i++) {
            int randomIndex = random.nextInt(words.length);
            sb.append(words[randomIndex]).append(" ");
        }

        return sb.toString().trim();
    }

    public static String generateRandomPaymentMethod() {
        String cardBrand = CARD_BRANDS[random.nextInt(CARD_BRANDS.length)];
        String cardType = CARD_TYPES[random.nextInt(CARD_TYPES.length)];
        String cardNumber = generateRandomCardNumber();
        String expirationDate = generateRandomExpirationDate();
        String cvv = generateRandomCVV();

        return cardBrand + " " + cardType + "\n" +
                "Card Number: " + cardNumber + "\n" +
                "Expiration Date: " + expirationDate + "\n" +
                "CVV: " + cvv;
    }

    public static String generateRandomPaymentMethodV2() {
        return CARD_BRANDS[random.nextInt(CARD_BRANDS.length)];
    }

    public static String generateRandomExpirationDate() {
        int randomMonth = random.nextInt(12) + 1;
        int randomYear = random.nextInt(10) + 2023; // Generate year from 2023 to 2032
        return String.format("%02d/%d", randomMonth, randomYear);
    }
    public static String generateRandomExpirationMonth() {
        return String.format("%02d", random.nextInt(12) + 1);
    }

    public static String generateRandomExpirationYear() {
        return String.format("%d",random.nextInt(10) + 2023);// Generate year from 2023 to 2032
    }

    public static String generateRandomCVV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    public static String generateRandomProductName(){
        String randomAdjective = PRODUCT_ADJECTIVES[random.nextInt(PRODUCT_ADJECTIVES.length)];
        String randomNoun = PRODUCT_NOUNS[random.nextInt(PRODUCT_NOUNS.length)];

        return randomAdjective + " " + randomNoun;
    }

}
