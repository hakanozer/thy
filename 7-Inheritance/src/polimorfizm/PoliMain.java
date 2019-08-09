package polimorfizm;

public class PoliMain {

	public static void main(String[] args) {
		
		PoliMain pl = new PoliMain();
		
		Y nsy = new Y();
		Z nsz = new Z();
		T nst = new T();
		pl.poliFnc(nsy);
		pl.poliFnc(nsz);
		pl.poliFnc(nst);

	}
	
	
	public void poliFnc(X nsx) {
		if(nsx instanceof Y) {
			Y nsy = (Y) nsx;
			nsy.sum(30, 40);
		}
		nsx.call();
	}

}
