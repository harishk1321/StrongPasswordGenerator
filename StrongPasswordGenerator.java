import java.util.Random;
    import java.util.Scanner;
    
    public class StrongPasswordGenerator {
    
        // Method to generate a strong password based on user preferences
        public static String generatePassword(int length, boolean includeLower, boolean includeUpper, boolean includeNumbers, boolean includeSpecial) {
            StringBuilder password = new StringBuilder();
            StringBuilder characterPool = new StringBuilder();
    
            // Add characters to the pool based on user selection
            if (includeLower) {
                characterPool.append("abcdefghijklmnopqrstuvwxyz");
            }
            if (includeUpper) {
                characterPool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            }
            if (includeNumbers) {
                characterPool.append("0123456789");
            }
            if (includeSpecial) {
                characterPool.append("!@#$%^&*()-_=+[]{}|;:,.<>?");
            }
    
            // Ensure that the pool has at least one character type
            if (characterPool.length() == 0) {
                throw new IllegalArgumentException("You must select at least one character type (lowercase, uppercase, numbers, or special characters).");
            }
    
            Random random = new Random();
    
            // Generate password by selecting random characters from the pool
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characterPool.length());
                password.append(characterPool.charAt(index));
            }
    
            return password.toString();
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Prompt user for desired password length
            System.out.print("Enter the desired length of the password: ");
            int length = scanner.nextInt();
    
            // Prompt user for inclusion of various character types
            System.out.print("Include lowercase letters? (true/false): ");
            boolean includeLower = scanner.nextBoolean();
    
            System.out.print("Include uppercase letters? (true/false): ");
            boolean includeUpper = scanner.nextBoolean();
    
            System.out.print("Include numbers? (true/false): ");
            boolean includeNumbers = scanner.nextBoolean();
    
            System.out.print("Include special characters? (true/false): ");
            boolean includeSpecial = scanner.nextBoolean();
    
            try {
                // Generate the password
                String password = generatePassword(length, includeLower, includeUpper, includeNumbers, includeSpecial);
    
                // Display the generated password
                System.out.println("Generated Password: " + password);
            } catch (IllegalArgumentException e) {
                // Handle the case where no character types were selected
                System.out.println(e.getMessage());
            }
    
            // Close the scanner to avoid resource leak
            scanner.close();
        }      
}
