package Util;

public class SumUtil {


	public float sum(long L){
		float f=0f;
		if(L>=0 && L<1024*1024){
			
			f=onlyMath(L);
		}else if(L>1024*1024){
			
			float f1=onlyMath(L);
			f=onlyMath((long)f1);
		}
		return f;
	}
	
	public float onlyMath(long m){
		float f=0f;
			int a=(int) (m/1024);
			int dig=(int) (m%1024)*10/1024;
			int ten=(int) ( (m%1024)*10%1024*10/1024 );
			int th=(int) (m%1024*10%1024*10%1024*10/1024);
			String str;
			if(th>=5){
				ten=ten+1;
				if(ten>9){
					ten=0;
					dig+=1;
					if(dig>9){
						dig=0;
						a+=1;
					}
				}
				str=a+"."+dig+ten;
			}else{
				str=a+"."+dig+ten;
			}
			f=Float.parseFloat(str);
		return f;
	}

}
