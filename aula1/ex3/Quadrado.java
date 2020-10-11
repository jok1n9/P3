package aula1.ex3;

public class Quadrado extends Retangulo{
	
	public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4)
	{
		super(p1, p2, p3, p4);
		assert(isSquare()): "Não é um quadrado";
	}
	
	public boolean isSquare(){
		  return ((areACorner(this.p1(),this.p2(),this.p3()) && areACorner(this.p4(),this.p2(),this.p3()))
		   || (areACorner(this.p1(),this.p2(),this.p4()) && areACorner(this.p3(),this.p2(),this.p4()))
		   || (areACorner(this.p1(),this.p3(),this.p4()) && areACorner(this.p2(),this.p3(),this.p4())));

		  
		}

	private boolean areACorner(Ponto p1,Ponto p2,Ponto p3){
		
		  return Math.abs(p2.y() - p1.y()) == Math.abs(p3.x() - p1.x()) 
		      && Math.abs(p2.x() - p1.x()) == Math.abs(p3.y() - p1.y());
		}
	
}
