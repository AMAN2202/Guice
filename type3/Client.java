package type3;

import com.google.inject.Guice;
import com.google.inject.Injector;
import type3.services.SpellChecker_service1;

public class Client {
    public static void main(String args[]) {

        Injector injector = Guice.createInjector(new Module(),new Module());
        SpellChecker_service1 s1 = injector.getInstance(SpellChecker_service1.class);
        SpellChecker_service1 s2 = injector.getInstance(SpellChecker_service1.class);


        s1.make_request();
//        injector.injectMembers(s1); on demand injection
        System.out.println(s1.equals(s2));


    }
}
