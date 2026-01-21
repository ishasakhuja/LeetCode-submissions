class Solution {
        public String discountPrices(String sentence, int discount) {
        StringBuilder stb = new StringBuilder();
        String[] chunks = sentence.split(" ");
        for(String chunk : chunks) {
            stb.append(applyDiscount(chunk, discount)).append(' ');
        }
        stb.setLength(stb.length() - 1);
        return stb.toString();
    }

    private String applyDiscount(String str, int discount) {
        if (str.charAt(0) != '$') {
            return str;
        }
        double price = 0;
        char ch;
        for (int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                return str;
            } else {
                price = price * 10 + (ch - '0');
            }
        }
        return price > 0 ?  String.format("$%.2f", (price * (100 - discount) / 100)) : str;
    }
}