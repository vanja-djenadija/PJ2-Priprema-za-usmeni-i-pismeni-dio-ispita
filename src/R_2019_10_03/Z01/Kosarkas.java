package R_2019_10_03.Z01;

import java.util.*;

public abstract class Kosarkas{

	int broj;
	double pogodak;

	public Kosarkas(){
		broj = new Random().nextInt(100);
	}

	public String toString(){
		return "KOSARKAS " + ime;
	}
}