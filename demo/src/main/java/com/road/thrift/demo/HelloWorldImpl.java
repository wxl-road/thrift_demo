package com.road.thrift.demo;

import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorldService.Iface {

	@Override
	public String say(String msg) throws TException {
		// TODO Auto-generated method stub
		 //return "Hi,"+msg+"Welcome to my blog http://www.cnblogs.com/zfygiser";
		return ""+Integer.parseInt(msg)*2;
	}

}
