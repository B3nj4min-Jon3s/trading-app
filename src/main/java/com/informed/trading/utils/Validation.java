package com.informed.trading.utils;

import com.informed.trading.exception.EmptyArgumentException;
import com.informed.trading.exception.InvalidArgumentException;

public class Validation {

     public static boolean checkStringIsNull(String input) {
          if(input == null) {
               return true;
          } else {
               return false;
          }
     }
     public static boolean checkStringIsEmpty(String input) {
          if(input.isEmpty()) {
               return true;
          } else {
               return false;
          }
     }

     public static void checkStringIsNullOrEmpty(String input, String inputName) {
          if(checkStringIsNull(input)) {
               throw new NullPointerException("Please provide information for: " + inputName);
          }
          if(checkStringIsEmpty(input)) {
               throw new EmptyArgumentException("Please provide information for: " + inputName);
          }
     }

     public static boolean checkStringContainsOnlyLettersAndNumbers(String str, String fieldName) {
          if(!str.matches("[a-zA-Z0-9]{0,50}")) {
               throw new InvalidArgumentException(fieldName + ": Please only use letters and numbers");
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

     public static String checkStringNotNullEmptyAndOnlyLetters(String str, String inputName) {
          Validation.checkStringIsNullOrEmpty(str, inputName);
          if(checkStringContainsOnlyLetters(str, inputName)) {
               return str;
          } else {
               return "";
          }
     }

     public static String checkStringNotNullEmptyAndOnlyLettersNumbers(String str, String inputName) {
          Validation.checkStringIsNullOrEmpty(str, inputName);
          if(checkStringContainsOnlyLettersAndNumbers(str, inputName)) {
               return str;
          } else {
               return "";
          }
     }

     public static Object checkObjectIsNotNullAndReturnObject(Object inputObject, String inputName) {
          if(inputObject == null) {
               throw new NullPointerException(inputName + ": cannot be null");
          }
          return inputObject;
     }

     public static boolean checkObjectIsNotNull(Object inputObject, String inputName) {
          if (inputObject == null) {
               throw new NullPointerException(inputName + ": is empty");
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
