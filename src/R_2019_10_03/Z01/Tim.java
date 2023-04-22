package R_2019_10_03.Z01;

public class Tim{

	String ime;
	ArrayList<Kosarkas> igraci;
	static int count;

	public Tim(){
		ime = "TIM " + (++count);
		timovi = Stream.generate(Kosarkas::new).limit(12).collect(Collectors.toList());
	}

	public String toString(){
		return ime;
	}
}