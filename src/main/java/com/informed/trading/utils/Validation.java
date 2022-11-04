package com.informed.trading.utils;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;

public class Validation {
     public static boolean checkStringIsEmptyOrNull(String input, String inputName) {
          if(input == null) {
               throw new NullPointerException("Please provide information for: " + inputName);
          }
          if(input.isEmpty()) {
               throw new EmptyArgumentException("Please provide information for: " + inputName);
          } else {
               return true;
          }
     }

     public static boolean checkStringContainsOnlyLettersAndNumbers(String str, String fieldName) {
          if(!str.matches("[a-zA-Z0-9]{0,50}")) {
               throw new InvalidArgumentException("Please only use letters and numbers for: " + fieldName);
          } else {
               return true;
          }
     }

     public static boolean checkStringContainsOnlyLetters(String str, String fieldName) {
          if(!str.matches("[a-zA-Z]{0,50}")) {
               throw new InvalidArgumentException("Please only use letters and numbers for: " + fieldName);
          } else {
               return true;
          }
     }

     public static boolean checkObjectIsNotNull(Object inputObject, String inputName) {
          return inputObject != null;
     }

     public static Object checkObjectIsNotNullAndReturnObject(Object inputObject, String inputName) {
          if (inputObject == null) {
               throw new EmptyArgumentException(inputName + ": is empty");
          } else {
               return true;
          }
     }

     public static int checkIntIsGreaterThanZero(int intInput, String inputName) {
          if(intInput < 1) {
               throw new InvalidArgumentException(inputName + ": should be greater than 0");
          } else {
               return intInput;
          }
     }

     public static double checkDoubleIsGreaterThanZero(double doubleInput, String inputName) {
          if(doubleInput > 0) {
               return doubleInput;
          } else {
               throw new InvalidArgumentException(inputName + ": should be greater than zero");
          }
     }
}
