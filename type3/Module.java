package type3;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import type3.spellcheckers.Api_Spellchecker_impl;
import type3.spellcheckers.Db_Spellchecker_impl;
import type3.spellcheckers.GrammerChecker_impl;
import type3.spellcheckers.Spellchecker;


public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).toInstance("jdbc:mysql://localhost:3306/");

//        bind(Spellchecker.class).to(Api_Spellchecker_impl.class);
            bind(Spellchecker.class).to(Db_Spellchecker_impl.class);
//        bind(Spellchecker.class).annotatedWith(Api_SpellChecker.class).to(Api_Spellchecker_impl.class);
//        bind(Spellchecker.class).toProvider(Spellcheck_provider.class); //with provider

//                bind(Spellchecker.class).to(Api_Spellchecker_impl.class);
//        bind(Api_Spellchecker_impl.class).to(GrammerChecker_impl.class);
//        bind(Spellchecker.class).annotatedWith(Names.named("api")).to(GrammerChecker_impl.class);
//
//        bind(Spellchecker.class).toInstance(new Db_Spellchecker_impl());
//        bind(Db_Spellchecker_impl.class).in(Singleton.class);
    }

//    @Singleton
//    @Provides
//    public  Spellchecker provide_api_spellchecker()
//    {
//        return new Db_Spellchecker_impl();
//    }


}
