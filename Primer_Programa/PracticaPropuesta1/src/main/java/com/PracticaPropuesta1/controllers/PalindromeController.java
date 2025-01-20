package com.PracticaPropuesta1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palindromos
 */
@RestController
public class PalindromeController {

    /**
     * Endpoint para verificar si una palabra es un palindromo
     * Verifica si una palabra es un palindromo
     * @param word Palabra a verificar
     * @return Mensaje indicando si la palabra es un palindromo o no
     */
    @GetMapping("/palindrome/{word}")
    public String palindrome(@PathVariable String word) {

        if(isPalindrome(word)) {

            return "La palabra " + word + " es un palindromo.";

        } else {

            return "La palabra " + word + " NO es un palindromo.";

        }

    }

    /**
     * Verifica si una palabra es un palindromo
     * @param word es la palabra a verificar
     * @return true si la palabra es un palindromo, false en caso contrario
     */
    private boolean isPalindrome(String word) {

        int length = word.length();

        for (int i = 0; i < length / 2; i++) {

            if (word.charAt(i) != word.charAt(length - i - 1)) {

                return false;

            }
        }

        return true;

    }
}
