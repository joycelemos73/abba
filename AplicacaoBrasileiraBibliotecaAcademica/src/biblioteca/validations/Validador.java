package biblioteca.validations;

import biblioteca.services.BibliotecaService;
import biblioteca.services.PersistenciaService;

import java.util.ArrayList;

public class Validador {

    // ================== Atributos
    Object input;
    public static String inputString = "Strings";
    public static Integer inputInteger = 1;
    public static ArrayList<String> allISBN;
    public static ArrayList<String> copiaISBN;
    private PersistenciaService persistenciaService = new PersistenciaService();


    // ================== Construtor
    public Validador() {

        inputString = "Strings";
        allISBN = (ArrayList<String>) (BibliotecaService.todosISBNCadastrados);
        if (allISBN == null || allISBN.isEmpty()) {
            allISBN.add("010101");
        }
    }


    // ================== Métodos
    public static boolean validarInputString(Object currentInput) { // VALIDAR STRING
        boolean checkString = true;

        if (inputString.getClass() == currentInput.getClass()) {
            if(currentInput == "" || ((String) currentInput).isBlank() || ((String) currentInput).length() < 3) {
                checkString = false;
            }
        } else {
            checkString = false;
        }

        //System.out.println("Check String >>> " + checkString);
        return checkString;
    }


    public static boolean validarInputInteger(Object currentInput) { // VALIDAR INTEIROS
        boolean checkInteger = true;

        if (inputInteger.getClass() == currentInput.getClass()) {
            if (((Integer) currentInput).equals(0) || currentInput == null) {
                checkInteger = false;
            }
        } else {
            checkInteger = false;
        }

        System.out.println("check int " + checkInteger);
        return checkInteger;
    }


    public static boolean validarInputISBN(String currentISBN) { // VALIDAR ISBN
        boolean checkISBN = true;

        if (currentISBN.isBlank()) {
            checkISBN = false;
        } else {
            //System.out.println("Não is blank: " + checkISBN);
            if (currentISBN.length() < 7 || !currentISBN.matches("[0-9]+")) {
                currentISBN.length();
                checkISBN = false;
                //System.out.println("matches and length: " + checkISBN);
            } else {

                if (allISBN.isEmpty()) {
                    checkISBN = true;
                } else {
                    for (String isbn : allISBN) {
                        if (isbn.equals(currentISBN)) {
                            checkISBN = false;
                            //System.out.println("Dentro do FOR: " + checkISBN);
                        }
                    }
                }

            }

        }

        //System.out.println("valida ISBN >>> " + checkISBN);
        return checkISBN;
    }




// MÉTODOS DESCARTADOS MOMENTANEAMENTE
// ============================================================

//    public static boolean validarInputTitulo(String inputTitulo) { // VALIDAR TÍTULO
//        boolean checkTitulo = true;
//
//        if (inputTitulo.isBlank()) {
//            checkTitulo = false;
//        } else {
//            System.out.println("Não is blank: " + checkTitulo);
//            if (inputTitulo.length() < 3) {
//                inputTitulo.length();
//                checkTitulo = false;
//                System.out.println("length: " + checkTitulo);
//            }
//
//        }
//
//        System.out.println("valida ISBN >>> " + checkTitulo);
//        return checkTitulo;
//    }


}
