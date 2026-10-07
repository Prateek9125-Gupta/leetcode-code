class Solution {

    String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();

        if (num >= 1000000000) {
            sb.append(convert3(num / 1000000000)).append(" Billion ");
            num %= 1000000000;
        }

        if (num >= 1000000) {
            sb.append(convert3(num / 1000000)).append(" Million ");
            num %= 1000000;
        }

        if (num >= 1000) {
            sb.append(convert3(num / 1000)).append(" Thousand ");
            num %= 1000;
        }

        if (num > 0) {
            sb.append(convert3(num));
        }

        return sb.toString().trim().replaceAll("\\s+", " ");
    }

    String convert3(int num) {

        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(ones[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            sb.append(tens[num / 10]).append(" ");
            num %= 10;
        }

        if (num > 0) {
            sb.append(ones[num]).append(" ");
        }

        return sb.toString().trim();
    }
}