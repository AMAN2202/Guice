package type1;

 class SpellCheckerService {
    private Spellchecker spellchecker;

    public SpellCheckerService() {
        this.spellchecker = new Spellchecker();
    }

    public  void request()
    {
        spellchecker.check();
    }

}
