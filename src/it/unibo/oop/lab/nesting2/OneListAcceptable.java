package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T>{

	private List<T> list = new ArrayList<>();
	
	public OneListAcceptable(final List<T> list){
		this.list = list;
	}
	public Acceptor<T> acceptor() {
		return new Acceptor<T>(){

			Iterator listIterator = OneListAcceptable.this.list.iterator();
			public void accept(T newElement) throws ElementNotAcceptedException {
				try {
					if(newElement.equals(listIterator.next())) {
						return;	
					}
				}catch(Exception e) {
					System.out.println("No more elements to be evaluated");
				}
				throw new Acceptor.ElementNotAcceptedException(newElement);
			}

			public void end() throws EndNotAcceptedException {
				try {
					if (!listIterator.hasNext()) {
						return;
					}
				}catch (Exception e) {
					System.out.println("2" + e.getMessage());
				}
				throw new EndNotAcceptedException();
			}
			
		};
	}

}
