class Solution {
    public String toGoatLatin(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        String vowels = "aeiouAEIOU";

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            if (vowels.indexOf(word.charAt(0)) == -1) {
                word = word.substring(1) + word.charAt(0);
            }

            
            word = word + "ma";

           
            for (int j = 0; j <= i; j++) {
                word += "a";
            }

            
            if (i > 0) {
                result.append(" ");
            }

            result.append(word);
        }

        return result.toString();
    }
}