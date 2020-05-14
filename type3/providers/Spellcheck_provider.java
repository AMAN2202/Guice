package type3.providers;

import com.google.inject.Provider;
import type3.spellcheckers.Api_Spellchecker_impl;
import type3.spellcheckers.Spellchecker;

public class Spellcheck_provider implements Provider<Spellchecker> {


    public Spellchecker get() {
        System.out.println("Privider separate class");
        Spellchecker s = new Api_Spellchecker_impl();
        return s;
    }
}

