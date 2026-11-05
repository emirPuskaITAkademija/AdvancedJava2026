package com.academy.one.exception;

/**
 * <p>
 *     U bilo kojem kompjuterskom programu loše stvari se mogu desiti uprkos tome što
 *     mi napišemo fenoemalan kodu.
 * </p>
 *
 * <p>
 *     Loše stvari mi programeri zovemo error/exception
 * </p>
 *
 *
 *  <P>
 *      EXPECTED  8 linija programerskog koda uspješno završi..
 *      EXCEPTION ili exceptional event koji prekida normalan tok izvršavanja programa je
 *      GREŠKA ili EXCEPTIOn
 *
 *  </P>
 *
 *
 *
 *
 *   Sve počinje i sve završava s klasom.
 *   Šta je suština postojanja klase ?
 *   <p>
 *       Kada se kreira objekat po šablonu klase ona ispuni svoju svrhu postojanja.
 *   </p>
 *
 *   Ako je ovo istina onda je neko kreirao po šablonu klase ArrayIndexOutOfBoundsException
 *   objekat. Taj neko je JRE  i kada neko kreira po šablonu ove klase objekat
 *   taj objekat će prekinuti normalan tok izvršavanja mog programa.
 *
 *   <p>
 *       Tipovi grešaka:
 *       <li>1.RuntimeException
 *         - jesam li kompajlirao kod..
 *         - jesam li startao kod
 *
 *         Rezultat ove greške je PROGRAMERSKA NEPAŽNJA.
 *       </li>
 *       <li> 2. CheckedException - svi oni koji su potomci/extends Exception a ne
 *            naslijeđuju RuntimException.
 *            Takve greške nas ne puštaju na miru tj. ne dozvoljavaju da kompajliramo kod.
 *            Kad će nam te greške dozvoliti da kompajliramo kod ?
 *            Odgovor:
 *            Kada obradimo tu grešku ili kada mi kao programer preuzmemo
 *            odgovornost da ćemo obraditi poziv funkcije koja vodi ka toj grešci
 *            na način da ćemo definirati BLOK KODA koji reaguje na tu grešku.
 *
 *       </li>
 *       <li> 3. Error - greške na koje mi kao programer nemamo uticaj
 *         - nit mi kao programer možemo hvatati i definirati blok koda koji će odreagovati
 *         na tu grešku
 *         - najčešće na ove greške nemamo ni uticaj  16 GB
 *
 *           OutOfMemoryError
 *           StackOverflowError
 *
 *       </li>
 *   </p>
 *
 */
public class ExceptionDemo{
    static void main(String[] args) {
        int number = 23;
        int[] numbers = new int[3];
        numbers[0] = number;
        numbers[1] = 123;
        numbers[2] = number+1;
        //numbers[3] = number+2;  // throws new ArrayIndexOutOfBoundException("..")
        //int result = number/0;

        // Java koristi IEEE 754 standard za rad decimalnim brojevima
        // Infinity ili NaN
        double decimalNumber = 23.5;
        double result = decimalNumber/0.0;

        float floatNumber = 23.5f;
        float result2 = floatNumber/0f;

        double negativeNumber = -23.5;
        double result3 = negativeNumber/0f;

        System.out.println(result3);

        int intNumber = 100;
//        int resultIntNumber = intNumber/0;

        long longNumber = 100L;
//        long resultLongNumber = longNumber/0;
        Movie movie = null;
//        movie.setTitle("Prohujalo s vihorom");
        printMovieInfo(movie);


        try {
            procitajFajl("dusanovFile");
        } catch (ReadFileException e) {
            System.err.println(e.getMessage());
        }


        // run je metoda koja je takođe bila u beskonačnoj rekurzija i možemo reći beskonačno se izvršava
//        run("Dušan");
        while (true){
            System.out.println("Dušan trči...");
        }

    }

    static void printMovieInfo(Movie movie){
//        System.out.println(movie.getTitle());
    }

    static String procitajFajl(String imeFajla) throws ReadFileException {
        //FileReader fileReader = new FileReader(imeFajla);
        return "";
    }


    static void run(String name){
        System.out.println("%s trči..".formatted(name));
        run(name);
    }

}
