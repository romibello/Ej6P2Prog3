
import java.util.LinkedList;
import java.util.List;

public class Arbol {
	int dato;
	Arbol izq;
	Arbol der;
	public Arbol(){
		dato=0;
		izq=null;
		der=null;
	}
	
	public boolean isEmpty(){
		if((this.dato==0) && (this.izq==null) &&(this.der==null)){
			return true;
		}
		return false;
	}
	
	public void Insert(Object dato){ // Olog(n)
		if(this.isEmpty()){
			this.dato=(int)dato;
			this.izq=new Arbol();
			this.der= new Arbol();
		}else{
			if ((int)dato<this.dato){
				this.izq.Insert(dato);
			}else{
				this.der.Insert(dato);
			}
		}
	}
	
	public Object getRoot() {
		if(this.isEmpty()) {
			System.out.print("el arbol esta vacio");
			return -1;
		}
		return this.dato;
	}
	
	public void PrintPreOrder(){
		if(!this.isEmpty()){
			System.out.print(this.dato + ";");
			this.izq.PrintPreOrder();
			this.der.PrintPreOrder();
		}
	}
	
	public void PrintInOrder(){
		if(!this.isEmpty()){
			this.izq.PrintInOrder();
			System.out.print(this.dato + ";");
			this.der.PrintInOrder();
			
		}
	}
	
	public void PrintPosOrder(){
		if(!this.isEmpty()){
			this.der.PrintPosOrder();
			this.izq.PrintPosOrder();
			System.out.print(this.dato + ";");
			
		}
	}
	
	public Object getMaxElem(){
		int b = 0;
		int c = 0;
		if(!this.isEmpty()){
			b = this.dato;
			c=(int)this.der.getMaxElem();
			if(b < c) {
				b = c;
			}
			c=(int)this.izq.getMaxElem();
		}
		return b;
	}
	
	public Object getMinElem(){
		int b = 50000;
		int c = 0;
		if(!this.isEmpty()){
			b = this.dato;
			c=(int)this.izq.getMinElem();
			if(b > c) {
				b = c;
			}
			c=(int)this.der.getMinElem();
			
		}
		return b;
	}
	
	public boolean hasElement(int valor){
		
		if (!this.isEmpty()){
			
			if (this.dato==valor){
				return true;
			}else 
			{if(this.dato<valor)
				 return this.der.hasElement(valor);
			 if(this.dato>valor){
				 return this.izq.hasElement(valor);
				 }
			 }
		}
		return false;
	}
	
	private boolean isLeaf() {
		if(this.der.isEmpty() && this.izq.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean delete(int aElim, Arbol Padre) {
		if (this.isEmpty()) {
			return false;
		}else {
			if (aElim < this.dato) {
				return this.izq.delete(aElim,this);
			}
			if (aElim > this.dato) {
				return this.der.delete(aElim,this);
			}
			if (aElim == this.dato){
				return this.CasoDelete(aElim,Padre);
			}
			}
		return false;
		}
	
	public boolean CasoDelete(int aElim, Arbol Padre) {
		if (this.isLeaf()) { //caso 1: el nodo es una hoja
			if (Padre.izq == this) {
				Padre.izq = new Arbol();
			}else {
				Padre.der = new Arbol();
			}
			return true;
		}else if (this.izq.isEmpty()) {//caso 2: el nodo tiene 1 hijo
				if (Padre.izq == this)
					Padre.izq = this.der;
				else {
					Padre.der = this.der;
				}
				return true;
			}else if (this.der.isEmpty()) {
				if (Padre.der == this)
					Padre.der = this.izq;
				else {
					Padre.izq = this.izq;
				}
				return true;
			}else {//caso 3: el nodo tiene 2 hijos
					int temp = (int)this.der.getMinElem();
					this.dato = temp;
					return this.der.delete(temp, this);
				}
	}
	
	
	public int getHeight() {
		if (this.isEmpty())
			return -1;
		else {
			int leftHeight = this.izq.getHeight() + 1;
			int rightHeight = this.der.getHeight() + 1;
			if (leftHeight > rightHeight)
				return leftHeight;
			else
				return rightHeight;
		}
	}
	
	
	public List<Object> getLongestBranch() {
		List<Object> left = new LinkedList<>();
		List<Object> right = new LinkedList<>();

		if (!this.isEmpty()) {
			left.add(this.dato);
			right.add(this.dato);
			left.addAll(this.izq.getLongestBranch());
			right.addAll(this.der.getLongestBranch());
		}

		if (left.size() > right.size())
			return left;
		else
			return right;
	}
	

	public List<Object> getFrontera() {//O(n)
		List<Object> frontera = new LinkedList<>();
		if (this.isLeaf()) {
			frontera.add(this.dato);
		}
		else {
			if (!this.izq.isEmpty())
				frontera.addAll(this.izq.getFrontera());
			if (!this.der.isEmpty())
				frontera.addAll(this.der.getFrontera());
		}
		return frontera;
	}
	
	
	public List<Object> getElemAtLevel(int level) {
		List<Object> aux = new LinkedList<>();
		if (this.isEmpty()) {
			return aux;
		}else {
			if (level > 0) {
				aux.addAll(this.izq.getElemAtLevel( level - 1));
				aux.addAll(this.der.getElemAtLevel( level - 1));
			}
			if (level == 0) {
				aux.add(this.dato);
			}
			return aux;
		}
		
	}
	
	
}
	
