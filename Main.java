

public class Main {

	public static void main(String[] args) {
				
		Arbol a = new Arbol();
		System.out.println("Raiz: "+a.getRoot());
		
		a.Insert(8);
		a.Insert(4);
		a.Insert(2);
		a.Insert(9);
		a.Insert(3);
		a.Insert(1);
		a.Insert(7);
		a.Insert(6);
		//metodos del arbol
		a.PrintPreOrder();
		System.out.println();
		a.PrintInOrder();
		System.out.println();
		a.PrintPosOrder();
		System.out.println();
		
		//System.out.println();
		//System.out.println("elemento encuentra:"+a.hasElement(2));
		
		int b = (int)a.getMaxElem();
		//System.out.println("resultado final ElemMayor:   "+b);

		b = (int)a.getMinElem();
		//System.out.println("resultado final ElemMenor:   "+b);
		
		//System.out.println("elimino el elemento:   "+ a.delete(2,a));
		
		b = a.getHeight();
		System.out.println("getHeight() :   "+b);
		System.out.println("Rama mas larga: "+a.getLongestBranch());
		System.out.println("Lista frontera: "+a.getFrontera());
		System.out.println("Lista en el nivel: "+a.getElemAtLevel(2));
		System.out.println("Raiz: "+a.getRoot());
		
	}
	

}
