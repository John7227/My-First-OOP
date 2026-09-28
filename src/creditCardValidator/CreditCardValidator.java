package creditCardValidator;

public class CreditCardValidator {

    private boolean creditCardLength;
    private String creditCardType;
    private int sumOfSecondDigitsAndALlDigitsInOddPlaces;
    private String creditCardValidation;


    public boolean getCreditCardLength() {
        return creditCardLength;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public int getSumOfSecondDigitsAndALlDigitsInOddPlaces() {
        return sumOfSecondDigitsAndALlDigitsInOddPlaces;
    }

    public String getCreditCardValidation() {
        return creditCardValidation;
    }


    public void setCreditCardLength(long number) {

        if(number >= 1000000000000L && number <= 9999999999999999L) {
            this.creditCardLength = true;
        }
        else {
            this.creditCardLength = false;
        }
    }

    public void setCreditCardType(long number) {

        String numberString = number + "";

        if(numberString.charAt(0) == '4') {
            creditCardType = "Visa Card";
        }
        else if(numberString.charAt(0) == '5') {
            creditCardType = "MasterCard";
        }
        else if(numberString.charAt(0) == '3' && numberString.charAt(1) == '7') {
            creditCardType = "American Express Card";
        }
        else if(numberString.charAt(0) == '6') {
            creditCardType = "Discover Card";
        }

    }

    public void setSumOfSecondDigitsAndALlDigitsInOddPlaces(long number) {

        String numberString = number + "";
        String sumOfOddPlaces = number + "";
        int result = 0;

        int sum = 0;
        for(int index = numberString.length() - 2; index >= 0; index -= 2) {
            int multiply = Character.getNumericValue(numberString.charAt(index)) * 2;

            if(multiply > 9) {
                sum += (multiply - 9);
            }
            else {
                sum += multiply;
            }
        }

        int sumOfOddNumbers = 0;
        for(int index = sumOfOddPlaces.length() - 1; index >= 0; index -= 2) {
            sumOfOddNumbers += Character.getNumericValue(sumOfOddPlaces.charAt(index));
        }

        result = sumOfOddNumbers + sum;

        sumOfSecondDigitsAndALlDigitsInOddPlaces = result;

    }


    public void setCreditCardValidation() {

        if(sumOfSecondDigitsAndALlDigitsInOddPlaces % 10 == 0) {
            creditCardValidation = "Valid";
        }
        else {
            creditCardValidation = "Invalid";
        }
    }


}
