import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public class Worker extends SwingWorker<Double, Void>{

	private JProgressBar progreso;
	public boolean start;
	
	public Worker(JProgressBar bar){
		progreso=bar;
	}
	
	@Override
	protected Double doInBackground() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("doInBackground() esta en hilo"+Thread.currentThread().getName());
		int val=this.progreso.getValue();
		int max=this.progreso.getMaximum();
		while(val<max){
			if(!start){
				continue;
			}
			try{
				Thread.sleep(100);
			}catch(InterruptedException ex){
				
			}
			
			this.progreso.setValue(val+1);
			val++;
		}
		return null;
	}
	
	@Override
	protected void done(){
		
		double siHaTerminado=this.progreso.getPercentComplete();
		if(siHaTerminado==1.0){
			WorkerFrame.txtResultadoWorker.setText("Terminado");
		}
	}
	
	

}
