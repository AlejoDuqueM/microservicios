package curso.SpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador que se encarga de verificar si una palabra
 * es un palíndromo
 */
@RestController
public class PalindromeController {

    /**
     * endpoint y/o Método que se encarga de verificar si una palabra es un palíndromo
     * @param word Palabra a verificar
     * @return Mensaje que indica si la palabra es un palíndromo o no
     */

    @GetMapping("/palindrome/{word}")
    public String Palindrome(@PathVariable String word) {

        if(isPalindrome(word)) {

            return "La palabra " + word + " es un palíndromo";

        }else {

            return "La palabra " + word + " no es un palíndromo";

        }

    }

    /**
     * Etos no es una buena prectica de programación,
     * la clase isPalindrome debería estar en una clase aparte
     * @param word
     * @return
     */

    private boolean isPalindrome(String word) {

        int length = word.length();

        for(int i = 0; i < length / 2; i++) {

            if(word.charAt(i) != word.charAt(length - i - 1)) {

                return false;

            }

        }

        return true;

    }


}
