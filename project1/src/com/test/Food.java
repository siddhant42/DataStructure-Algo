package com.test;

interface Cookable {
	public void cook();
}
class Food {
/*	class Food$1 implements Cookable{

		@Override
		public void cook() {
			System.out.println("inside food$1 method of cookable interface implementation");
			
		}
		
	}*/
	
	public static void main(String[] args) {
		Cookable c = new Cookable() {
			public void cook() {
				System.out.println("anonymous c1 cookable implementer");
			}
		};
		Cookable c2 = new Cookable() {
			public void cook() {
				System.out.println("anonymous c2 cookable implementer");
			}
		};
		System.out.println(c2.getClass().getName());
	}
}
