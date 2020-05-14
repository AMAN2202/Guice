package type2;



public class Client {
    public static void main(String args[]) {
   Spellchecker_service s=new Spellchecker_service(new Spellchecker_impl());
    s.request();
    }
}
