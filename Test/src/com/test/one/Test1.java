package com.test.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

public class Test1 {

	
	
	public interface ITest
	{
	    @GET("/heiheihei")
	    public void add(int a, int b);

	}
	public static void main(String[] args)
	{
		
		Proxy.newProxyInstance(ITest.class.getClassLoader(), new Class<?>[]{ITest.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
	    ITest iTest = (ITest) Proxy.newProxyInstance
	    		(ITest.class.getClassLoader(), 
	    				new Class<?>[]{ITest.class},
	    				new InvocationHandler()
	    {
	        @Override
	        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	        {
	            Integer a = (Integer) args[0];
	            Integer b = (Integer) args[1];
	            System.out.println("方法名：" + method.getName());
	            System.out.println("参数：" + a + " , " + b);

	            GET get = method.getAnnotation(GET.class);
	            System.out.println("注解1：" + get.value());
	            System.out.println("注解2：" + get.value());
	            System.out.println("注解3：" + get.value());
	            return null;
	        }
	    });
	    iTest.add(3, 5);
	}
	
	public void getData(){
		Retrofit retrofit=new Retrofit.Builder().
				baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();
		
		IBean iBean=retrofit.create(IBean.class);
		Map<String, String> map=new HashMap<>();
		map.put("", "");
		map.put("", "");
		Call<Bean> call=iBean.getBean(map);
		
		call.enqueue(new Callback<Bean>() {
			
			@Override
			public void onResponse(Response<Bean> arg0, Retrofit arg1) {
				// TODO Auto-generated method stub
				showlog("Bean:"+arg0.body());
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	   public static void showlog(String info) {
	   	   System.out.print("Retrofit " + info + "\n");
	   }
}
