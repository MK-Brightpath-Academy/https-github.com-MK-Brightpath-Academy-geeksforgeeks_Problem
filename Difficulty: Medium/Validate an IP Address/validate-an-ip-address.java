class Solution {
    public boolean isValid(String s) {

        String[] parts = s.split("\\.", -1);

        // Must have exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {

            // Empty part
            if (part.length() == 0) {
                return false;
            }

            // Leading zero
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            // Check all digits
            for (char ch : part.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }
}