package com.ssafy.live.washer;

public class LWasher implements Washer {
	@Override
	public void wash(String clothes) {
		System.out.println(this.getClass().getSimpleName()+"으로 "+clothes+"세탁");
	}
}
