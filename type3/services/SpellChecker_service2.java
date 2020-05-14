package type3.services;

import type3.spellcheckers.Spellchecker;

import javax.inject.Inject;
import javax.inject.Named;

public class SpellChecker_service2 {
    private Spellchecker s;

    public Spellchecker getS() {
        return s;
    }

    public void setS(Spellchecker s) {
        this.s = s;
    }

    @Inject
    public SpellChecker_service2(@Named("api") Spellchecker s) {
        this.s = s;
    }

    public void make_request() {
        s.check();
    }
}
