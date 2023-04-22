package R_2022_06_29.Z03;

public class RemoveThread extends Thread{
	Long postotak;

	public RemoveThread(long l){
		start();
		this.postotak = postotak;
	}

	public void run(){
		while(!Simulacija.END){
			try{
				Thread.sleep(500*postotak);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			try{
				Student s = Simulacija.red.studenti.element();}
			catch(Exception e){

			}
		}
	}
}