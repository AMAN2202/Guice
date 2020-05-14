package type3.services;

import type3.spellcheckers.Spellchecker;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SpellChecker_service1 {
    private Spellchecker s;

    public Spellchecker getS() {
        return s;
    }

    public void setS(Spellchecker s) {
        this.s = s;
    }

    @Inject
    public SpellChecker_service1(Spellchecker s) {
        this.s = s;
    }

    public void make_request() {
        s.check();
    }
}
