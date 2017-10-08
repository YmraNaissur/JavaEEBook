package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorldJSF", eager = true)
public class HelloWorldJSF {

	public HelloWorldJSF() {
		System.out.println("Hello world started!");
	}
	
	public String getMessage() {
		return "Hello world!";
	}
}