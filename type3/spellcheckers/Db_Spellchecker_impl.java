package type3.spellcheckers;


import javax.inject.Inject;

public class Db_Spellchecker_impl implements Spellchecker {

    @Inject
    private String dburl;

    public void check() {
        System.out.println(String.format("Checking spelling via database url: %s", dburl));
    }

    public String getDburl() {
        return dburl;
    }

    public void setDburl(String dburl) {
        this.dburl = dburl;
    }



}
