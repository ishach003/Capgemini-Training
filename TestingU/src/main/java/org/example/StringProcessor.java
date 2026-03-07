<<<<<<< HEAD
package org.example;

public class StringProcessor {
    public String concatenate(String a,String b){
        if(a==null || b==null){
            throw new IllegalArgumentException("String cannot be null");
        }
        return a+b;
    }

    public boolean isPalindrome(String str){
        if(str==null){
            return false;
        }
        String reversed=new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
=======
package org.example;

public class StringProcessor {
    public String concatenate(String a,String b){
        if(a==null || b==null){
            throw new IllegalArgumentException("String cannot be null");
        }
        return a+b;
    }

    public boolean isPalindrome(String str){
        if(str==null){
            return false;
        }
        String reversed=new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
>>>>>>> ae9c5601946bc87c5ebd0e1003e56754fb6a16c2
}