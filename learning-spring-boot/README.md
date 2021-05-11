### Spring Boot Application
#### SpringApplication
The **SpringApplication** class provides a convenient way to bootstrap a Spring Boot application that is started from a **main()** method. In many situations, you can delegate to the static SpringApplication.run method, as shown in the following example:

	public static void main(String[] args) {
		SpringApplication.run(MySpringConfiguration.class, args);
	}

Startup information logging can be turned off by setting   
> spring.main.log-startup-info=false     

This will also turn off logging of the application’s active profiles

** Customizing the Banner **   
The banner that is printed on start up can be changed by adding a `banner.txt` file to your classpath or by setting the `spring.banner.location` property to the location of such a file. If the file has an encoding other than UTF-8, you can set `spring.banner.charset`. In addition to a text file, you can also add a `banner.gif`, `banner.jpg`, or `banner.png` image file to your classpath or set the `spring.banner.image.location` property. Images are converted into an ASCII art representation and printed above any text banner.   

> spring.main.banner-mode=off    
> spring.banner.location=classpath:custom-banner.txt     
> spring.banner.image.location=classpath:banner.gif    

If the **SpringApplication** defaults are not to your taste, you can instead create a local instance and customize it. For example, to turn off the banner, you could write:   

	public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(MySpringConfiguration.class);
    	app.setBannerMode(Banner.Mode.OFF);
    	app.run(args);
	}