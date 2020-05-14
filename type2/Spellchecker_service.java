package type2;

 class Spellchecker_service {
    private Spellchecker spellchecker;


    public Spellchecker_service(Spellchecker spellchecker){
        this.spellchecker=spellchecker;
    }
    public  void request()
    {
        spellchecker.check();
    }

}
