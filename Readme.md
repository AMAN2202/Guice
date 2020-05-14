For using dependency injection we need to configure module . Our module must be extending AbstractModule


			public class Module extends AbstractModule {
			    
			    @Override
			    protected void configure() {
			    	//binds 
			    	        bind(A.class).to(B.class);
			    } 
			}

For injectting create injector supllying it configurations.
		       
		       
		       Injector injector = Guice.createInjector(new Module(),new OtherModule());
Now we can use this injector for injection dependency.
for that we have to first place @inject annotation in any of the following ways.

	1)constructor injection


	class B{
		private A a;
		@Inject  
		public B(A a)
		{
			this.a=a;
		}
	}


	2)field injection
	

		class B{
		@Inject  private A a;
		


		}



	3)Method injection
	

		class B{
		private A a;

		@Inject  
		public setA(A a)
		{
			this.a=a;
		}
	}
		
After that we can use the injector.
	

	B b= injector.getInstance(A.class)


Suppose our class A also have some dependency on other class and we have binded that dependency then while creatring an instance of class A other class will also be instanciated.


Other Annotations
Scope based: Needs to be placed at top of class e.g
		
		@Singleton
		class a{
		}

	
		1)@Singleton − Single instance for lifetime of the application. @Singleton object needs to be threadsafe.  e.g Database connection instances

		2)@SessionScoped − Single instance for a particular session of the web application. @SessionScoped object needs to be threadsafe. e.g Cart of an user

		3)@RequestScoped − Single instance for a particular request of the web application. @RequestScoped object does not need to be threadsafe. e.g Request for file that is prepared by server



Injection a cosntant instance
	

	bind(String.class).toInstance("string that you want");
	bind(Integer.class).toInstance(10);

But some places String might require diffrent values. for that we use @Named annotations or even can create our own annotations

Using @Named

	

			Class A{
				
				private string dburl;

				@Inject
				public A(@Named.name("DatabaseUrl")String url)
				{ this.dburl=url;	
				}
			}

	
Binding it 	
			
			 bind(String).annonatedWith(Names.named(DatabaseUrl)).to("String you want")

Using custom annotations
	 creating annotation:-
		

		@Qualifier
		@Target({FIELD, PARAMETER, METHOD})
		@Retention(RUNTIME)
				public  @interface DatabaseUrl {
				
				}

giving it  to class
		

		Class A{
				
				private string dburl;

				@Inject
				public A(@DatabaseUrl String url)
				{ this.dburl=url;	
				}
			}

binding it:-
		


		 bind(A.class).annotatedWith(DatabaseUrl.class).to("string you want");
	

But suppose we are using any extenal module/jar we cannot place @Inject annotation :).
But we can use Provide to overcome above problem by proving which class to inject during runtime.
	suppose external jar conatins A
	
	

	Class A{
				
				private Listr<Integer> a;
			}

We can use provide in Module class and simply inject as we were doing earlier.
				public class Module extends AbstractModule {
			    
	

			    @Override
			    protected void configure() {
			    	//binds 
			    	        bind(A.class).to(B.class);
			    } 

	

			        @Singleton   //  we can use other annotations as well
				    @Provides
				    public  List<Integer> ProvideListInt(int a)
				    {
				    	if(cond1)
				    	{
				    		return new ArrayList<Integer>;
				    	}
				    	else

				    		return new LinkedList<Integer>;

				    }

			}

We can create a seperate class for proving dependecy using Provider. But it needs to implement interface


interface Provider<T>{
	T get();
	}
	

public class Spellcheck_provider implements Provider<Spellchecker> {


    public Spellchecker get() {
        System.out.println("Privider separate class");
        Spellchecker s = new Api_Spellchecker_impl();
        return s;
    }
}


